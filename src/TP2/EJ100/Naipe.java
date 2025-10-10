package TP2.EJ100;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Naipe {
    protected final String palo;
    protected final String valor;
    protected Naipe(String valor, String palo) { this.valor = valor; this.palo = palo; }
    public String getPalo() { return palo; }
    public String getValor() { return valor; }
    public boolean esJoker() { return false; }
    public abstract int ordenValor();
    @Override public String toString() { return esJoker() ? "JOKER" : (valor + " de " + palo); }
}

/** ======= INGLÉS ======= */
class NaipeIngles extends Naipe {
    public enum Palo { CORAZONES, DIAMANTES, TREBOLES, PICAS }
    public enum Valor {
        DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10),
        J(11), Q(12), K(13), A(14), JOKER(0);
        final int n; Valor(int n){ this.n=n; } public int n(){ return n; }
    }
    private final Valor v; private final Palo p; private final boolean joker;
    public NaipeIngles(Valor v, Palo p){ super(v.name(), p.name()); if(v==Valor.JOKER) throw new IllegalArgumentException(); this.v=v; this.p=p; this.joker=false; }
    private NaipeIngles(){ super(Valor.JOKER.name(),"JOKER"); this.v=Valor.JOKER; this.p=null; this.joker=true; }
    public static NaipeIngles joker(){ return new NaipeIngles(); }
    public Valor getValorIngles(){ return v; }
    public Palo getPaloIngles(){ return p; }
    @Override public boolean esJoker(){ return joker; }
    @Override public int ordenValor(){ return v.n(); }
}

/** ======= REGLAS PÓKER ======= */
class RevisaPoker {

    /* ---------- API pedida ---------- */
    public static String evaluaMano(List<NaipeIngles> cinco) {
        Objects.requireNonNull(cinco);
        if (cinco.size()!=5) throw new IllegalArgumentException("Se esperan 5 cartas.");
        if (esEscaleraReal(cinco)) return "escalera real";
        if (esPoker(cinco))        return "poker";
        if (esFull(cinco))         return "full";
        if (esEscalera(cinco))     return "escalera";
        return "nada";
    }

    /* ---------- Helpers generales ---------- */
    private static boolean todosMismoPalo(List<NaipeIngles> cartas) {
        List<NaipeIngles> noJ = cartas.stream().filter(c -> !c.esJoker()).collect(Collectors.toList());
        if (noJ.isEmpty()) return true;
        NaipeIngles.Palo palo = noJ.get(0).getPaloIngles();
        for (NaipeIngles c: noJ) if (c.getPaloIngles()!=palo) return false;
        return true; // jokers se adaptan al palo
    }
    private static boolean valoresUnicos(List<Integer> v){ return new HashSet<>(v).size()==v.size(); }

    private static boolean puedeSerEscaleraConJokers(List<NaipeIngles> cartas, int n){
        int jokers = (int) cartas.stream().filter(Naipe::esJoker).count();
        List<Integer> vals = cartas.stream().filter(c -> !c.esJoker()).map(Naipe::ordenValor).collect(Collectors.toList());
        if (!valoresUnicos(vals)) return false;
        return secuenciaPosible(vals,jokers,n,false) || secuenciaPosible(vals,jokers,n,true);
    }
    private static boolean secuenciaPosible(List<Integer> raw, int jokers, int n, boolean asBajo){
        List<Integer> vals = new ArrayList<>(raw);
        if (asBajo) vals = vals.stream().map(v-> v==14?1:v).collect(Collectors.toList());
        Collections.sort(vals);
        int minInicio = asBajo?1:2;
        int maxInicio = 14-(n-1);
        for (int start=minInicio; start<=maxInicio; start++){
            int end = start+n-1;
            Set<Integer> rango = new HashSet<>();
            for(int v=start; v<=end; v++) rango.add(v);
            if (vals.stream().anyMatch(v->!rango.contains(v))) continue;
            int cubiertos = 0;
            for(int v=start; v<=end; v++) if (vals.contains(v)) cubiertos++;
            if (n-cubiertos <= jokers) return true;
        }
        return false;
    }

    /* ---------- Reglas específicas ---------- */
    public static boolean esPoker(List<NaipeIngles> cinco){
        int jokers = (int) cinco.stream().filter(Naipe::esJoker).count();
        Map<Integer,Integer> cnt = new HashMap<>();
        for (NaipeIngles c: cinco) if (!c.esJoker()) cnt.merge(c.ordenValor(),1,Integer::sum);
        int max = cnt.values().stream().max(Integer::compareTo).orElse(0);
        return max + jokers >= 4;
    }

    public static boolean esFull(List<NaipeIngles> cinco){
        int jokers = (int) cinco.stream().filter(Naipe::esJoker).count();
        Map<Integer,Integer> cnt = new HashMap<>();
        for (NaipeIngles c: cinco) if (!c.esJoker()) cnt.merge(c.ordenValor(),1,Integer::sum);
        // probar asignaciones tríos/pares (permitiendo crear valor con jokers)
        List<Integer> cand = new ArrayList<>(cnt.keySet());
        cand.add(-1); // valor “nuevo” con jokers
        for (int vTrio: cand){
            int haveTrio = vTrio==-1?0:cnt.getOrDefault(vTrio,0);
            for (int vPar: cand){
                if (vPar==vTrio) continue;
                int havePar = vPar==-1?0:cnt.getOrDefault(vPar,0);
                int needTrio = Math.max(0,3-haveTrio);
                int rest = jokers - needTrio;
                if (rest<0) continue;
                int needPar = Math.max(0,2-havePar);
                if (rest>=needPar && (haveTrio+havePar+jokers)>=5) return true;
            }
        }
        return false;
    }

    public static boolean esEscalera(List<NaipeIngles> cinco){
        return puedeSerEscaleraConJokers(cinco,5);
    }

    public static boolean esEscaleraReal(List<NaipeIngles> cinco){
        if (!todosMismoPalo(cinco)) return false;
        int jokers = (int) cinco.stream().filter(Naipe::esJoker).count();
        List<Integer> vals = cinco.stream().filter(c -> !c.esJoker()).map(Naipe::ordenValor).collect(Collectors.toList());
        if (!valoresUnicos(vals)) return false;
        Set<Integer> objetivo = Set.of(10,11,12,13,14);
        if (vals.stream().anyMatch(v->!objetivo.contains(v))) return false;
        return (5 - vals.size()) <= jokers;
    }
}

/** ======= DEMO ======= */
class DemoPoker {
    public static void main(String[] args) {
        List<NaipeIngles> mano1 = Arrays.asList( // escalera real con 1 joker
                new NaipeIngles(NaipeIngles.Valor.DIEZ, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.J, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.Q, NaipeIngles.Palo.PICAS),
                NaipeIngles.joker(),
                new NaipeIngles(NaipeIngles.Valor.A, NaipeIngles.Palo.PICAS)
        );
        System.out.println(RevisaPoker.evaluaMano(mano1)); // escalera real

        List<NaipeIngles> mano2 = Arrays.asList( // poker (3 nueves + 1 joker)
                new NaipeIngles(NaipeIngles.Valor.NUEVE, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.NUEVE, NaipeIngles.Palo.CORAZONES),
                new NaipeIngles(NaipeIngles.Valor.NUEVE, NaipeIngles.Palo.DIAMANTES),
                NaipeIngles.joker(),
                new NaipeIngles(NaipeIngles.Valor.CINCO, NaipeIngles.Palo.TREBOLES)
        );
        System.out.println(RevisaPoker.evaluaMano(mano2)); // poker

        List<NaipeIngles> mano3 = Arrays.asList( // full (J,J + 2,2 + joker completa J)
                new NaipeIngles(NaipeIngles.Valor.J, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.J, NaipeIngles.Palo.CORAZONES),
                NaipeIngles.joker(),
                new NaipeIngles(NaipeIngles.Valor.DOS, NaipeIngles.Palo.DIAMANTES),
                new NaipeIngles(NaipeIngles.Valor.DOS, NaipeIngles.Palo.TREBOLES)
        );
        System.out.println(RevisaPoker.evaluaMano(mano3)); // full

        List<NaipeIngles> mano4 = Arrays.asList( // escalera A-2-3-4-5 (As bajo)
                new NaipeIngles(NaipeIngles.Valor.A, NaipeIngles.Palo.CORAZONES),
                new NaipeIngles(NaipeIngles.Valor.DOS, NaipeIngles.Palo.DIAMANTES),
                new NaipeIngles(NaipeIngles.Valor.TRES, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.CUATRO, NaipeIngles.Palo.TREBOLES),
                new NaipeIngles(NaipeIngles.Valor.CINCO, NaipeIngles.Palo.CORAZONES)
        );
        System.out.println(RevisaPoker.evaluaMano(mano4)); // escalera

        List<NaipeIngles> mano5 = Arrays.asList( // nada
                new NaipeIngles(NaipeIngles.Valor.DOS, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.CUATRO, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.SEIS, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.OCHO, NaipeIngles.Palo.PICAS),
                new NaipeIngles(NaipeIngles.Valor.DIEZ, NaipeIngles.Palo.PICAS)
        );
        System.out.println(RevisaPoker.evaluaMano(mano5)); // nada
    }
}

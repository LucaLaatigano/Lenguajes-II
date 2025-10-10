package TP2.EJ11;



import java.util.Objects;


abstract class DinamicaExponencial {
    private final double N0;  // valor inicial (t=0)
    private final double k;   // coeficiente específico (>0 crecimiento, <0 decaimiento)

    protected DinamicaExponencial(double N0, double k) {
        this.N0 = N0;
        this.k  = k;
    }

    public double getN0() { return N0; }
    public double getK()  { return k; }

    public double valorEn(double t) {
        return N0 * Math.exp(k * t);
    }
}


class Microorganismo {
    public enum Forma { COCO, BACILO, ESPIRILO, VIBRION, OTRA }

    private final String especie;         // opcional: nombre/código de especie
    private final double masaPromedio;    // en, p. ej., pg (picogramos)
    private final Forma forma;

    public Microorganismo(String especie, double masaPromedio, Forma forma) {
        this.especie = Objects.requireNonNull(especie, "especie");
        this.masaPromedio = masaPromedio;
        this.forma = Objects.requireNonNull(forma, "forma");
    }

    public String getEspecie() { return especie; }
    public double getMasaPromedio() { return masaPromedio; }
    public Forma getForma() { return forma; }

    @Override
    public String toString() {
        return "Microorganismo{especie='" + especie + "', masaPromedio=" + masaPromedio + ", forma=" + forma + "}";
    }
}


class PoblacionMicroorganismos extends DinamicaExponencial {
    private final Microorganismo microorganismo;
    private final double densidad;
    private final double turbiedad;

    public PoblacionMicroorganismos(double N0, double k,
                                    Microorganismo microorganismo,
                                    double densidad, double turbiedad) {
        super(N0, k);
        this.microorganismo = Objects.requireNonNull(microorganismo, "microorganismo");
        this.densidad = densidad;
        this.turbiedad = turbiedad;
    }

    public Microorganismo getMicroorganismo() { return microorganismo; }
    public double getDensidad() { return densidad; }
    public double getTurbiedad() { return turbiedad; }

    @Override
    public String toString() {
        return "PoblacionMicroorganismos{N0=" + getN0() + ", k=" + getK() +
                ", densidad=" + densidad + ", turbiedad=" + turbiedad +
                ", " + microorganismo + "}";
    }
}


class Nutrientes extends DinamicaExponencial {
    private final String nombre;  // p. ej., Glucosa
    private final String unidad;  // p. ej., g/L, mmol/L

    public Nutrientes(double N0, double k, String nombre, String unidad) {
        super(N0, k);
        this.nombre = Objects.requireNonNull(nombre, "nombre");
        this.unidad = Objects.requireNonNull(unidad, "unidad");
    }

    public String getNombre() { return nombre; }
    public String getUnidad() { return unidad; }

    @Override
    public String toString() {
        return "Nutrientes{N0=" + getN0() + ", k=" + getK() + ", nombre='" + nombre + "', unidad='" + unidad + "'}";
    }
}

/** ===== Ejemplo de uso ===== */
class DemoBio {
    public static void main(String[] args) {
        Microorganismo eColi = new Microorganismo("E. coli", 1.0e-12, Microorganismo.Forma.BACILO);

        // Crecimiento poblacional (k>0)
        PoblacionMicroorganismos pobl = new PoblacionMicroorganismos(
                1.0e6,      // N0: 1 millón de células
                0.8,        // k: tasa de crecimiento (1/h, por ejemplo)
                eColi,
                1.2e7,      // densidad inicial
                0.15        // turbiedad (OD)
        );

        // Consumo de nutriente (k<0 si decae exponencialmente)
        Nutrientes glucosa = new Nutrientes(
                10.0,       // N0: 10 g/L
                -0.25,      // k: decaimiento por consumo
                "Glucosa",
                "g/L"
        );

        double t = 3.0; // 3 horas
        System.out.printf("Población a t=%.1fh: %.2e células%n", t, pobl.valorEn(t));
        System.out.printf("Glucosa a t=%.1fh: %.3f %s%n", t, glucosa.valorEn(t), glucosa.getUnidad());
    }
}
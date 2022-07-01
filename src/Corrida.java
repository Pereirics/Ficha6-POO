import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Corrida extends Actividade {

    // Variáveis de instância
    private double distanciaPercorrida;
    private double altimetriaGanha;
    private String percurso;

    // Construtor por omissão
    public Corrida() {
        super();
        this.distanciaPercorrida = 0;
        this.altimetriaGanha = 0;
        this.percurso = "";
    }

    // Construtor parametrizado
    public Corrida(String codigo, String descricao, String data, Integer duracaoMinutos, double distanciaPercorrida, double altimetriaGanha, String percurso) {
        super(codigo, descricao, data, duracaoMinutos);
        this.distanciaPercorrida = distanciaPercorrida;
        this.altimetriaGanha = altimetriaGanha;
        this.percurso = percurso;
    }

    // Construtor cópia
    public Corrida(Corrida c) {
        super(c);
        this.distanciaPercorrida = c.getDistanciaPercorrida();
        this.altimetriaGanha = c.getAltimetriaGanha();
        this.percurso = c.getPercurso();
    }

    // Métodos de instância
    public double getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }

    public double getAltimetriaGanha() {
        return this.altimetriaGanha;
    }

    public String getPercurso() {
        return this.percurso;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public void setAltimetriaGanha(double altimetriaGanha) {
        this.altimetriaGanha = altimetriaGanha;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Corrida corrida = (Corrida) o;
        return super.equals(corrida) && (corrida.getDistanciaPercorrida() == getDistanciaPercorrida()) && (corrida.getAltimetriaGanha() == getAltimetriaGanha()) && (getPercurso().equals(corrida.getPercurso()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistanciaPercorrida(), getAltimetriaGanha(), getPercurso());
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "distanciaPercorrida=" + distanciaPercorrida +
                ", altimetriaGanha=" + altimetriaGanha +
                ", percurso='" + percurso + '\'' +
                '}';
    }
}

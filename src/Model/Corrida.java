package Model;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;



public class Corrida extends Actividade implements FazMetros{

    // Variáveis de instância
    private double distanciaPercorrida;
    private double altimetriaGanha;
    private String percurso;
    private double valorMetro = 0;

    // Construtor por omissão
    public Corrida() {
        super();
        this.setCodigo("1");
        this.distanciaPercorrida = 0;
        this.altimetriaGanha = 0;
        this.percurso = "";
    }

    // Construtor parametrizado
    public Corrida(String codigo, String descricao, LocalDate data, Integer duracaoMinutos, double distanciaPercorrida, double altimetriaGanha, String percurso) {
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

    @Override
    public double getValorMetro() {
        return valorMetro;
    }

    public void setValorMetro(double valorMetro) {
        this.valorMetro = valorMetro;
    }

    @Override
    public double totalPontosActividade(Fitness f, String codActividade) {
        double total = 0;
        for (Utilizador utilizador: f.getUtilizadores().values()) {
            for (Actividade actividade: utilizador.getActividadesRealizadas()) {
                if (actividade.getCodigo().equals(codActividade)) {
                    total += this.getValorMetro() * ((Corrida)actividade).getDistanciaPercorrida();
                }
            }
        }
        return total;
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
        return "Model.Corrida{" +
                "distanciaPercorrida=" + distanciaPercorrida +
                ", altimetriaGanha=" + altimetriaGanha +
                ", percurso='" + percurso + '\'' +
                '}';
    }
}

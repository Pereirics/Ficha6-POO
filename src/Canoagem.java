import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Canoagem extends Actividade {

    // Variáveis de instância
    private String embarcacao;
    private double velocidadeVento;
    private String direcaoVento;
    private double distanciaPercorrida;
    private Integer numeroVoltas;

    // Construtor por omissão
    public Canoagem() {
        super();
        this.embarcacao = "";
        this.velocidadeVento = 0;
        this.direcaoVento = "";
        this.distanciaPercorrida = 0;
        this.numeroVoltas = 0;
    }

    // Construtor parametrizado
    public Canoagem(String codigo, String descricao, String data, Integer duracaoMinutos, String embarcacao, double velocidadeVento, String direcaoVento, double distanciaPercorrida, Integer numeroVoltas) {
        super(codigo, descricao, data, duracaoMinutos);
        this.embarcacao = embarcacao;
        this.velocidadeVento = velocidadeVento;
        this.direcaoVento = direcaoVento;
        this.distanciaPercorrida = distanciaPercorrida;
        this.numeroVoltas = numeroVoltas;
    }

    // Construtor cópia
    public Canoagem(Canoagem c) {
        super(c);
        this.embarcacao = c.getEmbarcacao();
        this.velocidadeVento = c.getVelocidadeVento();
        this.direcaoVento = c.getDirecaoVento();
        this.distanciaPercorrida = c.getDistanciaPercorrida();
        this.numeroVoltas = c.getNumeroVoltas();
    }

    // Métodos de instância
    public String getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public String getDirecaoVento() {
        return direcaoVento;
    }

    public void setDirecaoVento(String direcaoVento) {
        this.direcaoVento = direcaoVento;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public Integer getNumeroVoltas() {
        return numeroVoltas;
    }

    public void setNumeroVoltas(Integer numeroVoltas) {
        this.numeroVoltas = numeroVoltas;
    }

    @Override
    public String toString() {
        return "Canoagem{" +
                "embarcacao='" + embarcacao + '\'' +
                ", velocidadeVento=" + velocidadeVento +
                ", direcaoVento='" + direcaoVento + '\'' +
                ", distanciaPercorrida=" + distanciaPercorrida +
                ", numeroVoltas=" + numeroVoltas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Canoagem canoagem = (Canoagem) o;
        return super.equals(canoagem) && Double.compare(canoagem.getVelocidadeVento(), getVelocidadeVento()) == 0 && Double.compare(canoagem.getDistanciaPercorrida(), getDistanciaPercorrida()) == 0 && Objects.equals(getEmbarcacao(), canoagem.getEmbarcacao()) && Objects.equals(getDirecaoVento(), canoagem.getDirecaoVento()) && Objects.equals(getNumeroVoltas(), canoagem.getNumeroVoltas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmbarcacao(), getVelocidadeVento(), getDirecaoVento(), getDistanciaPercorrida(), getNumeroVoltas());
    }

    public Canoagem clone() {
        return new Canoagem(this);
    }
}

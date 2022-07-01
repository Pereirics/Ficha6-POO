import java.util.Objects;

public class Abdominais extends Actividade {

    // Variáveis de instância
    private String tipoAbdominal;
    private Integer numeroRepeticoes;

    // Construtor por omissão
    public Abdominais() {
        super();
        this.tipoAbdominal = "";
        this.numeroRepeticoes = 0;
    }

    // Construtor parametrizado
    public Abdominais(String codigo, String descricao, String data, Integer duracaoMinutos, String tipoAbdominal, Integer numeroRepeticoes) {
        super(codigo, descricao, data, duracaoMinutos);
        this.tipoAbdominal = tipoAbdominal;
        this.numeroRepeticoes = numeroRepeticoes;
    }

    // Construtor cópia
    public Abdominais(Abdominais a) {
        super(a);
        this.tipoAbdominal = a.getTipoAbdominal();
        this.numeroRepeticoes = a.getNumeroRepeticoes();
    }

    // Métodos de instância
    public String getTipoAbdominal() {
        return this.tipoAbdominal;
    }

    public void setTipoAbdominal(String tipoAbdominal) {
        this.tipoAbdominal = tipoAbdominal;
    }

    public Integer getNumeroRepeticoes() {
        return this.numeroRepeticoes;
    }

    public void setNumeroRepeticoes(Integer numeroRepeticoes) {
        this.numeroRepeticoes = numeroRepeticoes;
    }

    @Override
    public String toString() {
        return "Abdominais{" +
                "tipoAbdominal='" + tipoAbdominal + '\'' +
                ", numeroRepeticoes=" + numeroRepeticoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Abdominais that = (Abdominais) o;
        return super.equals(o) && Objects.equals(getTipoAbdominal(), that.getTipoAbdominal()) && Objects.equals(getNumeroRepeticoes(), that.getNumeroRepeticoes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoAbdominal(), getNumeroRepeticoes());
    }

    public Abdominais clone() {
        return new Abdominais(this);
    }
}

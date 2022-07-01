import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Actividade {

    // Variáveis de instância
    private String codigo;
    private String descricao;
    private String data;
    private Integer duracaoMinutos;

    // Construtor por omissão
    public Actividade() {
        this.codigo = "";
        this.descricao = "";
        this.data = "";
        this.duracaoMinutos = 0;
    }

    // Construtor parametrizado
    public Actividade(String codigo, String descricao, String data, Integer duracaoMinutos) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.data = data;
        this.duracaoMinutos = duracaoMinutos;
    }

    // Construtor cópia
    public Actividade(Actividade f) {
        this.codigo = f.getCodigo();
        this.descricao = f.getDescricao();
        this.data = f.getData();
        this.duracaoMinutos = f.getDuracaoMinutos();
    }

    // Métodos de instância
    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getData() {
        return this.data;
    }

    public Integer getDuracaoMinutos() {
        return this.duracaoMinutos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public double calculaValorCaloricoDispendido(Utilizador utilizador) {
        if (this.getClass() == Corrida.class) {
            return ((Corrida)this).getDistanciaPercorrida() * utilizador.getPeso() * this.getDuracaoMinutos() * Period.between(utilizador.getDataNascimento(), LocalDate.now()).getYears() / 50;
        } else if (this.getClass() == Canoagem.class) {
            return ((Canoagem)this).getDistanciaPercorrida()*((Canoagem) this).getVelocidadeVento()*this.getDuracaoMinutos()*Period.between(utilizador.getDataNascimento(), LocalDate.now()).getYears()/4;
        } else if (this.getClass() == Abdominais.class) {
            return this.getDuracaoMinutos()*((Abdominais) this).getNumeroRepeticoes()*3/5.0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Actividade{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", duracaoMinutos=" + duracaoMinutos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Actividade that = (Actividade) o;
        return super.equals(that) && Objects.equals(getCodigo(), that.getCodigo()) && Objects.equals(getDescricao(), that.getDescricao()) && Objects.equals(getData(), that.getData()) && Objects.equals(getDuracaoMinutos(), that.getDuracaoMinutos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getDescricao(), getData(), getDuracaoMinutos());
    }

    public Actividade clone() {
        return new Actividade(this);
    }
}

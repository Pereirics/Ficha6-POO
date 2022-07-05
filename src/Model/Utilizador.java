package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utilizador {

    // Variáveis de instância
    private String email;
    private String password;
    private String nome;
    private String genero;
    private double altura;
    private double peso;
    private LocalDate dataNascimento;
    private String desportoFavorito;
    private List<Actividade> actividadesRealizadas;

    // Construtor por omissão
    public Utilizador() {
        this.email = "";
        this.password = "";
        this.nome = "";
        this.genero = "";
        this.altura = 0;
        this.peso = 0;
        this.dataNascimento = LocalDate.now();
        this.desportoFavorito = "";
        this.actividadesRealizadas = new ArrayList<>();
    }

    // Construtor parametrizado
    public Utilizador(String email, String password, String nome, String genero, double altura, double peso, LocalDate dataNascimento, String desportoFavorito, List<Actividade> atividadesRealizadas) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.desportoFavorito = desportoFavorito;
        this.actividadesRealizadas = atividadesRealizadas;
    }

    // Construtor cópia
    public Utilizador(Utilizador u) {
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.nome = u.getNome();
        this.genero = u.getGenero();
        this.altura = u.getAltura();
        this.peso = u.getPeso();
        this.dataNascimento = u.getDataNascimento();
        this.desportoFavorito = u.getDesportoFavorito();
        this.actividadesRealizadas = u.getActividadesRealizadas();
    }

    // Métodos de instância
    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public double getAltura() {
        return this.altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public String getDesportoFavorito() {
        return this.desportoFavorito;
    }

    public List<Actividade> getActividadesRealizadas() {
        return this.actividadesRealizadas;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDesportoFavorito(String desportoFavorito) {
        this.desportoFavorito = desportoFavorito;
    }

    public void setAtividadesRealizadas(List<Actividade> actividadesRealizadas) {
        this.actividadesRealizadas = actividadesRealizadas;
    }

    public int numeroAtividades() {
        return this.actividadesRealizadas.size();
    }
    public double calculaCaloriasTotais() {
        double total = 0;
        for (Actividade actividade: this.actividadesRealizadas) {
            total += actividade.calculaValorCaloricoDispendido(this);
        }
        return total;
    }

    @Override
    public String toString() {
        return "Model.Utilizador{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", dataNascimento=" + dataNascimento +
                ", desportoFavorito='" + desportoFavorito + '\'' +
                ", actividadesRealizadas=" + actividadesRealizadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Utilizador that = (Utilizador) o;
        return Double.compare(that.getAltura(), getAltura()) == 0 && Double.compare(that.getPeso(), getPeso()) == 0 && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getGenero(), that.getGenero()) && Objects.equals(getDataNascimento(), that.getDataNascimento()) && Objects.equals(getDesportoFavorito(), that.getDesportoFavorito()) && Objects.equals(this.actividadesRealizadas, that.getActividadesRealizadas());
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }
}

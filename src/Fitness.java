import jdk.jshell.execution.Util;

import java.util.*;

public class Fitness {

    // Variáveis de instância
    private Map<String, Utilizador> utilizadores;
    private Map<String, Comparator<Utilizador>> comparadores;

    // Construtor por omissão
    public Fitness() {
        this.utilizadores = new HashMap<>();
        this.comparadores = new HashMap<>();
    }

    // Construtor parametrizado
    public Fitness(Map<String, Utilizador> utilizadores, Map<String, Comparator<Utilizador>> comparadores) {
        this.utilizadores = utilizadores;
        this.comparadores = comparadores;
    }

    // Construtor cópia
    public Fitness(Fitness f) {
        this.utilizadores = f.getUtilizadores();
        this.comparadores = f.getComparadores();
    }

    // Métodos de instância
    public Map<String, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public Map<String, Comparator<Utilizador>> getComparadores() {
        return this.comparadores;
    }

    public void setComparadores(Map<String, Comparator<Utilizador>> comparadores) {
        this.comparadores = comparadores;
    }

    public void adicionaComparador(String nome, Comparator<Utilizador> comparador) {
        this.comparadores.put(nome, comparador);
    }

    public boolean existeutilizador(String email) {
        return this.utilizadores.containsKey(email);
    }

    public int quantos() {
        return this.utilizadores.size();
    }

    public Utilizador getUtilizador(String email) {
        for (Utilizador utilizador: this.utilizadores.values()) {
            if (utilizador.getEmail().equals(email)) return utilizador;
        }
        return new Utilizador();
    }

    public void adiciona(String email, Actividade act) {
        for (Utilizador utilizador: this.utilizadores.values()) {
            if (utilizador.getEmail().equals(email)) {
                List<Actividade> nova = utilizador.getActividadesRealizadas();
                nova.add(act);
                utilizador.setAtividadesRealizadas(nova);
                break;
            }
        }
    }

    public List<Actividade> getAllActividades() {
        List<Actividade> res = new ArrayList<>();
        for (Utilizador utilizador: this.utilizadores.values()) {
            res.addAll(utilizador.getActividadesRealizadas());
        }
        return res;
    }

    public void adiciona(String email, Set<Actividade> activs) {
        for (Utilizador utilizador: this.utilizadores.values()) {
            if (utilizador.getEmail().equals(email)) {
                List<Actividade> nova = utilizador.getActividadesRealizadas();
                nova.addAll(activs);
                utilizador.setAtividadesRealizadas(nova);
                break;
            }
        }
    }

    public int tempoTotalUtilizador(String email) {
        int total = 0;
        for (Utilizador utilizador: this.utilizadores.values()) {
            if (utilizador.getEmail().equals(email)) {
                for (Actividade actividade: utilizador.getActividadesRealizadas()) {
                    total += actividade.getDuracaoMinutos();
                }
                break;
            }
        }
        return total;
    }

    public Actividade actividadeMaisExigente() {
        double maior = 0;
        Actividade res = new Actividade();
        for (Utilizador utilizador: this.utilizadores.values()) {
            for (Actividade actividade: utilizador.getActividadesRealizadas()) {
                if (actividade.calculaValorCaloricoDispendido(utilizador) > maior) {
                    maior = actividade.calculaValorCaloricoDispendido(utilizador);
                    res = actividade;
                }
            }
        }
        return res;
    }

    public Utilizador utilizadorMaisActivo() {
        Utilizador res = new Utilizador();
        double maior = 0;
        for (Utilizador utilizador: this.utilizadores.values()) {
            for (Actividade actividade: utilizador.getActividadesRealizadas()) {
                if (actividade.calculaValorCaloricoDispendido(utilizador) > maior) {
                    maior = actividade.calculaValorCaloricoDispendido(utilizador);
                    res = utilizador;
                }
            }
        }
        return res;
    }

    public void actualizaDesportoFav() {
        for (Utilizador utilizador: this.utilizadores.values()) {
            Map<String, Integer> contador = new HashMap<>();
            for (Actividade actividade: utilizador.getActividadesRealizadas()) {
                if (!contador.containsKey(actividade.getCodigo())) {
                    contador.put(actividade.getCodigo(), 1);
                }
                else {
                    int valor = contador.get(actividade.getCodigo()) + 1;
                    contador.put(actividade.getCodigo(), valor);
                }
            }
            int maior = 0;
            String cod = "";
            for (Map.Entry<String, Integer> entry : contador.entrySet()) {
                if (entry.getValue() > maior) {
                    maior = entry.getValue();
                    cod = entry.getKey();
                }
            }
            utilizador.setDesportoFavorito(cod);
        }
    }

    public Set<Utilizador> ordenarUtilizadores() {
        Comparator<Utilizador> calorias = Comparator.comparingDouble(Utilizador::calculaCaloriasTotais).reversed();
        Comparator<Utilizador> nomes = Comparator.comparing(Utilizador::getNome);
        Set<Utilizador> res = new TreeSet<>(calorias.thenComparing(nomes));
        res.addAll(this.utilizadores.values());
        return res;
    }

    public List<Utilizador> ordenarUtilizadoresLista() {
        Comparator<Utilizador> calorias = Comparator.comparingDouble(Utilizador::calculaCaloriasTotais).reversed();
        Comparator<Utilizador> nomes = Comparator.comparing(Utilizador::getNome);
        List<Utilizador> res = new ArrayList<>(this.utilizadores.values());
        res.sort(calorias.thenComparing(nomes));
        return res;
    }

    public Set<Utilizador> ordenarUtilizador(Comparator<Utilizador> c) {
        Set<Utilizador> res = new TreeSet<>(c);
        res.addAll(utilizadores.values());
        return res;
    }

    public Iterator<Utilizador> ordenarUtilizador(String criterio) {
        Comparator<Utilizador> c = this.comparadores.get(criterio);
        List<Utilizador> lista = new ArrayList<>(this.utilizadores.values());
        lista.sort(c);
        return lista.iterator();
    }

    /* NÃO CONSEGUI FAZER ESTA
    public Map<String, List<Utilizador>> podiumPorActiv() {
        Map<String, List<Utilizador>> res = new HashMap<>();
        for (Utilizador utilizador: this.utilizadores.values()) {
            for (Actividade actividade: utilizador.getActividadesRealizadas()) {
                if (!res.containsKey(actividade.getCodigo())) {
                    List<Utilizador> lista = new ArrayList<>();
                    lista.add(utilizador);
                    res.put(actividade.getCodigo(), lista);
                }
                else {
                    if (res.get(actividade.getCodigo()).size() < 3) {
                        res.get(actividade.getCodigo()).add(utilizador);
                    }
                    else {
                        double valor = actividade.calculaValorCaloricoDispendido(utilizador);
                        for (List<Utilizador> listas: res.values()) {
                            for (Utilizador utilizador1: listas) {
                               break;
                            }
                        }
                    }
                }
            }
        }
    }
    */



    @Override
    public String toString() {
        return "Fitness{" +
                "utilizadores=" + utilizadores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Fitness f = (Fitness) o;
        return (Objects.equals(f.getUtilizadores(), this.utilizadores));
    }

    public Fitness clone() {
        return new Fitness(this);
    }
}

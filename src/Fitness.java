import java.util.*;

public class Fitness {

    // Variáveis de instância
    private Map<String, Utilizador> utilizadores;

    // Construtor por omissão
    public Fitness() {
        this.utilizadores = new HashMap<>();
    }

    // Construtor parametrizado
    public Fitness(Map<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    // Construtor cópia
    public Fitness(Fitness f) {
        this.utilizadores = f.getUtilizadores();
    }

    // Métodos de instância
    public Map<String, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
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

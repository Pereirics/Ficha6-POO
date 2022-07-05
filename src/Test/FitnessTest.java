import Model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

class FitnessTest {

    @Test
    void ordenarUtilizadores() {
        LocalDate data = LocalDate.of(2002, 7, 4);
        Actividade actividade1 = new Corrida("1", "corrida", LocalDate.now(), 32, 1, 20, "");
        Actividade actividade2 = new Abdominais("2", "abdominais", LocalDate.now(), 70, "", 200);
        List<Actividade> lista1 = new ArrayList<>();
        lista1.add(actividade1);
        lista1.add(actividade2);
        List<Actividade> lista2 = new ArrayList<>();
        lista2.add(actividade2);
        Utilizador user1 = new Utilizador("", "", "Joao", "", 172, 85, data, "", lista1);
        Utilizador user2 = new Utilizador("", "", "Carina", "", 160, 60, data, "", lista2);
        Utilizador user3 = new Utilizador("", "", "Manel", "", 160, 60, data, "", lista2);
        Map<String, Utilizador> utilizadorMap = new HashMap<>();
        utilizadorMap.put(user1.getNome(), user1);
        utilizadorMap.put(user3.getNome(), user3);
        utilizadorMap.put(user2.getNome(), user2);
        Fitness fitness = new Fitness(utilizadorMap, new HashMap<>());
        System.out.println(user1.calculaCaloriasTotais());
        System.out.println(user2.calculaCaloriasTotais());
        System.out.println(fitness.ordenarUtilizadores());
    }

    @Test
    void ordenarUtilizadoresLista() {
        LocalDate data = LocalDate.of(2002, 7, 4);
        Actividade actividade1 = new Corrida("1", "corrida", LocalDate.now(), 32, 1, 20, "");
        Actividade actividade2 = new Abdominais("2", "abdominais", LocalDate.now(), 70, "", 200);
        List<Actividade> lista1 = new ArrayList<>();
        lista1.add(actividade1);
        lista1.add(actividade2);
        List<Actividade> lista2 = new ArrayList<>();
        lista2.add(actividade2);
        Utilizador user1 = new Utilizador("", "", "Joao", "", 172, 85, data, "", lista1);
        Utilizador user2 = new Utilizador("", "", "Carina", "", 160, 60, data, "", lista2);
        Utilizador user3 = new Utilizador("", "", "Manel", "", 160, 60, data, "", lista2);
        Map<String, Utilizador> utilizadorMap = new HashMap<>();
        utilizadorMap.put(user1.getNome(), user1);
        utilizadorMap.put(user3.getNome(), user3);
        utilizadorMap.put(user2.getNome(), user2);
        Fitness fitness = new Fitness(utilizadorMap, new HashMap<>());
        System.out.println(user1.calculaCaloriasTotais());
        System.out.println(user2.calculaCaloriasTotais());
        System.out.println(fitness.ordenarUtilizadoresLista());
    }

    @Test
    void ordenarUtilizador() {
        LocalDate data = LocalDate.of(2002, 7, 4);
        Actividade actividade1 = new Corrida("1", "corrida", LocalDate.now(), 32, 1, 20, "");
        Actividade actividade2 = new Abdominais("2", "abdominais", LocalDate.now(), 70, "", 200);
        List<Actividade> lista1 = new ArrayList<>();
        lista1.add(actividade1);
        lista1.add(actividade2);
        List<Actividade> lista2 = new ArrayList<>();
        lista2.add(actividade2);
        Utilizador user1 = new Utilizador("", "", "Joao", "", 172, 85, data, "", lista1);
        Utilizador user2 = new Utilizador("", "", "Carina", "", 160, 60, data, "", lista2);
        Utilizador user3 = new Utilizador("", "", "Manel", "", 160, 60, data, "", lista2);
        Map<String, Utilizador> utilizadorMap = new HashMap<>();
        utilizadorMap.put(user1.getNome(), user1);
        utilizadorMap.put(user3.getNome(), user3);
        utilizadorMap.put(user2.getNome(), user2);
        Fitness fitness = new Fitness(utilizadorMap, new HashMap<>());
        System.out.println(user1.calculaCaloriasTotais());
        System.out.println(user2.calculaCaloriasTotais());
        Comparator<Utilizador> nomes = Comparator.comparing(Utilizador::getNome);
        System.out.println(fitness.ordenarUtilizador(nomes));
    }

    @Test
    void testOrdenarUtilizador() {
        LocalDate data = LocalDate.of(2002, 7, 4);
        Actividade actividade1 = new Corrida("1", "corrida", LocalDate.now(), 32, 1, 20, "");
        Actividade actividade2 = new Abdominais("2", "abdominais", LocalDate.now(), 70, "", 200);
        List<Actividade> lista1 = new ArrayList<>();
        lista1.add(actividade1);
        lista1.add(actividade2);
        List<Actividade> lista2 = new ArrayList<>();
        lista2.add(actividade2);
        Utilizador user1 = new Utilizador("", "", "Joao", "", 172, 85, data, "", lista1);
        Utilizador user2 = new Utilizador("", "", "Carina", "", 160, 60, data, "", lista2);
        Utilizador user3 = new Utilizador("", "", "Manel", "", 160, 60, data, "", lista2);
        Map<String, Utilizador> utilizadorMap = new HashMap<>();
        utilizadorMap.put(user1.getNome(), user1);
        utilizadorMap.put(user3.getNome(), user3);
        utilizadorMap.put(user2.getNome(), user2);

        Comparator<Utilizador> nomes = Comparator.comparing(Utilizador::getNome);
        Comparator<Utilizador> calorias = Comparator.comparingDouble(Utilizador::calculaCaloriasTotais).reversed();
        Comparator<Utilizador> numeroAtividades = Comparator.comparingInt(Utilizador::numeroAtividades).reversed();
        Map<String, Comparator<Utilizador>> comparatorMap = new HashMap<>();
        comparatorMap.put("nome", nomes);
        comparatorMap.put("calorias", calorias);
        comparatorMap.put("numeroAtividades", numeroAtividades);
        Fitness fitness = new Fitness(utilizadorMap, comparatorMap);
        System.out.println(user1.calculaCaloriasTotais());
        System.out.println(user2.calculaCaloriasTotais());
        Iterator<Utilizador> res = fitness.ordenarUtilizador("numeroAtividades");
        while (res.hasNext()) {
            System.out.println(res.next());
        }
    }
}
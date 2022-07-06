package Model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.out;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

        public static void main(String[] args) throws UtilizadorInexistenteException {
        LocalDate data = LocalDate.of(2002, 7, 4);
        Actividade actividade1 = new Corrida("1", "corrida", LocalDate.now(), 32, 20, 20, "");
        Actividade actividade2 = new Abdominais("2", "abdominais", LocalDate.now(), 70, "", 200);
        Actividade actividade3 = new Canoagem("3", "canoagem", LocalDate.now(), 30, "", 10, "", 10, 2);
        List<Actividade> lista1 = new ArrayList<>();
        lista1.add(actividade1);
        lista1.add(actividade2);
        List<Actividade> lista2 = new ArrayList<>();
        lista2.add(actividade2);
        Utilizador user1 = new Utilizador("joao", "", "Joao", "", 172, 85, data, "", lista1);
        Utilizador user2 = new Utilizador("carina", "", "Carina", "", 160, 60, data, "", lista2);
        Utilizador user3 = new Utilizador("manel", "", "Manel", "", 160, 60, data, "", lista2);
        Map<String, Utilizador> utilizadorMap = new HashMap<>();
        utilizadorMap.put(user1.getEmail(), user1);
        utilizadorMap.put(user3.getEmail(), user3);
        utilizadorMap.put(user2.getEmail(), user2);

        Comparator<Utilizador> nomes = Comparator.comparing(Utilizador::getNome);
        Comparator<Utilizador> calorias = Comparator.comparingDouble(Utilizador::calculaCaloriasTotais).reversed();
        Comparator<Utilizador> numeroAtividades = Comparator.comparingInt(Utilizador::numeroAtividades).reversed();
        Map<String, Comparator<Utilizador>> comparatorMap = new HashMap<>();
        comparatorMap.put("nome", nomes);
        comparatorMap.put("calorias", calorias);
        comparatorMap.put("numeroAtividades", numeroAtividades);
        Fitness fitness = new Fitness(utilizadorMap, comparatorMap);

        // fitness.getUtilizador("joao");
        // out.println(fitness.quantos());
        // fitness.adiciona("carina", actividade1);
        // out.println(fitness.getUtilizador("carina"));
        // out.println(fitness.getAllActividades());
        // out.println(fitness.actividadeMaisExigente());
        // fitness.adiciona("joao", actividade2);
        // fitness.actualizaDesportoFav();
        // out.println(fitness.getUtilizadores());
        Corrida c = new Corrida();
        c.setValorMetro(200);
        out.println(c.totalPontosActividade(fitness, "1"));

        fitness.adiciona("manel", actividade3);
        Canoagem canoagem = new Canoagem();
        canoagem.setValorMetro(200);
        out.println(canoagem.totalPontosActividade(fitness, "3"));
    }
}

package br.inatel.cdg.service;

import br.inatel.cdg.model.Jogo;
import br.inatel.cdg.model.Plataforma;
import br.inatel.cdg.model.Produtora;
import br.inatel.cdg.utils.CsvUtils;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class JogoService {

    public static List<Jogo> lerListaPorPlataforma(List<Jogo> jogos, Plataforma plataforma) {
        List<Jogo> jogosPorPlataforma = new ArrayList<>();

        jogos.stream().filter((jogo ->
                        jogo.getPlatform().equals(plataforma.name()))).
                forEach(jogo -> jogosPorPlataforma.add(jogo));

        return jogosPorPlataforma;
    }

    public static List<Jogo> lerListaPorProdutora(List<Jogo> jogos, Produtora produtora) {
        List<Jogo> jogosPorProdutora = new ArrayList<>();

        jogos.stream().filter((jogo ->
                        jogo.getPublisher().replaceAll("\\s+", "").equals(produtora.name()))).
                forEach(jogo -> jogosPorProdutora.add(jogo));

        return jogosPorProdutora;
    }

    public static List<Jogo> lerListaPorAno(List<Jogo> jogos, int year) {
        List<Jogo> jogosPorAno = new ArrayList<>();

        jogos.stream().filter(jogo ->
                        jogo.getYear() == year)
                .forEach(jogo -> jogosPorAno.add(jogo));

        return jogosPorAno;
    }

    public static void escreverListaFiltradaEmArquivoCSV(List<Jogo> jogoList) {
        CsvUtils.escreverArquivo(jogoList);
    }
}
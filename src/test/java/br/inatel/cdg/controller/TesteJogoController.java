package br.inatel.cdg.controller;

import br.inatel.cdg.model.Jogo;
import br.inatel.cdg.model.Plataforma;
import br.inatel.cdg.model.Produtora;
import br.inatel.cdg.utils.CsvUtils;
import org.junit.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TesteJogoController {

    private static List<Jogo> jogoList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        jogoList = CsvUtils.lerArquivoCsv(caminho);
    }

    @Test
    public void testFiltroProdutoraActvision() throws InterruptedException, URISyntaxException {
        JogoController.filtraProdutoraEEscreveNovoArquivo(jogoList, Produtora.Activision);

        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games-filtrados.csv").toURI());
        //esperando 3 segundos para o arquivo ser criado
        new Thread().sleep(3000);

        List<Jogo> novoArquivojogoList = CsvUtils.lerArquivoCsv(caminho);

        int numLines = novoArquivojogoList.size();
        Assert.assertEquals(14, numLines);
    }

    @Test
    public void testFiltroProdutoraNintendo() throws InterruptedException, URISyntaxException {
        JogoController.filtraProdutoraEEscreveNovoArquivo(jogoList, Produtora.Nintendo);

        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games-filtrados.csv").toURI());
        //esperando 3 segundos para o arquivo ser criado
        new Thread().sleep(3000);

        List<Jogo> novoArquivojogoList = CsvUtils.lerArquivoCsv(caminho);

        int numLines = novoArquivojogoList.size();
        Assert.assertEquals(52, numLines);
    }


    @Test
    public void testFiltroPlataformaXB() throws InterruptedException, URISyntaxException {
        JogoController.filtraPlataformaEEscreveNovoArquivo(jogoList, Plataforma.XB);

        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games-filtrados.csv").toURI());

        //esperando 2 segundos para o arquivo ser criado
        new Thread().sleep(3000);

        List<Jogo> novoArquivojogoList = CsvUtils.lerArquivoCsv(caminho);

        int numLines = novoArquivojogoList.size();
        Assert.assertEquals(1, numLines);
    }

    @Test
    public void testFiltroPlataformaPC() throws InterruptedException, URISyntaxException {
        JogoController.filtraPlataformaEEscreveNovoArquivo(jogoList, Plataforma.PC);

        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games-filtrados.csv").toURI());

        //esperando 3 segundos para o arquivo ser criado
        new Thread().sleep(3000);
        List<Jogo> novoArquivojogoList = CsvUtils.lerArquivoCsv(caminho);

        int numLines = novoArquivojogoList.size();
        Assert.assertEquals(1, numLines);
    }

    @Test
    public void testFiltroPlataformaWii() throws InterruptedException, URISyntaxException {
        JogoController.filtraPlataformaEEscreveNovoArquivo(jogoList, Plataforma.Wii);

        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games-filtrados.csv").toURI());
        //esperando 2 segundos para o arquivo ser criado
        new Thread().sleep(3000);
        List<Jogo> novoArquivojogoList = CsvUtils.lerArquivoCsv(caminho);

        int numLines = novoArquivojogoList.size();
        Assert.assertEquals(15, numLines);
    }
}

package br.inatel.cdg.utils;

import br.inatel.cdg.model.Jogo;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestCSVUtils {

    private static List<Jogo> jogoList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        jogoList = CsvUtils.lerArquivoCsv(caminho);
    }

    @Test
    public void testNumberOfLines() {
        int numLines = jogoList.size();
        Assert.assertEquals(100, numLines);
    }

    @Test
    public void testEscreverArquivos() throws URISyntaxException, InterruptedException {
        CsvUtils.escreverArquivo(jogoList);

        //esperando 2 segundos para o arquivo ser criado
        Thread.sleep(2000);

        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games-filtrados.csv").toURI());
        List<Jogo> novoArquivojogoList = CsvUtils.lerArquivoCsv(caminho);

        int numLines = novoArquivojogoList.size();
        Assert.assertEquals(100, numLines);
    }
}
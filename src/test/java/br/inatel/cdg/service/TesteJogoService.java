package br.inatel.cdg.service;

import br.inatel.cdg.model.Jogo;
import br.inatel.cdg.model.Plataforma;
import br.inatel.cdg.model.Produtora;
import br.inatel.cdg.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TesteJogoService {

    private static List<Jogo> jogoList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        jogoList = CsvUtils.lerArquivoCsv(caminho);
    }

    @Test
    public void testeGamesPS4(){
        List<Jogo> ps4Jogos = JogoService.lerListaPorPlataforma(jogoList, Plataforma.PS4);

        Assert.assertEquals(5, ps4Jogos.size());
    }

    @Test
    public void testeGameX360(){
        List<Jogo> x360Jogos = JogoService.lerListaPorPlataforma(jogoList, Plataforma.X360);

        Assert.assertEquals(16, x360Jogos.size());
    }

    @Test
    public void testeGameActivision(){
        List<Jogo> activisionJogos = JogoService.lerListaPorProdutora(jogoList, Produtora.Activision);

        Assert.assertEquals(14, activisionJogos.size());
    }

    @Test
    public void testeGameMicrosoft(){
        List<Jogo> microsoftJogos = JogoService.lerListaPorProdutora(jogoList, Produtora.MicrosoftGameStudios);

        Assert.assertEquals(6, microsoftJogos.size());
    }

    @Test
    public void testeGameBy2005Year(){
        List<Jogo> jogosByYear = JogoService.lerListaPorAno(jogoList, 2005);

        Assert.assertEquals(6, jogosByYear.size());
    }

    @Test
    public void testeGameBy1982Year(){
        List<Jogo> jogosByYear = JogoService.lerListaPorAno(jogoList, 1982);

        Assert.assertEquals(1, jogosByYear.size());
        Assert.assertEquals(jogosByYear.get(0).getYear(), 1982);
    }
}

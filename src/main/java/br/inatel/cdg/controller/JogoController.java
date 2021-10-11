package br.inatel.cdg.controller;

import br.inatel.cdg.model.Jogo;
import br.inatel.cdg.model.Plataforma;
import br.inatel.cdg.model.Produtora;
import br.inatel.cdg.service.JogoService;
import br.inatel.cdg.utils.CsvUtils;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JogoController {

    public static void filtraJogo() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, URISyntaxException {

        boolean menuAberto = true;
        do {
            Scanner menu = new Scanner(System.in);
            System.out.println("Escolha como deseja Filtrar o Jogo:");
            System.out.println("1 - Plataforma.");
            System.out.println("2 - Produtora.");
            System.out.println("0 - Para encerrrar o programa.");
            System.out.println("|-----------------------------------|");
            System.out.println("Digite uma opção: ");

            int opcao;

            try {
                opcao = menu.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Caracter inserido não compatível!");
                continue;
            }

            if (opcao == 0) {
                System.out.println("Programa encerrado!");
                menu.close();
                menuAberto = false;
            } else {
                switch (opcao) {
                    case 1:
                        menuFiltroPlataforma();
                        break;

                    case 2:
                        menuFiltroProdutora();
                        break;

                    default:
                        System.out.print("\nOpção Inválida!");
                        break;
                }
            }
        } while (menuAberto);
    }

    private static void menuFiltroProdutora() throws URISyntaxException {

        boolean menuAberto = true;
        do {
            Scanner menuProdutora = new Scanner(System.in);
            System.out.println("Escolha Produtora do qual deseja Filtrar :");
            System.out.println("1 - Activision");
            System.out.println("2 - MicrosoftGameStudios.");
            System.out.println("3 - Nintendo.");
            System.out.println("4 - SonyComputerEntertainment.");
            System.out.println("5 - TakeTwoInteractive.");
            System.out.println("0 - Para encerrrar o programa.");
            System.out.println("|-----------------------------------|");
            System.out.println("Digite uma opção: ");

            int opcao = menuProdutora.nextInt();

            if (opcao == 0) {
                System.out.println("Programa encerrado!");
                menuAberto = false;

            } else {
                List<Jogo> jogoList = new ArrayList<>();
                List<Jogo> jogoListFiltrada = new ArrayList<>();
                Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
                jogoList = CsvUtils.lerArquivoCsv(caminho);

                switch (opcao) {
                    case 1:
                        jogoListFiltrada = JogoService.lerListaPorProdutora(jogoList, Produtora.Activision);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 2:
                        jogoListFiltrada = JogoService.lerListaPorProdutora(jogoList, Produtora.MicrosoftGameStudios);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 3:
                        jogoListFiltrada = JogoService.lerListaPorProdutora(jogoList, Produtora.Nintendo);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 4:
                        jogoListFiltrada = JogoService.lerListaPorProdutora(jogoList, Produtora.SonyComputerEntertainment);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 5:
                        jogoListFiltrada = JogoService.lerListaPorProdutora(jogoList, Produtora.TakeTwoInteractive);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    default:
                        System.out.print("\nOpção Inválida!");
                        break;
                }
            }
        } while (menuAberto);
    }

    private static void menuFiltroPlataforma() throws URISyntaxException {

        boolean menuAberto = true;

        do {
            Scanner menuPlataforma = new Scanner(System.in);
            System.out.println("Escolha Produtora do qual deseja Filtrar :");
            System.out.println("1 - PS4.");
            System.out.println("2 - PC.");
            System.out.println("3 - XB.");
            System.out.println("4 - Wii.");
            System.out.println("5 - GB.");
            System.out.println("6 - GBA.");
            System.out.println("7 - X360.");
            System.out.println("8 - PS3.");
            System.out.println("9 - PS2.");
            System.out.println("0 - Para encerrrar o programa.");
            System.out.println("|-----------------------------------|");
            System.out.println("Digite uma opção: ");

            int opcao = menuPlataforma.nextInt();

            if (opcao == 0) {
                System.out.println("Programa encerrado!");
                menuAberto = false;
            } else {
                List<Jogo> jogoList = new ArrayList<>();
                List<Jogo> jogoListFiltrada = new ArrayList<>();
                Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
                jogoList = CsvUtils.lerArquivoCsv(caminho);

                switch (opcao) {
                    case 1:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.PS4);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 2:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.PC);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 3:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.XB);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 4:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.Wii);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 5:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.GB);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 6:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.GBA);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 7:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.X360);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 8:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.PS3);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    case 9:
                        jogoListFiltrada = JogoService.lerListaPorPlataforma(jogoList, Plataforma.PS2);
                        JogoService.escreverListaFiltradaEmArquivoCSV(jogoListFiltrada);
                        break;

                    default:
                        System.out.print("\nOpção Inválida!");
                        break;
                }
            }
        } while (menuAberto);
    }
}

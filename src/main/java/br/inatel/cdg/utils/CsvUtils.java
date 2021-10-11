package br.inatel.cdg.utils;

import br.inatel.cdg.model.Jogo;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

       public static List<Jogo> lerArquivoCsv(Path csvFilePath) {

        List<Jogo> jogoList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<Jogo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Jogo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            jogoList = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogoList;
    }

    public static void escreverArquivo(List<Jogo> listaDeJogos) {

        Writer writer = null;
        try {
            writer = new FileWriter("src/main/resources/vendas-games-filtrados.csv");
            StatefulBeanToCsv<Jogo> beanToCsv = new StatefulBeanToCsvBuilder<Jogo>(writer).build();

            beanToCsv.write(listaDeJogos);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}
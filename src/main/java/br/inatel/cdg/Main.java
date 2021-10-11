package br.inatel.cdg;

import br.inatel.cdg.controller.JogoController;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, URISyntaxException {
        JogoController.filtraJogo();
    }
}

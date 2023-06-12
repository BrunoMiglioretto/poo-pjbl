package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.models.Produto;

public class ProdutoBuilder {
    private String csvDivisor = ",";
    private String arquivo;
    
    public ProdutoBuilder(String arquivo) {
        this.arquivo = arquivo;
    }

    public ArrayList<Produto> run() {
        List<String> lines = readCSV();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        for (String line : lines) {
            String dados[] = line.split(csvDivisor);
            Produto produto = new Produto(
                Integer.parseInt(dados[0]),
                dados[1],
                Double.parseDouble(dados[2]),
                Double.parseDouble(dados[3]),
                dados[4]
            );
            produtos.add(produto);
        }
        return produtos;
    }

    private List<String> readCSV() {
        List<String> lines = new ArrayList<>();
        BufferedReader br = null;
        String linha = "";

        try {
            br = new BufferedReader(new FileReader(arquivo));
            while ((linha = br.readLine()) != null) {
                lines.add(linha);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }
}

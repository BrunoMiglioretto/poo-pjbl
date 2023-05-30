package app.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
    private int id;
    private double quantidade;
    private double preco; // Preço unitário
    private String marca;
    private Date cadastrado_em;

    public Produto(int id, double quantidade, double preco, String marca) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this.marca = marca;
        this.cadastrado_em = new Date();
    }

    public int get_id() {
        return id;
    }    

    public String get_cadastrado_em() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(cadastrado_em);
    } 

}

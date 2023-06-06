package app.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
    private int id;
    private String nome;
    private double quantidade;
    private double preco; // Preço unitário
    private String marca;
    private Date cadastrado_em;

    public Produto(int id, String nome, double quantidade, double preco, String marca) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.marca = marca;
        this.cadastrado_em = new Date();
    }

    public int get_id() {
        return id;
    }    

    public String get_nome() {
        return nome;
    }

    public double get_quantidade() {
        return quantidade;
    }

    public String get_marca() {
        return marca;
    }

    public double get_preco() {
        return preco;
    }

    public String get_cadastrado_em() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(cadastrado_em);
    } 

}

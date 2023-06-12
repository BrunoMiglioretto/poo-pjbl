package app.contollers;

import java.util.ArrayList;

import app.models.Produto;
import utils.PrecoInvalidoException;

public class ProdutoController {
    private ArrayList<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<Produto>(); 
    }

    private int gerarProximoId() {
        int maior_id = 0;
        for (Produto produto: produtos) {
            if (produto.get_id() > maior_id)
                maior_id = produto.get_id();
        }

        return maior_id + 1;
    }
   
    public Produto cadastrarProduto(String nome, double quantidade, double preco, String marca) throws PrecoInvalidoException {
        if (preco <= 0) 
            throw new PrecoInvalidoException("O preço não pode ser menor que 0.");

        Produto produto = new Produto(gerarProximoId(), nome, quantidade, preco, marca);

        produtos.add(produto);

        return produto;
    }


    public Produto excluirProduto(int id) throws Exception{
        Produto produtoExcluido = null;
        for (Produto produto: produtos) {
            
            if (produto.get_id() == id) {
                produto.excluir();
                produtoExcluido = produto;
                break;
            }
        }
        if (produtoExcluido == null) {
            throw new Exception("O produto não foi encontrado.", null); 
        }

        return produtoExcluido;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}

package app.contollers;

import java.util.ArrayList;

import app.models.Produto;

public class ProdutoController {
    private ArrayList<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<Produto>(); 
    }

    private int gerar_proximo_id() {
        int maior_id = 0;
        for (Produto produto: produtos) {
            if (produto.get_id() > maior_id)
                maior_id = produto.get_id();
        }

        return maior_id + 1;
    }
   
    public Produto cadastrar_produto(String nome, double quantidade, double preco, String marca) {
        Produto produto = new Produto(gerar_proximo_id(), nome, quantidade, preco, marca);

        produtos.add(produto);

        return produto;
    }


    public Produto deletar_produto(int id) throws Exception{
        Produto produto_removido = null;
        for (Produto produto: produtos) {
            if (produto.get_id() == id) {
                boolean removido = produtos.remove(produto);
                if (!removido) 
                    throw new Exception("O produto não foi encontrado.", null); 
                
                    produto_removido = produto;
            }
        }

        return produto_removido;
    }

    public ArrayList<Produto> get_produtos() {
        return produtos;
    }
}

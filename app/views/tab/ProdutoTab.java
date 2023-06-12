package app.views.tab;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.contollers.ProdutoController;
import app.models.Produto;

public class ProdutoTab extends Tab {
    private ProdutoController produtoController;

    public ProdutoTab(JTable tabela, DefaultTableModel modelo, ProdutoController produtoController) {
        super(tabela, modelo);
        this.produtoController = produtoController;
        this.headers = new Vector<String>();        

        headers.add("Id");
        headers.add("Nome");
        headers.add("Marca");
        headers.add("Preco");
        headers.add("Quantidade");
        headers.add("Data cadastro");

        for (String header: headers) 
            modelo.addColumn(header);

        atualizar();
    }

    @Override
    public void atualizarTabela() {
		ArrayList<Produto> produtos = produtoController.get_produtos();

		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
		   modelo.addRow(new Object[] { 
			   Integer.toString(produto.get_id()),
               produto.get_nome(),
			   produto.get_marca(),
			   Double.toString(produto.get_preco()),
			   Double.toString(produto.get_quantidade()),
			   produto.get_cadastrado_em()
		   });
	   }
    }
}

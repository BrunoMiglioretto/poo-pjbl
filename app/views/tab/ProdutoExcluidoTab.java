package app.views.tab;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.contollers.ProdutoController;
import app.models.Produto;

public class ProdutoExcluidoTab extends ProdutoTab {
    public ProdutoExcluidoTab(JTable tabela, DefaultTableModel modelo, ProdutoController produtoController) {
        super(tabela, modelo, produtoController);
    }
    
    public void atualizarTabela() {
		ArrayList<Produto> produtos = produtoController.getProdutos();

		for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);

            if (produto.excluido()) {
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
}

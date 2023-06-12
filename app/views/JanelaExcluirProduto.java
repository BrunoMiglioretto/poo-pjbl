package app.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.contollers.ProdutoController;
import app.views.tab.ProdutoExcluidoTab;
import app.views.tab.ProdutoTab;

public class JanelaExcluirProduto extends Janela {
    ProdutoController produtoController;    
    ProdutoTab produtoTab;
    ProdutoExcluidoTab produtoExcluidoTab;

    public JanelaExcluirProduto(ProdutoController produtoController, ProdutoTab produtoTab, ProdutoExcluidoTab produtoExcluidoTab) {
        super("Excluir produto");
        this.produtoController = produtoController; 
        this.produtoTab = produtoTab;
        this.produtoExcluidoTab = produtoExcluidoTab;

        this.setSize(500, 500);

        JLabel labelId = new JLabel("id");

        JTextField inputId = new JTextField(10);
        
        JButton butaoExcluir = new JButton("Excluir");

        butaoExcluir.addActionListener(e -> {
            int id = Integer.parseInt(inputId.getText());

            try {
                produtoController.excluirProduto(id);
                produtoTab.atualizar();
                produtoExcluidoTab.atualizar();
                setVisible(false);
            } catch (Exception error) {
                mostrarAviso("Não encontrado", error.getMessage());   
            }
        });

        JPanel painel = new JPanel();

        painel.add(labelId);
        painel.add(inputId);
        painel.add(butaoExcluir);

        add(painel);
    }
    
}

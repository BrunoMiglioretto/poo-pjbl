package app.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.contollers.ProdutoController;
import app.views.tab.ProdutoTab;
import utils.PrecoInvalidoException;

public class JanelaNovoProduto extends Janela {
    ProdutoController produtoController;    
    ProdutoTab produtoTab;

    public JanelaNovoProduto(ProdutoController produtoController, ProdutoTab produtoTab) {
        super("Novo produto");
        this.produtoController = produtoController; 
        this.produtoTab = produtoTab;

        this.setSize(500, 500);

        JLabel labelNome = new JLabel("Nome");
        JLabel labelMarca = new JLabel("Marca");
        JLabel labelPreco = new JLabel("Preço");
        JLabel labelQuantidade = new JLabel("Quantidade");

        JTextField inputNome = new JTextField(10);
        JTextField inputMarca = new JTextField(10);
        JTextField inputPreco = new JTextField(10);
        JTextField inputQuantidade = new JTextField(10);
        
        JButton butaoCadastro = new JButton("Cadastrar");

        butaoCadastro.addActionListener(e -> {
            String nome = inputNome.getText();
            String marca = inputMarca.getText();
            String preco = inputPreco.getText();
            String quantidade = inputQuantidade.getText();

            try {
                produtoController.cadastrar_produto(
                    nome,
                    Double.parseDouble(quantidade), 
                    Double.parseDouble(preco), 
                    marca
                );
                produtoTab.atualizar();
                setVisible(false);
            } catch(PrecoInvalidoException error) {
                mostrarAviso("Erro", error.getMessage());
            }
        });

        JPanel painel = new JPanel();

        painel.add(labelNome);
        painel.add(inputNome);
        painel.add(labelMarca);
        painel.add(inputMarca);
        painel.add(labelPreco);
        painel.add(inputPreco);
        painel.add(labelQuantidade);
        painel.add(inputQuantidade);
        painel.add(butaoCadastro);

        add(painel);
    } 

}

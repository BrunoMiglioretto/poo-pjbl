package app.views;

import java.awt.Panel;
import java.beans.Visibility;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import app.contollers.ProdutoController;
import app.models.Produto;

public class ProdutoJanela extends JFrame {
    ProdutoController produtoController;    
    DefaultTableModel modeloTabelaProduto;

    public ProdutoJanela(ProdutoController produtoController, DefaultTableModel modeloTabelaProduto) {
        super("Novo produto");
        this.modeloTabelaProduto = modeloTabelaProduto;
        this.produtoController = produtoController; 

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

            produtoController.cadastrar_produto(
                nome,
                Double.parseDouble(quantidade), 
                Double.parseDouble(preco), 
                marca
            );

            setVisible(false);
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

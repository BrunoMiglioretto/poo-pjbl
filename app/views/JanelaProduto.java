package app.views;

import java.awt.Dialog;
import java.awt.Panel;
import java.beans.Visibility;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import utils.PrecoInvalidoException;

public class JanelaProduto extends JFrame {
    ProdutoController produtoController;    
    DefaultTableModel modeloTabelaProduto;
    JPanel painel;

    public JanelaProduto(ProdutoController produtoController, DefaultTableModel modeloTabelaProduto) {
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

            try {
                produtoController.cadastrar_produto(
                    nome,
                    Double.parseDouble(quantidade), 
                    Double.parseDouble(preco), 
                    marca
                );
                setVisible(false);
            } catch(PrecoInvalidoException error) {
                adicionarMensagem(error.getMessage());
            }
        });

        painel = new JPanel();

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

    private void adicionarMensagem(String mensagem) { 
        JDialog dialog = new JDialog(this, "Erro");
        JLabel labelMensagem = new JLabel(mensagem);
        dialog.add(labelMensagem);
        dialog.setSize(500, 100);
        dialog.setVisible(true);
    }
}

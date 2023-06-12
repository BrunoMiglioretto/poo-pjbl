package app.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.contollers.ProdutoController;
import app.models.Produto;


public class JanelaPrincipal extends JFrame {
	private ProdutoController produtoController;	
	private JTable TabelaProduto; 
	private DefaultTableModel modeloTabelaProduto;
	private JTable TabelaCarrinho; 
	private JTable TabelaPagamento; 

	public JanelaPrincipal(ProdutoController produtoController) {
		this.produtoController = produtoController;
		setTitle("Sistema de Caixa");
				
		criarTabs();	
		criarMenu();
	}

	private void criarMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu produtoMenu = new JMenu("Produto");
		menuBar.add(produtoMenu);
		
		JFrame janelaNovoProduto = new JanelaProduto(produtoController, modeloTabelaProduto);		
		JMenuItem novoProdutoMenu = new JMenuItem("Novo");
		ActionListener abrirMenuNovoProduto = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaNovoProduto.setVisible(true);	
			}
		};
		novoProdutoMenu.addActionListener(abrirMenuNovoProduto);

		JMenuItem removerAction = new JMenuItem("Remover");
		produtoMenu.add(novoProdutoMenu);
		produtoMenu.add(removerAction);

		JMenuItem novoCarrinhoAction = new JMenuItem("Novo");
		JMenu carrinhoMenu = new JMenu("Carrinho");
		carrinhoMenu.add(novoCarrinhoAction);
		menuBar.add(carrinhoMenu);

		setJMenuBar(menuBar);
	}

	private void criarTabs() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent tabProdutos = criarTabProdutos();
		tabbedPane.addTab("Produtos", tabProdutos);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		JComponent tabCarrinhos = criarTabCarrinhos();
		tabbedPane.addTab("Carrinhos", tabCarrinhos);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		add(tabbedPane);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent criarTabProdutos() {
		JPanel panel = new JPanel(false);
		JButton botaoRecarregar = new JButton("Recarregar");
		botaoRecarregar.setSize(new Dimension(100, 30));
		botaoRecarregar.addActionListener(e -> {
			atualizarTabelaProdutos();
		});		

		
		modeloTabelaProduto = new DefaultTableModel();
        TabelaProduto = new JTable(modeloTabelaProduto);
        modeloTabelaProduto.addColumn("Id");
        modeloTabelaProduto.addColumn("Quantidade");
        modeloTabelaProduto.addColumn("Preco");
        modeloTabelaProduto.addColumn("Marca");
        modeloTabelaProduto.addColumn("Data cadastro");

		ArrayList<Produto> produtos = produtoController.get_produtos();
		if (produtos.size() > 0) 
			atualizarTabelaProdutos();

		panel.add(botaoRecarregar);
		panel.add(TabelaProduto);
		panel.setLayout(new GridLayout(1, 1));
		
		return panel;
	}

	private void atualizarTabelaProdutos() {
		ArrayList<Produto> produtos = produtoController.get_produtos();

		modeloTabelaProduto.setRowCount(0);
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
		   modeloTabelaProduto.addRow(new Object[] { 
			   Integer.toString(produto.get_id()),
			   Double.toString(produto.get_quantidade()),
			   Double.toString(produto.get_preco()),
			   produto.get_marca(),
			   produto.get_cadastrado_em()
		   });
	   }
	}

	protected JComponent criarTabCarrinhos() {
		JPanel panel = new JPanel(false);
		
		Object [][] dados = {
			{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
			{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
			{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
		};

		String [] colunas = {"Nome", "Telefone", "Email"};

		JTable filler = new JTable(dados, colunas);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
}

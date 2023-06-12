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
import app.views.tab.ProdutoTab;


public class JanelaPrincipal extends Janela {
	private ProdutoController produtoController;	
	private ProdutoTab produtoTab;

	public JanelaPrincipal(ProdutoController produtoController) {
		super("Sistema de Caixa");
		this.produtoController = produtoController;
				
		criarTabs();	
		criarMenu();
	}

	private void criarMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu produtoMenu = new JMenu("Produto");
		menuBar.add(produtoMenu);
		
		JFrame janelaNovoProduto = new JanelaNovoProduto(produtoController, produtoTab);		
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
		
		produtoTab = construirTabProdutos();
		tabbedPane.addTab("Produtos", produtoTab);
		tabbedPane.addTab("Carrinhos", criarTabCarrinhos());

		add(tabbedPane);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected ProdutoTab construirTabProdutos() {
		DefaultTableModel modelo = new DefaultTableModel();
        JTable tabela = new JTable(modelo);
		return new ProdutoTab(tabela, modelo, produtoController);
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

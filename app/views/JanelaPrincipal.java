package app.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.contollers.ProdutoController;
import app.views.tab.ProdutoExcluidoTab;
import app.views.tab.ProdutoTab;


public class JanelaPrincipal extends Janela {
	private ProdutoController produtoController;	
	private ProdutoTab produtoTab;
	private ProdutoExcluidoTab produtoExcluidoTab;

	public JanelaPrincipal(ProdutoController produtoController) {
		super("Sistema de gerenciamento de estoque");
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
		ActionListener abrirJanelaNovoProduto = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaNovoProduto.setVisible(true);	
			}
		};
		novoProdutoMenu.addActionListener(abrirJanelaNovoProduto);

		JFrame janelaExcluirProduto = new JanelaExcluirProduto(produtoController, produtoTab, produtoExcluidoTab);
		JMenuItem excluirAction = new JMenuItem("Excluir");
		ActionListener abrirJanelaExcluirProduto = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaExcluirProduto.setVisible(true);
			}
		};
		excluirAction.addActionListener(abrirJanelaExcluirProduto);

		produtoMenu.add(novoProdutoMenu);
		produtoMenu.add(excluirAction);

		setJMenuBar(menuBar);
	}

	private void criarTabs() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		produtoTab = construirTabProdutos();
		tabbedPane.addTab("Produtos", produtoTab);
		produtoExcluidoTab = construirTabProdutosExcluidos();
		tabbedPane.addTab("Produtos excluidos", produtoExcluidoTab);

		add(tabbedPane);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected ProdutoTab construirTabProdutos() {
		DefaultTableModel modelo = new DefaultTableModel();
        JTable tabela = new JTable(modelo);
		return new ProdutoTab(tabela, modelo, produtoController);
	}

	protected ProdutoExcluidoTab construirTabProdutosExcluidos() {
		DefaultTableModel modelo = new DefaultTableModel();
        JTable tabela = new JTable(modelo);
		return new ProdutoExcluidoTab(tabela, modelo, produtoController);
	}
}

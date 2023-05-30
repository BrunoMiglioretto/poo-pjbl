package app.test;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class ProgramaTcc extends JFrame implements ActionListener {


/**
 * Create the panel.
 */
public ProgramaTcc() {
	
	setTitle("Caixa");
			
	 // Cria uma barra de menu para o JFrame
	JMenuBar menuBar = new JMenuBar();
	
	// Adiciona a barra de menu ao  frame
	setJMenuBar(menuBar);
	
	 // Define e adiciona dois menus drop down na barra de menus
	JMenu produtoMenu = new JMenu("Produto");
	JMenu carrinhoMenu = new JMenu("Carrinho");
	menuBar.add(produtoMenu);
	menuBar.add(carrinhoMenu);
	
	 // Cria e adiciona um item simples para o menu
	JMenuItem novoAction = new JMenuItem("Novo");
	JMenuItem removerAction = new JMenuItem("Remover");
	
	produtoMenu.add(novoAction);
	produtoMenu.add(removerAction);

	JMenuItem novoCarrinhoAction = new JMenuItem("Novo");
	
	produtoMenu.add(novoCarrinhoAction);
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JComponent cadastroPanel1 = makeTextPanel("Panel1");
	tabbedPane.addTab("Cadastro", cadastroPanel1);
	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	
	JComponent orcamentoPanel2 = makeTextPanel("Panel2");
	tabbedPane.addTab("Orçamento", orcamentoPanel2);
	tabbedPane.setMnemonicAt(1,  KeyEvent.VK_2);
	
	JComponent custosPanel3 = makeTextPanel("Panel3");
	custosPanel3.setPreferredSize(new Dimension(410, 50));
	tabbedPane.addTab("Custos", custosPanel3);
	tabbedPane.setMnemonicAt(2,  KeyEvent.VK_3);
	
	add(tabbedPane);
	
	
	tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	
	

}

protected JComponent makeTextPanel(String text) {
	JPanel panel = new JPanel(false);
	JLabel filler = new JLabel(text);
	filler.setHorizontalAlignment(JLabel.CENTER);
	panel.setLayout(new GridLayout(1, 1));
	panel.add(filler);
	return panel;
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
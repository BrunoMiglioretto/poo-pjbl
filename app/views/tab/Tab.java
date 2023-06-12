package app.views.tab;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Tab extends JPanel {
	protected JTable tabela; 
	protected DefaultTableModel modelo;
	protected Vector<String> headers;
    
    public Tab(JTable tabela, DefaultTableModel modelo) {
        super(false);        

        this.tabela = tabela;
        this.modelo = modelo;

		add(tabela);
		setLayout(new GridLayout(1, 1));
    }

	public void atualizar() {
		modelo.setRowCount(0);
		modelo.addRow(headers);
		atualizarTabela();
	} 

    protected abstract void atualizarTabela();
}

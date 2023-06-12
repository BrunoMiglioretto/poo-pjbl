package app.views;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Janela extends JFrame {
    public Janela(String titulo) {
        super(titulo);
		setTitle(titulo);
    }

    protected void mostrarAviso(String titulo, String mensagem) { 
        JDialog dialog = new JDialog(this, titulo);
        JLabel labelMensagem = new JLabel(mensagem);
        dialog.add(labelMensagem);
        dialog.setSize(500, 100);
        dialog.setVisible(true);
    }

}

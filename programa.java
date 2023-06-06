import app.contollers.ProdutoController;
import app.views.JanelaPrincipal;

public class programa {
    public ProdutoController produtoController;    

    public programa() {
        produtoController = new ProdutoController();        

        JanelaPrincipal janela = new JanelaPrincipal(produtoController);
        janela.setDefaultCloseOperation(JanelaPrincipal.EXIT_ON_CLOSE);
        janela.setSize(1024, 768);
        janela.setVisible(true);
    }
}

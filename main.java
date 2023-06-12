import app.contollers.ProdutoController;
import app.views.JanelaPrincipal;

public class main {
    public static ProdutoController produtoController;    
    public static JanelaPrincipal janelaPrincipal;

    public static void main(String[] args) {
        produtoController = new ProdutoController();        

        janelaPrincipal = new JanelaPrincipal(produtoController);
        janelaPrincipal.setDefaultCloseOperation(JanelaPrincipal.EXIT_ON_CLOSE);
        janelaPrincipal.setSize(1024, 768);
        janelaPrincipal.setVisible(true);
    }
}

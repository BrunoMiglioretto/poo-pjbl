import app.contollers.ProdutoController;
import app.views.JanelaPrincipal;

public class main {
    public static ProdutoController produtoController;    

    public static void main(String[] args) {
        produtoController = new ProdutoController();        

        JanelaPrincipal janela = new JanelaPrincipal(produtoController);
        janela.setDefaultCloseOperation(JanelaPrincipal.EXIT_ON_CLOSE);
        janela.setSize(1024, 768);
        janela.setVisible(true);
    }
}

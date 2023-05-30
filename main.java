import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.Box;

public class main {
    public static void main(String[] args) {
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Test");
        guiFrame.setSize(300, 350);
        guiFrame.setLocationRelativeTo(null);

        Box caixaVertical = Box.createVerticalBox();
        ArrayList<JLabel> labelList = new ArrayList<JLabel>();
        ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();
        for (int i = 0; i < 10; i++) {
            Box caixaHorizontal = Box.createHorizontalBox();
            JLabel label = new JLabel("label " + i);
            JTextField input = new JTextField(10);
            labelList.add(label);
            textFieldList.add(input);
            caixaHorizontal.add(label);
            caixaHorizontal.add(input);
            caixaVertical.add(caixaHorizontal);
        }

        guiFrame.add(caixaVertical);
        guiFrame.setVisible(true);

    }
}

/* 
        //JOptionPane.showMessageDialog(null, "Something");
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);

        JLabel label = new JLabel("Uma nova label: ");
        JTextField textField = new JTextField("um texto");
        textField.setSize(100, 100);

        Box caixaHorizontal = Box.createHorizontalBox();
        caixaHorizontal.add(label);
        caixaHorizontal.add(textField);


        Box caixaVertical = Box.createVerticalBox();
        caixaVertical.add(caixaHorizontal);
        caixaVertical.setSize(100, 100);

        frame.add(caixaVertical);

        frame.setVisible(true);
    }
    


*/
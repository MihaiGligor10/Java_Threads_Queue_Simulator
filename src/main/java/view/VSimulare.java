package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VSimulare extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public VSimulare() {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 715);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(22, 11, 635, 654);
        textArea.setEditable(false);
        contentPane.add(textArea);

        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(22, 11, 635, 654);
        contentPane.add(scrollPane);

    }

    public void setText(String s) {
         textArea.setText(s);
    }
}

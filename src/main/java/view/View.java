package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {

    private JPanel contentPane;
    private JTextField nrClients;
    private JTextField nrQueues;
    private JTextField simInterval;
    private JTextField MinArr;
    private JTextField MaxArr;
    private JTextField MinSer;
    private JTextField MaxSer;
    private JLabel NrC;
    private JLabel NrQ;
    private JLabel Si;
    private JLabel Arr;
    private JLabel Ser;
    private JButton Simbutton;

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nrClients = new JTextField();
        nrClients.setBounds(240, 10, 120, 20);
        contentPane.add(nrClients);
        nrClients.setColumns(10);

        nrQueues = new JTextField();
        nrQueues.setBounds(240, 40, 120, 20);
        contentPane.add(nrQueues);
        nrQueues.setColumns(10);

        simInterval = new JTextField();
        simInterval.setBounds(240, 71, 120, 20);
        contentPane.add(simInterval);
        simInterval.setColumns(10);

        MinArr = new JTextField();
        MinArr.setBounds(240, 102, 50, 20);
        contentPane.add(MinArr);
        MinArr.setColumns(10);

        MaxArr = new JTextField();
        MaxArr.setBounds(310, 102, 50, 20);
        contentPane.add(MaxArr);
        MaxArr.setColumns(10);

        MinSer = new JTextField();
        MinSer.setColumns(10);
        MinSer.setBounds(240, 133, 50, 20);
        contentPane.add(MinSer);

        MaxSer = new JTextField();
        MaxSer.setColumns(10);
        MaxSer.setBounds(310, 133, 50, 20);
        contentPane.add(MaxSer);

        NrC = new JLabel("Number of clients");
        NrC.setBounds(40, 13, 150, 14);
        contentPane.add(NrC);

        NrQ = new JLabel("Number of queues");
        NrQ.setBounds(40, 44, 150, 14);
        contentPane.add(NrQ);

        Si = new JLabel("Simulation interval");
        Si.setBounds(40, 74, 150, 14);
        contentPane.add(Si);

        Arr = new JLabel("Min max arrival time");
        Arr.setBounds(40, 105, 150, 14);
        contentPane.add(Arr);

        Ser = new JLabel("Min max service time");
        Ser.setBounds(40, 136, 150, 14);
        contentPane.add(Ser);

        Simbutton = new JButton("Simulate");
        Simbutton.setBounds(140, 181, 150, 50);
        contentPane.add(Simbutton);
    }

    public String getClients() {
        return nrClients.getText();
    }
    public String getQueues() {
        return nrQueues.getText();
    }
    public String getInt() {
        return this.simInterval.getText();
    }
    public String getMinArr() {
        return this.MinArr.getText();
    }
    public String getMaxArr() {
        return this.MaxArr.getText();
    }
    public String getMinSer() {
        return this.MinSer.getText();
    }
    public String getMaxSer() {
        return this.MaxSer.getText();
    }
    public JButton getButton() {
        return Simbutton;
    }

    public void showError(String x) {
        JOptionPane.showMessageDialog(null,x);
    }
}


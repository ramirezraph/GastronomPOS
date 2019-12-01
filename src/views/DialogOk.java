package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogOk extends JDialog {

    private final Font SegoeUI15 = new Font("Segoe UI", Font.PLAIN, 15);
    private final Font SegoeUI20 = new Font("Segoe UI", Font.PLAIN, 20);

    private final Color color_lightgray = new Color(90,90,90);
    private final Color color_jungle = new Color(72,151,164);

    public DialogOk(){
        this("", "");
    }

    public DialogOk(String title, String message){
        setSize(628, 241);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setUndecorated(true);
        setModal(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.lightGray));

        JPanel pnlDialogTitle = new JPanel();
        pnlDialogTitle.setLayout(null);
        pnlDialogTitle.setBackground(color_lightgray);
        add(pnlDialogTitle);
        pnlDialogTitle.setBounds(0,0,628,60);

        JLabel lblDialogTitle = new JLabel(title);
        lblDialogTitle.setFont(SegoeUI20);
        lblDialogTitle.setForeground(Color.WHITE);
        pnlDialogTitle.add(lblDialogTitle);
        lblDialogTitle.setBounds(20, 8, 200,43);

        JLabel lblDialogMessage = new JLabel(message);
        lblDialogMessage.setFont(SegoeUI20);
        lblDialogMessage.setForeground(color_lightgray);
        add(lblDialogMessage);
        lblDialogMessage.setBounds(58, 80, getWidth(), 35);

        JButton btnOk = new JButton("Ok");
        btnOk.setBackground(color_jungle);
        btnOk.setForeground(Color.white);
        btnOk.setFont(SegoeUI20);
        btnOk.setBorder(null);
        btnOk.setFocusable(false);
        add(btnOk);
        btnOk.setBounds(363, 150, 228, 51);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}

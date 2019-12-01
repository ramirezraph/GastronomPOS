package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogYesNo extends JDialog {

    private final Font SegoeUI15 = new Font("Segoe UI", Font.PLAIN, 15);
    private final Font SegoeUI20 = new Font("Segoe UI", Font.PLAIN, 20);

    private final Color color_lightgray = new Color(90,90,90);
    private final Color color_jungle = new Color(72,151,164);
    private final Color color_red = new Color(228,52,52);

    private boolean isYes = false;

    public DialogYesNo(){
        this("", "");
    }

    public DialogYesNo(String title, String message){
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

        JButton btnYes = new JButton("Yes");
        btnYes.setBackground(color_jungle);
        btnYes.setForeground(Color.white);
        btnYes.setFont(SegoeUI20);
        btnYes.setBorder(null);
        btnYes.setFocusable(false);
        add(btnYes);
        btnYes.setBounds(273, 163, 161, 51);
        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isYes = true;
                dispose();
            }
        });

        JButton btnNo = new JButton("No");
        btnNo.setBackground(color_jungle);
        btnNo.setForeground(Color.white);
        btnNo.setFont(SegoeUI20);
        btnNo.setBorder(null);
        btnNo.setFocusable(false);
        add(btnNo);
        btnNo.setBounds(446, 163, 161, 51);
        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isYes = false;
                dispose();
            }
        });
    }

    public boolean getYesNo(){
        return isYes;
    }
}

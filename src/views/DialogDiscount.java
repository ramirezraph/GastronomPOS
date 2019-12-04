package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDiscount extends JDialog {


    private final JTextField txtPercentage;

    public DialogDiscount(int discount){
        setSize(628, 241);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setModal(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.lightGray));

        JPanel pnlDialogTitle = new JPanel();
        pnlDialogTitle.setLayout(null);
        pnlDialogTitle.setBackground(new Color(90,90,90));
        add(pnlDialogTitle);
        pnlDialogTitle.setBounds(0,0,628,60);

        JLabel lblDialogTitle = new JLabel("Discount");
        lblDialogTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblDialogTitle.setForeground(Color.WHITE);
        pnlDialogTitle.add(lblDialogTitle);
        lblDialogTitle.setBounds(20, 8, 200,43);

        JLabel lblDialogMessage = new JLabel("Enter Percentage:");
        lblDialogMessage.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        lblDialogMessage.setForeground(new Color(90,90,90));
        add(lblDialogMessage);
        lblDialogMessage.setBounds(77, 92, getWidth(), 35);

        txtPercentage = new JTextField(String.valueOf(discount));
        txtPercentage.setBackground(Color.WHITE);
        txtPercentage.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        txtPercentage.setHorizontalAlignment(JLabel.RIGHT);
        txtPercentage.setForeground(new Color(43,43,43));
        txtPercentage.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        add(txtPercentage);
        txtPercentage.setBounds(292,92,176,35);

        JLabel lblPercent = new JLabel("%");
        lblPercent.setFont(new Font("Segoe UI", Font.BOLD, 23));
        lblPercent.setForeground(new Color(90,90,90));
        add(lblPercent);
        lblPercent.setBounds(476, 92, getWidth(), 35);

        JButton btnApplyDiscount = new JButton("Apply");
        btnApplyDiscount.setBackground(new Color(72,151,164));
        btnApplyDiscount.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        btnApplyDiscount.setForeground(Color.WHITE);
        btnApplyDiscount.setFocusable(false);
        btnApplyDiscount.setBorder(BorderFactory.createEmptyBorder());
        btnApplyDiscount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnApplyDiscount);
        btnApplyDiscount.setBounds(197,163,237,51);
        btnApplyDiscount.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                }
        );

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(220,108,108));
        btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFocusable(false);
        btnCancel.setBorder(BorderFactory.createEmptyBorder());
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnCancel);
        btnCancel.setBounds(446,163,161,51);
        btnCancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                }
        );

        getRootPane().setDefaultButton(btnApplyDiscount);

    }

    public int getDiscountPercentage(){
        try {
            return Integer.parseInt(txtPercentage.getText());
        } catch (NumberFormatException ex){
            return 0;
        }
    }
}

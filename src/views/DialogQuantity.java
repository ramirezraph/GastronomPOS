package views;

import common.Data;
import common.Order;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DialogQuantity extends JDialog {

    private final Color color_darkgray = new Color(43,43,43);

    JLabel imgHolder;
    JLabel lblProductName;
    JLabel lblTotal;
    JLabel lblQuantity;
    JButton btnMinus;
    JTextField txtQuantity;
    JButton btnPlus;

    public int quantity = 1;

    public DialogQuantity(){
        this(new Data(),"","","",0.00);
    }

    public DialogQuantity(Data data, String code, String image, String name, double price){
        setSize(793,388);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setModal(true);

        JPanel pnlContainer = new JPanel();
        pnlContainer.setLayout(null);
        pnlContainer.setBackground(Color.WHITE);
        pnlContainer.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        add(pnlContainer);
        pnlContainer.setBounds(0,0,793,388);

        imgHolder = new JLabel();
        imgHolder.setBackground(Color.WHITE);
        imgHolder.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        pnlContainer.add(imgHolder);
        imgHolder.setBounds(63,50,150,150);
        // resizing image
        BufferedImage icon = null;
        try {
            File path = new File(image);
            icon = ImageIO.read(path);
            Image dimg = icon.getScaledInstance(imgHolder.getWidth(), imgHolder.getHeight(),
                    Image.SCALE_SMOOTH);
            imgHolder.setIcon(new ImageIcon(dimg));
        } catch (IOException ex){
            ex.printStackTrace();
        }

        lblProductName = new JLabel(name);
        lblProductName.setForeground(new Color(90,90,90));
        lblProductName.setFont(new Font("Segoe UI", Font.PLAIN, 34));
        pnlContainer.add(lblProductName);
        lblProductName.setBounds(236,46,500,49);

        lblTotal = new JLabel("₱"+price);
        lblTotal.setForeground(new Color(90,90,90));
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 34));
        pnlContainer.add(lblTotal);
        lblTotal.setBounds(236,98,300,49);

        lblQuantity = new JLabel("QTY:");
        lblQuantity.setForeground(new Color(90,90,90));
        lblQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        pnlContainer.add(lblQuantity);
        lblQuantity.setBounds(236,171,300,49);

        btnMinus = new JButton("-");
        btnMinus.setBackground(Color.WHITE);
        btnMinus.setForeground(new Color(90,90,90));
        btnMinus.setFont(new Font("Segoe UI", Font.PLAIN, 70));
        btnMinus.setFocusable(false);
        btnMinus.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(0, 10, 12, 10)));
        pnlContainer.add(btnMinus);
        btnMinus.setBounds(350,159,75,65);
        btnMinus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (quantity != 1){
                            quantity--;
                            txtQuantity.setText(String.valueOf(quantity));
                        }
                    }
                }
        );

        txtQuantity = new JTextField(String.valueOf(quantity));
        txtQuantity.setBackground(Color.WHITE);
        txtQuantity.setForeground(new Color(90,90,90));
        txtQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        txtQuantity.setFocusable(false);
        txtQuantity.setHorizontalAlignment(JLabel.CENTER);
        txtQuantity.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 0, 5, 0)));
        pnlContainer.add(txtQuantity);
        txtQuantity.setBounds(420,159,183,65);

        btnPlus = new JButton("+");
        btnPlus.setBackground(Color.WHITE);
        btnPlus.setForeground(new Color(90,90,90));
        btnPlus.setFont(new Font("Segoe UI", Font.PLAIN, 60));
        btnPlus.setFocusable(false);
        btnPlus.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(0, 10, 12, 10)));
        pnlContainer.add(btnPlus);
        btnPlus.setBounds(603,159,75,65);
        btnPlus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quantity++;
                        txtQuantity.setText(String.valueOf(quantity));
                    }
                }
        );

        JButton btnOrder = new JButton("Order");
        btnOrder.setForeground(Color.WHITE);
        btnOrder.setBackground(new Color(62,151,164));
        btnOrder.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        btnOrder.setBorder(BorderFactory.createEmptyBorder());
        btnOrder.setFocusable(false);
        pnlContainer.add(btnOrder);
        btnOrder.setBounds(63,264,382,76);
        btnOrder.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int qty = Integer.parseInt(txtQuantity.getText());
                        double total = qty * price;

                        data.addOrder(new Order(code, name, price, qty, total));

                        MainForm.generateOrderList(data);
                        dispose();
                    }
                }
        );

        JButton btnCancelOrder = new JButton("Cancel");
        btnCancelOrder.setForeground(Color.WHITE);
        btnCancelOrder.setBackground(new Color(220,108,108));
        btnCancelOrder.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        btnCancelOrder.setBorder(BorderFactory.createEmptyBorder());
        btnCancelOrder.setFocusable(false);
        pnlContainer.add(btnCancelOrder);
        btnCancelOrder.setBounds(454,264,247,76);
        btnCancelOrder.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                }
        );

    }
}

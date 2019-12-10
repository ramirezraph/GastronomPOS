package views;

import common.Data;
import common.Order;
import common.Printer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class ReceiptDialog extends JDialog {

    private boolean confirm = false;

    public ReceiptDialog(Data data, String address, String staff, String date, String id, String subtotal,
                         String discount, String total){
        setSize(628, 972);
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

        JLabel lblDialogTitle = new JLabel("Receipt");
        lblDialogTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblDialogTitle.setForeground(Color.WHITE);
        pnlDialogTitle.add(lblDialogTitle);
        lblDialogTitle.setBounds(20, 8, 200,43);

        JPanel pnlReceiptBody = new JPanel();
        pnlReceiptBody.setLayout(null);
        pnlReceiptBody.setBackground(Color.WHITE);
        add(pnlReceiptBody);
        pnlReceiptBody.setBounds(0,54, 628,787);

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\logo_44.png").getImage()
                .getScaledInstance(44, 44, Image.SCALE_SMOOTH)));
        pnlReceiptBody.add(lblLogo);
        lblLogo.setBounds(203,27, 44, 44);

        JLabel lblAppTitle = new JLabel("Gastronom");
        lblAppTitle.setForeground(new Color(90,90,90));
        lblAppTitle.setFont(new Font("Segoe UI", Font.BOLD, 33));
        pnlReceiptBody.add(lblAppTitle);
        lblAppTitle.setBounds(251,30,172,30);

        JLabel lblAddress = new JLabel(address);
        lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblAddress.setHorizontalAlignment(JLabel.CENTER);
        pnlReceiptBody.add(lblAddress);
        lblAddress.setBounds(0,76,628, 21);

        JLabel lblTransactionID = new JLabel("Transaction ID:");
        lblTransactionID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblTransactionID);
        lblTransactionID.setBounds(129,111,103, 21);

        JLabel lblTransactionIDValue = new JLabel(id);
        lblTransactionIDValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblTransactionIDValue);
        lblTransactionIDValue.setBounds(251,111,103, 21);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDate);
        lblDate.setBounds(129,137,37, 21);

        JLabel lblDateValue = new JLabel(date);
        lblDateValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDateValue);
        lblDateValue.setBounds(251,137,200, 21);

        JLabel lblDivider1 = new JLabel("******************************************************");
        lblDivider1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDivider1);
        lblDivider1.setBounds(121,170,414, 21);

        String orderList = "<html>";
        for (Order o: data.getOrderList()){
            orderList += o.getQuantity() + "x       " + o.getName() + " --- ₱" + o.getTotal();
            orderList += "<br>";
        }
        orderList += "</html>";

        JLabel lblOrderedItems = new JLabel(orderList);
        lblOrderedItems.setVerticalAlignment(JLabel.NORTH);
        lblOrderedItems.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblOrderedItems);
        lblOrderedItems.setBounds(130,203,362, 379);

        JLabel lblDivider2 = new JLabel("******************************************************");
        lblDivider2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDivider2);
        lblDivider2.setBounds(121,586,414, 21);

        JLabel lblSubtotal = new JLabel("Subtotal:");
        lblSubtotal.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblSubtotal);
        lblSubtotal.setBounds(121,607,63, 21);

        JLabel lblSubtotalValue = new JLabel(subtotal);
        lblSubtotalValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblSubtotalValue);
        lblSubtotalValue.setBounds(439,607,73, 21);

        JLabel lblDiscount = new JLabel("Discount:");
        lblDiscount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDiscount);
        lblDiscount.setBounds(121,633,66, 21);

        JLabel lblDiscountValue = new JLabel(discount);
        lblDiscountValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDiscountValue);
        lblDiscountValue.setBounds(439,633,73, 21);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblTotal);
        lblTotal.setBounds(121,659,66, 21);

        JLabel lblTotalValue = new JLabel(total);
        lblTotalValue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblTotalValue);
        lblTotalValue.setBounds(439,659,73, 21);

        JLabel lblDivider3 = new JLabel("******************************************************");
        lblDivider3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblDivider3);
        lblDivider3.setBounds(121,685,414, 21);

        JLabel lblThankYou = new JLabel("Thank You & Come Again!");
        lblThankYou.setHorizontalAlignment(JLabel.CENTER);
        lblThankYou.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnlReceiptBody.add(lblThankYou);
        lblThankYou.setBounds(0,720,628, 21);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(new Color(72,151,164));
        btnConfirm.setForeground(Color.white);
        btnConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnConfirm.setBorder(null);
        btnConfirm.setFocusable(true);
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnConfirm);
        btnConfirm.setBounds(95, 886, 235, 51);
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Printer.printComponentToFile(pnlReceiptBody, true);
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
                confirm = true;
                dispose();
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(220,108,108));
        btnCancel.setForeground(Color.white);
        btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnCancel.setBorder(null);
        btnCancel.setFocusable(false);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnCancel);
        btnCancel.setBounds(342, 886, 192, 51);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm = false;
                dispose();
            }
        });

        getRootPane().setDefaultButton(btnConfirm);
    }

    public boolean isConfirm(){
        return confirm;
    }

}

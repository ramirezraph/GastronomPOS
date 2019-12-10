package views;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class ExportTransactionLog extends JComponent {
    public ExportTransactionLog(DefaultTableModel tableModel, String address, String date){
        setSize(1500,1500);
        setLayout(null);

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\logo_44.png").getImage()
                .getScaledInstance(22, 22, Image.SCALE_SMOOTH)));
        add(lblLogo);
        lblLogo.setBounds(0,10, 22, 22);

        JLabel lblAppTitle = new JLabel("GASTRONOM");
        lblAppTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        add(lblAppTitle);
        lblAppTitle.setBounds(30,0,291,40);

        JLabel lblAddress = new JLabel(address);
        lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblAddress);
        lblAddress.setBounds(0,35,500,20);

        JLabel lblTransactionLog = new JLabel("TRANSACTION LOG - " + date);
        lblTransactionLog.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblTransactionLog);
        lblTransactionLog.setBounds(0,55,400,20);

        JTable tblLog = new JTable();
        tblLog.setModel(tableModel);
        tblLog.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        tblLog.setRowHeight(15);

        TableColumnModel tableColumnModel = tblLog.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(0)); // hides
        tableColumnModel.removeColumn(tableColumnModel.getColumn(2)); // hides

        tblLog.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblLog.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblLog.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblLog.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblLog.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblLog.getColumnModel().getColumn(5).setPreferredWidth(50);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblLog.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblLog.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblLog.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblLog.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblLog.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblLog.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        JScrollPane sp = new JScrollPane(tblLog);
        sp.setBackground(Color.WHITE);
        add(sp);
        sp.setBounds(0,80, 650, 1000);




    }
}

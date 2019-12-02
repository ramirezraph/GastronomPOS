package views;

import common.Account;
import common.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogAdminConfirm extends JDialog {

    private boolean accountvalid = false;

    public DialogAdminConfirm(Data data){
        setSize(628, 422);
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

        JLabel lblDialogTitle = new JLabel("Confirm");
        lblDialogTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblDialogTitle.setForeground(Color.WHITE);
        pnlDialogTitle.add(lblDialogTitle);
        lblDialogTitle.setBounds(20, 8, 200,43);

        JLabel lblDialogMessage = new JLabel("This action requires administrator level.");
        lblDialogMessage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblDialogMessage.setForeground(new Color(90,90,90));
        add(lblDialogMessage);
        lblDialogMessage.setBounds(58, 80, getWidth(), 35);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblUsername);
        lblUsername.setBounds(70,134,100,28);

        JTextField txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtUsername.setBackground(Color.WHITE);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        add(txtUsername);
        txtUsername.setBounds(70,172,374,39);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblPassword);
        lblPassword.setBounds(70,222,100,28);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        add(txtPassword);
        txtPassword.setBounds(70,260,374,39);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(new Color(72,151,164));
        btnConfirm.setForeground(Color.white);
        btnConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnConfirm.setBorder(null);
        btnConfirm.setFocusable(false);
        add(btnConfirm);
        btnConfirm.setBounds(65, 339, 235, 51);
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtUsername.getText().isEmpty() || String.valueOf(txtPassword.getPassword()).isEmpty()){
                    DialogOk dialogOk = new DialogOk("Error", "Please enter admin credentials");
                    dialogOk.setVisible(true);
                    return;
                }

                String username = txtUsername.getText();
                String password = String.valueOf(txtPassword.getPassword());

                for (Account o: data.getAccountList()){
                    if (username.equals(o.getUsername()) && password.equals(o.getPassword())){
                        if (o.getLevel().equals("Administrator")){
                            accountvalid = true;
                            dispose();
                            return;
                        } else {
                            DialogOk dialogOk = new DialogOk("Confirm Failed", "Account does not meet the requirement.");
                            dialogOk.setVisible(true);
                            accountvalid = false;

                            txtUsername.setText("");
                            txtPassword.setText("");

                            return;
                        }
                    }
                }

                accountvalid = false;
                DialogOk dialogOk = new DialogOk("Confirm Failed", "Account does not meet the requirement.");
                dialogOk.setVisible(true);

                txtUsername.setText("");
                txtPassword.setText("");
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(220,108,108));
        btnCancel.setForeground(Color.white);
        btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnCancel.setBorder(null);
        btnCancel.setFocusable(false);
        add(btnCancel);
        btnCancel.setBounds(314, 339, 192, 51);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public boolean isAccountValid(){
        return accountvalid;
    }
}

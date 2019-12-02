package views;

import common.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DialogMyAccount extends JDialog {

    private final JButton btnUpdateInformation;

    public DialogMyAccount(Account account){
        setSize(1105, 532);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setModal(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.darkGray));

        JLabel lblMyAccount = new JLabel("MY ACCOUNT");
        lblMyAccount.setFont(new Font("Segoe UI", Font.BOLD, 42));
        lblMyAccount.setForeground(new Color(90,90,90));
        add(lblMyAccount);
        lblMyAccount.setBounds(43, 39, 288, 56);

        JLabel lblUsename = new JLabel("Username");
        lblUsename.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblUsename);
        lblUsename.setBounds(112,154,93,28);

        JTextField txtUsername = new JTextField(account.getUsername());
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtUsername.setBackground(Color.WHITE);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtUsername.setEditable(false);
        add(txtUsername);
        txtUsername.setBounds(112,192,374,39);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblName);
        lblName.setBounds(112,241,93,28);

        JTextField txtName = new JTextField(account.getName());
        txtName.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtName.setBackground(Color.WHITE);
        txtName.setForeground(Color.BLACK);
        txtName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtName.setEditable(false);
        add(txtName);
        txtName.setBounds(112,279,374,39);

        JLabel lblContact = new JLabel("Contact #.");
        lblContact.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblContact);
        lblContact.setBounds(112,328,150,28);

        JTextField txtContactNo = new JTextField(account.getContactNumber());
        txtContactNo.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtContactNo.setBackground(Color.WHITE);
        txtContactNo.setForeground(Color.BLACK);
        txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtContactNo.setEditable(false);
        add(txtContactNo);
        txtContactNo.setBounds(112,366,374,39);

        JLabel lblChangePassword = new JLabel("CHANGE PASSWORD");
        lblChangePassword.setFont(new Font("Segoe UI", Font.BOLD, 21));
        add(lblChangePassword);
        lblChangePassword.setBounds(597,109,250,28);

        JLabel lblOldPassword = new JLabel("Old Password");
        lblOldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblOldPassword);
        lblOldPassword.setBounds(597,154,150,28);

        JPasswordField txtOldPassword = new JPasswordField();
        txtOldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtOldPassword.setBackground(Color.WHITE);
        txtOldPassword.setForeground(Color.BLACK);
        txtOldPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtOldPassword.setEditable(false);
        add(txtOldPassword);
        txtOldPassword.setBounds(597,192,374,39);

        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblNewPassword);
        lblNewPassword.setBounds(597,241,150,28);

        JPasswordField txtNewPassword = new JPasswordField();
        txtNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtNewPassword.setBackground(Color.WHITE);
        txtNewPassword.setForeground(Color.BLACK);
        txtNewPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtNewPassword.setEditable(false);
        add(txtNewPassword);
        txtNewPassword.setBounds(597,279,374,39);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        add(lblConfirmPassword);
        lblConfirmPassword.setBounds(597,328,170,28);

        JPasswordField txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtConfirmPassword.setBackground(Color.WHITE);
        txtConfirmPassword.setForeground(Color.BLACK);
        txtConfirmPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtConfirmPassword.setEditable(false);
        add(txtConfirmPassword);
        txtConfirmPassword.setBounds(597,366,374,39);

        JCheckBox cbEditInformation = new JCheckBox(" Edit Information");
        cbEditInformation.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        cbEditInformation.setFocusable(false);
        add(cbEditInformation);
        cbEditInformation.setBounds(338,53,200,28);
        cbEditInformation.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (cbEditInformation.isSelected()){
                            txtName.setEditable(true);
                            txtContactNo.setEditable(true);
                            txtOldPassword.setEditable(true);
                            txtNewPassword.setEditable(true);
                            txtConfirmPassword.setEditable(true);

                            txtName.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtOldPassword.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtNewPassword.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtConfirmPassword.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));

                            btnUpdateInformation.setEnabled(true);

                        } else {
                            txtName.setEditable(false);
                            txtContactNo.setEditable(false);
                            txtOldPassword.setEditable(false);
                            txtNewPassword.setEditable(false);
                            txtConfirmPassword.setEditable(false);

                            txtName.setText(account.getName());
                            txtContactNo.setText(account.getContactNumber());

                            txtOldPassword.setText("");
                            txtNewPassword.setText("");
                            txtConfirmPassword.setText("");

                            txtName.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtOldPassword.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtNewPassword.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtConfirmPassword.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));

                            btnUpdateInformation.setEnabled(false);

                        }
                    }
                }
        );

        btnUpdateInformation = new JButton("Update Information");
        btnUpdateInformation.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        btnUpdateInformation.setBorder(BorderFactory.createEmptyBorder());
        btnUpdateInformation.setBackground(new Color(43,43,43));
        btnUpdateInformation.setForeground(Color.WHITE);
        btnUpdateInformation.setFocusable(false);
        btnUpdateInformation.setEnabled(false);
        add(btnUpdateInformation);
        btnUpdateInformation.setBounds(578, 471, 304,46);
        btnUpdateInformation.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (txtName.getText().isEmpty() || txtContactNo.getText().isEmpty()){
                            DialogOk dialogOk = new DialogOk("Edit Error", "Incomplete form.");
                            dialogOk.setVisible(true);

                            return;
                        } else {
                            String name = txtName.getText();
                            String contact = txtName.getText();

                            account.editInformation(name, contact);

                            if (String.valueOf(txtOldPassword.getPassword()).isEmpty()
                                    && String.valueOf(txtNewPassword.getPassword()).isEmpty()
                                    && String.valueOf(txtConfirmPassword.getPassword()).isEmpty()){

                                DialogOk dialogOk = new DialogOk("Edit Success","Account information has been updated.");
                                dialogOk.setVisible(true);

                                MainForm.refreshAccountInfo(account);

                                dispose();
                                return;
                            }
                        }

                        if (String.valueOf(txtOldPassword.getPassword()).isEmpty()
                                || String.valueOf(txtNewPassword.getPassword()).isEmpty()
                                || String.valueOf(txtConfirmPassword.getPassword()).isEmpty()){
                            DialogOk dialogOk = new DialogOk("Edit Error", "Incomplete form.");
                            dialogOk.setVisible(true);
                        } else {
                            String oldpassword = String.valueOf(txtOldPassword.getPassword());
                            String newpassword = String.valueOf(txtNewPassword.getPassword());
                            String confirmpassword = String.valueOf(txtConfirmPassword.getPassword());

                            account.editPassword(oldpassword, newpassword, confirmpassword);

                            MainForm.refreshAccountInfo(account);

                            dispose();
                        }




                    }
                }
        );

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        btnCancel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setForeground(new Color(43,43,43));
        btnCancel.setFocusable(false);
        add(btnCancel);
        btnCancel.setBounds(897, 471, 197,46);
        btnCancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                }
        );



    }
}

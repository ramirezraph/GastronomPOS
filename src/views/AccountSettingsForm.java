package views;

import common.Account;
import common.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccountSettingsForm extends JDialog {

    private final Color color_darkgray = new Color(43,43,43);
    private final Font fontX = new Font("Segoe UI", Font.PLAIN, 30);

    private final Color color_border_lightgray = new Color(200,200,200);
    private final Color color_whitesmoke = new Color(238,238,238);

    private final JLabel btnCancelEdit;
    private final JLabel btnSubmitEdit;
    private JTable tblAccounts;
    private JTextField txtName;
    private JTextField txtContactNo;
    private JTextField txtUsername;
    private JTextField txtLastLogin;

    private JPanel pnlAccountInfo;
    private DefaultTableModel tblAccountsModel;

    public AccountSettingsForm(Data data){
        setSize(1500, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setModal(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(color_darkgray));

        JPanel pnlTop = new JPanel();
        pnlTop.setLayout(null);
        pnlTop.setBackground(color_darkgray);
        add(pnlTop);
        pnlTop.setBounds(0,0, 1500, 104);

        JLabel lblFormTitle = new JLabel("  Account Settings");
        lblFormTitle.setIcon(new ImageIcon(".\\src\\resources\\accountsettingsColored_64.png"));
        lblFormTitle.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        lblFormTitle.setForeground(Color.WHITE);
        pnlTop.add(lblFormTitle);
        lblFormTitle.setBounds(43, 20, 300, 67);

        // Close Button
        JLabel btnClose = new JLabel("X");
        btnClose.setBounds(1433, 20, 56, 56);
        btnClose.setFont(fontX);
        btnClose.setForeground(Color.RED);
        pnlTop.add(btnClose);
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setForeground(new Color(255,58,58));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setForeground(Color.RED);
            }
        });
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        JPanel pnlMain = new JPanel();
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setLayout(null);
        add(pnlMain);
        pnlMain.setBounds(0,104, 1500, 696);

        JLabel lblAccountList = new JLabel("Account List");
        lblAccountList.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAccountList.setForeground(color_darkgray);
        pnlMain.add(lblAccountList);
        lblAccountList.setBounds(56,43,121,28);

        JButton btnLoadAccount = new JButton("Load / Refresh");
        btnLoadAccount.setFocusable(false);
        btnLoadAccount.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnLoadAccount.setBackground(Color.WHITE);
        btnLoadAccount.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        pnlMain.add(btnLoadAccount);
        btnLoadAccount.setBounds(538,35,309,36);
        btnLoadAccount.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createAccountTable(data);

                        txtName.setText("");
                        txtContactNo.setText("");
                        txtUsername.setText("");
                        txtLastLogin.setText("");
                        clearTableSelection();
                    }
                }
        );

        // Create Account

        JPanel pnlCreateAccount = new JPanel();
        pnlCreateAccount.setLayout(null);
        pnlCreateAccount.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlCreateAccount.setEnabled(false);
        pnlCreateAccount.setVisible(false);
        pnlCreateAccount.setBackground(color_whitesmoke);
        pnlMain.add(pnlCreateAccount);
        pnlCreateAccount.setBounds(924, 18, 511,661);

        JPanel pnlCreateAccountTop = new JPanel();
        pnlCreateAccountTop.setLayout(null);
        pnlCreateAccountTop.setBackground(color_darkgray);
        pnlCreateAccount.add(pnlCreateAccountTop);
        pnlCreateAccountTop.setBounds(0,0, 511, 49);

        JLabel lblCreateAccount = new JLabel("Create New Account");
        lblCreateAccount.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblCreateAccount.setForeground(color_whitesmoke);
        pnlCreateAccountTop.add(lblCreateAccount);
        lblCreateAccount.setBounds(168, 11,181, 27);

        JLabel lblCreateName = new JLabel("Name");
        lblCreateName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlCreateAccount.add(lblCreateName);
        lblCreateName.setBounds(71, 73,55,28);

        JTextField txtCreateName = new JTextField();
        txtCreateName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCreateName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlCreateAccount.add(txtCreateName);
        txtCreateName.setBounds(71, 110, 374, 39);

        JLabel lblCreateContact = new JLabel("Contact #.");
        lblCreateContact.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlCreateAccount.add(lblCreateContact);
        lblCreateContact.setBounds(71, 159,95,28);

        JTextField txtCreateContact = new JTextField();
        txtCreateContact.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCreateContact.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlCreateAccount.add(txtCreateContact);
        txtCreateContact.setBounds(71, 197, 374, 39);

        JLabel lblCreateUsername = new JLabel("Username");
        lblCreateUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlCreateAccount.add(lblCreateUsername);
        lblCreateUsername.setBounds(71, 246,242,28);

        JTextField txtCreateUsername = new JTextField();
        txtCreateUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCreateUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlCreateAccount.add(txtCreateUsername);
        txtCreateUsername.setBounds(71, 284, 374, 39);

        JLabel lblCreatePassword = new JLabel("Password");
        lblCreatePassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlCreateAccount.add(lblCreatePassword);
        lblCreatePassword.setBounds(71, 333,95,28);

        JPasswordField txtCreatePassword = new JPasswordField();
        txtCreatePassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCreatePassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlCreateAccount.add(txtCreatePassword);
        txtCreatePassword.setBounds(71, 371, 374, 39);

        JLabel lblCreateConfirmPassword = new JLabel("Confirm Password");
        lblCreateConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlCreateAccount.add(lblCreateConfirmPassword);
        lblCreateConfirmPassword.setBounds(71, 420,167,28);

        JPasswordField txtCreateConfirmPassword = new JPasswordField();
        txtCreateConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCreateConfirmPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlCreateAccount.add(txtCreateConfirmPassword);
        txtCreateConfirmPassword.setBounds(71, 458, 374, 39);

        JLabel btnSubmitCreate = new JLabel();
        btnSubmitCreate.setIcon(new ImageIcon(".\\src\\resources\\btnSubmit.png"));
        pnlCreateAccount.add(btnSubmitCreate);
        btnSubmitCreate.setBounds(108, 574, 143,71);
        btnSubmitCreate.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnSubmitCreate.setIcon(new ImageIcon(".\\src\\resources\\btnSubmitHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnSubmitCreate.setIcon(new ImageIcon(".\\src\\resources\\btnSubmit.png"));
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String name = txtCreateName.getText();
                        String contact = txtCreateContact.getText();
                        String username = txtCreateUsername.getText();
                        String password = String.valueOf(txtCreatePassword.getPassword());
                        String confirmPassword = String.valueOf(txtCreateConfirmPassword.getPassword());

                        if (name.isEmpty() || contact.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                            DialogOk dialogOk = new DialogOk("Create Account Error", "Please complete the form.");
                            dialogOk.setVisible(true);
                        } else {
                            if (password.equals(confirmPassword)){
                                Account newAccount = new Account(name,"Staff", username, password, contact);
                                data.addAccount(newAccount);

                                MainForm.refreshStatsData(data);

                                txtCreateName.setText("");
                                txtCreateContact.setText("");
                                txtCreateUsername.setText("");
                                txtCreatePassword.setText("");
                                txtCreateConfirmPassword.setText("");

                                pnlCreateAccount.setEnabled(false);
                                pnlCreateAccount.setVisible(false);

                                pnlAccountInfo.setEnabled(true);
                                pnlAccountInfo.setVisible(true);

                                createAccountTable(data);
                            } else {
                                DialogOk dialogOk = new DialogOk("Create Account Error", "Password mismatch.");
                                dialogOk.setVisible(true);
                            }
                        }
                    }
                }
        );

        JLabel btnCancelCreate = new JLabel();
        btnCancelCreate.setIcon(new ImageIcon(".\\src\\resources\\btnCancel.png"));
        pnlCreateAccount.add(btnCancelCreate);
        btnCancelCreate.setBounds(261, 574, 143,71);
        btnCancelCreate.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnCancelCreate.setIcon(new ImageIcon(".\\src\\resources\\btnCancelHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnCancelCreate.setIcon(new ImageIcon(".\\src\\resources\\btnCancel.png"));
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        txtCreateName.setText("");
                        txtCreateContact.setText("");
                        txtCreateUsername.setText("");
                        txtCreatePassword.setText("");
                        txtCreateConfirmPassword.setText("");

                        pnlCreateAccount.setEnabled(false);
                        pnlCreateAccount.setVisible(false);

                        pnlAccountInfo.setEnabled(true);
                        pnlAccountInfo.setVisible(true);
                    }
                }
        );

        // End Create Account

        // Account List

        tblAccounts = new JTable();

        createAccountTable(data);

        JPanel pnlAccountList = new JPanel();
        pnlAccountList.setBackground(color_whitesmoke);
        pnlAccountList.setLayout(null);
        pnlMain.add(pnlAccountList);
        pnlAccountList.setBounds(43, 81, 827, 519);

        JScrollPane spAccounts = new JScrollPane(tblAccounts);
        pnlAccountList.add(spAccounts, BorderLayout.CENTER);
        spAccounts.setBounds(0,0,827,519);

        tblAccounts.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DefaultTableModel tableModel = (DefaultTableModel) tblAccounts.getModel();
                        int selectedRowIndex = tblAccounts.getSelectedRow();
                        txtName.setText(tableModel.getValueAt(selectedRowIndex, 0).toString());
                        txtContactNo.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
                        txtUsername.setText(tableModel.getValueAt(selectedRowIndex, 2).toString());
                        txtLastLogin.setText(tableModel.getValueAt(selectedRowIndex, 3).toString());
                    }
                }
        );

        // End Account List

        pnlAccountInfo = new JPanel();
        pnlAccountInfo.setLayout(null);
        pnlAccountInfo.setBackground(Color.WHITE);
        pnlMain.add(pnlAccountInfo);
        pnlAccountInfo.setBounds(890, 45, 594,661);

        JLabel lblAccountInfo = new JLabel("Account Information");
        lblAccountInfo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAccountInfo.setForeground(color_darkgray);
        pnlAccountInfo.add(lblAccountInfo);
        lblAccountInfo.setBounds(26, 18,206, 28);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlAccountInfo.add(lblName);
        lblName.setBounds(40, 72,55,28);

        txtName = new JTextField();
        txtName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtName.setBackground(Color.WHITE);
        txtName.setEditable(false);
        txtName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlAccountInfo.add(txtName);
        txtName.setBounds(40, 110, 374, 39);

        JLabel lblContactNo = new JLabel("Contact #.");
        lblContactNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlAccountInfo.add(lblContactNo);
        lblContactNo.setBounds(40, 159,95,28);

        txtContactNo = new JTextField();
        txtContactNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtContactNo.setEditable(false);
        txtContactNo.setBackground(Color.WHITE);
        txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlAccountInfo.add(txtContactNo);
        txtContactNo.setBounds(40, 197, 374, 39);

        JLabel lblLastLogin = new JLabel("Last Login (MM/DD/YYYY)");
        lblLastLogin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlAccountInfo.add(lblLastLogin);
        lblLastLogin.setBounds(40, 246,242,28);

        txtLastLogin = new JTextField();
        txtLastLogin.setEditable(false);
        txtLastLogin.setBackground(Color.WHITE);
        txtLastLogin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtLastLogin.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlAccountInfo.add(txtLastLogin);
        txtLastLogin.setBounds(40, 284, 374, 39);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pnlAccountInfo.add(lblUsername);
        lblUsername.setBounds(40, 333,95,28);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtUsername.setBackground(Color.WHITE);
        txtUsername.setEditable(false);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        pnlAccountInfo.add(txtUsername);
        txtUsername.setBounds(40, 371, 374, 39);

        JButton btnResetPassword = new JButton("Reset Password");
        btnResetPassword.setFocusable(false);
        btnResetPassword.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnResetPassword.setBackground(Color.WHITE);
        btnResetPassword.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        pnlAccountInfo.add(btnResetPassword);
        btnResetPassword.setBounds(40,439,374,48);
        btnResetPassword.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedRowIndex = tblAccounts.getSelectedRow();

                        if (selectedRowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Reset Password Error", "Please select an account.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        DialogAdminConfirm dialogAdminConfirm = new DialogAdminConfirm(data);
                        dialogAdminConfirm.setVisible(true);

                        if (dialogAdminConfirm.isAccountValid()){
                            data.resetPassword(txtUsername.getText());
                        }
                    }
                }
        );

        JButton btnUnlockAccount = new JButton("Unlock Account");
        btnUnlockAccount.setFocusable(false);
        btnUnlockAccount.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnUnlockAccount.setBackground(Color.WHITE);
        btnUnlockAccount.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        pnlAccountInfo.add(btnUnlockAccount);
        btnUnlockAccount.setBounds(40,498,374,48);
        btnUnlockAccount.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedRowIndex = tblAccounts.getSelectedRow();

                        if (selectedRowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Unlock Account Error", "Please select an account.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        DialogAdminConfirm dialogAdminConfirm = new DialogAdminConfirm(data);
                        dialogAdminConfirm.setVisible(true);

                        if (dialogAdminConfirm.isAccountValid()){
                            data.removeFromLockedAccountList(txtUsername.getText());
                            DialogOk dialogOk = new DialogOk("Success", "The account: " + txtUsername.getText()
                                    + " is now unlocked.");
                            dialogOk.setVisible(true);
                        }
                    }
                }
        );

        JLabel btnCreateAccount = new JLabel();
        btnCreateAccount.setIcon(new ImageIcon(".\\src\\resources\\btnCreateAccount.png"));
        pnlMain.add(btnCreateAccount);
        btnCreateAccount.setBounds(43, 611, 269,71);
        btnCreateAccount.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnCreateAccount.setIcon(new ImageIcon(".\\src\\resources\\btnCreateAccountHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnCreateAccount.setIcon(new ImageIcon(".\\src\\resources\\btnCreateAccount.png"));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        btnCreateAccount.setIcon(new ImageIcon(".\\src\\resources\\btnCreateAccount.png"));

                        pnlCreateAccount.setEnabled(true);
                        pnlCreateAccount.setVisible(true);

                        pnlAccountInfo.setEnabled(false);
                        pnlAccountInfo.setVisible(false);

                        txtName.setText("");
                        txtContactNo.setText("");
                        txtUsername.setText("");
                        txtLastLogin.setText("");
                        clearTableSelection();
                    }
                }
        );

        // EDIT ACCOUNT

        JLabel btnEditAccount = new JLabel();
        btnEditAccount.setIcon(new ImageIcon(".\\src\\resources\\btnEditAccount.png"));
        pnlMain.add(btnEditAccount);
        btnEditAccount.setBounds(322, 611, 269,71);
        btnEditAccount.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnEditAccount.setIcon(new ImageIcon(".\\src\\resources\\btnEditAccountHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnEditAccount.setIcon(new ImageIcon(".\\src\\resources\\btnEditAccount.png"));
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        btnEditAccount.setIcon(new ImageIcon(".\\src\\resources\\btnEditAccount.png"));

                        int selectedRowIndex = tblAccounts.getSelectedRow();

                        if (selectedRowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Edit Error", "Please select an account.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        txtName.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                        txtName.setEditable(true);
                        txtName.setFocusable(true);

                        txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(72,151,164), 3),
                                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                        txtContactNo.setEditable(true);
                        txtContactNo.setFocusable(true);

                        btnSubmitEdit.setVisible(true);
                        btnSubmitEdit.setEnabled(true);

                        btnCancelEdit.setVisible(true);
                        btnCancelEdit.setEnabled(true);

                        pnlCreateAccount.setEnabled(false);
                        pnlCreateAccount.setVisible(false);

                        pnlAccountInfo.setEnabled(true);
                        pnlAccountInfo.setVisible(true);

                    }
                }
        );

        btnSubmitEdit = new JLabel();
        btnSubmitEdit.setIcon(new ImageIcon(".\\src\\resources\\btnSubmit.png"));
        btnSubmitEdit.setVisible(false);
        btnSubmitEdit.setEnabled(false);
        pnlAccountInfo.add(btnSubmitEdit);
        btnSubmitEdit.setBounds(78, 554, 143,71);
        btnSubmitEdit.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnSubmitEdit.setIcon(new ImageIcon(".\\src\\resources\\btnSubmitHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnSubmitEdit.setIcon(new ImageIcon(".\\src\\resources\\btnSubmit.png"));
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        String username = txtUsername.getText();
                        String name = txtName.getText();
                        String contact = txtContactNo.getText();

                        if (name.isEmpty() || contact.isEmpty()){
                            DialogOk dialogOk = new DialogOk("Create Account Error", "Please complete the form.");
                            dialogOk.setVisible(true);
                        } else {

                            data.editAccountInfo(username, name, contact);

                            txtName.setText("");
                            txtContactNo.setText("");
                            txtUsername.setText("");
                            txtLastLogin.setText("");

                            btnSubmitEdit.setVisible(false);
                            btnSubmitEdit.setEnabled(false);
                            btnCancelEdit.setVisible(false);
                            btnCancelEdit.setEnabled(false);

                            txtName.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtName.setFocusable(false);
                            txtName.setEditable(false);

                            txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.GRAY, 1),
                                    BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                            txtContactNo.setFocusable(false);
                            txtContactNo.setEditable(false);

                            btnSubmitEdit.setVisible(false);
                            btnSubmitEdit.setEnabled(false);

                            btnCancelEdit.setVisible(false);
                            btnCancelEdit.setEnabled(false);

                            clearTableSelection();
                            createAccountTable(data);
                        }
                    }
                }
        );

        btnCancelEdit = new JLabel();
        btnCancelEdit.setIcon(new ImageIcon(".\\src\\resources\\btnCancel.png"));
        btnCancelEdit.setVisible(false);
        btnCancelEdit.setEnabled(false);
        pnlAccountInfo.add(btnCancelEdit);
        btnCancelEdit.setBounds(231, 554, 143,71);
        btnCancelEdit.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnCancelEdit.setIcon(new ImageIcon(".\\src\\resources\\btnCancelHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnCancelEdit.setIcon(new ImageIcon(".\\src\\resources\\btnCancel.png"));
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        txtName.setText("");
                        txtContactNo.setText("");
                        txtUsername.setText("");
                        txtLastLogin.setText("");

                        btnSubmitEdit.setVisible(false);
                        btnSubmitEdit.setEnabled(false);
                        btnCancelEdit.setVisible(false);
                        btnCancelEdit.setEnabled(false);

                        txtName.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(Color.GRAY, 1),
                                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                        txtName.setFocusable(false);
                        txtName.setEditable(false);

                        txtContactNo.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(Color.GRAY, 1),
                                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
                        txtContactNo.setFocusable(false);
                        txtContactNo.setEditable(false);

                        btnSubmitEdit.setVisible(false);
                        btnSubmitEdit.setEnabled(false);

                        btnCancelEdit.setVisible(false);
                        btnCancelEdit.setEnabled(false);

                        clearTableSelection();
                    }
                }
        );



        // END EDIT ACCOUNT


        JLabel btnDeleteAccount = new JLabel();
        btnDeleteAccount.setIcon(new ImageIcon(".\\src\\resources\\btnDeleteAccount.png"));
        pnlMain.add(btnDeleteAccount);
        btnDeleteAccount.setBounds(601, 611, 269,71);
        btnDeleteAccount.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDeleteAccount.setIcon(new ImageIcon(".\\src\\resources\\btnDeleteAccountHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDeleteAccount.setIcon(new ImageIcon(".\\src\\resources\\btnDeleteAccount.png"));
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        btnDeleteAccount.setIcon(new ImageIcon(".\\src\\resources\\btnDeleteAccount.png"));
                        int selectedRowIndex = tblAccounts.getSelectedRow();

                        if (selectedRowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Delete Error", "Please select an account.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        DialogAdminConfirm dialogAdminConfirm = new DialogAdminConfirm(data);
                        dialogAdminConfirm.setVisible(true);

                        if (dialogAdminConfirm.isAccountValid()){
                            data.deleteAccount(txtUsername.getText());
                            createAccountTable(data);

                            MainForm.refreshStatsData(data);

                            txtName.setText("");
                            txtContactNo.setText("");
                            txtUsername.setText("");
                            txtLastLogin.setText("");
                        }

                    }
                }
        );

    }

    public void createAccountTable(Data data){
        String[] colAccounts = {"Name", "Contact #", "Username", "Last Login"};
        tblAccountsModel = new DefaultTableModel(colAccounts, 0);

        for (int i = data.getAccountList().size() - 1; i >= 0; i--){
            Object[] newRow = {data.getAccountList().get(i).getName(), data.getAccountList().get(i).getContactNumber(), data.getAccountList().get(i).getUsername(),
                    data.getAccountList().get(i).getLastLogin()};
            tblAccountsModel.addRow(newRow);
        }
        tblAccounts.setModel(tblAccountsModel);
        tblAccounts.setGridColor(color_border_lightgray);
        tblAccounts.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        tblAccounts.setRowHeight(50);
        tblAccounts.setDefaultEditor(Object.class, null); // editable = false
        tblAccounts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblAccounts.setFocusable(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblAccounts.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblAccounts.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblAccounts.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblAccounts.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

    }

    public void clearTableSelection(){
        tblAccounts.getSelectionModel().clearSelection();
        tblAccounts.getColumnModel().getSelectionModel().clearSelection();
    }
}
package views;

import common.Account;
import common.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LoginForm extends JFrame {

    private final Font fontX = new Font("Segoe UI", Font.PLAIN, 30);
    private final Color color_lightgray = new Color(90,90,90);
    private final JLabel btnLogin;
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;

    private ArrayList<Account> accounts;

    public LoginForm(){
        this(new Data());
    }

    public LoginForm(Data data){

        // This is a test

        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setTitle("Gastronom");

        accounts = data.getAccountList();

        // Account Check
//        for (Account acc: accounts){
//            System.out.println(acc.getUsername());
//        }

        Panel pnlLogin = new Panel();
        pnlLogin.setLayout(null);
        add(pnlLogin);
        pnlLogin.setBounds(683,0,683,768);

        // App Title
        JLabel lblTitle = new JLabel(new ImageIcon(".\\src\\resources\\logo.png"));
        pnlLogin.add(lblTitle);
        lblTitle.setBounds(138,20,407,166);

        // Close Button
        JLabel btnCloseApp = new JLabel("X");
        btnCloseApp.setBounds(630, 5, 56, 56);
        btnCloseApp.setFont(fontX);
        btnCloseApp.setForeground(color_lightgray);
        pnlLogin.add(btnCloseApp);
        btnCloseApp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCloseApp.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCloseApp.setForeground(color_lightgray);
            }
        });
        btnCloseApp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        JLabel lblSignIn = new JLabel("SIGN IN");
        lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 34));
        lblSignIn.setForeground(color_lightgray);
        pnlLogin.add(lblSignIn);
        lblSignIn.setBounds(138, 226, 134,46);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        lblUsername.setForeground(color_lightgray);
        pnlLogin.add(lblUsername);
        lblUsername.setBounds(138,307,120,36);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        txtUsername.setForeground(color_lightgray);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                txtUsername.getBorder(),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        pnlLogin.add(txtUsername);
        txtUsername.setBounds(138, 361, 448, 45);
        txtUsername.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnLogin_doClick(data);
                    }
                }
        );

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        lblPassword.setForeground(color_lightgray);
        pnlLogin.add(lblPassword);
        lblPassword.setBounds(138,424,120,36);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        txtPassword.setForeground(color_lightgray);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                txtPassword.getBorder(),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        pnlLogin.add(txtPassword);
        txtPassword.setBounds(138, 478, 448, 45);
        txtPassword.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnLogin_doClick(data);
                    }
                }
        );

        btnLogin = new JLabel();
        btnLogin.setIcon(new ImageIcon(".\\src\\resources\\btnLogin.png"));
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(138, 579, 443,66);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setIcon(new ImageIcon(".\\src\\resources\\btnLoginColored.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setIcon(new ImageIcon(".\\src\\resources\\btnLogin.png"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                btnLogin_doClick(data);
            }
        });

        // Frame Background Image
        JLabel imgBackground = new JLabel(new ImageIcon(".\\src\\resources\\loginbg.jpg"));
        add(imgBackground);
        imgBackground.setBounds(0,0,1366,768);


    }

    private void btnLogin_doClick(Data data){
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()){
            DialogOk dialogOk = new DialogOk("Empty Fields", "Please complete the form to continue.");
            dialogOk.setVisible(true);
            return;
        }

        if (data.isAccountValid(username, password)){
            dispose();
            MainForm mainForm = new MainForm(data.getAccount(username), data);
            mainForm.setVisible(true);
        } else {
            DialogOk dialogOk = new DialogOk("Login Failed.", "Invalid username or password.");
            dialogOk.setVisible(true);
            txtPassword.setText("");
        }
    }

    public static void main(String[] args) {

        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);

    }

}

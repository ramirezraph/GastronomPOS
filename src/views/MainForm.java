package views;

import common.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
<<<<<<< Updated upstream
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
=======
import java.util.List;
>>>>>>> Stashed changes

public class MainForm extends JFrame {

    private static final Color color_darkgray = new Color(43,43,43);
    private final Color color_lightergray = new Color(220,218,215);
    private static final Color color_white = new Color(235, 230, 224);
    private final Color color_red = new Color(228,52,52);
    private final Color color_gray = new Color(138,138,138);
    private final Color color_darkergray = new Color(90,90,90);
    private final Color color_jungle = new Color(72,151,164);
    private final Color color_blue = new Color(125,160,213);

    private static final Color color_border_lightgray = new Color(200,200,200);
    private final Color color_title_gray = new Color(90,90,90);
    private final JLabel lblDateTime;

    // Components
    private JPanel pnlPointOfSale;
    private JPanel pnlDashboard;
    private JPanel pnlTransactionLog;
    private JPanel pnlSystemSettings;

    public static Data DATA;

    private static JLabel lblUserName;
    private static JButton btnCurrentUser;
    private static JButton btnCurrentUserPanel;
    private final JPanel pnlAccount;

    private String CALCULATOR_TEXT;

    private static DecimalFormat twoDecimalFormat = new DecimalFormat("00.00");
    private static DecimalFormat noDecimalFormat = new DecimalFormat("00");

    private JPanel pnlPOSMenu;
    private static JTable tblMenu;
    private static DefaultTableModel tblMenuModel;

    private static JTable tblOrderList;
    private static DefaultTableModel tblOrderListModel;

    public static JLabel lblTotalAmount;
    public static JLabel lblDiscountAmount;
    public static JLabel lblBalanceAmount;
    public static JLabel lblChangeAmount;

    private JTextField txtPayment;

    private static JTable tblSales;
    private static DefaultTableModel tblSalesModel;
    private static JLabel lblTotalRevenue;
    private static JLabel lblNumberOfItem;
    private static JLabel lblNumberOfEmployee;

    private static JTable tblTransactionLog;
    private static DefaultTableModel tblTransactionLogModel;
    public static JLabel imgProduct1stPlace;
    public static JLabel imgProduct2ndPlace;
    public static JLabel imgProduct3rdPlace;
    public static JLabel lblProductName1stPlace;
    public static JLabel lblProductName2ndPlace;
    public static JLabel lblProductName3rdPlace;

    private final JLabel btnSystemSettings;
    private JLabel btnDown;
    private JButton btnResetTransactionLog;

    private static JLabel lblBusinessAddress;
    private JLabel btnGenerateReceipt;
    private JButton btnProcessOrder;
<<<<<<< Updated upstream
    private JPanel pnlIndicatorMain;
    private JPanel pnlIndicatorDessert;
    private JPanel pnlIndicatorDrinks;
    private JPanel pnlIndicatorOthers;

    private JComboBox<String> cmbDay;
    private JComboBox<String> cmbMonth;
=======
>>>>>>> Stashed changes

    public MainForm(Account account, Data data) {
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setTitle("Gastronom");

        DATA = data;

        JPanel pnlNavbar = new JPanel();
        pnlNavbar.setBackground(color_darkgray);
        pnlNavbar.setForeground(color_white);
        pnlNavbar.setLayout(null);
        add(pnlNavbar);
        pnlNavbar.setBounds(0,0, 1920, 103);

        JLabel imgNavTitle = new JLabel();
        imgNavTitle.setIcon(new ImageIcon(".\\src\\resources\\navtitle.png"));
        pnlNavbar.add(imgNavTitle);
        imgNavTitle.setBounds(62,18,215,70);

        lblBusinessAddress = new JLabel("Sample St., Sabang, Baliuag, Bulacan");
        lblBusinessAddress.setForeground(color_white);
        lblBusinessAddress.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlNavbar.add(lblBusinessAddress);
        lblBusinessAddress.setBounds(300,45,336,28);

        lblDateTime = new JLabel("  November 15, 2019 - 9:54 AM");
        lblDateTime.setIcon(new ImageIcon(".\\src\\resources\\calendar_32.png"));
        lblDateTime.setForeground(color_white);
        lblDateTime.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        pnlNavbar.add(lblDateTime);
        lblDateTime.setBounds(1171,35,331,33);

        JLabel lblDivider = new JLabel("|");
        lblDivider.setForeground(color_white);
        lblDivider.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        pnlNavbar.add(lblDivider);
        lblDivider.setBounds(1527,35,6,33);

        lblUserName = new JLabel();
        lblUserName.setForeground(color_white);
        lblUserName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        lblUserName.setIcon(new ImageIcon(".\\src\\resources\\man-user_32.png"));
        pnlNavbar.add(lblUserName);
        lblUserName.setBounds(1568,35,200,33);

        JLabel btnLogout = new JLabel(" Logout");
        btnLogout.setForeground(color_white);
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnLogout.setIcon(new ImageIcon(".\\src\\resources\\logout_32.png"));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlNavbar.add(btnLogout);
        btnLogout.setBounds(1770,35,200,33);
        btnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogout.setIcon(new ImageIcon(".\\src\\resources\\logoutRed_32.png"));
                btnLogout.setForeground(color_red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogout.setIcon(new ImageIcon(".\\src\\resources\\logout_32.png"));
                btnLogout.setForeground(color_white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                DialogYesNo dialogYesNo = new DialogYesNo("Confirm", "Are you sure you want to logout?");
                dialogYesNo.setVisible(true);

                if (dialogYesNo.getYesNo()){

                    for (Account o: DATA.getAccountList()){
                        if (o.getName().equals(lblUserName.getText())){
                            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/uuuu"));
//                            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
                            o.setLastLogin(date);
                            break;
                        }
                    }

                    DATA.getOrderList().removeIf(o -> true);
                    generateOrderList(DATA);

                    dispose();
                    LoginForm loginForm = new LoginForm(data);
                    loginForm.setVisible(true);
                }
            }
        });

        JPanel pnlLeft = new JPanel();
        pnlLeft.setBackground(color_lightergray);
        pnlLeft.setForeground(color_white);
        pnlLeft.setLayout(null);
        add(pnlLeft);
        pnlLeft.setBounds(0,103, 354, 977);

        // Nav Buttons

        JLabel btnDashboard = new JLabel(" Dashboard");
        btnDashboard.setHorizontalAlignment(SwingConstants.LEFT);
        btnDashboard.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 5));
        btnDashboard.setIcon(new ImageIcon(".\\src\\resources\\dashboard_32.png"));
        btnDashboard.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnDashboard.setForeground(color_white);
        btnDashboard.setBackground(color_darkgray);
        btnDashboard.setOpaque(true);
        btnDashboard.setFocusable(false);
        btnDashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLeft.add(btnDashboard);
        btnDashboard.setBounds(0,20, 354, 82);
        btnDashboard.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnDashboard.setBackground(color_jungle);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDashboard.setBackground(color_darkgray);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                btnDashboard.setBackground(color_gray);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btnDashboard.setBackground(color_jungle);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pnlDashboard.setVisible(true);
                pnlDashboard.setEnabled(true);

                pnlPointOfSale.setVisible(false);
                pnlPointOfSale.setEnabled(false);

                pnlTransactionLog.setVisible(false);
                pnlTransactionLog.setEnabled(false);

                pnlSystemSettings.setVisible(false);
                pnlSystemSettings.setEnabled(false);

                btnCurrentUser.setEnabled(true);
                btnCurrentUser.setVisible(true);
                pnlAccount.setEnabled(false);
                pnlAccount.setVisible(false);

                refreshStatsData(data);

            }
        });

        JLabel lblModules = new JLabel("MODULES");
        lblModules.setFont(new Font("Segoe UI", Font.BOLD, 19));
        lblModules.setForeground(color_darkgray);
        lblModules.setHorizontalAlignment(SwingConstants.LEFT);
        pnlLeft.add(lblModules);
        lblModules.setBounds(48, 90, 354,82);

        JLabel btnPointOfSale = new JLabel(" Point-of-Sale");
        btnPointOfSale.setHorizontalAlignment(SwingConstants.LEFT);
        btnPointOfSale.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 5));
        btnPointOfSale.setIcon(new ImageIcon(".\\src\\resources\\point-of-sale_32.png"));
        btnPointOfSale.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnPointOfSale.setForeground(color_white);
        btnPointOfSale.setBackground(color_darkgray);
        btnPointOfSale.setOpaque(true);
        btnPointOfSale.setFocusable(false);
        btnPointOfSale.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLeft.add(btnPointOfSale);
        btnPointOfSale.setBounds(0,162, 354, 82);
        btnPointOfSale.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnPointOfSale.setBackground(color_jungle);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnPointOfSale.setBackground(color_darkgray);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                btnPointOfSale.setBackground(color_gray);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btnPointOfSale.setBackground(color_jungle);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pnlDashboard.setVisible(false);
                pnlDashboard.setEnabled(false);

                pnlPointOfSale.setVisible(true);
                pnlPointOfSale.setEnabled(true);

                pnlTransactionLog.setVisible(false);
                pnlTransactionLog.setEnabled(false);

                pnlSystemSettings.setVisible(false);
                pnlSystemSettings.setEnabled(false);

                btnCurrentUser.setEnabled(true);
                btnCurrentUser.setVisible(true);
                pnlAccount.setEnabled(false);
                pnlAccount.setVisible(false);

                pnlIndicatorMain.setBackground(color_jungle);
                pnlIndicatorDessert.setBackground(Color.WHITE);
                pnlIndicatorDrinks.setBackground(Color.WHITE);
                pnlIndicatorOthers.setBackground(Color.WHITE);

                generateMenu(data, "Main");

            }
        });

        JLabel btnTransactionLog = new JLabel(" Transaction Log");
        btnTransactionLog.setHorizontalAlignment(SwingConstants.LEFT);
        btnTransactionLog.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 5));
        btnTransactionLog.setIcon(new ImageIcon(".\\src\\resources\\log_32.png"));
        btnTransactionLog.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnTransactionLog.setForeground(color_white);
        btnTransactionLog.setBackground(color_darkgray);
        btnTransactionLog.setOpaque(true);
        btnTransactionLog.setFocusable(false);
        btnTransactionLog.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLeft.add(btnTransactionLog);
        btnTransactionLog.setBounds(0,244, 354, 82);
        btnTransactionLog.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnTransactionLog.setBackground(color_jungle);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTransactionLog.setBackground(color_darkgray);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                btnTransactionLog.setBackground(color_gray);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btnTransactionLog.setBackground(color_jungle);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pnlDashboard.setVisible(false);
                pnlDashboard.setEnabled(false);

                pnlPointOfSale.setVisible(false);
                pnlPointOfSale.setEnabled(false);

                pnlTransactionLog.setVisible(true);
                pnlTransactionLog.setEnabled(true);

                pnlSystemSettings.setVisible(false);
                pnlSystemSettings.setEnabled(false);

                btnCurrentUser.setEnabled(true);
                btnCurrentUser.setVisible(true);
                pnlAccount.setEnabled(false);
                pnlAccount.setVisible(false);

                generateTransactionTable(data, 1);
            }
        });

        btnSystemSettings = new JLabel(" System Settings");
        btnSystemSettings.setHorizontalAlignment(SwingConstants.LEFT);
        btnSystemSettings.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 5));
        btnSystemSettings.setIcon(new ImageIcon(".\\src\\resources\\settings_32.png"));
        btnSystemSettings.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnSystemSettings.setForeground(color_white);
        btnSystemSettings.setBackground(color_darkgray);
        btnSystemSettings.setOpaque(true);
        btnSystemSettings.setFocusable(false);
        btnSystemSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLeft.add(btnSystemSettings);
        btnSystemSettings.setBounds(0,326, 354, 82);
        btnSystemSettings.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSystemSettings.setBackground(color_jungle);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSystemSettings.setBackground(color_darkgray);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                btnSystemSettings.setBackground(color_gray);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btnSystemSettings.setBackground(color_jungle);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pnlDashboard.setVisible(false);
                pnlDashboard.setEnabled(false);

                pnlPointOfSale.setVisible(false);
                pnlPointOfSale.setEnabled(false);

                pnlTransactionLog.setVisible(false);
                pnlTransactionLog.setEnabled(false);

                pnlSystemSettings.setVisible(true);
                pnlSystemSettings.setEnabled(true);

                btnCurrentUser.setEnabled(true);
                btnCurrentUser.setVisible(true);
                pnlAccount.setEnabled(false);
                pnlAccount.setVisible(false);
            }
        });

        pnlAccount = new JPanel();
        pnlAccount.setLayout(null);
        pnlAccount.setBackground(color_darkgray);
        pnlAccount.setEnabled(false);
        pnlAccount.setVisible(false);
        pnlLeft.add(pnlAccount);
        pnlAccount.setBounds(0, 791,356,186);

        btnCurrentUserPanel = new JButton();
        btnCurrentUserPanel.setBackground(color_darkgray);
        btnCurrentUserPanel.setForeground(Color.WHITE);
        btnCurrentUserPanel.setBorder(BorderFactory.createLineBorder(color_title_gray, 1));
        btnCurrentUserPanel.setIcon(new ImageIcon(".\\src\\resources\\online_15.png"));
        btnCurrentUserPanel.setIconTextGap(12);
        btnCurrentUserPanel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        btnCurrentUserPanel.setFocusable(false);
        btnCurrentUserPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlAccount.add(btnCurrentUserPanel);
        btnCurrentUserPanel.setBounds(0,0,353,50);
        btnCurrentUserPanel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnCurrentUser.setEnabled(true);
                        btnCurrentUser.setVisible(true);
                        pnlAccount.setEnabled(false);
                        pnlAccount.setVisible(false);
                    }
                }
        );

        JLabel btnAccount = new JLabel();
        btnAccount.setIcon(new ImageIcon(".\\src\\resources\\btnMyAccount.png"));
        btnAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlAccount.add(btnAccount);
        btnAccount.setBounds(30, 95,294,45);
        btnAccount.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        for(Account o: data.getAccountList()){
                            if (btnCurrentUser.getText().equals(o.getUsername())){

                                btnCurrentUser.setEnabled(true);
                                btnCurrentUser.setVisible(true);
                                pnlAccount.setEnabled(false);
                                pnlAccount.setVisible(false);

                                DialogMyAccount dialogMyAccount = new DialogMyAccount(o);
                                dialogMyAccount.setVisible(true);

                                return;
                            }
                        }

                        DialogOk dialogOk = new DialogOk("Error", "There is something wrong with your account.");
                        dialogOk.setVisible(true);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnAccount.setIcon(new ImageIcon(".\\src\\resources\\btnMyAccountHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnAccount.setIcon(new ImageIcon(".\\src\\resources\\btnMyAccount.png"));
                    }
                }
        );

        btnCurrentUser = new JButton();
        btnCurrentUser.setBackground(color_darkgray);
        btnCurrentUser.setForeground(Color.WHITE);
        btnCurrentUser.setBorder(BorderFactory.createEmptyBorder());
        btnCurrentUser.setIcon(new ImageIcon(".\\src\\resources\\online_15.png"));
        btnCurrentUser.setIconTextGap(12);
        btnCurrentUser.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        btnCurrentUser.setFocusable(false);
        btnCurrentUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlLeft.add(btnCurrentUser);
        btnCurrentUser.setBounds(0,927,353,50);
        btnCurrentUser.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnCurrentUser.setEnabled(false);
                        btnCurrentUser.setVisible(false);
                        pnlAccount.setEnabled(true);
                        pnlAccount.setVisible(true);
                    }
                }
        );

        createDashboardGUI();
        createPointOfSaleGUI();
        createTransactionLogGUI();
        createSystemSettingsGUI();


        pnlDashboard.setVisible(true);
        pnlDashboard.setEnabled(true);

        pnlPointOfSale.setVisible(false);
        pnlPointOfSale.setEnabled(false);

        pnlTransactionLog.setVisible(false);
        pnlTransactionLog.setEnabled(false);

        pnlSystemSettings.setVisible(false);
        pnlSystemSettings.setEnabled(false);

        refreshAccountInfo(account);

        if (!account.getLevel().equals("Administrator")){
            btnSystemSettings.setEnabled(false);
            btnSystemSettings.setVisible(false);

            btnDown.setEnabled(false);
            btnDown.setVisible(false);

            btnResetTransactionLog.setEnabled(false);
            btnResetTransactionLog.setVisible(false);

        }

<<<<<<< Updated upstream
        UpdateDateTime();

=======
>>>>>>> Stashed changes
        getRootPane().setDefaultButton(btnProcessOrder);

    }

    public static void updateAddress(String address){
        lblBusinessAddress.setText(address);
    }

    private void createDashboardGUI(){

        pnlDashboard = new JPanel();
        pnlDashboard.setBackground(Color.WHITE);
        pnlDashboard.setForeground(color_darkgray);
        pnlDashboard.setLayout(null);
        add(pnlDashboard);
        pnlDashboard.setBounds(354, 98, 1566, 977);

        JPanel pnlTopContent = new JPanel();
        JPanel pnlBottomContent = new JPanel();

        // TOP CONTENT /////////////////////////////////////////////////////////

        pnlTopContent.setBackground(Color.WHITE);
        pnlTopContent.setLayout(null);
        pnlTopContent.setEnabled(true);
        pnlTopContent.setVisible(true);
        pnlDashboard.add(pnlTopContent);
        pnlTopContent.setBounds(0,0,1566,977);

        JLabel imgDashboard = new JLabel(new ImageIcon(".\\src\\resources\\dashboardheaderbg.png"));
        pnlTopContent.add(imgDashboard);
        imgDashboard.setBounds(0,0, 1566,200);

        JPanel pnlDivider = new JPanel();
        pnlDivider.setBackground(color_darkergray);
        pnlTopContent.add(pnlDivider);
        pnlDivider.setBounds(0,200, 1566,43);

        JLabel lblWelcomeText = new JLabel("Welcome to Gastronom Point-of-Sale System!");
        lblWelcomeText.setFont(new Font("Segoe UI", Font.PLAIN, 60));
        lblWelcomeText.setForeground(color_darkgray);
        pnlTopContent.add(lblWelcomeText);
        lblWelcomeText.setBounds(195,305, 1241, 80);

        // FIRST PLACE

        JLabel img1stPlace = new JLabel();
        img1stPlace.setIcon(new ImageIcon(".\\src\\resources\\1stPlace.png"));
        pnlTopContent.add(img1stPlace);
        img1stPlace.setBounds(312,703,288,107);

        imgProduct1stPlace = new JLabel();
        imgProduct1stPlace.setIcon(null);
        pnlTopContent.add(imgProduct1stPlace);
        imgProduct1stPlace.setBounds(382,579,150,150);

        lblProductName1stPlace = new JLabel();
        lblProductName1stPlace.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        lblProductName1stPlace.setForeground(color_lightergray);
        lblProductName1stPlace.setHorizontalAlignment(JLabel.CENTER);
        pnlTopContent.add(lblProductName1stPlace);
        lblProductName1stPlace.setBounds(310,817,288,46);

        // SECOND PLACE

        JLabel img2ndPlace = new JLabel();
        img2ndPlace.setIcon(new ImageIcon(".\\src\\resources\\2ndPlace.png"));
        pnlTopContent.add(img2ndPlace);
        img2ndPlace.setBounds(640,703,288,107);

        imgProduct2ndPlace = new JLabel();
        imgProduct2ndPlace.setIcon(null);
        pnlTopContent.add(imgProduct2ndPlace);
        imgProduct2ndPlace.setBounds(710,579,150,150);

        lblProductName2ndPlace = new JLabel();
        lblProductName2ndPlace.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        lblProductName2ndPlace.setForeground(color_lightergray);
        lblProductName2ndPlace.setHorizontalAlignment(JLabel.CENTER);
        pnlTopContent.add(lblProductName2ndPlace);
        lblProductName2ndPlace.setBounds(639,817,288,46);

        // THIRD PLACE

        JLabel img3rdPlace = new JLabel();
        img3rdPlace.setIcon(new ImageIcon(".\\src\\resources\\3rdPlace.png"));
        pnlTopContent.add(img3rdPlace);
        img3rdPlace.setBounds(968,703,288,107);

        imgProduct3rdPlace = new JLabel();
        imgProduct3rdPlace.setIcon(null);
        pnlTopContent.add(imgProduct3rdPlace);
        imgProduct3rdPlace.setBounds(1038,579,150,150);

        lblProductName3rdPlace = new JLabel();
        lblProductName3rdPlace.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        lblProductName3rdPlace.setForeground(color_lightergray);
        lblProductName3rdPlace.setHorizontalAlignment(JLabel.CENTER);
        pnlTopContent.add(lblProductName3rdPlace);
        lblProductName3rdPlace.setBounds(968,817,288,46);

        // Background
        JLabel pnlBestSelling = new JLabel();
        pnlBestSelling.setIcon(new ImageIcon(".\\src\\resources\\bestsellingbg.png"));
        pnlTopContent.add(pnlBestSelling);
        pnlBestSelling.setBounds(231,449,1105,454);

        btnDown = new JLabel();
        btnDown.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\btnDown.png").getImage()
                .getScaledInstance(120, 120,Image.SCALE_SMOOTH)));
        btnDown.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlTopContent.add(btnDown);
        btnDown.setBounds(56,764,120,120);
        btnDown.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        pnlTopContent.setVisible(false);
                        pnlTopContent.setEnabled(false);

                        pnlBottomContent.setVisible(true);
                        pnlBottomContent.setEnabled(true);

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDown.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\btnDownHl.png").getImage()
                                .getScaledInstance(120, 120,Image.SCALE_SMOOTH)));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDown.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\btnDown.png").getImage()
                                .getScaledInstance(120, 120,Image.SCALE_SMOOTH)));
                    }
                }
        );

        // BOTTOM CONTENT /////////////////////////////////////////////////////////

        pnlBottomContent.setBackground(Color.WHITE);
        pnlBottomContent.setLayout(null);
        pnlBottomContent.setEnabled(false);
        pnlBottomContent.setVisible(false);
        pnlDashboard.add(pnlBottomContent);
        pnlBottomContent.setBounds(0,0,1566,977);

        JLabel btnUp = new JLabel();
        btnUp.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\btnUp.png").getImage()
                .getScaledInstance(120, 120,Image.SCALE_SMOOTH)));
        btnUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlBottomContent.add(btnUp);
        btnUp.setBounds(56,60,120,120);
        btnUp.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        pnlTopContent.setVisible(true);
                        pnlTopContent.setEnabled(true);

                        pnlBottomContent.setVisible(false);
                        pnlBottomContent.setEnabled(false);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnUp.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\btnUpHl.png").getImage()
                                .getScaledInstance(120, 120,Image.SCALE_SMOOTH)));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnUp.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\btnUp.png").getImage()
                                .getScaledInstance(120, 120,Image.SCALE_SMOOTH)));
                    }
                }
        );

        JLabel lblStatistic = new JLabel("App Data");
        lblStatistic.setForeground(color_darkgray);
        lblStatistic.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        pnlBottomContent.add(lblStatistic);
        lblStatistic.setBounds(266,23,255,53);

        // No. of Item

        JPanel pnlNoOfItem = new JPanel();
        pnlNoOfItem.setLayout(null);
        pnlNoOfItem.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlBottomContent.add(pnlNoOfItem);
        pnlNoOfItem.setBounds(255,111,382,194);

        lblNumberOfItem = new JLabel("11");
        lblNumberOfItem.setHorizontalAlignment(JLabel.CENTER);
        lblNumberOfItem.setForeground(color_jungle);
        lblNumberOfItem.setFont(new Font("Segoe UI", Font.BOLD, 72));
        pnlNoOfItem.add(lblNumberOfItem);
        lblNumberOfItem.setBounds(0,20, 382,91);

        JPanel pnlTextNo = new JPanel();
        pnlTextNo.setBackground(color_darkgray);
        pnlTextNo.setLayout(null);
        pnlNoOfItem.add(pnlTextNo);
        pnlTextNo.setBounds(0, 126,382,68);

        JLabel lblNoOfItem = new JLabel("No. of Item/s");
        lblNoOfItem.setHorizontalAlignment(JLabel.CENTER);
        lblNoOfItem.setForeground(color_white);
        lblNoOfItem.setFont(new Font("Segoe UI", Font.BOLD, 22));
        pnlTextNo.add(lblNoOfItem);
        lblNoOfItem.setBounds(0, 19, 382,30);

        // No. of Employee

        JPanel pnlNoOfEmployee = new JPanel();
        pnlNoOfEmployee.setLayout(null);
        pnlNoOfEmployee.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlBottomContent.add(pnlNoOfEmployee);
        pnlNoOfEmployee.setBounds(646,111,382,194);

        lblNumberOfEmployee = new JLabel("11");
        lblNumberOfEmployee.setHorizontalAlignment(JLabel.CENTER);
        lblNumberOfEmployee.setForeground(color_red);
        lblNumberOfEmployee.setFont(new Font("Segoe UI", Font.BOLD, 72));
        pnlNoOfEmployee.add(lblNumberOfEmployee);
        lblNumberOfEmployee.setBounds(0,20, 382,91);

        JPanel pnlTextEmployee = new JPanel();
        pnlTextEmployee.setBackground(color_darkgray);
        pnlTextEmployee.setLayout(null);
        pnlNoOfEmployee.add(pnlTextEmployee);
        pnlTextEmployee.setBounds(0, 126,382,68);

        JLabel lblNoOfEmp = new JLabel("No. of Employee/s");
        lblNoOfEmp.setHorizontalAlignment(JLabel.CENTER);
        lblNoOfEmp.setForeground(color_white);
        lblNoOfEmp.setFont(new Font("Segoe UI", Font.BOLD, 22));
        pnlTextEmployee.add(lblNoOfEmp);
        lblNoOfEmp.setBounds(0, 19, 382,30);

        // Total Earnings

        JPanel pnlEarnings = new JPanel();
        pnlEarnings.setLayout(null);
        pnlEarnings.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlBottomContent.add(pnlEarnings);
        pnlEarnings.setBounds(1037,111,382,194);

        lblTotalRevenue = new JLabel();
        lblTotalRevenue.setHorizontalAlignment(JLabel.CENTER);
        lblTotalRevenue.setForeground(new Color(177,142,46));
        lblTotalRevenue.setFont(new Font("Segoe UI", Font.BOLD, 57));
        pnlEarnings.add(lblTotalRevenue);
        lblTotalRevenue.setBounds(0,20, 382,91);

        JPanel pnlTextEarnings = new JPanel();
        pnlTextEarnings.setBackground(color_darkgray);
        pnlTextEarnings.setLayout(null);
        pnlEarnings.add(pnlTextEarnings);
        pnlTextEarnings.setBounds(0, 126,382,68);

        JLabel lblRev = new JLabel("Total Revenue");
        lblRev.setHorizontalAlignment(JLabel.CENTER);
        lblRev.setForeground(color_white);
        lblRev.setFont(new Font("Segoe UI", Font.BOLD, 22));
        pnlTextEarnings.add(lblRev);
        lblRev.setBounds(0, 19, 382,30);

        // Sales

        JLabel lblSales = new JLabel("Sales Report");
        lblSales.setForeground(color_darkgray);
        lblSales.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        pnlBottomContent.add(lblSales);
        lblSales.setBounds(186, 334, 250,53);

        JLabel lblSearchProduct = new JLabel("Search Product");
        lblSearchProduct.setForeground(color_darkergray);
        lblSearchProduct.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        pnlBottomContent.add(lblSearchProduct);
        lblSearchProduct.setBounds(490, 351, 144,28);

        JTextField txtSearchProduct = new JTextField();
        txtSearchProduct.setForeground(color_darkergray);
        txtSearchProduct.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        txtSearchProduct.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_darkergray, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        pnlBottomContent.add(txtSearchProduct);
        txtSearchProduct.setBounds(642, 346, 284,39);

        JButton btnSearch = new JButton("Search");
        btnSearch.setFocusable(false);
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setForeground(color_darkergray);
        btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnSearch.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlBottomContent.add(btnSearch);
        btnSearch.setBounds(931,346,135,39);
        btnSearch.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String search = txtSearchProduct.getText().toLowerCase();
                        generateSalesTable(DATA, search);
                    }
                }
        );

        JButton btnResetSales = new JButton("RESET");
        btnResetSales.setFocusable(false);
        btnResetSales.setBackground(color_red);
        btnResetSales.setForeground(Color.WHITE);
        btnResetSales.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnResetSales.setBorder(BorderFactory.createEmptyBorder());
        btnResetSales.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlBottomContent.add(btnResetSales);
        btnResetSales.setBounds(1148,346,223,39);
        btnResetSales.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        DialogAdminConfirm dialogAdminConfirm = new DialogAdminConfirm(DATA);
                        dialogAdminConfirm.setVisible(true);

                        if (dialogAdminConfirm.isAccountValid()){
                            DATA.resetSalesList();
                            generateSalesTable(DATA, "");

                            DATA.FindBestSelling();

                            lblProductName1stPlace.setText("");
                            lblProductName2ndPlace.setText("");
                            lblProductName3rdPlace.setText("");
                            imgProduct1stPlace.setIcon(null);
                            imgProduct2ndPlace.setIcon(null);
                            imgProduct3rdPlace.setIcon(null);
                        }
                    }
                }
        );
        tblSales = new JTable();

        JScrollPane spSalesTable = new JScrollPane(tblSales);
        spSalesTable.setBorder(BorderFactory.createLineBorder(color_darkergray,1));
        pnlBottomContent.add(spSalesTable);
        spSalesTable.setBounds(175,400,1257,485);

        JButton btnViewTransactionLog = new JButton("VIEW TRANSACTION LOG");
        btnViewTransactionLog.setBackground(color_darkgray);
        btnViewTransactionLog.setForeground(color_white);
        btnViewTransactionLog.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        btnViewTransactionLog.setFocusable(false);
        btnViewTransactionLog.setBorder(BorderFactory.createEmptyBorder());
        btnViewTransactionLog.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlBottomContent.add(btnViewTransactionLog);
        btnViewTransactionLog.setBounds(175,900,444,58);
        btnViewTransactionLog.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pnlDashboard.setVisible(false);
                        pnlDashboard.setEnabled(false);

                        pnlPointOfSale.setVisible(false);
                        pnlPointOfSale.setEnabled(false);

                        pnlTransactionLog.setVisible(true);
                        pnlTransactionLog.setEnabled(true);

                        pnlSystemSettings.setVisible(false);
                        pnlSystemSettings.setEnabled(false);
                    }
                }
        );

        generateSalesTable(DATA, "");

    }

    public static void refreshAccountInfo(Account account){
        lblUserName.setText(account.getName());
        btnCurrentUser.setText(account.getUsername());
        btnCurrentUserPanel.setText(account.getUsername());
    }

    public static void refreshStatsData(Data data){
        lblNumberOfItem.setText(String.valueOf(data.getProductList().size()));
        lblNumberOfEmployee.setText(String.valueOf(data.getAccountList().size()));
        lblTotalRevenue.setText("₱" + twoDecimalFormat.format(data.getTotalRevenue()));
    }

    private static void generateSalesTable(Data data, String search){

        refreshStatsData(data);

        String[] colsSales = {"Code","Item Name", "Price", "Number of Order/s" , "Total Earning/s", "Percentage"};
        tblSalesModel = new DefaultTableModel(colsSales, 0);
        ArrayList<Account> accounts = data.getAccountList();
        for (Sales o: data.getSalesList()){
            if (o.getName().toLowerCase().contains(search)){
                Object[] newRow = {o.getCode(), o.getName(), "₱"+twoDecimalFormat.format(o.getPrice()),
                        noDecimalFormat.format(o.getNumberOfOrder()),
                        "₱"+twoDecimalFormat.format(o.getTotalEarnings()),
                        (twoDecimalFormat.format(data.getItemSalesPercentage(o.getNumberOfOrder())) + "%")};
                tblSalesModel.addRow(newRow);
                o.setPercentage(data.getItemSalesPercentage(o.getNumberOfOrder()));
            }
        }
        tblSales.setModel(tblSalesModel);
        tblSales.setGridColor(color_border_lightgray);
        tblSales.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        tblSales.setRowHeight(50);
        tblSales.setDefaultEditor(Object.class, null); // editable = false
        tblSales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSales.setFocusable(false);

        // Sort
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblSales.getModel());
        tblSales.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);

        // Modify Column
        TableColumnModel tableColumnModel = tblSales.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(0)); // hides code

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblSales.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblSales.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblSales.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblSales.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblSales.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        data.FindBestSelling();

    }

    private void createPointOfSaleGUI(){
        pnlPointOfSale = new JPanel();
        pnlPointOfSale.setBackground(Color.WHITE);
        pnlPointOfSale.setForeground(color_darkgray);
        pnlPointOfSale.setLayout(null);
        add(pnlPointOfSale);
        pnlPointOfSale.setBounds(354,103, 1566, 977);

        CALCULATOR_TEXT = "";

        JPanel pnlCenter = new JPanel();
        pnlCenter.setBackground(Color.WHITE);
        pnlCenter.setForeground(color_darkgray);
        pnlCenter.setLayout(null);
        pnlPointOfSale.add(pnlCenter);
        pnlCenter.setBounds(0,0, 1010, 977);

        JLabel lblMenu = new JLabel("MENU");
        lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 30));
        pnlCenter.add(lblMenu);
        lblMenu.setBounds(112, 41, 102, 46);

        // Indicators

        pnlIndicatorMain = new JPanel();
        pnlIndicatorMain.setBackground(color_jungle);
        pnlCenter.add(pnlIndicatorMain);
        pnlIndicatorMain.setBounds(112,160, 206, 9);

        pnlIndicatorDessert = new JPanel();
        pnlIndicatorDessert.setBackground(Color.WHITE);
        pnlCenter.add(pnlIndicatorDessert);
        pnlIndicatorDessert.setBounds(321,160, 206, 9);

        pnlIndicatorDrinks = new JPanel();
        pnlIndicatorDrinks.setBackground(Color.WHITE);
        pnlCenter.add(pnlIndicatorDrinks);
        pnlIndicatorDrinks.setBounds(530,160, 206, 9);

        pnlIndicatorOthers = new JPanel();
        pnlIndicatorOthers.setBackground(Color.WHITE);
        pnlCenter.add(pnlIndicatorOthers);
        pnlIndicatorOthers.setBounds(739,160, 206, 9);


        JButton btnMainMenu = new JButton("Main");
        btnMainMenu.setForeground(color_white);
        btnMainMenu.setBackground(color_darkergray);
        btnMainMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnMainMenu.setFocusable(false);
        btnMainMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnMainMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCenter.add(btnMainMenu);
        btnMainMenu.setBounds(112, 104, 206,57);
        btnMainMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Main");

                        pnlIndicatorMain.setBackground(color_jungle);
                        pnlIndicatorDessert.setBackground(Color.WHITE);
                        pnlIndicatorDrinks.setBackground(Color.WHITE);
                        pnlIndicatorOthers.setBackground(Color.WHITE);
                    }
                }
        );

        JButton btnDessertMenu = new JButton("Dessert");
        btnDessertMenu.setForeground(color_white);
        btnDessertMenu.setBackground(color_darkergray);
        btnDessertMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnDessertMenu.setFocusable(false);
        btnDessertMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnDessertMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCenter.add(btnDessertMenu);
        btnDessertMenu.setBounds(320, 104, 206,57);
        btnDessertMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Dessert");

                        pnlIndicatorMain.setBackground(Color.WHITE);
                        pnlIndicatorDessert.setBackground(color_jungle);
                        pnlIndicatorDrinks.setBackground(Color.WHITE);
                        pnlIndicatorOthers.setBackground(Color.WHITE);
                    }
                }
        );

        JButton btnDrinksMenu = new JButton("Drinks");
        btnDrinksMenu.setForeground(color_white);
        btnDrinksMenu.setBackground(color_darkergray);
        btnDrinksMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnDrinksMenu.setFocusable(false);
        btnDrinksMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnDrinksMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCenter.add(btnDrinksMenu);
        btnDrinksMenu.setBounds(529, 104, 206,57);
        btnDrinksMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Drinks");

                        pnlIndicatorMain.setBackground(Color.WHITE);
                        pnlIndicatorDessert.setBackground(Color.WHITE);
                        pnlIndicatorDrinks.setBackground(color_jungle);
                        pnlIndicatorOthers.setBackground(Color.WHITE);
                    }
                }
        );

        JButton btnOthersMenu = new JButton("Others");
        btnOthersMenu.setForeground(color_white);
        btnOthersMenu.setBackground(color_darkergray);
        btnOthersMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnOthersMenu.setFocusable(false);
        btnOthersMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnOthersMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCenter.add(btnOthersMenu);
        btnOthersMenu.setBounds(738, 104, 206,57);
        btnOthersMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Others");

                        pnlIndicatorMain.setBackground(Color.WHITE);
                        pnlIndicatorDessert.setBackground(Color.WHITE);
                        pnlIndicatorDrinks.setBackground(Color.WHITE);
                        pnlIndicatorOthers.setBackground(color_jungle);
                    }
                }
        );

        // Menu Panels

        pnlPOSMenu = new JPanel();
        pnlPOSMenu.setBackground(Color.BLACK);
        pnlPOSMenu.setForeground(color_darkgray);
        pnlPOSMenu.setEnabled(true);
        pnlPOSMenu.setVisible(true);
        pnlPOSMenu.setLayout(null);
        pnlCenter.add(pnlPOSMenu);
        pnlPOSMenu.setBounds(112, 187, 833, 725);

        // End Menu Panels

        tblMenu = new JTable();

        generateMenu(DATA, "Main");

        JScrollPane spMenu = new JScrollPane(tblMenu);
        spMenu.setBorder(BorderFactory.createEmptyBorder());
        pnlPOSMenu.add(spMenu);
        spMenu.setBounds(0,0,833,725);

        tblMenu.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clearOrderListSelection();
                    }
                }
        );

        // Right Side

        JPanel pnlRight = new JPanel();
        pnlRight.setBackground(color_lightergray);
        pnlRight.setForeground(color_darkgray);
        pnlRight.setLayout(null);
        pnlPointOfSale.add(pnlRight);
        pnlRight.setBounds(1010,0, 556, 977);

        JLabel lblOrderList = new JLabel("Order List/s");
        lblOrderList.setForeground(color_darkergray);
        lblOrderList.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        pnlRight.add(lblOrderList);
        lblOrderList.setBounds(20,14,128,33);

        JButton btnReset = new JButton();
        btnReset.setForeground(Color.WHITE);
        btnReset.setBackground(color_darkgray);
        btnReset.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnReset.setBorder(BorderFactory.createEmptyBorder());
        btnReset.setFocusable(false);
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlRight.add(btnReset);
        btnReset.setBounds(406,13,129,35);
        Action btnResetAction = new AbstractAction("Reset (F5)") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DialogYesNo dialogYesNo = new DialogYesNo("Confirm Reset", "Click 'Yes' to continue.");
                dialogYesNo.setVisible(true);

                if (dialogYesNo.getYesNo()){
                    // Remove ALL item from Order List
                    DATA.getOrderList().removeIf(o -> true);
                    generateOrderList(DATA);

                    CALCULATOR_TEXT = "";

                    lblTotalAmount.setText("₱00.00");
                    lblBalanceAmount.setText("₱00.00");
                    txtPayment.setText("");
                    lblChangeAmount.setText("");
                    lblDiscountAmount.setText("₱00.00");
                }
            }
        };
        String key = "Reset";
        btnReset.setAction(btnResetAction);
        btnReset.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), key);
        btnReset.getActionMap().put(key, btnResetAction);

        JPanel pnlOrderList = new JPanel();
        pnlOrderList.setLayout(null);
        pnlOrderList.setBackground(Color.WHITE);
        pnlOrderList.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_white, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        pnlRight.add(pnlOrderList);
        pnlOrderList.setBounds(0, 57, 556, 408);

        tblOrderList = new JTable();

        generateOrderList(DATA);

        JScrollPane spOrderList = new JScrollPane(tblOrderList);
        pnlOrderList.add(spOrderList);
        spOrderList.setBounds(0,0,556,408);

        tblOrderList.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clearMenuSelection();
                    }
                }
        );

        JLabel btnQty = new JLabel();
        btnQty.setIcon(new ImageIcon(".\\src\\resources\\btnQty.png"));
        btnQty.setForeground(Color.white);
        btnQty.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnQty.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlRight.add(btnQty);
        btnQty.setBounds(12, 495, 195, 45);
        btnQty.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        int rowIndex = tblOrderList.getSelectedRow();

                        if (rowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Quantity Error.", "Please select an item.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        String productCode = ((DefaultTableModel)tblOrderList.getModel()).getValueAt(rowIndex, 4).toString();
                        String productName = ((DefaultTableModel)tblOrderList.getModel()).getValueAt(rowIndex, 0).toString();
                        Double productPrice = Double.parseDouble(((DefaultTableModel)tblOrderList.getModel())
                                .getValueAt(rowIndex,1).toString().substring(1));
                        int productQty = Integer.parseInt(((DefaultTableModel)tblOrderList.getModel()).getValueAt(rowIndex, 2).toString());
                        String imagePath = "";
                        for (Product o: DATA.getProductList()){
                            if (o.getCode().equals(productCode)){
                                imagePath = o.getImage().toString();
                            }
                        }

                        DialogEditOrderQuantity dialogEditOrderQuantity = new DialogEditOrderQuantity(DATA, productCode, imagePath, productName,
                                productPrice, productQty);
                        dialogEditOrderQuantity.setVisible(true);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnQty.setIcon(new ImageIcon(".\\src\\resources\\btnQtyHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnQty.setIcon(new ImageIcon(".\\src\\resources\\btnQty.png"));
                    }
                }
        );

        JLabel btnDeleteItemFromList = new JLabel();
        btnDeleteItemFromList.setIcon(new ImageIcon(".\\src\\resources\\btnDelete.png"));
        btnDeleteItemFromList.setForeground(Color.white);
        btnDeleteItemFromList.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeleteItemFromList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlRight.add(btnDeleteItemFromList);
        btnDeleteItemFromList.setBounds(12, 552, 195, 45);
        btnDeleteItemFromList.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int[] selectedRowIndex = tblOrderList.getSelectedRows();

                        if (selectedRowIndex.length <= 0){
                            DialogOk dialogOk = new DialogOk("Delete Error.", "Please select an item.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        for (int i = 0; i < selectedRowIndex.length; i++){
                            if (selectedRowIndex[i] < 0){
                                DialogOk dialogOk = new DialogOk("Delete Error", "Please select an item.");
                                dialogOk.setVisible(true);
                                return;
                            }
                            DefaultTableModel tableModel = (DefaultTableModel) tblOrderList.getModel();
                            String codeToDelete = tableModel.getValueAt(selectedRowIndex[i], 4).toString();
                            DATA.deleteOrder(codeToDelete);
                        }
                        generateOrderList(DATA);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDeleteItemFromList.setIcon(new ImageIcon(".\\src\\resources\\btnDeleteHl.png"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDeleteItemFromList.setIcon(new ImageIcon(".\\src\\resources\\btnDelete.png"));
                    }
                }
        );

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        lblTotal.setForeground(color_darkgray);
        pnlRight.add(lblTotal);
        lblTotal.setBounds(234, 497, 85, 47);

        lblTotalAmount = new JLabel();
        lblTotalAmount.setText("₱00.00");
        lblTotalAmount.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        lblTotalAmount.setForeground(color_darkgray);
        pnlRight.add(lblTotalAmount);
        lblTotalAmount.setBounds(329, 497, 220, 47);

        JLabel lblDiscount = new JLabel("Discount:");
        lblDiscount.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        lblDiscount.setForeground(color_title_gray);
        pnlRight.add(lblDiscount);
        lblDiscount.setBounds(234, 553, 85, 47);

        JLabel btnDiscount = new JLabel();
        btnDiscount.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\discount_128.png").getImage()
                .getScaledInstance(50, 50,Image.SCALE_DEFAULT)));
        btnDiscount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlRight.add(btnDiscount);
        btnDiscount.setBounds(428, 545, 50,50);
        btnDiscount.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        double total = Double.parseDouble(lblTotalAmount.getText().substring(1));
                        if (total <= 0){
                            DialogOk dialogOk = new DialogOk("Discount Error", "Please order an item first.");
                            dialogOk.setVisible(true);
                            return;
                        }


                        Double balance1 = Double.parseDouble(lblBalanceAmount.getText().substring(1));
                        Double totalprice = Double.parseDouble(lblTotalAmount.getText().substring(1));
                        double oldpercentage = Math.abs(Math.floor((balance1 / totalprice * 100) - 100));

                        DialogDiscount dialogDiscount = new DialogDiscount(Integer.parseInt(noDecimalFormat.format(oldpercentage)));
                        dialogDiscount.setVisible(true);

                        double percentage = dialogDiscount.getDiscountPercentage();
                        double discount = total * (percentage/100);
                        double balance = total - discount;
                        lblDiscountAmount.setText("₱" + twoDecimalFormat.format(discount));
                        lblBalanceAmount.setText("₱" + twoDecimalFormat.format(balance));

                        lblChangeAmount.setText("");
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDiscount.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\discountHl_128.png").getImage()
                                .getScaledInstance(50, 50,Image.SCALE_DEFAULT)));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDiscount.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\discount_128.png").getImage()
                                .getScaledInstance(50, 50,Image.SCALE_DEFAULT)));
                    }
                }
        );

        lblDiscountAmount = new JLabel();
        lblDiscountAmount.setText("₱00.00");
        lblDiscountAmount.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        lblDiscountAmount.setForeground(color_darkgray);
        pnlRight.add(lblDiscountAmount);
        lblDiscountAmount.setBounds(329, 553, 220, 47);

        JLabel lblBalance = new JLabel("Balance");
        lblBalance.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        lblBalance.setForeground(color_title_gray);
        pnlRight.add(lblBalance);
        lblBalance.setBounds(20, 625, 68, 27);

        lblBalanceAmount = new JLabel();
        lblBalanceAmount.setText("₱00.00");
        lblBalanceAmount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblBalanceAmount.setForeground(color_red);
        pnlRight.add(lblBalanceAmount);
        lblBalanceAmount.setBounds(20, 665, 220, 46);

        JLabel lblPayment = new JLabel("Payment");
        lblPayment.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        lblPayment.setForeground(color_title_gray);
        pnlRight.add(lblPayment);
        lblPayment.setBounds(20, 719, 100, 27);

        txtPayment = new JTextField();
        txtPayment.setEditable(false);
        txtPayment.setFont(new Font("Segoe UI", Font.BOLD, 30));
        txtPayment.setForeground(color_title_gray);
        txtPayment.setBackground(Color.WHITE);
        txtPayment.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_border_lightgray, 1),
                BorderFactory.createEmptyBorder(2, 20, 2, 2)));
        pnlRight.add(txtPayment);
        txtPayment.setBounds(0, 754, 219, 66);

        JLabel lblChange = new JLabel("Change");
        lblChange.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        lblChange.setForeground(color_title_gray);
        pnlRight.add(lblChange);
        lblChange.setBounds(20, 830, 100, 27);

        lblChangeAmount = new JLabel();
        lblChangeAmount.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblChangeAmount.setForeground(new Color(90,167,226));
        pnlRight.add(lblChangeAmount);
        lblChangeAmount.setBounds(20, 861, 220, 46);

        // Calculator
        JButton btn1 = new JButton("1");
        btn1.setForeground(color_darkergray);
        btn1.setBackground(Color.WHITE);
        btn1.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn1.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn1.setFocusable(false);
        pnlRight.add(btn1);
        btn1.setBounds(219,618, 84 , 90);
        Action btn1Action = new AbstractAction("1") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "1";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn1.setAction(btn1Action);
        btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "One");
        btn1.getActionMap().put("One", btn1Action);

        JButton btn2 = new JButton("2");
        btn2.setForeground(color_darkergray);
        btn2.setBackground(Color.WHITE);
        btn2.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn2.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn2.setFocusable(false);
        pnlRight.add(btn2);
        btn2.setBounds(302,618, 84 , 90);
        Action btn2Action = new AbstractAction("2") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "2";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn2.setAction(btn2Action);
        btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "Two");
        btn2.getActionMap().put("Two", btn2Action);

        JButton btn3 = new JButton("3");
        btn3.setForeground(color_darkergray);
        btn3.setBackground(Color.WHITE);
        btn3.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn3.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn3.setFocusable(false);
        pnlRight.add(btn3);
        btn3.setBounds(385,618, 84 , 90);
        Action btn3Action = new AbstractAction("3") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "3";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn3.setAction(btn3Action);
        btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "Three");
        btn3.getActionMap().put("Three", btn3Action);

        JButton btn4 = new JButton("4");
        btn4.setForeground(color_darkergray);
        btn4.setBackground(Color.WHITE);
        btn4.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn4.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn4.setFocusable(false);
        pnlRight.add(btn4);
        btn4.setBounds(219,708, 84 , 90);
        Action btn4Action = new AbstractAction("4") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "4";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn4.setAction(btn4Action);
        btn4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "Four");
        btn4.getActionMap().put("Four", btn4Action);

        JButton btn5 = new JButton("5");
        btn5.setForeground(color_darkergray);
        btn5.setBackground(Color.WHITE);
        btn5.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn5.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn5.setFocusable(false);
        pnlRight.add(btn5);
        btn5.setBounds(302,708, 84 , 90);
        Action btn5Action = new AbstractAction("5") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "5";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn5.setAction(btn5Action);
        btn5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), "Five");
        btn5.getActionMap().put("Five", btn5Action);

        JButton btn6 = new JButton("6");
        btn6.setForeground(color_darkergray);
        btn6.setBackground(Color.WHITE);
        btn6.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn6.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn6.setFocusable(false);
        pnlRight.add(btn6);
        btn6.setBounds(385,708, 84 , 90);
        Action btn6Action = new AbstractAction("6") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "6";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn6.setAction(btn6Action);
        btn6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), "Six");
        btn6.getActionMap().put("Six", btn6Action);

        JButton btn7 = new JButton("7");
        btn7.setForeground(color_darkergray);
        btn7.setBackground(Color.WHITE);
        btn7.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn7.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn7.setFocusable(false);
        pnlRight.add(btn7);
        btn7.setBounds(219,798, 84 , 90);
        Action btn7Action = new AbstractAction("7") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "7";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn7.setAction(btn7Action);
        btn7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), "Seven");
        btn7.getActionMap().put("Seven", btn7Action);

        JButton btn8 = new JButton("8");
        btn8.setForeground(color_darkergray);
        btn8.setBackground(Color.WHITE);
        btn8.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn8.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn8.setFocusable(false);
        pnlRight.add(btn8);
        btn8.setBounds(302,798, 84 , 90);
        Action btn8Action = new AbstractAction("8") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "8";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn8.setAction(btn8Action);
        btn8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_8, 0), "Eight");
        btn8.getActionMap().put("Eight", btn8Action);


        JButton btn9 = new JButton("9");
        btn9.setForeground(color_darkergray);
        btn9.setBackground(Color.WHITE);
        btn9.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn9.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn9.setFocusable(false);
        pnlRight.add(btn9);
        btn9.setBounds(385,798, 84 , 90);
        Action btn9Action = new AbstractAction("9") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "9";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn9.setAction(btn9Action);
        btn9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "Nine");
        btn9.getActionMap().put("Nine", btn9Action);


        JButton btn0 = new JButton("0");
        btn0.setForeground(color_darkergray);
        btn0.setBackground(Color.WHITE);
        btn0.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn0.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn0.setFocusable(false);
        pnlRight.add(btn0);
        btn0.setBounds(302,888, 84 , 90);
        Action btn0Action = new AbstractAction("0") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += "0";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btn0.setAction(btn0Action);
        btn0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "Zero");
        btn0.getActionMap().put("Zero", btn0Action);

        JButton btn50 = new JButton("₱50");
        btn50.setForeground(color_darkergray);
        btn50.setBackground(Color.WHITE);
        btn50.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btn50.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn50.setFocusable(false);
        pnlRight.add(btn50);
        btn50.setBounds(468,708, 84 , 90);
        btn50.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (CALCULATOR_TEXT.length() == 0){
                                CALCULATOR_TEXT = "50";
                                txtPayment.setText(CALCULATOR_TEXT);
                                return;
                            }

                            if (CALCULATOR_TEXT.contains(".")){
                                double payment = Double.parseDouble(CALCULATOR_TEXT);
                                payment += 50;
                                CALCULATOR_TEXT = String.valueOf(payment);
                            } else {
                                double payment = Double.parseDouble(CALCULATOR_TEXT);
                                payment += 50;
                                CALCULATOR_TEXT = noDecimalFormat.format(payment);
                            }
                            txtPayment.setText(CALCULATOR_TEXT);

                            lblChangeAmount.setText("");

                        } catch (NumberFormatException ex){
                            System.out.println(ex);
                        }
                    }
                }
        );

        JButton btn100 = new JButton("₱100");
        btn100.setForeground(color_darkergray);
        btn100.setBackground(Color.WHITE);
        btn100.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btn100.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn100.setFocusable(false);
        pnlRight.add(btn100);
        btn100.setBounds(468,618, 84 , 90);
        btn100.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (CALCULATOR_TEXT.length() == 0){
                                CALCULATOR_TEXT = "100";
                                txtPayment.setText(CALCULATOR_TEXT);
                                return;
                            }

                            if (CALCULATOR_TEXT.contains(".")){
                                double payment = Double.parseDouble(CALCULATOR_TEXT);
                                payment += 100;
                                CALCULATOR_TEXT = String.valueOf(payment);
                            } else {
                                double payment = Double.parseDouble(CALCULATOR_TEXT);
                                payment += 100;
                                CALCULATOR_TEXT = noDecimalFormat.format(payment);
                            }
                            txtPayment.setText(CALCULATOR_TEXT);

                            lblChangeAmount.setText("");

                        } catch (NumberFormatException ex){
                            System.out.println(ex);
                        }
                    }
                }
        );

        JButton btnC = new JButton("C");
        btnC.setForeground(color_darkergray);
        btnC.setBackground(Color.WHITE);
        btnC.setFont(new Font("Segoe UI", Font.BOLD, 33));
        btnC.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnC.setFocusable(false);
        pnlRight.add(btnC);
        btnC.setBounds(468,798, 84 , 90);
        btnC.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT = "";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");
                    }
                }
        );

        JButton btnDot = new JButton(".");
        btnDot.setForeground(color_darkergray);
        btnDot.setBackground(Color.WHITE);
        btnDot.setFont(new Font("Segoe UI", Font.BOLD, 33));
        btnDot.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnDot.setFocusable(false);
        pnlRight.add(btnDot);
        btnDot.setBounds(385,888, 84 , 90);
        Action btnDotAction = new AbstractAction(".") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CALCULATOR_TEXT += ".";
                txtPayment.setText(CALCULATOR_TEXT);

                lblChangeAmount.setText("");
            }
        };
        btnDot.setAction(btnDotAction);
        btnDot.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), "Period");
        btnDot.getActionMap().put("Period", btnDotAction);

        JButton btnX = new JButton("X");
        btnX.setForeground(color_darkergray);
        btnX.setBackground(Color.WHITE);
        btnX.setFont(new Font("Segoe UI", Font.BOLD, 33));
        btnX.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnX.setFocusable(false);
        pnlRight.add(btnX);
        btnX.setBounds(468,888, 84 , 90);
        Action btnXAction = new AbstractAction("X") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (CALCULATOR_TEXT.length() > 0){
                    int length = CALCULATOR_TEXT.length();
                    CALCULATOR_TEXT = CALCULATOR_TEXT.substring(0,(length-1));
                    txtPayment.setText(CALCULATOR_TEXT);

                    lblChangeAmount.setText("");
                }
            }
        };
        btnX.setAction(btnXAction);
        btnX.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "Backspace");
        btnX.getActionMap().put("Backspace", btnXAction);


        JButton btnEqualCal = new JButton("=");
        btnEqualCal.setForeground(color_darkergray);
        btnEqualCal.setBackground(Color.WHITE);
        btnEqualCal.setFont(new Font("Segoe UI", Font.BOLD, 33));
        btnEqualCal.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnEqualCal.setFocusable(false);
        pnlRight.add(btnEqualCal);
        btnEqualCal.setBounds(219,888, 84 , 90);
        Action btnEqualAction = new AbstractAction("=") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (txtPayment.getText().isEmpty()){
                    DialogOk dialogOk = new DialogOk("Transaction Error","Incomplete transaction.");
                    dialogOk.setVisible(true);
                    return;
                }

                double balance = Double.parseDouble(lblBalanceAmount.getText().substring(1));
                double payment = Double.parseDouble(txtPayment.getText());

                if (balance <= 0){
                    DialogOk dialogOk = new DialogOk("Transaction Error","Incomplete transaction.");
                    dialogOk.setVisible(true);
                    txtPayment.setText("");
                    return;
                }

                double change = payment - balance;
                if (change < 0){
                    DialogOk dialogOk = new DialogOk("Payment Error","Insufficient payment.");
                    dialogOk.setVisible(true);
                } else {
                    lblChangeAmount.setText("₱" + twoDecimalFormat.format(change));
                }
            }
        };
        btnEqualCal.setAction(btnEqualAction);
        btnEqualCal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "Equal");
        btnEqualCal.getActionMap().put("Equal", btnEqualAction);

        // End Calculator

        btnProcessOrder = new JButton("Process Order");
        btnProcessOrder.setForeground(Color.WHITE);
        btnProcessOrder.setBackground(new Color(80,199,116));
        btnProcessOrder.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnProcessOrder.setBorder(BorderFactory.createEmptyBorder());
        pnlRight.add(btnProcessOrder);
        btnProcessOrder.setBounds(11,920,196,45);
        btnProcessOrder.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            double change = Double.parseDouble(lblChangeAmount.getText().substring(1));
                        } catch (StringIndexOutOfBoundsException ex){ // no change amount
                            DialogOk dialogOk = new DialogOk("Error", "Incomplete transaction.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                        LocalDate DATE = LocalDate.now();

<<<<<<< Updated upstream
                        String month = String.valueOf(DATE.getMonthValue());
                        String day = String.valueOf(DATE.getDayOfMonth());
                        String year = String.valueOf(DATE.getYear());
                        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
                        String staffincharge = lblUserName.getText();

                        String id = month + day + year + (DATA.getTransactionLog().size()+1);
=======
                        if (dialogYesNo.getYesNo()){
>>>>>>> Stashed changes

                        ReceiptDialog receiptDialog = new ReceiptDialog(DATA, lblBusinessAddress.getText(),
                                staffincharge, date, id, lblTotalAmount.getText(), lblDiscountAmount.getText(),
                                lblBalanceAmount.getText());
                        receiptDialog.setVisible(true);

                        if (receiptDialog.isConfirm()){
                            StringBuilder itemordered = new StringBuilder();
                            for(Order order: DATA.getOrderList()){
                                itemordered.append(order.getName()).append(" ").append(order.getQuantity()).append("x").append(" ");
                            }
                            double total = Double.parseDouble(lblBalanceAmount.getText().substring(1));
                            String discount = lblDiscountAmount.getText().substring(1);
                            double payment = Double.parseDouble(txtPayment.getText());
                            double change = Double.parseDouble(lblChangeAmount.getText().substring(1));

                            TransactionLog transactionLog = new TransactionLog(id,month,day,year,time,staffincharge,itemordered.toString(),total,discount,payment
                                    ,change);

                            DATA.saveTransaction(transactionLog);

                            generateTransactionTable(DATA, 1);

                            // add to sales

                            for (Order o: DATA.getOrderList()){
                                DATA.addToSales(new Sales(o.getCode(), o.getName(), o.getEachPrice(),o.getQuantity()));
                            }

                            generateSalesTable(DATA, "");

                            btnReset.doClick();
                        }
                    }
                }
        );

        // End Right Side
    }

    public static void generateMenu(Data data, String category){
        String[] colsMenu = {"", "Item", "Price", "", ""};
        tblMenuModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
        ArrayList<Product> products = data.getProductList();
        for (Product o: products){
            if (o.getCategory().equals(category)){
                if (o.getAvailability().equals("Available")){

                    // resizing image
                    BufferedImage image = null;
                    Icon icon = null;
                    try {
                        File file = new File(o.getImage().toString());
                        image = ImageIO.read(file);
                        Image dimg = image.getScaledInstance(100, 100,
                                Image.SCALE_SMOOTH);
                        icon = new ImageIcon(dimg);
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }

                    Object[] newRow = {icon, o.getName(), "₱"+twoDecimalFormat.format(o.getPrice()),
                            "Order", o.getCode()};
                    tblMenuModel.addRow(newRow);
                }
            }
        }

        tblMenu.setSelectionBackground(new Color(242,242,242));
        tblMenu.setModel(tblMenuModel);
        tblMenu.setGridColor(color_border_lightgray);
        tblMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tblMenu.setRowHeight(100);
        tblMenu.setGridColor(Color.WHITE);
        tblMenu.setBorder(BorderFactory.createEmptyBorder());
        tblMenu.setRowMargin(10);
        tblMenu.setDefaultEditor(Object.class, null); // editable = false
        tblMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMenu.setFocusable(false);
        tblMenu.setShowHorizontalLines(false);
        tblMenu.setShowVerticalLines(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblMenu.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        Action OrderEvent = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clearOrderListSelection();

                    int rowIndex = Integer.valueOf(e.getActionCommand());

                    String imagePath = "";
                    String productCode = ((DefaultTableModel)tblMenu.getModel()).getValueAt(rowIndex, 4).toString();
                    for (Product o: data.getProductList()){
                        if (o.getCode().equals(productCode)){
                            imagePath = o.getImage().toString();
                        }
                    }
                    String productName = ((DefaultTableModel)tblMenu.getModel()).getValueAt(rowIndex, 1).toString();
                    Double productPrice = Double.parseDouble(((DefaultTableModel)tblMenu.getModel()).getValueAt(rowIndex,
                            2).toString().substring(1));


                    DialogQuantity dialogQuantity = new DialogQuantity(data, productCode, imagePath, productName, productPrice);
                    dialogQuantity.setVisible(true);
                } catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println(ex);
                }
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblMenu, OrderEvent, 3);

        // Modify Column
        TableColumnModel tableColumnModel = tblMenu.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(4)); // hides code

    }

    public void clearMenuSelection(){
        tblMenu.getSelectionModel().clearSelection();
        tblMenu.getColumnModel().getSelectionModel().clearSelection();
    }

    public static void generateOrderList(Data data){
        String[] colsMenu = {"Item Name", "Each Price", "QTY", "Price", ""};
        tblOrderListModel = new DefaultTableModel(colsMenu, 0);

        ArrayList<Order> orders = data.getOrderList();
        for (Order o: orders){
            Object[] newRow = {o.getName(), "₱"+twoDecimalFormat.format(o.getEachPrice()), o.getQuantity(),
                    "₱"+twoDecimalFormat.format(o.getTotal()), o.getCode()};
            tblOrderListModel.addRow(newRow);
        }

        tblOrderList.setSelectionBackground(color_darkgray);
        tblOrderList.setSelectionForeground(color_white);
        tblOrderList.setModel(tblOrderListModel);
        tblOrderList.setGridColor(color_border_lightgray);
        tblOrderList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tblOrderList.setRowHeight(40);
        tblOrderList.setGridColor(Color.WHITE);
        tblOrderList.setBorder(BorderFactory.createEmptyBorder());
        tblOrderList.setDefaultEditor(Object.class, null); // editable = false
//        tblOrderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblOrderList.setFocusable(false);
        tblOrderList.setShowHorizontalLines(false);
        tblOrderList.setShowVerticalLines(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblOrderList.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblOrderList.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblOrderList.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblOrderList.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        // Modify Column
        TableColumnModel tableColumnModel = tblOrderList.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(4)); // hides code
        tableColumnModel.getColumn(0).setPreferredWidth(150);
        tableColumnModel.getColumn(2).setPreferredWidth(20);

    }

    public static void clearOrderListSelection(){
        tblOrderList.getSelectionModel().clearSelection();
        tblOrderList.getColumnModel().getSelectionModel().clearSelection();
    }

    private void createTransactionLogGUI(){
        pnlTransactionLog = new JPanel();
        pnlTransactionLog.setBackground(Color.WHITE);
        pnlTransactionLog.setForeground(color_darkgray);
        pnlTransactionLog.setLayout(null);
        add(pnlTransactionLog);
        pnlTransactionLog.setBounds(354, 103, 1566, 977);
        pnlTransactionLog.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clearTransactionSelection();
                    }
                }
        );

        JPanel pnlMainTransactionLog = new JPanel();
        pnlMainTransactionLog.setBackground(Color.WHITE);
        pnlMainTransactionLog.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlMainTransactionLog.setLayout(null);
        pnlTransactionLog.add(pnlMainTransactionLog);
        pnlMainTransactionLog.setBounds(64,33,1406,902);

        JLabel lblTransactionLog = new JLabel("TRANSACTION LOG");
        lblTransactionLog.setFont(new Font("Segoe UI", Font.BOLD, 30));
        pnlMainTransactionLog.add(lblTransactionLog);
        lblTransactionLog.setBounds(50, 40, 390, 56);

        JButton btnExportLog = new JButton("EXPORT LOG");
        btnExportLog.setBackground(new Color(225,176,20));
        btnExportLog.setForeground(Color.WHITE);
        btnExportLog.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnExportLog.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\add_128.png").getImage()
                .getScaledInstance(32, 32,Image.SCALE_DEFAULT)));
        btnExportLog.setIconTextGap(10);
        btnExportLog.setFocusable(false);
        btnExportLog.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        btnExportLog.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlMainTransactionLog.add(btnExportLog);
        btnExportLog.setBounds(469,38,317,58);
        btnExportLog.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (tblTransactionLog.getRowCount() == 0){
                            DialogOk dialogOk = new DialogOk("Error", "Transaction Log is empty.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        DefaultTableModel defaultTableModel = tblTransactionLogModel;

                        String exportdate = "";
                        if (cmbMonth.getSelectedIndex() == 0){
                            DialogOk dialogOk = new DialogOk("Error", "Please select a month.");
                            dialogOk.setVisible(true);
                            return;
                        } else {
                            exportdate = cmbMonth.getSelectedItem().toString();
                            if (cmbDay.getSelectedIndex() != 0){
                                exportdate += " " + cmbDay.getSelectedItem();
                            }
                        }

                        ExportTransactionLog exportTransactionLog = new ExportTransactionLog(defaultTableModel,
                                lblBusinessAddress.getText() , exportdate);
                        try {
                            Printer.printComponent(exportTransactionLog, true);
                        } catch (PrinterException ex) {
                            DialogOk dialogOk = new DialogOk("Error", "An error occured.");
                            dialogOk.setVisible(true);
                        }
                    }
                }
        );

        btnResetTransactionLog = new JButton("RESET LOG");
        btnResetTransactionLog.setBackground(color_darkgray);
        btnResetTransactionLog.setForeground(Color.WHITE);
        btnResetTransactionLog.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnResetTransactionLog.setFocusable(false);
        btnResetTransactionLog.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        btnResetTransactionLog.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlMainTransactionLog.add(btnResetTransactionLog);
        btnResetTransactionLog.setBounds(806,38,226,58);
        btnResetTransactionLog.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DialogAdminConfirm dialogAdminConfirm = new DialogAdminConfirm(DATA);
                        dialogAdminConfirm.setVisible(true);

                        if (dialogAdminConfirm.isAccountValid()){
                            DATA.deleteAllTransaction();
                        }
                        generateTransactionTable(DATA, 1);
                    }
                }
        );

        JLabel lblDivider = new JLabel(
                "___________________________________________________________________________________________________________________________________________________________");
        lblDivider.setFont(new Font("Segoe UI", Font.BOLD, 19));
        lblDivider.setForeground(color_darkgray);
        pnlMainTransactionLog.add(lblDivider);
        lblDivider.setBounds(50,90,1316,30);

        JLabel lblMonth = new JLabel("Month:");
        lblMonth.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        pnlMainTransactionLog.add(lblMonth);
        lblMonth.setBounds(131,160,70,28);

        final String[] months = {"- select -", "January", "February", "March", "April", "May", "June", "July",
                "August",
                "September",
                "October", "November", "December"};
        cmbMonth = new JComboBox<>(months);
        cmbMonth.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        cmbMonth.setBackground(Color.WHITE);
        cmbMonth.setForeground(color_darkgray);
        cmbMonth.setFocusable(false);
        ((JLabel)cmbMonth.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlMainTransactionLog.add(cmbMonth);
        cmbMonth.setBounds(213,155,284,39);
        cmbMonth.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (cmbMonth.getSelectedIndex() == 0){
                            cmbDay.setEnabled(false);
                        } else {
                            cmbDay.setEnabled(true);
                        }
                    }
                }
        );

        JLabel lblDay = new JLabel("Day:");
        lblDay.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        pnlMainTransactionLog.add(lblDay);
        lblDay.setBounds(519,160,50,28);

        final String[] days = {"- select -","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        cmbDay = new JComboBox<>(days);
        cmbDay.setFont(new Font("Segoe UI", Font.PLAIN, 21));
        cmbDay.setBackground(Color.WHITE);
        cmbDay.setForeground(color_darkgray);
        cmbDay.setFocusable(false);
        cmbDay.setEnabled(false);
        ((JLabel)cmbDay.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlMainTransactionLog.add(cmbDay);
        cmbDay.setBounds(575,155,284,39);

        JButton btnApplyFilter = new JButton("Apply Filter");
        btnApplyFilter.setBackground(Color.WHITE);
        btnApplyFilter.setFocusable(false);
        btnApplyFilter.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnApplyFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlMainTransactionLog.add(btnApplyFilter);
        btnApplyFilter.setBounds(881,155,149,39);
        btnApplyFilter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String monthNumber;

                        if (cmbMonth.getSelectedItem().equals("January")){
                            monthNumber = "1";
                        } else if (cmbMonth.getSelectedItem().equals("February")){
                            monthNumber = "2";
                        } else if (cmbMonth.getSelectedItem().equals("March")){
                            monthNumber = "3";
                        } else if (cmbMonth.getSelectedItem().equals("April")){
                            monthNumber = "4";
                        } else if (cmbMonth.getSelectedItem().equals("May")){
                            monthNumber = "5";
                        } else if (cmbMonth.getSelectedItem().equals("June")){
                            monthNumber = "6";
                        } else if (cmbMonth.getSelectedItem().equals("July")){
                            monthNumber = "7";
                        } else if (cmbMonth.getSelectedItem().equals("August")){
                            monthNumber = "8";
                        } else if (cmbMonth.getSelectedItem().equals("September")){
                            monthNumber = "9";
                        } else if (cmbMonth.getSelectedItem().equals("October")){
                            monthNumber = "10";
                        } else if (cmbMonth.getSelectedItem().equals("November")){
                            monthNumber = "11";
                        } else if (cmbMonth.getSelectedItem().equals("December")){
                            monthNumber = "12";
                        } else {
                            monthNumber = "0";
                        }

                        if (cmbMonth.getSelectedIndex() == 0 && cmbDay.getSelectedIndex() == 0){
                            System.out.println("no filter");
                            generateTransactionTable(DATA, 1);
                        } else if (cmbMonth.getSelectedIndex() != 0 && cmbDay.getSelectedIndex() == 0){
                            System.out.println("filter month");
                            generateTransactionTable(DATA, 2, monthNumber);
                        } else if (cmbMonth.getSelectedIndex() == 0 && cmbDay.getSelectedIndex() != 0){
                            System.out.println("filter day");
                            generateTransactionTable(DATA, 3, monthNumber, cmbDay.getSelectedItem().toString());
                        } else if (cmbMonth.getSelectedIndex() != 0 && cmbDay.getSelectedIndex() != 0) {
                            System.out.println("filter both");
                            generateTransactionTable(DATA, 4, monthNumber,
                                    cmbDay.getSelectedItem().toString());
                        }
                    }
                }
        );

        JButton btnClearFilter = new JButton("Clear Filter");
        btnClearFilter.setBackground(Color.WHITE);
        btnClearFilter.setFocusable(false);
        btnClearFilter.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnClearFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlMainTransactionLog.add(btnClearFilter);
        btnClearFilter.setBounds(1048,155,149,39);
        btnClearFilter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cmbMonth.setSelectedIndex(0);
                        cmbDay.setSelectedIndex(0);
                        generateTransactionTable(DATA, 1);
                    }
                }
        );


        tblTransactionLog = new JTable();
        JScrollPane spTransactionLog = new JScrollPane(tblTransactionLog);
        pnlMainTransactionLog.add(spTransactionLog);
        spTransactionLog.setBounds(44,213,1310,653);

        generateTransactionTable(DATA, 1);

    }

    private static void generateTransactionTable(Data data, int filterMode){
        generateTransactionTable(data, filterMode, "0");
    }

    private static void generateTransactionTable(Data data, int filterMode, String month){
        generateTransactionTable(data, filterMode, month, "0");
    }

    private static void generateTransactionTable(Data data, int filterMode, String month, String day){

        String[] colsLog = {"ID","Date of Purchase", "Staff-in-Charge", "Item/s Ordered" , "Discount", "Total Price",
                "Payment", "Change"};
        tblTransactionLogModel = new DefaultTableModel(colsLog, 0);

        for (int i = data.getTransactionLog().size() - 1; i >= 0; i--){ // Iterate in Reverse order
            switch (filterMode){
                case 1: { // no filter
                    String dateOfPurchase = data.getTransactionLog().get(i).getMonthOfPurchase() + "/" + data.getTransactionLog().get(i).getDayOfPurchase() + "/" + data.getTransactionLog().get(i).getYearOfPurchase();
                    Object[] newRow = {data.getTransactionLog().get(i).getId(), dateOfPurchase, data.getTransactionLog().get(i).getStaffInCharge(), data.getTransactionLog().get(i).getItem(),"₱"+data.getTransactionLog().get(i).getDiscount(),
                            "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getTotal()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getPayment()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getChange())};
                    tblTransactionLogModel.addRow(newRow);
                    break;
                } case 2: { // month filter
                    if (data.getTransactionLog().get(i).getMonthOfPurchase().equals(month)){
                        String dateOfPurchase = data.getTransactionLog().get(i).getMonthOfPurchase() + "/" + data.getTransactionLog().get(i).getDayOfPurchase() + "/" + data.getTransactionLog().get(i).getYearOfPurchase();
                        Object[] newRow = {data.getTransactionLog().get(i).getId(), dateOfPurchase, data.getTransactionLog().get(i).getStaffInCharge(), data.getTransactionLog().get(i).getItem(),"₱"+data.getTransactionLog().get(i).getDiscount(),
                                "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getTotal()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getPayment()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getChange())};
                        tblTransactionLogModel.addRow(newRow);
                    }
                    break;
                } case 3: { // day filter
                    if (data.getTransactionLog().get(i).getDayOfPurchase().equals(day)){
                        String dateOfPurchase = data.getTransactionLog().get(i).getMonthOfPurchase() + "/" + data.getTransactionLog().get(i).getDayOfPurchase() + "/" + data.getTransactionLog().get(i).getYearOfPurchase();
                        Object[] newRow = {data.getTransactionLog().get(i).getId(), dateOfPurchase, data.getTransactionLog().get(i).getStaffInCharge(), data.getTransactionLog().get(i).getItem(),"₱"+data.getTransactionLog().get(i).getDiscount(),
                                "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getTotal()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getPayment()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getChange())};
                        tblTransactionLogModel.addRow(newRow);
                    }
                    break;
                } case 4: { // both filter
                    if (data.getTransactionLog().get(i).getDayOfPurchase().equals(day) && data.getTransactionLog().get(i).getMonthOfPurchase().equals(month)){
                        String dateOfPurchase = data.getTransactionLog().get(i).getMonthOfPurchase() + "/" + data.getTransactionLog().get(i).getDayOfPurchase() + "/" + data.getTransactionLog().get(i).getYearOfPurchase();
                        Object[] newRow = {data.getTransactionLog().get(i).getId(), dateOfPurchase, data.getTransactionLog().get(i).getStaffInCharge(), data.getTransactionLog().get(i).getItem(),"₱"+data.getTransactionLog().get(i).getDiscount(),
                                "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getTotal()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getPayment()), "₱"+twoDecimalFormat.format(data.getTransactionLog().get(i).getChange())};
                        tblTransactionLogModel.addRow(newRow);
                    }
                    break;
                }
            }
        }
        tblTransactionLog.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblTransactionLog.setModel(tblTransactionLogModel);
        tblTransactionLog.setGridColor(color_border_lightgray);
        tblTransactionLog.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblTransactionLog.setRowHeight(40);
        tblTransactionLog.setDefaultEditor(Object.class, null); // editable = false
        tblTransactionLog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblTransactionLog.setFocusable(false);

        // Modify Column
        TableColumnModel tableColumnModel = tblTransactionLog.getColumnModel();
//        tableColumnModel.removeColumn(tableColumnModel.getColumn(0)); // hides code

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblTransactionLog.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblTransactionLog.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblTransactionLog.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblTransactionLog.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblTransactionLog.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblTransactionLog.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tblTransactionLog.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

        tblTransactionLog.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblTransactionLog.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblTransactionLog.getColumnModel().getColumn(2).setPreferredWidth(300);
        tblTransactionLog.getColumnModel().getColumn(3).setPreferredWidth(710);
        tblTransactionLog.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblTransactionLog.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblTransactionLog.getColumnModel().getColumn(6).setPreferredWidth(150);
        tblTransactionLog.getColumnModel().getColumn(7).setPreferredWidth(150);



    }

    public void clearTransactionSelection(){
        tblTransactionLog.getSelectionModel().clearSelection();
        tblTransactionLog.getColumnModel().getSelectionModel().clearSelection();
    }

    private void createSystemSettingsGUI(){
        pnlSystemSettings = new JPanel();
        pnlSystemSettings.setBackground(Color.WHITE);
        pnlSystemSettings.setForeground(color_darkgray);
        pnlSystemSettings.setLayout(null);
        add(pnlSystemSettings);
        pnlSystemSettings.setBounds(354, 103, 1566, 977);

        JPanel pnlInsideSystemSettings = new JPanel();
        pnlInsideSystemSettings.setBackground(Color.WHITE);
        pnlInsideSystemSettings.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlInsideSystemSettings.setLayout(null);
        pnlSystemSettings.add(pnlInsideSystemSettings);
        pnlInsideSystemSettings.setBounds(64,33,1406,850);
        pnlInsideSystemSettings.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        pnlInsideSystemSettings.requestFocusInWindow();
                    }
                }
        );

        JLabel lblSystemSettings = new JLabel("SYSTEM SETTINGS");
        lblSystemSettings.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblSystemSettings.setForeground(color_title_gray);
        pnlInsideSystemSettings.add(lblSystemSettings);
        lblSystemSettings.setBounds(50,40,367,56);

        JLabel lblDivider = new JLabel(
                "___________________________________________________________________________________________________________________________________________________________");
        lblDivider.setFont(new Font("Segoe UI", Font.BOLD, 19));
        lblDivider.setForeground(color_darkgray);
        pnlInsideSystemSettings.add(lblDivider);
        lblDivider.setBounds(50,80,1316,30);

        JLabel btnAccountSettings = new JLabel("  Account Settings");
        btnAccountSettings.setHorizontalAlignment(SwingConstants.LEFT);
        btnAccountSettings.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_border_lightgray, 2),
                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
        btnAccountSettings.setIcon(new ImageIcon(".\\src\\resources\\accountsettings_64.png"));
        btnAccountSettings.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnAccountSettings.setForeground(color_title_gray);
        btnAccountSettings.setBackground(Color.white);
        btnAccountSettings.setOpaque(true);
        btnAccountSettings.setFocusable(false);
        btnAccountSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlInsideSystemSettings.add(btnAccountSettings);
        btnAccountSettings.setBounds(51, 177, 1160, 112);
        btnAccountSettings.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnAccountSettings.setIcon(new ImageIcon(".\\src\\resources\\accountsettingscolored_64.png"));
                        btnAccountSettings.setForeground(new Color(4, 197, 178));
                        btnAccountSettings.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(4, 197, 178), 2),
                                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnAccountSettings.setIcon(new ImageIcon(".\\src\\resources\\accountsettings_64.png"));
                        btnAccountSettings.setForeground(color_title_gray);
                        btnAccountSettings.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(color_border_lightgray, 2),
                                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        btnAccountSettings.setIcon(new ImageIcon(".\\src\\resources\\accountsettings_64.png"));
                        btnAccountSettings.setForeground(color_title_gray);
                        btnAccountSettings.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(color_border_lightgray, 2),
                                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
                        btnAccountSettings.setBackground(Color.WHITE);

                        AccountSettingsForm accountSettingsForm = new AccountSettingsForm(DATA);
                        accountSettingsForm.setVisible(true);
                    }
                }
        );

        JLabel btnMenuSettings = new JLabel("  Menu Settings");
        btnMenuSettings.setHorizontalAlignment(SwingConstants.LEFT);
        btnMenuSettings.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_border_lightgray, 2),
                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
        btnMenuSettings.setIcon(new ImageIcon(".\\src\\resources\\menusettings_64.png"));
        btnMenuSettings.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnMenuSettings.setForeground(color_title_gray);
        btnMenuSettings.setBackground(Color.white);
        btnMenuSettings.setOpaque(true);
        btnMenuSettings.setFocusable(false);
        btnMenuSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlInsideSystemSettings.add(btnMenuSettings);
        btnMenuSettings.setBounds(51, 309, 1160, 112);
        btnMenuSettings.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnMenuSettings.setIcon(new ImageIcon(".\\src\\resources\\menusettingscolored_64.png"));
                        btnMenuSettings.setForeground(new Color(4, 197, 178));
                        btnMenuSettings.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(4, 197, 178), 2),
                                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnMenuSettings.setIcon(new ImageIcon(".\\src\\resources\\menusettings_64.png"));
                        btnMenuSettings.setForeground(color_title_gray);
                        btnMenuSettings.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(color_border_lightgray, 2),
                                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        btnMenuSettings.setIcon(new ImageIcon(".\\src\\resources\\menusettings_64.png"));
                        btnMenuSettings.setForeground(color_title_gray);
                        btnMenuSettings.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(color_border_lightgray, 2),
                                BorderFactory.createEmptyBorder(5, 100, 5, 5)));
                        btnMenuSettings.setBackground(Color.WHITE);

                        MenuSettingsForm menuSettingsForm = new MenuSettingsForm(DATA);
                        menuSettingsForm.setVisible(true);
                    }
                }
        );

        JPanel pnlNameAddress = new JPanel();
        pnlNameAddress.setLayout(null);
        pnlNameAddress.setBackground(Color.WHITE);
        pnlNameAddress.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 1));
        pnlInsideSystemSettings.add(pnlNameAddress);
        pnlNameAddress.setBounds(51,441, 1160, 342);

        JLabel lblBusinessName = new JLabel("Business Name");
        lblBusinessName.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblBusinessName.setForeground(color_title_gray);
        pnlNameAddress.add(lblBusinessName);
        lblBusinessName.setBounds(79, 38, 314,53);

        JTextField txtBusinessName = new JTextField("Gastronom");
        txtBusinessName.setFont(new Font("Segoe UI", Font.BOLD, 25));
        txtBusinessName.setForeground(color_title_gray);
        txtBusinessName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_border_lightgray, 2),
                BorderFactory.createEmptyBorder(5, 50, 5, 5)));
        txtBusinessName.setEditable(false);
        pnlNameAddress.add(txtBusinessName);
        txtBusinessName.setBounds(300, 32, 644,64);
//        txtBusinessName.addFocusListener(
//                new FocusAdapter() {
//                    @Override
//                    public void focusGained(FocusEvent e) {
//                        txtBusinessName.setForeground(new Color(4, 197, 178));
//                        txtBusinessName.setBorder(BorderFactory.createCompoundBorder(
//                                BorderFactory.createLineBorder(new Color(4, 197, 178), 2),
//                                BorderFactory.createEmptyBorder(5, 50, 5, 5)));
//                    }
//
//                    @Override
//                    public void focusLost(FocusEvent e) {
//                        txtBusinessName.setForeground(color_title_gray);
//                        txtBusinessName.setBorder(BorderFactory.createCompoundBorder(
//                                BorderFactory.createLineBorder(color_border_lightgray, 2),
//                                BorderFactory.createEmptyBorder(5, 50, 5, 5)));
//
//                    }
//                }
//        );

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblAddress.setForeground(color_title_gray);
        pnlNameAddress.add(lblAddress);
        lblAddress.setBounds(79, 121, 314,53);

        JTextField txtAddress = new JTextField(lblBusinessAddress.getText());
        txtAddress.setFont(new Font("Segoe UI", Font.BOLD, 25));
        txtAddress.setForeground(color_title_gray);
        txtAddress.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color_border_lightgray, 2),
                BorderFactory.createEmptyBorder(5, 50, 5, 5)));
        pnlNameAddress.add(txtAddress);
        txtAddress.setBounds(300, 121, 644,64);
        txtAddress.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        txtAddress.setForeground(new Color(4, 197, 178));
                        txtAddress.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(4, 197, 178), 2),
                                BorderFactory.createEmptyBorder(5, 50, 5, 5)));
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        txtAddress.setForeground(color_title_gray);
                        txtAddress.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(color_border_lightgray, 2),
                                BorderFactory.createEmptyBorder(5, 50, 5, 5)));

                    }
                }
        );

        JButton btnApplyNameAddressChange = new JButton("Apply");
        btnApplyNameAddressChange.setBackground(color_blue);
        btnApplyNameAddressChange.setForeground(Color.WHITE);
        btnApplyNameAddressChange.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnApplyNameAddressChange.setFocusable(false);
        btnApplyNameAddressChange.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnApplyNameAddressChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlNameAddress.add(btnApplyNameAddressChange);
        btnApplyNameAddressChange.setBounds(655, 210, 289,62);
        btnApplyNameAddressChange.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnApplyNameAddressChange.setBackground(new Color(162,187,225));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnApplyNameAddressChange.setBackground(color_blue);
                    }
                }
        );
        btnApplyNameAddressChange.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (txtAddress.getText().isEmpty()){
                            DialogOk dialogOk = new DialogOk("Error", "Address field should not be empty.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        String newAddress = txtAddress.getText().trim();
                        updateAddress(newAddress);
                    }
                }
        );

    }

    public void UpdateDateTime(){

        ScheduledExecutorService e= Executors.newSingleThreadScheduledExecutor();
        e.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // do stuff
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // of course, you could improve this by moving dateformat variable elsewhere
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" MMMM dd, yyyy - hh:mm a");
                        String date = simpleDateFormat.format(new Date());

                        lblDateTime.setText(date);
                    }

                });
            }
        }, 0, 1, TimeUnit.SECONDS);

    }


}

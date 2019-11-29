package views;

import common.ButtonColumn;
import common.Data;
import common.Order;
import common.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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

    // Components
    private JPanel pnlPointOfSale;
    private JPanel pnlDashboard;
    private JPanel pnlTransactionLog;
    private JPanel pnlSystemSettings;

    private Data DATA;
    private String USER_NAME;
    private final JLabel lblUserName;

    private String CALCULATOR_TEXT;

    private static DecimalFormat twoDecimalFormat = new DecimalFormat(".00");
    private static DecimalFormat noDecimalFormat = new DecimalFormat("00");

    private JPanel pnlPOSMenu;
    private JTable tblMenu;
    private DefaultTableModel tblMenuModel;

    private static JTable tblOrderList;
    private static DefaultTableModel tblOrderListModel;

    public static JLabel lblTotalAmount;
    public static JLabel lblDiscountAmount;
    public static JLabel lblBalanceAmount;
    private JTextField txtPayment;
    private JLabel lblChangeAmount;

    public MainForm(){
        this("No Name", new Data());
    }

    public MainForm(String USER_NAME, Data data) {
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);

        this.USER_NAME = USER_NAME;
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

        JLabel lblBusinessAddress = new JLabel("Sample St., Sabang, Baliuag, Bulacan.");
        lblBusinessAddress.setForeground(color_white);
        lblBusinessAddress.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlNavbar.add(lblBusinessAddress);
        lblBusinessAddress.setBounds(300,45,336,28);

        JLabel lblDateTime = new JLabel("  November 15, 2019 - 9:54 AM");
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

        lblUserName.setText(USER_NAME);

        JLabel btnLogout = new JLabel(" Logout");
        btnLogout.setForeground(color_white);
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnLogout.setIcon(new ImageIcon(".\\src\\resources\\logout_32.png"));
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
            }
        });

        JLabel btnSystemSettings = new JLabel(" System Settings");
        btnSystemSettings.setHorizontalAlignment(SwingConstants.LEFT);
        btnSystemSettings.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 5));
        btnSystemSettings.setIcon(new ImageIcon(".\\src\\resources\\settings_32.png"));
        btnSystemSettings.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnSystemSettings.setForeground(color_white);
        btnSystemSettings.setBackground(color_darkgray);
        btnSystemSettings.setOpaque(true);
        btnSystemSettings.setFocusable(false);
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
            }
        });

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

    }

    private void createDashboardGUI(){
        pnlDashboard = new JPanel();
        pnlDashboard.setBackground(Color.WHITE);
        pnlDashboard.setForeground(color_darkgray);
        pnlDashboard.setLayout(null);
        add(pnlDashboard);
        pnlDashboard.setBounds(354, 98, 1566, 977);

        JLabel imgDashboard = new JLabel(new ImageIcon(".\\src\\resources\\dashboardheaderbg.png"));
        pnlDashboard.add(imgDashboard);
        imgDashboard.setBounds(0,0, 1566,200);

        JPanel pnlDivider = new JPanel();
        pnlDivider.setBackground(color_darkergray);
        pnlDashboard.add(pnlDivider);
        pnlDivider.setBounds(0,200, 1566,43);
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

        JButton btnMainMenu = new JButton("Main");
        btnMainMenu.setForeground(color_white);
        btnMainMenu.setBackground(color_darkergray);
        btnMainMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnMainMenu.setFocusable(false);
        btnMainMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlCenter.add(btnMainMenu);
        btnMainMenu.setBounds(112, 104, 206,57);
        btnMainMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Main");
                    }
                }
        );

        JButton btnDessertMenu = new JButton("Dessert");
        btnDessertMenu.setForeground(color_white);
        btnDessertMenu.setBackground(color_darkergray);
        btnDessertMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnDessertMenu.setFocusable(false);
        btnDessertMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlCenter.add(btnDessertMenu);
        btnDessertMenu.setBounds(320, 104, 206,57);
        btnDessertMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Dessert");
                    }
                }
        );

        JButton btnDrinksMenu = new JButton("Drinks");
        btnDrinksMenu.setForeground(color_white);
        btnDrinksMenu.setBackground(color_darkergray);
        btnDrinksMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnDrinksMenu.setFocusable(false);
        btnDrinksMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlCenter.add(btnDrinksMenu);
        btnDrinksMenu.setBounds(529, 104, 206,57);
        btnDrinksMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Drinks");
                    }
                }
        );

        JButton btnOthersMenu = new JButton("Others");
        btnOthersMenu.setForeground(color_white);
        btnOthersMenu.setBackground(color_darkergray);
        btnOthersMenu.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnOthersMenu.setFocusable(false);
        btnOthersMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlCenter.add(btnOthersMenu);
        btnOthersMenu.setBounds(738, 104, 206,57);
        btnOthersMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateMenu(DATA, "Others");
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

        JButton btnReset = new JButton("Reset");
        btnReset.setForeground(Color.WHITE);
        btnReset.setBackground(color_darkgray);
        btnReset.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnReset.setBorder(BorderFactory.createEmptyBorder());
        btnReset.setFocusable(false);
        pnlRight.add(btnReset);
        btnReset.setBounds(406,13,129,35);
        btnReset.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        DialogYesNo dialogYesNo = new DialogYesNo("Confirm", "Are you sure you want to reset?");
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
                }
        );

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
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                }
        );

        JLabel btnDeleteItemFromList = new JLabel();
        btnDeleteItemFromList.setIcon(new ImageIcon(".\\src\\resources\\btnDelete.png"));
        btnDeleteItemFromList.setForeground(Color.white);
        btnDeleteItemFromList.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
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
        btn1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "1";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn2 = new JButton("2");
        btn2.setForeground(color_darkergray);
        btn2.setBackground(Color.WHITE);
        btn2.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn2.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn2.setFocusable(false);
        pnlRight.add(btn2);
        btn2.setBounds(302,618, 84 , 90);
        btn2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "2";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn3 = new JButton("3");
        btn3.setForeground(color_darkergray);
        btn3.setBackground(Color.WHITE);
        btn3.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn3.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn3.setFocusable(false);
        pnlRight.add(btn3);
        btn3.setBounds(385,618, 84 , 90);
        btn3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "3";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn4 = new JButton("4");
        btn4.setForeground(color_darkergray);
        btn4.setBackground(Color.WHITE);
        btn4.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn4.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn4.setFocusable(false);
        pnlRight.add(btn4);
        btn4.setBounds(219,708, 84 , 90);
        btn4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "4";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn5 = new JButton("5");
        btn5.setForeground(color_darkergray);
        btn5.setBackground(Color.WHITE);
        btn5.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn5.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn5.setFocusable(false);
        pnlRight.add(btn5);
        btn5.setBounds(302,708, 84 , 90);
        btn5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "5";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn6 = new JButton("6");
        btn6.setForeground(color_darkergray);
        btn6.setBackground(Color.WHITE);
        btn6.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn6.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn6.setFocusable(false);
        pnlRight.add(btn6);
        btn6.setBounds(385,708, 84 , 90);
        btn6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "6";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn7 = new JButton("7");
        btn7.setForeground(color_darkergray);
        btn7.setBackground(Color.WHITE);
        btn7.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn7.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn7.setFocusable(false);
        pnlRight.add(btn7);
        btn7.setBounds(219,798, 84 , 90);
        btn7.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "7";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn8 = new JButton("8");
        btn8.setForeground(color_darkergray);
        btn8.setBackground(Color.WHITE);
        btn8.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn8.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn8.setFocusable(false);
        pnlRight.add(btn8);
        btn8.setBounds(302,798, 84 , 90);
        btn8.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "8";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn9 = new JButton("9");
        btn9.setForeground(color_darkergray);
        btn9.setBackground(Color.WHITE);
        btn9.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn9.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn9.setFocusable(false);
        pnlRight.add(btn9);
        btn9.setBounds(385,798, 84 , 90);
        btn9.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "9";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btn0 = new JButton("0");
        btn0.setForeground(color_darkergray);
        btn0.setBackground(Color.WHITE);
        btn0.setFont(new Font("Segoe UI", Font.PLAIN, 33));
        btn0.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btn0.setFocusable(false);
        pnlRight.add(btn0);
        btn0.setBounds(302,888, 84 , 90);
        btn0.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += "0";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

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
        btnDot.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CALCULATOR_TEXT += ".";
                        txtPayment.setText(CALCULATOR_TEXT);

                        lblChangeAmount.setText("");

                    }
                }
        );

        JButton btnX = new JButton("X");
        btnX.setForeground(color_darkergray);
        btnX.setBackground(Color.WHITE);
        btnX.setFont(new Font("Segoe UI", Font.BOLD, 33));
        btnX.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnX.setFocusable(false);
        pnlRight.add(btnX);
        btnX.setBounds(468,888, 84 , 90);
        btnX.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (CALCULATOR_TEXT.length() > 0){
                            int length = CALCULATOR_TEXT.length();
                            CALCULATOR_TEXT = CALCULATOR_TEXT.substring(0,(length-1));
                            txtPayment.setText(CALCULATOR_TEXT);

                            lblChangeAmount.setText("");

                        }
                    }
                }
        );

        JButton btnEqualCal = new JButton("=");
        btnEqualCal.setForeground(color_darkergray);
        btnEqualCal.setBackground(Color.WHITE);
        btnEqualCal.setFont(new Font("Segoe UI", Font.BOLD, 33));
        btnEqualCal.setBorder(BorderFactory.createLineBorder(color_border_lightgray, 2));
        btnEqualCal.setFocusable(false);
        pnlRight.add(btnEqualCal);
        btnEqualCal.setBounds(219,888, 84 , 90);
        btnEqualCal.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

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
                }
        );

        // End Calculator

        // End Right Side
    }

    public void generateMenu(Data data, String category){

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
        tblOrderList.setFont(new Font("Segoe UI", Font.PLAIN, 20));
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

    public void clearOrderListSelection(){
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

        JLabel lblTransactionLog = new JLabel("TRANSACTION LOG");
        lblTransactionLog.setFont(new Font("Segoe UI", Font.BOLD, 30));
        pnlTransactionLog.add(lblTransactionLog);
        lblTransactionLog.setBounds(112, 41, 500, 46);

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

                        AccountSettingsForm accountSettingsForm = new AccountSettingsForm(USER_NAME,DATA);
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

                        MenuSettingsForm menuSettingsForm = new MenuSettingsForm(USER_NAME, DATA);
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
        pnlNameAddress.add(txtBusinessName);
        txtBusinessName.setBounds(300, 32, 644,64);
        txtBusinessName.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        txtBusinessName.setForeground(new Color(4, 197, 178));
                        txtBusinessName.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(4, 197, 178), 2),
                                BorderFactory.createEmptyBorder(5, 50, 5, 5)));
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        txtBusinessName.setForeground(color_title_gray);
                        txtBusinessName.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(color_border_lightgray, 2),
                                BorderFactory.createEmptyBorder(5, 50, 5, 5)));

                    }
                }
        );

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblAddress.setForeground(color_title_gray);
        pnlNameAddress.add(lblAddress);
        lblAddress.setBounds(79, 121, 314,53);

        JTextField txtAddress = new JTextField("Sample St., Sabang, Baliuag, Bulacan");
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
    }


    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }
}

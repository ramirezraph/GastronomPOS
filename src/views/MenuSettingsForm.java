package views;

import common.Data;
import common.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class MenuSettingsForm extends JDialog {

    private final Color color_darkgray = new Color(43,43,43);
    private final Font fontX = new Font("Segoe UI", Font.PLAIN, 30);

    private final Color color_border_lightgray = new Color(200,200,200);
    private final Color color_whitesmoke = new Color(238,238,238);
    private final Color color_jungle = new Color(72,151,164);

    private final JTextField txtProductPrice;
    private final JTextField txtProductName;
    private final JComboBox cmbProductCategory;
    private final JButton btnSelectImage;
    private final JButton btnCancelCreate;
    private final JButton btnCreate;
    private final JButton btnUpdate;
    private final JButton btnCancelUpdate;
    private final JLabel imgHolder;
    private final JLabel lblProductCode;


    private String category[] = {"- select category -", "Main", "Dessert", "Drinks", "Others"};
    private final JComboBox cmbFilterProductCategory;

    private String status[] = {"- select status -", "Available", "Not Available"};
    private final JComboBox cmbProductAvailability;

    private JTable tblProducts;
    private DefaultTableModel tblProductModel;

    private final DecimalFormat twoDecimalFormat = new DecimalFormat(".00");

    private File imageFile = null;

    public MenuSettingsForm(Data data){

        setSize(1500, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setModal(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(color_darkgray));

        JPanel pnlTop = new JPanel();
        pnlTop.setBackground(color_darkgray);
        pnlTop.setLayout(null);
        add(pnlTop);
        pnlTop.setBounds(0,0,1500,104);

        JLabel lblFormTitle = new JLabel("  Menu Settings");
        lblFormTitle.setIcon(new ImageIcon(".\\src\\resources\\menusettingscolored_64.png"));
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

        JButton btnCreateNewProduct = new JButton("Create New Product");
        btnCreateNewProduct.setBackground(color_jungle);
        btnCreateNewProduct.setFocusable(false);
        btnCreateNewProduct.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnCreateNewProduct.setForeground(Color.WHITE);
        btnCreateNewProduct.setIconTextGap(10);
        btnCreateNewProduct.setBorder(BorderFactory.createEmptyBorder(10,43,10,10));
        btnCreateNewProduct.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\add_128.png").getImage()
                .getScaledInstance(32, 32,Image.SCALE_DEFAULT)));
        btnCreateNewProduct.setHorizontalAlignment(SwingConstants.LEFT);
        pnlMain.add(btnCreateNewProduct);
        btnCreateNewProduct.setBounds(47,42,534,58);
        btnCreateNewProduct.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnCreateNewProduct.setBackground(new Color(79,174,190));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnCreateNewProduct.setBackground(color_jungle);
                    }
                }
        );
        btnCreateNewProduct.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        clearTableSelection();

                        txtProductName.setText("");
                        txtProductName.setEditable(true);

                        cmbProductCategory.setSelectedIndex(0);
                        cmbProductCategory.setEnabled(true);

                        txtProductPrice.setText("");
                        txtProductPrice.setEditable(true);

                        cmbProductAvailability.setSelectedIndex(0);
                        cmbProductAvailability.setEnabled(true);

                        imgHolder.setIcon(null);
                        btnSelectImage.setEnabled(true);

                        btnCreate.setEnabled(true);
                        btnCreate.setVisible(true);

                        btnCancelCreate.setEnabled(true);
                        btnCancelCreate.setVisible(true);

                        lblProductCode.setText("");
                    }
                }
        );

        JButton btnEditProduct = new JButton("Edit Product");
        btnEditProduct.setBackground(new Color(225,176,20));
        btnEditProduct.setFocusable(false);
        btnEditProduct.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnEditProduct.setForeground(Color.WHITE);
        btnEditProduct.setIconTextGap(10);
        btnEditProduct.setBorder(BorderFactory.createEmptyBorder(10,43,10,10));
        btnEditProduct.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\edit_128.png").getImage()
                .getScaledInstance(32, 32,Image.SCALE_DEFAULT)));
        btnEditProduct.setHorizontalAlignment(SwingConstants.LEFT);
        pnlMain.add(btnEditProduct);
        btnEditProduct.setBounds(47,113,298,58);
        btnEditProduct.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnEditProduct.setBackground(new Color(241,195,51));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnEditProduct.setBackground(new Color(225,176,20));
                    }
                }
        );
        btnEditProduct.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedRowIndex = tblProducts.getSelectedRow();

                        if (selectedRowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Edit Error", "Please select a product.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        txtProductName.setEditable(true);
                        cmbProductCategory.setEnabled(true);
                        txtProductPrice.setEditable(true);
                        cmbProductAvailability.setEnabled(true);
                        btnSelectImage.setEnabled(true);

                        btnUpdate.setEnabled(true);
                        btnUpdate.setVisible(true);

                        btnCancelUpdate.setEnabled(true);
                        btnCancelUpdate.setVisible(true);

                    }
                }
        );

        JButton btnDelete = new JButton("Remove");
        btnDelete.setBackground(new Color(228,52,52));
        btnDelete.setFocusable(false);
        btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setIconTextGap(10);
        btnDelete.setBorder(BorderFactory.createEmptyBorder(10,43,10,10));
        btnDelete.setIcon(new ImageIcon(new ImageIcon(".\\src\\resources\\bin_128.png").getImage()
                .getScaledInstance(32, 32,Image.SCALE_DEFAULT)));
        btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
        pnlMain.add(btnDelete);
        btnDelete.setBounds(360,113,218,58);
        btnDelete.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDelete.setBackground(new Color(255,58,58));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDelete.setBackground(new Color(228,52,52));
                    }
                }
        );
        btnDelete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedRowIndex = tblProducts.getSelectedRow();

                        if (selectedRowIndex < 0){
                            DialogOk dialogOk = new DialogOk("Delete Error", "Please select a product.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        DialogAdminConfirm dialogAdminConfirm = new DialogAdminConfirm(data);
                        dialogAdminConfirm.setVisible(true);

                        if (dialogAdminConfirm.isAccountValid()){
                            data.deleteProduct(lblProductCode.getText());
                            createProductTable(data, 1);

                            MainForm.refreshStatsData(data);

                            txtProductName.setText("");
                            txtProductPrice.setText("");
                            cmbProductCategory.setSelectedIndex(0);
                            cmbProductAvailability.setSelectedIndex(0);
                            imgHolder.setIcon(null);
                        }

                    }
                }
        );

        JPanel pnlProductEditor = new JPanel();
        pnlProductEditor.setBackground(color_whitesmoke);
        pnlProductEditor.setLayout(null);
        pnlProductEditor.setBorder(BorderFactory.createLineBorder(color_border_lightgray,1));
        pnlMain.add(pnlProductEditor);
        pnlProductEditor.setBounds(47,190, 534, 470);

        JPanel pnlTopProductEditor = new JPanel();
        pnlTopProductEditor.setBackground(color_darkgray);
        pnlTopProductEditor.setLayout(null);
        pnlProductEditor.add(pnlTopProductEditor);
        pnlTopProductEditor.setBounds(0,0, 534, 49);

        JLabel lblProductEditor = new JLabel("Product Editor");
        lblProductEditor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblProductEditor.setForeground(color_whitesmoke);
        pnlTopProductEditor.add(lblProductEditor);
        lblProductEditor.setBounds(30,11,127,27);

        lblProductCode = new JLabel("asddf");
        lblProductCode.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblProductCode.setForeground(color_whitesmoke);
        lblProductCode.setVisible(false);
        pnlTopProductEditor.add(lblProductCode);
        lblProductCode.setBounds(450,11,127,27);

        imgHolder = new JLabel();
        imgHolder.setBackground(Color.WHITE);
        imgHolder.setBorder(BorderFactory.createLineBorder(color_darkgray, 1));
        pnlProductEditor.add(imgHolder);
        imgHolder.setBounds(32,73,100,100);

        btnSelectImage = new JButton("Select File");
        btnSelectImage.setBackground(Color.WHITE);
        btnSelectImage.setFocusable(false);
        btnSelectImage.setEnabled(false);
        btnSelectImage.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        pnlProductEditor.add(btnSelectImage);
        btnSelectImage.setBounds(32,189,100,30);
        btnSelectImage.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser(".\\src\\resources\\products");
                        int res = fileChooser.showOpenDialog(null);
                        try {
                            if (res == JFileChooser.APPROVE_OPTION){
                                File file = fileChooser.getSelectedFile();
                                imageFile = fileChooser.getSelectedFile();
                                // resizing image
                                BufferedImage image = null;
                                try {
                                    image = ImageIO.read(file);
                                    Image dimg = image.getScaledInstance(imgHolder.getWidth(), imgHolder.getHeight(),
                                            Image.SCALE_SMOOTH);
                                    imgHolder.setIcon(new ImageIcon(dimg));
                                } catch (IOException ex){
                                    ex.printStackTrace();
                                }
                            }
                        } catch (Exception ex){
                            System.out.println(ex);
                        }
                    }
                }
        );

        JLabel lblPictureSize = new JLabel("(100x100)");
        lblPictureSize.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlProductEditor.add(lblPictureSize);
        lblPictureSize.setBounds(46,224,73,22);

        JLabel lblProductName = new JLabel("Product Name:");
        lblProductName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblProductName.setForeground(color_darkgray);
        pnlProductEditor.add(lblProductName);
        lblProductName.setBounds(151, 73, 132,27);

        txtProductName = new JTextField();
        txtProductName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtProductName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtProductName.setForeground(color_darkgray);
        txtProductName.setBackground(Color.WHITE);
        txtProductName.setEditable(false);
        pnlProductEditor.add(txtProductName);
        txtProductName.setBounds(151,109,342,44);

        JLabel lblProductCategory = new JLabel("Product Category:");
        lblProductCategory.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblProductCategory.setForeground(color_darkgray);
        pnlProductEditor.add(lblProductCategory);
        lblProductCategory.setBounds(151, 158, 159,27);

        cmbProductCategory = new JComboBox(category);
        cmbProductCategory.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        cmbProductCategory.setForeground(color_darkgray);
        cmbProductCategory.setBackground(Color.WHITE);
        cmbProductCategory.setEditable(false);
        cmbProductCategory.setFocusable(false);
        cmbProductCategory.setEnabled(false);
        ((JLabel)cmbProductCategory.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlProductEditor.add(cmbProductCategory);
        cmbProductCategory.setBounds(151,194,342,44);

        JLabel lblProductPrice = new JLabel("Product Price:");
        lblProductPrice.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblProductPrice.setForeground(color_darkgray);
        pnlProductEditor.add(lblProductPrice);
        lblProductPrice.setBounds(151, 243, 121,27);

        txtProductPrice = new JTextField();
        txtProductPrice.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtProductPrice.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtProductPrice.setForeground(color_darkgray);
        txtProductPrice.setBackground(Color.WHITE);
        txtProductPrice.setEditable(false);
        pnlProductEditor.add(txtProductPrice);
        txtProductPrice.setBounds(151,279,342,44);

        JLabel lblProductAvailability = new JLabel("Product Status:");
        lblProductAvailability.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblProductAvailability.setForeground(color_darkgray);
        pnlProductEditor.add(lblProductAvailability);
        lblProductAvailability.setBounds(151, 328, 159,27);

        cmbProductAvailability = new JComboBox(status);
        cmbProductAvailability.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        cmbProductAvailability.setForeground(color_darkgray);
        cmbProductAvailability.setBackground(Color.WHITE);
        cmbProductAvailability.setEditable(false);
        cmbProductAvailability.setFocusable(false);
        cmbProductAvailability.setEnabled(false);
        ((JLabel)cmbProductAvailability.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlProductEditor.add(cmbProductAvailability);
        cmbProductAvailability.setBounds(151,364,342,44);

        btnCreate = new JButton("Create");
        btnCreate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setBackground(new Color(58,181,66));
        btnCreate.setBorder(BorderFactory.createEmptyBorder());
        btnCreate.setFocusable(false);
        btnCreate.setEnabled(false);
        btnCreate.setVisible(false);
        pnlProductEditor.add(btnCreate);
        btnCreate.setBounds(151,421,200,39);
        btnCreate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ImageIcon image;

                        if (txtProductName.getText().isEmpty() || txtProductPrice.getText().isEmpty() || cmbProductCategory.getSelectedIndex() == 0
                                || cmbProductAvailability.getSelectedIndex() == 0){
                            DialogOk dialogOk = new DialogOk("Create Error", "Please complete the form.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        if (imgHolder.getIcon() == null){
                            DialogYesNo dialogYesNo = new DialogYesNo("Create Warning", "There is no product image, still " +
                                    "want to continue?");
                            dialogYesNo.setVisible(true);
                            if (!dialogYesNo.getYesNo()){
                                return;
                            } // otherwise continue.
                            image = new ImageIcon(".\\src\\resources\\placeholder_100.jpg");
                        } else {
                            image = new ImageIcon(imageFile.getPath());
                        }

                        try { // check if price is number
                            double price = Double.parseDouble(txtProductPrice.getText());

                            if (price <= 0){
                                throw new NumberFormatException(); // also invalid.
                            }

                        } catch (NumberFormatException ex){
                            DialogOk dialogOk = new DialogOk("Create Error", "Please put a valid price.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        // GENERATE RANDOM STRING CODE
                        int leftLimit = 97; // letter 'a'
                        int rightLimit = 122; // letter 'z'
                        int targetStringLength = 5;
                        Random random = new Random();
                        StringBuilder buffer = new StringBuilder(targetStringLength);
                        for (int i = 0; i < targetStringLength; i++) {
                            int randomLimitedInt = leftLimit + (int)
                                    (random.nextFloat() * (rightLimit - leftLimit + 1));
                            buffer.append((char) randomLimitedInt);
                        }
                        String generatedString = buffer.toString().toUpperCase();
                        // END GENERATE

                        String name = txtProductName.getText();
                        String category = cmbProductCategory.getSelectedItem().toString();
                        double price = Double.parseDouble(txtProductPrice.getText());
                        String status = cmbProductAvailability.getSelectedItem().toString();

                        Product newProduct = new Product(generatedString,name,category,price,status, image);
                        data.addProduct(newProduct);
                        createProductTable(data, 1);

                        MainForm.refreshStatsData(data);

                        // RESET

                        imageFile = null;

                        txtProductName.setText("");
                        cmbProductCategory.setSelectedIndex(0);
                        txtProductPrice.setText("");
                        cmbProductAvailability.setSelectedIndex(0);
                        imgHolder.setIcon(null);

                        txtProductName.setEditable(false);
                        txtProductPrice.setEditable(false);
                        btnSelectImage.setEnabled(false);
                        cmbProductCategory.setEnabled(false);
                        cmbProductAvailability.setEnabled(false);

                        btnCreate.setEnabled(false);
                        btnCreate.setVisible(false);

                        btnCancelCreate.setEnabled(false);
                        btnCancelCreate.setVisible(false);

                        MainForm.generateMenu(data, "Main");
                    }
                }
        );

        btnCancelCreate = new JButton("Cancel");
        btnCancelCreate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnCancelCreate.setForeground(Color.WHITE);
        btnCancelCreate.setBackground(new Color(228,52,52));
        btnCancelCreate.setBorder(BorderFactory.createEmptyBorder());
        btnCancelCreate.setFocusable(false);
        btnCancelCreate.setEnabled(false);
        btnCancelCreate.setVisible(false);
        pnlProductEditor.add(btnCancelCreate);
        btnCancelCreate.setBounds(358,421,135,39);
        btnCancelCreate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtProductName.setText("");
                        txtProductName.setEditable(false);

                        cmbProductCategory.setSelectedIndex(0);
                        cmbProductCategory.setEnabled(false);

                        txtProductPrice.setText("");
                        txtProductPrice.setEditable(false);

                        cmbProductAvailability.setSelectedIndex(0);
                        cmbProductAvailability.setEnabled(false);

                        btnSelectImage.setEnabled(false);
                        imgHolder.setIcon(null);

                        btnCreate.setEnabled(false);
                        btnCreate.setVisible(false);
                        btnCancelCreate.setEnabled(false);
                        btnCancelCreate.setVisible(false);
                    }
                }
        );

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBackground(new Color(58,181,66));
        btnUpdate.setBorder(BorderFactory.createEmptyBorder());
        btnUpdate.setFocusable(false);
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        pnlProductEditor.add(btnUpdate);
        btnUpdate.setBounds(151,421,200,39);
        btnUpdate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ImageIcon image = null;

                        if (txtProductName.getText().isEmpty() || txtProductPrice.getText().isEmpty() || cmbProductCategory.getSelectedIndex() == 0
                                || cmbProductAvailability.getSelectedIndex() == 0){
                            DialogOk dialogOk = new DialogOk("Create Error", "Please complete the form.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        if (imgHolder.getIcon() == null){
                            DialogYesNo dialogYesNo = new DialogYesNo("Create Warning", "There is no product image, still " +
                                    "want to continue?");
                            dialogYesNo.setVisible(true);
                            if (!dialogYesNo.getYesNo()){
                                return;
                            } // otherwise continue.
                            image = new ImageIcon(".\\src\\resources\\placeholder_100.jpg");

                        } else {
                            try {
                                image = new ImageIcon(imageFile.getPath());
                            } catch (NullPointerException ex){ // empty icon
                                for (Product o: data.getProductList()){
                                    if (o.getCode().equals(lblProductCode.getText())){
                                        image = new ImageIcon(o.getImage().toString());
                                        System.out.println(image);
                                    }
                                }
                            }
                        }

                        try { // check if price is number
                            double price = Double.parseDouble(txtProductPrice.getText());

                            if (price <= 0){
                                throw new NumberFormatException(); // also invalid.
                            }

                        } catch (NumberFormatException ex){
                            DialogOk dialogOk = new DialogOk("Create Error", "Please put a valid price.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        // GENERATE RANDOM STRING CODE
                        int leftLimit = 97; // letter 'a'
                        int rightLimit = 122; // letter 'z'
                        int targetStringLength = 5;
                        Random random = new Random();
                        StringBuilder buffer = new StringBuilder(targetStringLength);
                        for (int i = 0; i < targetStringLength; i++) {
                            int randomLimitedInt = leftLimit + (int)
                                    (random.nextFloat() * (rightLimit - leftLimit + 1));
                            buffer.append((char) randomLimitedInt);
                        }
                        String generatedString = buffer.toString().toUpperCase();
                        // END GENERATE

                        String name = txtProductName.getText();
                        String category = cmbProductCategory.getSelectedItem().toString();
                        double price = Double.parseDouble(txtProductPrice.getText());
                        String status = cmbProductAvailability.getSelectedItem().toString();

                        data.editProduct(lblProductCode.getText(), name, category, price, status, image);

                        // RESET

                        createProductTable(data, 1);

                        imageFile = null;

                        lblProductCode.setText("");
                        txtProductName.setText("");
                        cmbProductCategory.setSelectedIndex(0);
                        txtProductPrice.setText("");
                        cmbProductAvailability.setSelectedIndex(0);
                        imgHolder.setIcon(null);

                        btnUpdate.setEnabled(false);
                        btnUpdate.setVisible(false);

                        btnCancelUpdate.setEnabled(false);
                        btnCancelUpdate.setVisible(false);
                    }
                }
        );

        btnCancelUpdate = new JButton("Cancel");
        btnCancelUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnCancelUpdate.setForeground(Color.WHITE);
        btnCancelUpdate.setBackground(new Color(228,52,52));
        btnCancelUpdate.setBorder(BorderFactory.createEmptyBorder());
        btnCancelUpdate.setFocusable(false);
        btnCancelUpdate.setEnabled(false);
        btnCancelUpdate.setVisible(false);
        pnlProductEditor.add(btnCancelUpdate);
        btnCancelUpdate.setBounds(358,421,135,39);
        btnCancelUpdate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtProductName.setText("");
                        txtProductName.setEditable(false);

                        cmbProductCategory.setSelectedIndex(0);
                        cmbProductCategory.setEnabled(false);

                        txtProductPrice.setText("");
                        txtProductPrice.setEditable(false);

                        cmbProductAvailability.setSelectedIndex(0);
                        cmbProductAvailability.setEnabled(false);

                        btnSelectImage.setEnabled(false);
                        imgHolder.setIcon(null);

                        lblProductCode.setText("");

                        btnUpdate.setEnabled(false);
                        btnUpdate.setVisible(false);
                        btnCancelUpdate.setEnabled(false);
                        btnCancelUpdate.setVisible(false);

                        clearTableSelection();
                    }
                }
        );

        JPanel pnlSearchFilter = new JPanel();
        pnlSearchFilter.setBackground(Color.WHITE);
        pnlSearchFilter.setLayout(null);
        pnlSearchFilter.setBorder(BorderFactory.createLineBorder(color_border_lightgray,1));
        pnlMain.add(pnlSearchFilter);
        pnlSearchFilter.setBounds(611, 42, 839,128);

        JLabel lblFilterProductName = new JLabel("Product Name:");
        lblFilterProductName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblFilterProductName.setForeground(color_darkgray);
        pnlSearchFilter.add(lblFilterProductName);
        lblFilterProductName.setBounds(47, 20, 134,27);

        JTextField txtFilterProductName = new JTextField();
        txtFilterProductName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        txtFilterProductName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtFilterProductName.setForeground(color_darkgray);
        txtFilterProductName.setBackground(Color.WHITE);
        txtFilterProductName.setEditable(true);
        pnlSearchFilter.add(txtFilterProductName);
        txtFilterProductName.setBounds(47,57,284,39);

        JLabel lblFilterProductCategory = new JLabel("Category:");
        lblFilterProductCategory.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblFilterProductCategory.setForeground(color_darkgray);
        pnlSearchFilter.add(lblFilterProductCategory);
        lblFilterProductCategory.setBounds(348, 20, 84,27);

        cmbFilterProductCategory = new JComboBox(category);
        cmbFilterProductCategory.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        cmbFilterProductCategory.setForeground(color_darkgray);
        cmbFilterProductCategory.setBackground(Color.WHITE);
        cmbFilterProductCategory.setEditable(false);
        cmbFilterProductCategory.setFocusable(false);
        ((JLabel)cmbFilterProductCategory.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlSearchFilter.add(cmbFilterProductCategory);
        cmbFilterProductCategory.setBounds(348,58,284,39);

        JButton btnApplyFilter = new JButton("Apply Filter");
        btnApplyFilter.setBackground(Color.WHITE);
        btnApplyFilter.setFocusable(false);
        btnApplyFilter.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlSearchFilter.add(btnApplyFilter);
        btnApplyFilter.setBounds(662,19,149,39);
        btnApplyFilter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (txtFilterProductName.getText().isEmpty() && cmbFilterProductCategory.getSelectedIndex() == 0){
                            // Filter Mode: 1
                            createProductTable(data, 1);
                        } else if (!txtFilterProductName.getText().isEmpty() && cmbFilterProductCategory.getSelectedIndex() == 0){
                            // Filter Mode: 2
                            createProductTable(data, 2, txtFilterProductName.getText().toLowerCase());
                        } else if (txtFilterProductName.getText().isEmpty() && cmbFilterProductCategory.getSelectedIndex() > 0){
                            // Filter Mode: 3
                            createProductTable(data, 3, "", cmbFilterProductCategory.getSelectedItem().toString());
                        } else if (!txtFilterProductName.getText().isEmpty() && cmbFilterProductCategory.getSelectedIndex() > 0){
                            // Filter Mode: 4
                            createProductTable(data, 4, txtFilterProductName.getText().toLowerCase(),
                                    cmbFilterProductCategory.getSelectedItem().toString());
                        }
                    }
                }
        );

        JButton btnClearFilter = new JButton("Clear Filter");
        btnClearFilter.setBackground(Color.WHITE);
        btnClearFilter.setFocusable(false);
        btnClearFilter.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlSearchFilter.add(btnClearFilter);
        btnClearFilter.setBounds(662,70,149,39);
        btnClearFilter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtFilterProductName.setText("");
                        cmbFilterProductCategory.setSelectedIndex(0);
                        createProductTable(data, 1);
                    }
                }
        );

        JPanel pnlProductList = new JPanel();
        pnlProductList.setBackground(color_whitesmoke);
        pnlProductList.setLayout(null);
        pnlMain.add(pnlProductList);
        pnlProductList.setBounds(611,190, 839, 470);

        JPanel pnlTopProductList = new JPanel();
        pnlTopProductList.setBackground(color_darkgray);
        pnlTopProductList.setLayout(null);
        pnlProductList.add(pnlTopProductList);
        pnlTopProductList.setBounds(0,0, 839, 49);

        JLabel lblProductList = new JLabel("Product List");
        lblProductList.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblProductList.setForeground(color_whitesmoke);
        pnlTopProductList.add(lblProductList);
        lblProductList.setBounds(368,11,104,27);

        tblProducts = new JTable();

        createProductTable(data, 1);

        JPanel pnlProducts = new JPanel();
        pnlProducts.setLayout(null);
        pnlProductList.add(pnlProducts);
        pnlProducts.setBounds(0, 49, 839, 421);

        JScrollPane spProducts = new JScrollPane(tblProducts);
        pnlProducts.add(spProducts);
        spProducts.setBounds(0,0,839,421);

        tblProducts.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        txtProductName.setEditable(false);
                        cmbProductCategory.setEnabled(false);
                        txtProductPrice.setEditable(false);
                        cmbProductAvailability.setEnabled(false);
                        imgHolder.setIcon(null);
                        btnSelectImage.setEnabled(false);

                        btnCreate.setEnabled(false);
                        btnCreate.setVisible(false);
                        btnCancelCreate.setEnabled(false);
                        btnCancelCreate.setVisible(false);

                        DefaultTableModel tableModel = (DefaultTableModel) tblProducts.getModel();
                        int selectedRowIndex = tblProducts.getSelectedRow();
                        txtProductName.setText(tableModel.getValueAt(selectedRowIndex, 0).toString());
                        cmbProductCategory.setSelectedItem(tableModel.getValueAt(selectedRowIndex, 1).toString());
                        txtProductPrice.setText(tableModel.getValueAt(selectedRowIndex, 2).toString().substring(1));
                        cmbProductAvailability.setSelectedItem((tableModel.getValueAt(selectedRowIndex, 3).toString()));

                        // resizing image
                        BufferedImage image = null;
                        try {
                            File file = new File(tableModel.getValueAt(selectedRowIndex, 4).toString());
                            image = ImageIO.read(file);
                            Image dimg = image.getScaledInstance(imgHolder.getWidth(), imgHolder.getHeight(),
                                    Image.SCALE_SMOOTH);
                            imgHolder.setIcon(new ImageIcon(dimg));
                        } catch (IOException ex){
                            ex.printStackTrace();
                        }

                        lblProductCode.setText(tableModel.getValueAt(selectedRowIndex, 5).toString());

                    }
                }
        );

    }

    public void createProductTable(Data data, int filterMode){
        createProductTable(data,filterMode, "");
    }

    public void createProductTable(Data data, int filterMode, String name){
        createProductTable(data,filterMode,name, "");
    }

    public void createProductTable(Data data, int filterMode, String name, String category){
        String[] colsProducts = {"Name", "Category", "Price", "Status", "Image", "Code"};
        tblProductModel = new DefaultTableModel(colsProducts, 0);
        for (int i = data.getProductList().size() - 1; i >= 0; i--){
            switch (filterMode){
                case 1: { // No Filter
                    Object[] newRow = {data.getProductList().get(i).getName(), data.getProductList().get(i).getCategory(), "₱"+twoDecimalFormat.format(data.getProductList().get(i).getPrice()),
                            data.getProductList().get(i).getAvailability(), data.getProductList().get(i).getImage(), data.getProductList().get(i).getCode()};
                    tblProductModel.addRow(newRow);
                    break;
                }
                case 2: { // Filter Name Only
                    if (data.getProductList().get(i).getName().toLowerCase().contains(name)){
                        Object[] newRow = {data.getProductList().get(i).getName(), data.getProductList().get(i).getCategory(), "₱"+twoDecimalFormat.format(data.getProductList().get(i).getPrice()),
                                data.getProductList().get(i).getAvailability(), data.getProductList().get(i).getImage(), data.getProductList().get(i).getCode()};
                        tblProductModel.addRow(newRow);
                    }
                    break;
                }
                case 3:{ // Filter Category Only
                    if (data.getProductList().get(i).getCategory().equals(category)){
                        Object[] newRow = {data.getProductList().get(i).getName(), data.getProductList().get(i).getCategory(), "₱"+twoDecimalFormat.format(data.getProductList().get(i).getPrice()),
                                data.getProductList().get(i).getAvailability(), data.getProductList().get(i).getImage(), data.getProductList().get(i).getCode()};
                        tblProductModel.addRow(newRow);
                    }
                    break;
                }
                case 4: { // Filter Both
                    if (data.getProductList().get(i).getName().toLowerCase().contains(name) && data.getProductList().get(i).getCategory().equals(category)){
                        Object[] newRow = {data.getProductList().get(i).getName(), data.getProductList().get(i).getCategory(), "₱"+twoDecimalFormat.format(data.getProductList().get(i).getPrice()),
                                data.getProductList().get(i).getAvailability(), data.getProductList().get(i).getImage(), data.getProductList().get(i).getCode()};
                        tblProductModel.addRow(newRow);
                    }
                }
            }
        }

        tblProducts.setModel(tblProductModel);
        tblProducts.setGridColor(color_border_lightgray);
        tblProducts.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        tblProducts.setRowHeight(40);
        tblProducts.setDefaultEditor(Object.class, null); // editable = false
        tblProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProducts.setFocusable(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblProducts.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblProducts.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblProducts.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblProducts.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        // Hides Column Image
        TableColumnModel tableColumnModel = tblProducts.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(4)); // hides image
        tableColumnModel.removeColumn(tableColumnModel.getColumn(4)); // hides code
    }

    public void clearTableSelection(){
        tblProducts.getSelectionModel().clearSelection();
        tblProducts.getColumnModel().getSelectionModel().clearSelection();
    }
}

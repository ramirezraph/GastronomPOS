package common;

import views.DialogOk;
import views.DialogYesNo;
import views.MainForm;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Data {

    private DecimalFormat twoDecimalFormat = new DecimalFormat(".00");

    private ArrayList<Account> accounts;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Sales> sales;
    private ArrayList<TransactionLog> transactionlog;

    private ArrayList<LoginAttempt> lockedAccounts;


    public Data() {

        // Accounts
        accounts = new ArrayList<>();
        accounts.add(new Account("Administrator", "Administrator", "admin", "123",
                "09452587170", "12/01/2019"));
        accounts.add(new Account("Raphael Ramirez", "Staff", "ramirez", "raph", "09454087172", "12/01/2019"));
        accounts.add(new Account("Arvin Vibal", "Staff", "arvin", "vibal", "09278532212", "12/01/2019"));
        accounts.add(new Account("John Doe", "Staff", "john", "doe", "09232552280", "12/02/2019"));
        accounts.add(new Account("Harry Potter", "Staff", "harry", "potter123", "09357867798", "12/02/2019"));
        accounts.add(new Account("James Carter", "Staff", "james123", "yoyo112", "09676678721", "12/02/2019"));
        accounts.add(new Account("Harold Sta. Maria", "Staff", "harold443", "bartolay", "09876782258", "12/02/2019"));
        accounts.add(new Account("Bill Gates", "Staff", "bill", "gates", "09787767871", "12/01/2019"));

        // Locked Accounts
        lockedAccounts = new ArrayList<>();

        // Products
        products = new ArrayList<>();

        // MAIN
        products.add(new Product("HGWER","Hawaiian Breakfast", "Main", 67.50, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\hawaiianbreakfast.png")));
        products.add(new Product("KLKMG","Bacon and Egg Breakfast", "Main", 50.99, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\baconandeggbreakfast.png")));
        products.add(new Product("LKPIH","Ham and Cheese Breakfast", "Main", 50.99, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\hamandcheesebreakfast.png")));
        products.add(new Product("ASGDF","Pork Schnitzel", "Main", 99, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\porkschnitzel.png")));
        products.add(new Product("KSDWS","Trout Amandine", "Main", 100, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\troutamandine.png")));
        products.add(new Product("UFGDF","Seared Diver Scallop", "Main", 140, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\seareddiverscallops.png")));
        products.add(new Product("KDGDF","Steak Frites", "Main", 130, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\steakfrites.png")));
        products.add(new Product("PYUGH","Roasted Duck Breast", "Main", 119, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\roastedduckbreast.png")));
        products.add(new Product("QWEGD","Roasted Beef Breast", "Main", 119, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\roastedbeefbreast.png")));
        products.add(new Product("JFASD","Beef Stew Dinner", "Main", 80, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\beefstewdinner.png")));

        // DESSERT
        products.add(new Product("OIUJK","Mocha Mud Pie", "Dessert", 50.50, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\mochamudpie.png")));
        products.add(new Product("UIPJM","Chocolate Caramel Crunch Cake", "Dessert", 50.50, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\chocolatecrunchcake.jpg")));
        products.add(new Product("DKJUO","Rockslide Brownie Bars", "Dessert", 53.50, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\rockslidebrownie.png")));
        products.add(new Product("YSDHF","Praline Cheesecake", "Dessert", 55.50, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\pralinecheesecake.png")));
        products.add(new Product("QJGDF","Warm Apple Crisp", "Dessert", 65.50, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\warmapplecrisp.png")));

        // DRINKS
        products.add(new Product("IOSVG","Cosmopolitan", "Drinks", 80.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\cosmopolitan.png")));
        products.add(new Product("AWNSD","Mai Tai", "Drinks", 80.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\maitai.png")));
        products.add(new Product("TYZVN","Champagne", "Drinks", 80.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\champagne.png")));
        products.add(new Product("UISCN","Gin Tonic", "Drinks", 80.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\gintonic.png")));
        products.add(new Product("XMFGG","Blue Lagoon", "Drinks", 80.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\bluelagoon.png")));

        // OTHERS
        products.add(new Product("LKIMJ","Fries", "Others", 50.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\fries.png")));
        products.add(new Product("XGVSD","Greek Salad", "Others", 80.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\greeksalad.png")));
        products.add(new Product("JDFRF","Meaty Spaghetti", "Others", 60.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\meatyspaghetti.png")));
        products.add(new Product("YSFGF","Madfish House Salad", "Others", 60.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\madfishhousesalad.png")));
        products.add(new Product("UYRGH","Fried Calamari", "Others", 45.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\friedcalamari.png")));
        products.add(new Product("QDPKF","Garlic Bread", "Others", 45.00, "Available"
                , new ImageIcon(".\\src\\resources\\menu\\garlicbread.png")));

        // Orders
        orders = new ArrayList<>();
//        orders.add(new Order("asd", "Mushroom Cake", 120.00, 2, 240.00));

        // Products
        sales = new ArrayList<>();
        sales.add(new Sales("KSDWS","Trout Amandine", 120, 23));
        sales.add(new Sales("UFGDF","Seared Diver Scallop", 139, 17));
        sales.add(new Sales("KDGDF","Steak Frites", 130, 20));
        sales.add(new Sales("QWEGD","Roasted Duck Breast", 150, 23));

        // Logs
        transactionlog = new ArrayList<>();
//        transactionlog.add(new TransactionLog("12120191", "12", "1", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50", 600, 97.50));
//        transactionlog.add(new TransactionLog("12120192", "11", "27", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50", 600, 97.50));
//        transactionlog.add(new TransactionLog("12120193", "11", "28", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50", 600, 97.50));
//        transactionlog.add(new TransactionLog("12120194", "10", "5", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50", 600, 97.50));
    }

    public ArrayList<LoginAttempt> getAccountLockList(){
        return lockedAccounts;
    }

    public void registerAccount(String username){
        for (Account o: accounts){
            if (o.getUsername().equals(username)){

                if (o.getLevel().equals("Administrator")){
                    return;
                }

                for (LoginAttempt a: lockedAccounts){
                    if (a.getUsername().equals(username)){
                        // already exists
                        int numberOfAttemps = a.getNumberOfAttempt();
                        numberOfAttemps++;
                        a.setNumberOfAttempt(numberOfAttemps);

                        if (numberOfAttemps >= 3){
                            a.setStatus("Locked");
                            DialogOk dialogOk = new DialogOk("Account", "The account has been locked. Please refer to the admin.");
                            dialogOk.setVisible(true);
                            return;
                        }

                        return;
                    }
                }
                // create new
                lockedAccounts.add(new LoginAttempt(username));
                return;
            }
        }

        // account does not exists. ignore
    }

    public void removeFromLockedAccountList(String username){
        lockedAccounts.removeIf(new Predicate<LoginAttempt>() {
            @Override
            public boolean test(LoginAttempt loginAttempt) {
                return loginAttempt.getUsername().equals(username);
            }
        });
    }

    public void FindBestSelling(){

        String firstPlace = "";
        String secondPlace = "";
        String thirdPlace = "";

        double first = 0;
        for (Sales o: sales){
            if (o.getNumberOfOrder() >= first){
                first = o.getNumberOfOrder();
                firstPlace = o.getName();
            }
        }
        double second = 0;
        for (Sales o: sales){
            if (!o.getName().equals(firstPlace)){
                if (o.getNumberOfOrder() >= second){
                    second = o.getNumberOfOrder();
                    secondPlace = o.getName();
                }
            }
        }

        double third = 0;
        for (Sales o: sales){
            if (!o.getName().equals(firstPlace) && !o.getName().equals(secondPlace)){
                if (o.getNumberOfOrder() >= third){
                    third = o.getNumberOfOrder();
                    thirdPlace = o.getName();
                }
            }
        }

        for (Product o: products){
            if (o.getName().equals(firstPlace)){
                MainForm.imgProduct1stPlace.setIcon(new ImageIcon(new ImageIcon(o.getImage().toString()).getImage()
                        .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                MainForm.lblProductName1stPlace.setText(o.getName());
            } else if (o.getName().equals(secondPlace)){
                MainForm.imgProduct2ndPlace.setIcon(new ImageIcon(new ImageIcon(o.getImage().toString()).getImage()
                        .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                MainForm.lblProductName2ndPlace.setText(o.getName());
            } else if (o.getName().equals(thirdPlace)){
                MainForm.imgProduct3rdPlace.setIcon(new ImageIcon(new ImageIcon(o.getImage().toString()).getImage()
                        .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                MainForm.lblProductName3rdPlace.setText(o.getName());
            }
        }

    }

    // TRANSACTION LOG

    public ArrayList<TransactionLog> getTransactionLog(){
        return transactionlog;
    }

    public void saveTransaction(TransactionLog transactionLog){
        transactionlog.add(transactionLog);
    }

    public void deleteAllTransaction(){
        try {
//            for (TransactionLog log: transactionlog){
//                transactionlog.remove(log);
//            }

            transactionlog = new ArrayList<>();

            DialogOk dialogOk = new DialogOk("Success", "Transaction log has been reset successfully.");
            dialogOk.setVisible(true);

        } catch (Exception ex){

        }
    }


    // SALES

    public ArrayList<Sales> getSalesList(){
        return sales;
    }

    public void resetSalesList(){
        sales = new ArrayList<>();

        DialogOk dialogOk = new DialogOk("Reset Success", "Sales data has been reset.");
        dialogOk.setVisible(true);

    }

    public double getItemSalesPercentage(double itemQuantity){
        double totalQuantity = 0;
        for (Sales o: sales){
            totalQuantity += o.getNumberOfOrder();
        }
        return (itemQuantity / totalQuantity) * 100;
    }

    public double getTotalRevenue(){
        double total = 0;
        for (TransactionLog o: transactionlog){
            total += o.getTotal();
        }
        return total;
    }
    public double getTotalEarningsBySales(){
        double total = 0;
        for (Sales o: sales){
            total += o.getTotalEarnings();
        }
        return total;
    }


    public void addToSales(Sales sale){
        for (Sales o: sales){
            if (o.getCode().equals(sale.getCode())){
                // item already exists

                double price = o.getPrice();
                double qty = o.getNumberOfOrder() + sale.getNumberOfOrder();
                double totalearning = price * qty;

                o.setNumberOfOrder(qty);
                o.setTotalEarnings(totalearning);
                return;
            }
        }
        sales.add(sale);
    }

    // ORDERS

    public ArrayList<Order> getOrderList(){
        return orders;
    }

    public void addOrder(Order order){
        try {
            for (Order o: orders){
                if (order.getCode().equals(o.getCode())){
                    // item already exists
                    addQuantity(order, o.getQuantity());
                    return;
                }
            }
            orders.add(order);
            MainForm.lblDiscountAmount.setText("₱00.00");
            getBalance();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void addQuantity(Order order, int oldQty){
        int quantity = order.getQuantity();
        quantity += oldQty;
        double total = order.getEachPrice() * quantity;

        Order newOrder = new Order(order.getCode(), order.getName(), order.getEachPrice(), quantity, total);
        deleteOrder(order.getCode());
        addOrder(newOrder);

    }

    public void deleteOrder(String codeToDelete){
        try {
            for (Order o: orders){

                if (codeToDelete.equals(o.getCode())){
                    orders.remove(o);
                    MainForm.lblDiscountAmount.setText("₱00.00");
                    getBalance();
                    return;
                }
            }
            DialogOk dialogOk = new DialogOk("Remove Failed", "Order does not exist.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void getBalance(){
        // Update Total Amount
        double total = getOrderTotal();
        if (total == 0){
            MainForm.lblTotalAmount.setText("₱00.00");

        } else {
            MainForm.lblTotalAmount.setText("₱" + twoDecimalFormat.format(total));
        }
        // Update Balance
        double discount = Double.parseDouble(MainForm.lblDiscountAmount.getText().substring(1));
        double balance = total - discount;

        if (balance == 0){
            MainForm.lblBalanceAmount.setText("₱00.00");
        } else {
            MainForm.lblBalanceAmount.setText("₱" + twoDecimalFormat.format(balance));
        }

        MainForm.lblChangeAmount.setText("");
    }

    public double getOrderTotal(){
        double total = 0.00;
        for (Order o: orders){
            total += o.getTotal();
        }
        return total;
    }

    // ACCOUNTS

    public ArrayList<Account> getAccountList(){
        return accounts;
    }

    public int getAccountSize(){
        int listCount = 0;
        for (Account o: accounts){
            listCount++;
        }
        return listCount;
    }

    public void addAccount(Account account){
        try {
            for (Account o: accounts){
                if (account.getUsername().equals(o.getUsername())){
                    DialogOk dialogOk = new DialogOk("Register Failed", "Username already exists.");
                    dialogOk.setVisible(true);
                    return;
                }
            }
            accounts.add(account);

            DialogOk dialogOk = new DialogOk("Success", "Account has been created successfully.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteAccount(String usernameToDelete){
        try {
            for (Account o: accounts){

                if (usernameToDelete.equals(o.getUsername())){

                    if (o.getLevel().equals("Administrator")){
                        DialogOk dialogOk = new DialogOk("Delete Failed", "Administrator account cannot be deleted.");
                        dialogOk.setVisible(true);
                        return;
                    }

                    DialogYesNo dialogYesNo = new DialogYesNo("Confirm", "Are you sure you want to delete this " +
                            "account?");
                    dialogYesNo.setVisible(true);

                    if (dialogYesNo.getYesNo()){
                        accounts.remove(o);

                        DialogOk dialogOk = new DialogOk("Delete Success", "Account deleted successfully.");
                        dialogOk.setVisible(true);
                    }
                    return;
                }
            }
            DialogOk dialogOk = new DialogOk("Delete Failed", "Account does not exist.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void resetPassword(String usernameToReset){
        try {
            for (Account o: accounts){
                if (usernameToReset.equals(o.getUsername())){

                    DialogYesNo dialogYesNo = new DialogYesNo("Confirm", "Are you sure you want to reset the password" +
                            " of this account?");
                    dialogYesNo.setVisible(true);

                    if (dialogYesNo.getYesNo()){
                        o.resetPassword();
                        DialogOk dialogOk = new DialogOk("Success", "Password of " + o.getName() + " has been" +
                                " reset.");
                        dialogOk.setVisible(true);

                    }
                    return;
                }
            }
            DialogOk dialogOk = new DialogOk("Delete Failed", "Account does not exist.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void editAccountInfo(String usernameToEdit, String name, String contactNo){
        try {
            for (Account o: accounts){
                if (usernameToEdit.equals(o.getUsername())){
                    o.editInformation(name, contactNo);
                    DialogOk dialogOk = new DialogOk("Success", "Account has been edited successfully.");
                    dialogOk.setVisible(true);
                    return;
                }
            }
            DialogOk dialogOk = new DialogOk("Edit Failed", "Account does not exist.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean isAccountValid(String typedUsername, String typedPassword){
        for (Account acc: accounts){
            if (acc.getUsername().equals(typedUsername) && acc.getPassword().equals(typedPassword)){
                return true;
            }
        }
        return false;
    }

    public Account getAccount(String typedUsername){
        for (Account acc: accounts){
            if (acc.getUsername().equals(typedUsername)){
                return acc;
            }
        }
        return null;
    }


    // PRODUCTS

    public ArrayList<Product> getProductList(){
        return products;
    }

    public void addProduct(Product product){
        try {
            for (Product o: products){
                if (product.getCode().equals(o.getCode())){
                    DialogOk dialogOk = new DialogOk("Add Product Failed", "Generated product code duplicate, please try again.");
                    dialogOk.setVisible(true);
                    return;
                }
                if (product.getName().equals(o.getName())){
                    DialogOk dialogOk = new DialogOk("Add Product Failed", "Product already exists.");
                    dialogOk.setVisible(true);
                    return;
                } else if (product.getCode().equals(o.getCode())){
                    DialogOk dialogOk = new DialogOk("Error", "An error occured. Please try again.");
                    dialogOk.setVisible(true);
                    return;
                }
            }
            products.add(product);
            DialogOk dialogOk = new DialogOk("Success", "Product has been created successfully.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteProduct(String codedToDelete){
        try {
            for (Product o: products){
                if (codedToDelete.equals(o.getCode())){

                    DialogYesNo dialogYesNo = new DialogYesNo("Confirm", "Are you sure you want to delete this " +
                            "product?");
                    dialogYesNo.setVisible(true);

                    if (dialogYesNo.getYesNo()){
                        products.remove(o);
                    }
                    return;
                }
            }
            DialogOk dialogOk = new DialogOk("Delete Failed", "Product does not exist.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void editProduct(String codeToEdit, String name, String category, double price, String availability,
                            ImageIcon image){
        try {
            for (Product o: products){
                if (codeToEdit.equals(o.getCode())){
                    o.editInformation(name,category,price,availability,image);
                    DialogOk dialogOk = new DialogOk("Success", "Product has been updated successfully.");
                    dialogOk.setVisible(true);
                    return;
                }
            }
            DialogOk dialogOk = new DialogOk("Edit Failed", "Product does not exist.");
            dialogOk.setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }


}

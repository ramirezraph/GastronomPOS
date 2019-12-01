package common;

import views.DialogOk;
import views.DialogYesNo;
import views.MainForm;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Data {

    private DecimalFormat twoDecimalFormat = new DecimalFormat(".00");

    private ArrayList<Account> accounts;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Sales> sales;
    private ArrayList<Log> transactionlog;


    public Data() {

        // Accounts
        accounts = new ArrayList<>();
        Account adminAccount = new Account("Administrator", "Administrator", "admin", "123", "09454087170", "Sample");
        accounts.add(adminAccount);
        Account myAccount = new Account("Raph Ramirez", "Staff", "ramirez", "111", "09454087170", "Sample");
        accounts.add(myAccount);

        // Products
        products = new ArrayList<>();
        products.add(new Product("ASGDF","Pork Schnitzel", "Main", 150, "Available"));
        products.add(new Product("KSDWS","Trout Amandine", "Main", 120, "Available"));
        products.add(new Product("UFGDF","Seared Diver Scallop", "Main", 139, "Available"));
        products.add(new Product("KDGDF","Steak Frites", "Main", 130, "Available"));
        products.add(new Product("PYUGH","Roasted Duck Breast", "Main", 150, "Available"));
        products.add(new Product("QWEGD","Roasted Beef Breast", "Others", 150, "Available"));

        // Orders
        orders = new ArrayList<>();
//        orders.add(new Order("asd", "Mushroom Cake", 120.00, 2, 240.00));

        // Products
        sales = new ArrayList<>();
//        sales.add(new Sales("ASD","Burger", 50.32, 50));

        // Logs
        transactionlog = new ArrayList<>();
//        transactionlog.add(new Log("12120191", "12", "1", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50 - 2%", 600, 97.50));
//        transactionlog.add(new Log("12120192", "11", "27", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50 - 2%", 600, 97.50));
//        transactionlog.add(new Log("12120193", "11", "28", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50 - 2%", 600, 97.50));
//        transactionlog.add(new Log("12120194", "10", "5", "2019",
//                "2:07 PM", "Administrator", "Burger 2x Squid 1x Pineapply 1x", 532.50,
//                "30.50 - 2%", 600, 97.50));
    }

    // TRANSACTION LOG

    public ArrayList<Log> getTransactionLog(){
        return transactionlog;
    }

    public void saveTransaction(Log log){
        transactionlog.add(log);
    }

    public void deleteAllTransaction(){
        try {
//            for (Log log: transactionlog){
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

    public double getTotalEarnings(){
        double total = 0;
        for (Log o: transactionlog){
            total += o.getTotal();
        }
        return total;
    }

    public void addToSales(Sales sale){
        for (Sales o: sales){
            if (o.getCode().equals(sale.getCode())){
                // item already exists

                double earnings = o.getTotalEarnings();
                System.out.println(earnings);
                double price = sale.getPrice();
                System.out.println(price);
                double qty = sale.getNumberOfOrder();
                System.out.println(qty);

                earnings += (price * qty);
                System.out.println(earnings);

                o.setNumberOfOrder(qty + o.getNumberOfOrder());
                o.setTotalEarnings(earnings);
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
        MainForm.lblTotalAmount.setText("₱" + twoDecimalFormat.format(total));
        // Update Balance
        double discount = Double.parseDouble(MainForm.lblDiscountAmount.getText().substring(1));
        double balance = total - discount;
        MainForm.lblBalanceAmount.setText("₱" + twoDecimalFormat.format(balance));

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

    public String getAccountName(String typedUsername){
        for (Account acc: accounts){
            if (acc.getUsername().equals(typedUsername)){
                return acc.getName();
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

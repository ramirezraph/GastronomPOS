package common;

import views.DialogOk;
import views.DialogYesNo;

import javax.swing.*;
import java.util.ArrayList;

public class Data {

    private ArrayList<Account> accounts;
    private ArrayList<Product> products;

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
    }

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

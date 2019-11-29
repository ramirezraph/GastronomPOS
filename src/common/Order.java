package common;

public class Order {
    private String code;
    private String name;
    private double eachPrice;
    private int quantity;
    private double total;

    public Order(String code, String name, double eachPrice, int quantity, double total) {
        this.code = code;
        this.name = name;
        this.eachPrice = eachPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(double eachPrice) {
        this.eachPrice = eachPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}

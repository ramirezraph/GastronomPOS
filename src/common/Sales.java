package common;

public class Sales {

    private String code;
    private String name;
    private double price;
    private double numberOfOrder;
    private double totalEarnings;
    private double percentage;

    public Sales(String code, String name, double price, double numberOfOrder) {
        this(code, name,price,numberOfOrder, (numberOfOrder*price), 1);
    }

    public Sales(String code, String name, double price, double numberOfOrder,
                 double totalEarnings, double percentage) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.numberOfOrder = numberOfOrder;
        this.totalEarnings = totalEarnings;
        this.percentage = percentage;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(double numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}

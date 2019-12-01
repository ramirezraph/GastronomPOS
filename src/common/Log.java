package common;

public class Log {
    private String id;
    private String monthOfPurchase;
    private String dayOfPurchase;
    private String yearOfPurchase;
    private String timeOfPurchase;
    private String staffInCharge;
    private String item;
    private double total;
    private String discount;
    private double payment;
    private double change;

    public Log(String id, String monthOfPurchase, String dayOfPurchase, String yearOfPurchase, String timeOfPurchase,
               String staffInCharge, String item, double total, String discount, double payment, double change) {
        this.id = id;
        this.monthOfPurchase = monthOfPurchase;
        this.dayOfPurchase = dayOfPurchase;
        this.yearOfPurchase = yearOfPurchase;
        this.timeOfPurchase = timeOfPurchase;
        this.staffInCharge = staffInCharge;
        this.item = item;
        this.total = total;
        this.discount = discount;
        this.payment = payment;
        this.change = change;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonthOfPurchase() {
        return monthOfPurchase;
    }

    public void setMonthOfPurchase(String monthOfPurchase) {
        this.monthOfPurchase = monthOfPurchase;
    }

    public String getDayOfPurchase() {
        return dayOfPurchase;
    }

    public void setDayOfPurchase(String dayOfPurchase) {
        this.dayOfPurchase = dayOfPurchase;
    }

    public String getYearOfPurchase() {
        return yearOfPurchase;
    }

    public void setYearOfPurchase(String yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(String timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }

    public String getStaffInCharge() {
        return staffInCharge;
    }

    public void setStaffInCharge(String staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}

package css.cis3334.project;

public class Order  {
    private String key;
    private String foodName;
    private Double price;

    public Order() {
    }

    public Order(String key, String foodName, Double price) {
        this.key = key;
        this.foodName = foodName;
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

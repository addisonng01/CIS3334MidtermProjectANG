package css.cis3334.project;

public class Order  {
    /*
        the object used to store the values for an order made by the user. The object contains
        a key that is used to make each order unique. The object also contains the name of the food
        that is added and the price of that food.
     */
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
    //getters and setters
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

package css.cis3334.project;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class OrderFirebaseData {

    DatabaseReference myOrderDbRef;
    public static final String OrderDataTag = "ORDER DATA";
    List<Order> orderList;

    //opens the database instance from firebase
    public DatabaseReference open()  {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myOrderDbRef = database.getReference(OrderDataTag);
        orderList =  new ArrayList();
        return myOrderDbRef;
    }

    public void close() {
    }

    //creates an order object that contains the name of the food and the price
    public Order createOrder(String foodName, Double price) {
        String key = myOrderDbRef.child(OrderDataTag).push().getKey();
        Order newOrder = new Order(key, foodName, price);
        myOrderDbRef.child(key).setValue(newOrder);
        return newOrder;
    }

    //deletes an order object
    public void deleteOrder(Order order) {
        String key = order.getKey();
        myOrderDbRef.child(key).removeValue();
    }

    //updates order list if there is a change (ex. an order is deleted)
    public List<Order> updateOrderList(DataSnapshot dataSnapshot) {
        orderList.clear();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Order order = data.getValue(Order.class);
            orderList.add(order);
        }
        return orderList;
    }

    //returns the order list
    public List<Order> getAllOrders() {
        return orderList;
    }
    //returns one order at the position called
    public Order getOrder(Integer position) {
        return orderList.get(position);
    }
    //returns the size of the order list
    public Integer getNumberOfOrders() {
        return orderList.size();
    }
}

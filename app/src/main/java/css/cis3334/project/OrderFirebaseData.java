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

    public DatabaseReference open()  {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myOrderDbRef = database.getReference(OrderDataTag);
        orderList =  new ArrayList();
        return myOrderDbRef;
    }

    public void close() {
    }

    public Order createOrder(String foodName, Double price) {
        String key = myOrderDbRef.child(OrderDataTag).push().getKey();
        Order newOrder = new Order(key, foodName, price);
        myOrderDbRef.child(key).setValue(newOrder);
        return newOrder;
    }

    public void deleteOrder(Order order) {
        String key = order.getKey();
        myOrderDbRef.child(key).removeValue();
    }


    public List<Order> updateOrderList(DataSnapshot dataSnapshot) {
        orderList.clear();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Order order = data.getValue(Order.class);
            orderList.add(order);
        }
        return orderList;
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order getOrder(Integer position) {
        return orderList.get(position);
    }

    public Integer getNumberOfOrders() {
        return orderList.size();
    }

}

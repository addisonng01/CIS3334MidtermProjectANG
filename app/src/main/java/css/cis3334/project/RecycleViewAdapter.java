package css.cis3334.project;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    OrderFirebaseData orderDataSource;

    RecycleViewAdapter (OrderFirebaseData orderDataSource) {
        this.orderDataSource = orderDataSource;
    }

    @NonNull
    @Override
    //populates the order recycler with order objects
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_row_layout, parent, false);
        OrderViewHolder holder = new OrderViewHolder(view);
        return holder;
    }

    @Override
    //finds an order object in the database and sets the text boxes with data from the object
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderDataSource.getOrder(position);
        Log.d("CIS3334", "Set text to textboxes");
        String foodName = order.getFoodName();
        holder.tvFoodName.setText(foodName);
        holder.tvPrice.setText(order.getPrice().toString());
    }

    @Override
    //returns the total amount of orders
    public int getItemCount() {
        Log.d("CIS3334","Returns number of orders");
        return orderDataSource.getNumberOfOrders();
    }
}

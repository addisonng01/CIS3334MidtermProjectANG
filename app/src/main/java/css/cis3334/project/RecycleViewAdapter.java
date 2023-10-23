package css.cis3334.project;

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
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_row_layout, parent, false);
        OrderViewHolder holder = new OrderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderDataSource.getOrder(position);
        String foodName = order.getFoodName();
        holder.tvFoodName.setText(foodName);
        holder.tvPrice.setText(order.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return orderDataSource.getNumberOfOrders();
    }
}

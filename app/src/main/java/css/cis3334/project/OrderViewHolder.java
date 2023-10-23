package css.cis3334.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderViewHolder extends RecyclerView.ViewHolder{
    TextView tvFoodName;
    TextView tvPrice;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        tvFoodName = itemView.findViewById(R.id.tvFoodName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
    }
}

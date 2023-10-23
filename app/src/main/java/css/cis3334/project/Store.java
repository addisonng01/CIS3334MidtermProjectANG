package css.cis3334.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Store extends AppCompatActivity {

    Button buttonPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_ui);


    }

    private void setupPlaceOrderButton() {
        buttonPlaceOrder = (Button) findViewById(R.id.buttonPlaceOrder);
        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }

}

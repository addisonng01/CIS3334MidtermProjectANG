package css.cis3334.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Objects;

public class storefront_ui extends AppCompatActivity {

    Button buttonPlaceOrder;
    CheckBox cbItem1;
    CheckBox cbItem2;
    CheckBox cbItem3;

    TextView tvPrice1, tvPrice2, tvPrice3;
    OrderFirebaseData orderDataSource;
    String nameItem1, nameItem2, nameItem3;
    Double priceItem1, priceItem2, priceItem3;
    String intentHotdog, intentBurger;

    // sets name and price for each item
    public storefront_ui(){
        nameItem1 = "a";
        nameItem2 = "a";
        nameItem3 = "a";
        priceItem1 = 0.0;
        priceItem2 = 0.0;
        priceItem3 = 0.0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storefront_ui);
        //uses intent extra to produce a key
        Intent intent = getIntent();
        String extras = intent.getExtras().getString("strKey");;
        String key = extras;

        tvPrice1 = (TextView) findViewById(R.id.tvPrice1);
        tvPrice1.setText(key);
        //Depending on which key is given by the FragmentHome buttons, produces UI for the appropriate store
        if(Objects.equals(key, "keyHotdog"))
        {
            hotdogInterface();
        }
        else if (Objects.equals(key, "keyBurger"))
        {
            burgerInterface();
        }
        else if (Objects.equals(key, "keyPizza"))
        {
            pizzaInterface();
        }
        //opens the firebase database
        orderDataSource = new OrderFirebaseData();
        orderDataSource.open();

        setupPlaceOrderButton();
    }
    //sets text and values for hotdog store
    private void hotdogInterface()
    {
        cbItem1 = (CheckBox) findViewById(R.id.cbItem1);
        cbItem2 = (CheckBox) findViewById(R.id.cbItem2);
        cbItem3 = (CheckBox) findViewById(R.id.cbItem3);
        tvPrice1 = (TextView) findViewById(R.id.tvPrice1);
        tvPrice2 = (TextView) findViewById(R.id.tvPrice2);
        tvPrice3 = (TextView) findViewById(R.id.tvPrice3);

        cbItem1.setText("Classic New York Dog");
        tvPrice1.setText("$2.99");
        cbItem2.setText("The Chi Glizzy");
        tvPrice2.setText("$3.99");
        cbItem3.setText("Mount Rushdog");
        tvPrice3.setText("$4.99");

        nameItem1 = "Classic New York Dog";
        nameItem2 = "The Chi Glizzy";
        nameItem3 = "Mount Rushdog";
        priceItem1 = 2.99;
        priceItem2 = 3.99;
        priceItem3 = 4.99;
    }
    //sets text and values for burger store
    private void burgerInterface()
    {
        cbItem1 = (CheckBox) findViewById(R.id.cbItem1);
        cbItem2 = (CheckBox) findViewById(R.id.cbItem2);
        cbItem3 = (CheckBox) findViewById(R.id.cbItem3);
        tvPrice1 = (TextView) findViewById(R.id.tvPrice1);
        tvPrice2 = (TextView) findViewById(R.id.tvPrice2);
        tvPrice3 = (TextView) findViewById(R.id.tvPrice3);

        cbItem1.setText("Plain Sad Cheeseburger");
        tvPrice1.setText("$0.01");
        cbItem2.setText("Beef Burger");
        tvPrice2.setText("$5.99");
        cbItem3.setText("Fish Sandwich :(");
        tvPrice3.setText("$3.99");

        nameItem1 = "Plain Sad Cheeseburger";
        nameItem2 = "Beef Burger";
        nameItem3 = "Fish Sandwich";
        priceItem1 = 0.01;
        priceItem2 = 5.99;
        priceItem3 = 3.99;
    }
    //sets text and values for pizza store
    private void pizzaInterface()
    {
        cbItem1 = (CheckBox) findViewById(R.id.cbItem1);
        cbItem2 = (CheckBox) findViewById(R.id.cbItem2);
        cbItem3 = (CheckBox) findViewById(R.id.cbItem3);
        tvPrice1 = (TextView) findViewById(R.id.tvPrice1);
        tvPrice2 = (TextView) findViewById(R.id.tvPrice2);
        tvPrice3 = (TextView) findViewById(R.id.tvPrice3);

        cbItem1.setText("Cheese & Pepperoni Pizza Slice");
        tvPrice1.setText("$1.49");
        cbItem2.setText("Meatlover's Pizza Slice");
        tvPrice2.setText("$1.99");
        cbItem3.setText("Pineapple Pizza Slice");
        tvPrice3.setText("$1.99");

        nameItem1 = "Cheese & Pepperoni Pizza Slice";
        nameItem2 = "Meatlover's Pizza Slice";
        nameItem3 = "Pineapple Pizza Slice";
        priceItem1 = 1.49;
        priceItem2 = 1.99;
        priceItem3 = 1.99;
    }
    //button uses checkboxes to print out the order object(s) into the recycler view
    private void setupPlaceOrderButton() {
        buttonPlaceOrder = (Button) findViewById(R.id.buttonPlaceOrder);
        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //checkbox 1 scenarios
                if(cbItem1.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                }
                else if (cbItem1.isChecked() & cbItem2.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem2,priceItem2);
                }
                else if (cbItem1.isChecked() & cbItem3.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                else if (cbItem1.isChecked() & cbItem2.isChecked() & cbItem3.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem2,priceItem2);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                //checkbox 2 scenarios
                if(cbItem2.isChecked())
                {
                    orderDataSource.createOrder(nameItem2,priceItem2);
                }
                else if (cbItem2.isChecked() & cbItem1.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem2,priceItem2);
                }
                else if (cbItem2.isChecked() & cbItem3.isChecked())
                {
                    orderDataSource.createOrder(nameItem2,priceItem2);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                else if (cbItem1.isChecked() & cbItem2.isChecked() & cbItem3.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem2,priceItem2);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                //checkbox 3 scenarios
                if(cbItem3.isChecked())
                {
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                else if (cbItem3.isChecked() & cbItem1.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                else if (cbItem3.isChecked() & cbItem2.isChecked())
                {
                    orderDataSource.createOrder(nameItem2,priceItem2);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }
                else if (cbItem1.isChecked() & cbItem2.isChecked() & cbItem3.isChecked())
                {
                    orderDataSource.createOrder(nameItem1,priceItem1);
                    orderDataSource.createOrder(nameItem2,priceItem2);
                    orderDataSource.createOrder(nameItem3,priceItem3);
                }

                finish();
            }
        });
    }
}

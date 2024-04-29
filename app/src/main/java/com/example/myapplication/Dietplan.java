package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Dietplan extends AppCompatActivity {
     LinearLayout loss,gain,normal;
    Button homes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan);
        loss=(LinearLayout) findViewById(R.id.fitone);
        gain=(LinearLayout) findViewById(R.id.fittwo);
        normal=(LinearLayout) findViewById(R.id.fitthree);
        homes=(Button)findViewById(R.id.btnexercise);

        loss.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dietplan.this);
                builder.setTitle("Weight Loss Diet Chart");
                builder.setMessage(""+
                        "\n" +      "6:30 AM         Cucumber Detox Water (1 glass)\n" +
                        "\n"+       "8:00 AM         Oats Porridge in Skimmed Milk (1 bowl)\n" +
                         "                          Mixed Nuts (25 grams)\n"+

                        "\n" +      "2:00 PM         Mixed Vegetable Salad (1 katori)\n"+
                        "\n" +      "2:10 PM         Dal(1 katori)Gajar Matar Sabzi (1 katori)\n" +
                        "\t" + "                      Roti (1 roti/chapati)\n"+

                        "\n" +      "4:00 PM         Cut Fruits (1 cup) Buttermilk (1 glass)\n"+
                        "\n" +      "5:30 PM         Tea with Less Sugar and Milk (1 teacup)\n"+
                        "\n" +      "8:50 PM         tMixed Vegetable Salad (1 katori)\n"+
                        "\n" +      "9:00 PM         Dal (1 katori) Lauki Sabzi (1 katori)\n" +
                        "                         Roti (1 roti/chapati)");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", null);
                builder.setNegativeButton("Cancel", null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }});
        gain.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dietplan.this);
                builder.setTitle("Weight Gain Diet Chart");
                builder.setMessage(""+
                        "\n" +      "Breakfast (8:00-8:30AM)" +
                        "\n"+       "2 egg brown bread sandwich + green chutney + \n" +
                                    "cup milk + 3 cashews + 4 almonds + 2 walnuts  \n"+

                        "\n\n" +    "Mid-Meal (11:00-11:30AM)"+
                        "\n" +      "1 cup banana shake\n" +

                        "\n\n" +    "Lunch (2:00-2:30PM)"+
                        "\n" +      "1 cup arhar dal + 1 cup potato curry + 3 chapatti "+
                        "\n" +      "+ 1/2 cup rice + 1/2 cup low fat curd + salad  \n" +

                        "\n\n" +     "Evening (4:00-4:30PM)"+
                        "\n" +      "1 cup strawberry smoothie + 1 cup vegetable poha\n" +

                        "\n\n" +    "Dinner (8:00-8:30PM)"+
                        "\n" +      "1.5 cup chicken curry + 3 chapatti + salad\n");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", null);
                builder.setNegativeButton("Cancel", null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }});
        normal.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dietplan.this);
                builder.setTitle("Mediterranean Diet Chart");
                builder.setMessage(""+
                        "\n" +      "Breakfast (8:00-8:30AM  453 calories)" +
                        "\n"+       "1 cup nonfat plain Greek yogurt (145 calories)+ \n" +
                                    "1/4 cup blackberries (16 calories)+ \n"+
                                    "3 Tbsp. chopped walnuts (292 calories)\n"+

                        "\n\n" +    "Mid-Meal Snack (39 calories  11:00-11:30AM) "+
                        "\n" +      "1/2 cup raspberries\n" +

                        "\n\n" +    "Lunch (325 calories  2:00-2:30PM)"+
                        "\n" +      "1 serving Veggie & Hummus Sandwich\n"+


                        "\n\n" +     "Evening Snack(4:00-4:30PM  106 calories)"+
                        "\n" +      "1 medium pear\n" +

                        "\n\n" +    "Dinner (8:00-8:30PM  422 calories)"+
                        "\n" +      "1 serving Sheet-Pan Roasted Salmon & Vegetables\n");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", null);
                builder.setNegativeButton("Cancel", null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }});
        homes.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i= new Intent(Dietplan.this,Home.class);
                startActivity(i);}});
    }
}
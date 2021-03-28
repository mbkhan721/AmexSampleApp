package com.example.amex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int creditScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Changing color of action top bar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2E77BB")); // Amex hex color
        actionBar.setBackgroundDrawable(colorDrawable); // Setting background drawable

        // Get app icon on top of action bar when app is running
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Finalizing values to variable once throughout the class
        final EditText hint = (EditText) findViewById(R.id.txtHint);
        final RadioButton radPlatinum = (RadioButton) findViewById(R.id.radAmexPlatinum);
        final RadioButton radGold = (RadioButton) findViewById(R.id.radAmexGold);
        final RadioButton radEveryDay = (RadioButton) findViewById(R.id.radAmexEveryday);
        final TextView decision = (TextView) findViewById(R.id.txtDecision);

        // Making the button work when pressed
        Button convert = (Button) findViewById(R.id.btnApply);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditScore = Integer.parseInt(hint.getText().toString());
                if (radPlatinum.isChecked()) {
                    if (creditScore >= 750 && creditScore <= 875) {
                        decision.setText("Congrats! You qualify for the Platinum Card");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Credit Score must be within 750 & 875", Toast.LENGTH_LONG).show();
                    }
                }
                // evaluating Gold Card
                if (radGold.isChecked()) {
                    if (creditScore >= 700 && creditScore <= 875) {
                        decision.setText("Congrats! You qualify for Amex Gold Card");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Credit Score must be 700 or more.", Toast.LENGTH_LONG).show();
                    }
                }
                // Evaluating Everyday card
                if (radEveryDay.isChecked()) {
                    if (creditScore >= 615 && creditScore <= 875) {
                        decision.setText("You qualify for the Everyday Card");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Credit Score must be above 615", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
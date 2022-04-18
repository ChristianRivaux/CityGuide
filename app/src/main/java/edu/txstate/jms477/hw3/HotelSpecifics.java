package edu.txstate.jms477.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class HotelSpecifics extends AppCompatActivity
{

    Button calcFinal = findViewById(R.id.btnCalcFinal);
    int Id;
    String Name;
    String City;
    String State;
    String URL;
    double dblCost;
    double Cost;
    int Image;
    String NightStay;
    int intNightStay;
    double dblFinalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_specifics);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(HotelSpecifics.this);
        Id = sharedPref.getInt("KEY_ID", 0);
        Name = sharedPref.getString("KEY_NAME", "");
        City = sharedPref.getString("KEY_CITY", "");
        State = sharedPref.getString("KEY_STATE", "");
        Cost = sharedPref.getFloat("KEY_COST", 0);
        Image = sharedPref.getInt("KEY_IMAGE", 0);
        URL = sharedPref.getString("KEY_URL", "");

        TextView FinalId = findViewById(R.id.txtFinalID);
        FinalId.setText(Id);
        TextView FinalName = findViewById(R.id.txtFinalName);
        FinalName.setText(Name);
        TextView FinalCity = findViewById(R.id.txtFinalCity);
        FinalCity.setText(City);
        TextView FinalState = findViewById(R.id.txtFinalState);
        FinalState.setText(State);
        calcFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NightStay = ((EditText)findViewById(R.id.numNightStay)).toString();
                intNightStay = Integer.parseInt(NightStay);
                dblFinalCost = intNightStay * Cost;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                TextView FinalCost = findViewById(R.id.txtFinalCost);
                FinalCost.setText(currency.format(dblFinalCost));
            }
        });
        Uri uriUrl = Uri.parse(URL);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
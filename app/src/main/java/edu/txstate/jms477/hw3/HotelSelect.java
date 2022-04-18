package edu.txstate.jms477.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HotelSelect extends ListActivity {

        List<Hotel> list = new ArrayList<Hotel>();

        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            Hotel selectedHotel = list.get(position);
            startActivity(new Intent(HotelSelect.this, HotelSpecifics.class));
            int Id = selectedHotel.getId();
            String Name = selectedHotel.getName();
            String City = selectedHotel.getCity();
            String State = selectedHotel.getState();
            double Cost = selectedHotel.getCost();
            int Image = selectedHotel.getImage();
            String URL = selectedHotel.getUrl();

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(HotelSelect.this);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("KEY_ID", Id);
            editor.putString("KEY_NAME", Name);
            editor.putString("KEY_CITY", City);
            editor.putString("KEY_STATE", State);
            editor.putFloat("KEY_COST", (float) Cost);
            editor.putInt("KEY_IMAGE", Image);
            editor.putString("KEY_URL", URL);
            editor.commit();

            //Toast.makeText(this, "You selected " + selectedHotel.getName(), Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Hotel a1 = null;
            a1 = new Hotel();
            a1.setId(1);
            a1.setName("Holiday Inn");
            a1.setCity("San Marcos");
            a1.setState("Texas");
            a1.setCost(70.00);
            //a1.setCost(); //need to maybe convert to string or create currency
            a1.setImage(R.drawable.holiday_inn_logo);
            list.add(a1);

            Hotel a2 = null;
            a2 = new Hotel();
            a2.setId(2);
            a2.setName("Hilton"); //change image and name later
            a2.setCity("San Marcos");
            a2.setState("Texas");
            a2.setCost(99.00);
            //a2.setCost(); //need to maybe convert to string or create currency
            a2.setImage(R.drawable.holiday_inn_logo);
            list.add(a2);

            Hotel a3 = null;
            a3 = new Hotel();
            a3.setId(3);
            a3.setName("Mariott"); //change image and name later
            a3.setCity("San Marcos");
            a3.setState("Texas");
            a3.setCost(100.00);
            //a3.setCost(); //need to maybe convert to string or create currency
            a3.setImage(R.drawable.holiday_inn_logo);
            list.add(a3);

            Hotel a4 = null;
            a4 = new Hotel();
            a4.setId(4);
            a4.setName("Inn & Suites"); //change image and name later
            a4.setCity("San Marcos");
            a4.setState("Texas");
            a4.setCost(120.00);
            //a4.setCost(); //need to maybe convert to string or create currency
            a4.setImage(R.drawable.holiday_inn_logo);
            list.add(a4);

            Hotel a5 = null;
            a5 = new Hotel();
            a5.setId(5);
            a5.setName("Motel 6"); //change image and name later
            a5.setCity("San Marcos");
            a5.setState("Texas");
            a5.setCost(50.00);
            //a5.setCost(); //need to maybe convert to string or create currency
            a5.setImage(R.drawable.holiday_inn_logo);
            list.add(a5);


            setListAdapter(new HotelAdapter(this, R.layout.layout_hotel, list));

        }


}


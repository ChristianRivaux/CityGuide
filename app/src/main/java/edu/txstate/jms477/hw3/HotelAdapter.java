package edu.txstate.jms477.hw3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

//create a subclass of
public class HotelAdapter extends ArrayAdapter<Hotel> {
    private Context context;
    private int resource;
    public HotelAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;


    }
    private class ViewHolder { //To reuse the template
        ImageView imageHolder;
        TextView textHolder;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        Hotel bean = getItem(position);
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(resource, null);
            ImageView image = convertView.findViewById(R.id.imgHotel);
            TextView name = convertView.findViewById(R.id.txtHotel);
            holder =new ViewHolder();
            holder.imageHolder = image;
            holder.textHolder = name;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageHolder.setImageResource(bean.getImage());
        holder.textHolder.setText(bean.getName());

        return convertView;
    }
}



package com.example.myapplication;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] names;
    private final Integer[] imageid;

    public CustomListAdapter(Activity context, String[] names, Integer[] imageid)
    {
        super(context, R.layout.male_listview, names);
        this.context = context;
        this.names = names;
        this.imageid = imageid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.male_listview, null,true);
        TextView titleText = (TextView) rowView.findViewById(R.id.text6);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image1);
        titleText.setText(names[position]);
        imageView.setImageResource(imageid[position]);
        return rowView;
    };
}
package com.schoolofnet.contacts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Leonan-Mac on 9/23/16.
 */
public class CustomAdapter extends ArrayAdapter<Person> {

    private Context context;

    public CustomAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        Person p = getItem(position);

        if (converView == null) {
            converView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        TextView txtName = (TextView) converView.findViewById(R.id.txt_label);
        TextView txtId = (TextView) converView.findViewById(R.id.txt_label_id);

        txtName.setText(p.getName());
        txtId.setText(p.getId().toString());

        return converView;
    }

}

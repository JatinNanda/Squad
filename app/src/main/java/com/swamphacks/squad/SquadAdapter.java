package com.swamphacks.squad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by manavdutta1 on 1/23/16.
 */
public class SquadAdapter  extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public SquadAdapter(Context context, String[] values) {
        super(context, R.layout.row_file, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_squad, parent, false);
        TextView firstView = (TextView) rowView.findViewById(R.id.friend);
        TextView secView = (TextView) rowView.findViewById(R.id.event);
        String theString = values[position];
        int stringIndex = theString.indexOf(" ");
        firstView.setText(theString.substring(0, stringIndex));
        secView.setText(theString.substring(stringIndex + 1, theString.length()));
        return rowView;
    }

}
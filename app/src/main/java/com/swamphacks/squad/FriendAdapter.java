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
public class FriendAdapter extends ArrayAdapter<String>{
    private final Context context;
    private final String[] values;

    public FriendAdapter(Context context, String[] values) {
        super(context, R.layout.row_file, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_file, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imView);
        TextView textView = (TextView) rowView.findViewById(R.id.teView);
        textView.setText("Friend");
        return rowView;
    }

}

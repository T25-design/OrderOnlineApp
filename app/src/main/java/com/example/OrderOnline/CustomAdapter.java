package com.example.OrderOnline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<FoodItems> versionArrayList;

    public CustomAdapter(Context context, ArrayList<FoodItems> versionArrayList){
        this.context=context;
        this.versionArrayList=versionArrayList;
    }
    @Override
    public int getCount() {
        if(versionArrayList!=null && versionArrayList.size()>0)
            return versionArrayList.size();
        else
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return versionArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView= LayoutInflater.from(context).inflate(R.layout.version_list_file, parent ,false);

        TextView txtVersionNum = convertView.findViewById(R.id.tv_version_num);
        TextView txtVersionName = convertView.findViewById(R.id.tv_version_name);
        txtVersionName.setText( versionArrayList.get(position).getItemName());
        txtVersionNum.setText("Cost : Rs"+ versionArrayList.get(position).getItemCost());


        return convertView;
    }
}

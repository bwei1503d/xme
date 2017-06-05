package com.bwei.xme.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bwei.xme.R;

import java.util.List;

/**
 * Created by muhanxi on 17/6/4.
 */

public class ListAdapter extends BaseAdapter {


    public List<ItemBean> list;
    public Context context;
    LayoutInflater inflater ;

    public ListAdapter(Context context,List<ItemBean> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if(convertView == null){
            viewHolder = new ViewHolder();
           convertView =   inflater.inflate(R.layout.listadapter,null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textview_id_list);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(list.get(position).getText());

        if(list.get(position).ischecked()){
            viewHolder.checkBox.setChecked(true);
        } else {
            viewHolder.checkBox.setChecked(false);
        }

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).ischecked()){
                    list.get(position).setIschecked(false);

                }else {
                    list.get(position).setIschecked(true);

                }
                notifyDataSetChanged();
            }
        });


        return convertView;
    }


    static class ViewHolder {
        TextView textView;
        CheckBox checkBox ;
    }
}

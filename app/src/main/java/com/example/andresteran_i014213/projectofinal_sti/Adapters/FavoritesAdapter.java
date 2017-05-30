package com.example.andresteran_i014213.projectofinal_sti.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andresteran_i014213.projectofinal_sti.Models.Favorites;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenet on 29/05/2017.
 */

public class FavoritesAdapter extends BaseAdapter{

    List<Favorites> userList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public FavoritesAdapter (Context context, List<Favorites> userList) {
        this.context = context;
        this.userList = userList;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return userList.size();
    }

    @Override
    public Favorites getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Favorites favorit = getItem(position);
        viewHolder.name.setText(String.valueOf(favorit.getIdUser()));
        viewHolder.email.setText( String.valueOf(favorit.getIdBus()));

        return convertView;
    }

    public class ViewHolder{
        TextView name;
        TextView email;

        public ViewHolder(View item) {
            name = (TextView) item.findViewById(R.id.id_item_name);
            email = (TextView) item.findViewById(R.id.id_item_email);
        }
    }
}
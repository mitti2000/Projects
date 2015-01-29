package com.mittidesign.initiativemanager;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterAdapter extends ArrayAdapter<Character> {
    Context context;
    int layoutResourceId;
    ArrayList<Character> data;

    public CharacterAdapter(Context context, int layoutResourceId, ArrayList<Character> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CharacterHolder holder;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CharacterHolder();
            holder.charName = (TextView)row.findViewById(R.id.charName);
            holder.charInitiative = (TextView)row.findViewById(R.id.charInitiative);
            holder.charHealthPoints = (TextView)row.findViewById(R.id.charHealthPoints);

            row.setTag(holder);
        }
        else
        {
            holder = (CharacterHolder)row.getTag();
        }

        Character character = data.get(position);
        holder.charName.setText(character.getName());
        holder.charInitiative.setText(Integer.toString(character.getInitiative()));
        holder.charHealthPoints.setText(Integer.toString(character.getHealthPoints()));

        return row;
    }

    static class CharacterHolder
    {
        TextView charName;
        TextView charInitiative;
        TextView charHealthPoints;
    }
}
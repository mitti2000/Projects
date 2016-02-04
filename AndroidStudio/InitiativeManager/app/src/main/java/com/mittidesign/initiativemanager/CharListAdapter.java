package com.mittidesign.initiativemanager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CharListAdapter extends ArrayAdapter<Character> {
    Context context;
    int layoutResourceId;
    ArrayList<Character> data;

    public CharListAdapter(Context context, int layoutResourceId, ArrayList<Character> data) {
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
            holder.charHealthPoints = (TextView)row.findViewById(R.id.charHealthPoints);
            holder.charStamina = (TextView)row.findViewById(R.id.charStamina);
            holder.charNpc = (TextView)row.findViewById(R.id.charNPC);

            row.setTag(holder);
        }
        else
        {
            holder = (CharacterHolder)row.getTag();
        }

        Character character = data.get(position);
        holder.charName.setText(character.getName());
        holder.charHealthPoints.setText(Integer.toString(character.getHealthPoints()));
        holder.charStamina.setText(Integer.toString(character.getStamina()));
        if(character.isNpc()) holder.charNpc.setText("X");
        else  holder.charNpc.setText("");

        return row;
    }

    static class CharacterHolder
    {
        TextView charName;
        TextView charHealthPoints;
        TextView charStamina;
        TextView charNpc;
    }
}

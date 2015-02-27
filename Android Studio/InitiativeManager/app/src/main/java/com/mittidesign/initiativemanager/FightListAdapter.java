package com.mittidesign.initiativemanager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FightListAdapter extends ArrayAdapter<Character> {
    Context context;
    int layoutResourceId;
    ArrayList<Character> data;

    public FightListAdapter(Context context, int layoutResourceId, ArrayList<Character> data) {
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
            holder.charActive = (TextView)row.findViewById(R.id.charActive);
            holder.charName = (TextView)row.findViewById(R.id.charName);
            holder.charInitiative = (TextView)row.findViewById(R.id.charInitiative);
            holder.charHealthPoints = (TextView)row.findViewById(R.id.charHealthPoints);
            holder.charStamina = (TextView)row.findViewById(R.id.charStamina);
            holder.charNPC = (TextView)row.findViewById(R.id.charNPC);

            row.setTag(holder);
        }
        else
        {
            holder = (CharacterHolder)row.getTag();
        }

        //TODO: Where to get active data from?
        Character character = data.get(position);
        holder.charActive.setText(character.getActive());
        holder.charName.setText(character.getName());
        holder.charInitiative.setText(Integer.toString(character.getInitiative()));
        holder.charHealthPoints.setText(Integer.toString(character.getHealthPoints()));
        holder.charStamina.setText(Integer.toString(character.getStamina()));
        if(character.isNpc()) holder.charNPC.setText("X");
        else holder.charNPC.setText("");

        return row;
    }

    static class CharacterHolder
    {
        TextView charActive;
        TextView charName;
        TextView charInitiative;
        TextView charHealthPoints;
        TextView charStamina;
        TextView charNPC;
    }
}

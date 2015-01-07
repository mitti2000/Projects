package com.mittidesign.gamemastertool;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CharacterAdapter extends ArrayAdapter<Character> {

    Context context;
    int layoutResourceId;
    Character data[] = null;

    public CharacterAdapter(Context context, int layoutResourceId, Character[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CharacterHolder holder = null;

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

        Character character = data[position];
        holder.charActive.setText(character.getActive());
        holder.charName.setText(character.getName());
        holder.charInitiative.setText(Integer.toString(character.getInitiative()));
        holder.charHealthPoints.setText(Integer.toString(character.getHealthPoints()));
        holder.charStamina.setText(Integer.toString(character.getStamina()));
        holder.charNPC.setText(character.getNpc());

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
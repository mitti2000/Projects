package com.mittidesign.initiativemanager;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;



public class EditCharDialogFragment extends DialogFragment {

    private View view;

    public interface EditCharDialogListener {
        public void onEditCharDialogPositiveClick(DialogFragment dialog);
        public void onEditCharDialogNegativeClick(DialogFragment dialog);
    }

    EditCharDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (EditCharDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.add_char_dialog_fragment, null);
        TextView initName = (TextView) view.findViewById(R.id.inp_amount);
        TextView initHP = (TextView) view.findViewById(R.id.inp_hp);
        TextView initStamina = (TextView) view.findViewById(R.id.inp_stamina);
        CheckBox initNPC = (CheckBox) view.findViewById(R.id.chk_npc);
        initName.setText(GlobalHandler.editChar.getName());
        initHP.setText(Integer.toString(GlobalHandler.editChar.getHealthPoints()));
        initStamina.setText(Integer.toString(GlobalHandler.editChar.getStamina()));
        initNPC.setChecked(GlobalHandler.editChar.isNpc());


        builder.setView(view);
        builder.setMessage(R.string.edit_character)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onEditCharDialogNegativeClick(EditCharDialogFragment.this);
                    }
                })
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView name = (TextView) view.findViewById(R.id.inp_amount);
                        TextView hp = (TextView) view.findViewById(R.id.inp_hp);
                        TextView stamina = (TextView) view.findViewById(R.id.inp_stamina);
                        CheckBox npc = (CheckBox) view.findViewById(R.id.chk_npc);
                        GlobalHandler.createCharListEntry(name.getText().toString(), Integer.parseInt(hp.getText().toString()), Integer.parseInt(stamina.getText().toString()), npc.isChecked());

                        mListener.onEditCharDialogPositiveClick(EditCharDialogFragment.this);
                    }
                });


        return builder.create();
    }
}

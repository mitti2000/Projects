package com.mittidesign.initiativemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class AddFightDialogFragment extends DialogFragment {

    public interface AddFightDialogListener {
        public void onAddFightDialogPositiveClick(DialogFragment dialog);
        public void onAddFightDialogNegativeClick(DialogFragment dialog);
    }

    AddFightDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (AddFightDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    private View view;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.add_fight_dialog_fragment, null);
        TextView amount = (TextView) view.findViewById(R.id.inp_amount);
        amount.setText(""+1);

        builder.setView(view);
        builder.setMessage(R.string.character_amount)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onAddFightDialogNegativeClick(AddFightDialogFragment.this);
                    }
                })
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView amount = (TextView) view.findViewById(R.id.inp_amount);
                        GlobalHandler.setAmountToAdd(Integer.parseInt(amount.getText().toString()));
                        Log.d("Dialog Amount", ""+GlobalHandler.getAmountToAdd());
                        mListener.onAddFightDialogPositiveClick(AddFightDialogFragment.this);
                    }
                });


        return builder.create();
    }
}


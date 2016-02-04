package de.galileo.scouttools.app;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 * <p />
 * <p />
 * Activities containing this fragment MUST implement the {@link }
 * interface.
 */
public class ScoutLogFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnScoutLogInteractionListener mListener;

    private ScoutLogDataSource dataSource;

    // TODO: Rename and change types of parameters
    public static ScoutLogFragment newInstance(String param1, String param2) {
        ScoutLogFragment fragment = new ScoutLogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ScoutLogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scoutlog, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataSource = new ScoutLogDataSource(getActivity());
        try {
            dataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<ScoutLog> scoutLogList = dataSource.getAllScoutLogs();
        setListAdapter(new ArrayAdapter<ScoutLog>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, scoutLogList));

        Button buttonAdd = (Button) getView().findViewById(R.id.button_new_scoutlog);
        final EditText editTextAdd = (EditText) getView().findViewById(R.id.editText_new_scoutlog);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextAdd.getText().toString();
                dataSource.createScoutLog(title);
                List<ScoutLog> scoutLogList = dataSource.getAllScoutLogs();
                setListAdapter(new ArrayAdapter<ScoutLog>(getActivity(),
                        android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, scoutLogList));
            }
        });

        final ListView listView = getListView();

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener( new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                getActivity().getMenuInflater().inflate(R.menu.scoutlog_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.scoutlog_cab_delete) {
                    SparseBooleanArray checkedScoutLogs = listView.getCheckedItemPositions();
                    for (int i = 0; i < checkedScoutLogs.size(); i++) {
                        if ( checkedScoutLogs.valueAt(i) ) {
                            dataSource.deleteScoutLog( (ScoutLog) listView.getItemAtPosition(i)  );
                        }
                    }
                    List<ScoutLog> scoutLogList = dataSource.getAllScoutLogs();
                    setListAdapter(new ArrayAdapter<ScoutLog>(getActivity(),
                            android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, scoutLogList));

                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnScoutLogInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnScoutLogInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String title = l.getItemAtPosition(position).toString();
        long scoutLogId = ((ScoutLog) l.getItemAtPosition(position)).getId();

        if (getView().findViewById(R.id.container_scoutlog_details) != null) {
            ScoutLogDetailsFragment scoutLogDetailsFragment = ScoutLogDetailsFragment.newInstance(title, scoutLogId);
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.container_scoutlog_details, scoutLogDetailsFragment);
            transaction.commit();
        } else {
            Intent intent = new Intent(getActivity(), ScoutLogDetailsActivity.class);
            intent.putExtra("value_title", title);
            intent.putExtra("value_id", scoutLogId);
            getActivity().startActivity(intent);
        }


        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.

        }
    }

    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnScoutLogInteractionListener {
        // TODO: Update argument type and name
        public void onScoutLogInteraction(String id);
    }

}

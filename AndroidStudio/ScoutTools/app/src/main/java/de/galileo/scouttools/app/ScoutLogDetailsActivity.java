package de.galileo.scouttools.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class ScoutLogDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_log_details);
        String title = getIntent().getStringExtra("value_title");
        long scoutLogId = getIntent().getLongExtra("value_id", 0);
        Log.d("SCOUTLOG", title);
        EditText editTextTitle = (EditText) findViewById(R.id.scoutlog_details_title);
        editTextTitle.setText(title);
        ScoutLogDetailsFragment scoutLogDetailsFragment =
                (ScoutLogDetailsFragment) getFragmentManager().findFragmentById(R.id.scoutlog_details_fragment);
        scoutLogDetailsFragment.setArgs(title, scoutLogId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

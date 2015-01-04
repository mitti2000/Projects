package de.galileo.scouttools.app;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link ScoutLogDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ScoutLogDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM_ID = "param_id";


    private String mParam1;
    private long mParamId;
    private File imageFile;



    public static ScoutLogDetailsFragment newInstance(String param1, long param2) {
        ScoutLogDetailsFragment fragment = new ScoutLogDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putLong(ARG_PARAM_ID, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ScoutLogDetailsFragment() {
        // Required empty public constructor
    }

    public void setArgs(String title, long scoutLogId) {
        mParam1 = title;
        mParamId = scoutLogId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParamId = getArguments().getLong(ARG_PARAM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scout_log_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextTitle = (EditText) view.findViewById(R.id.scoutlog_details_title);
        editTextTitle.setText(mParam1);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.scoutlog_details, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_camera) {
            startCamera();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imageFolder = new File( Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM);
        imageFile = new File(imageFolder, mParam1 + Long.toString(mParamId) + ".jpg");
        Uri uriImage = Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriImage);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == getActivity().RESULT_OK ) {
            Log.d("CAMERA", imageFile.toString() );
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            ImageView imageViewDetail = (ImageView) getView().findViewById(R.id.scoutlog_details_image);
            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
            imageViewDetail.setImageBitmap(bitmap);
        }
    }


}

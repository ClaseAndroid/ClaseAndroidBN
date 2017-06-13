package com.capacitacion.project.appclase5.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.capacitacion.project.appclase5.R;
import com.capacitacion.project.appclase5.view.OnFragmentInteractionListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VersionAndroidFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VersionAndroidFragment#} factory method to
 * create an instance of this fragment.
 */
public class VersionAndroidFragment extends Fragment {

    private static final String ARG_PARAM1 = "nameVersion";
    private static final String ARG_PARAM2 = "imageVersion";

    @Bind(R.id.tviTitle) TextView tviTile;
    @Bind(R.id.iviAndroid) ImageView iviAndroid;

    private OnFragmentInteractionListener mListener;
    private String nameVersion;
    private int imageVersion;

    public VersionAndroidFragment() {
        // Required empty public constructor
    }

    public static VersionAndroidFragment newInstanceOne(String nameVersion, int imageVersion) {
        VersionAndroidFragment fragment = new VersionAndroidFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nameVersion);
        args.putInt(ARG_PARAM2, imageVersion);
        fragment.setArguments(args);
        return fragment;
    }

    public static VersionAndroidFragment newInstanceTwo(String nameVersion, int imageVersion) {
        VersionAndroidFragment fragment = new VersionAndroidFragment();
        fragment.imageVersion = imageVersion;
        fragment.nameVersion = nameVersion;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nameVersion = getArguments().getString(ARG_PARAM1);
            imageVersion = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_version_android, container, false);
        ButterKnife.bind(this, view);
        initUI();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void initUI(){

    }

    private void loadData(){

        tviTile.setText(nameVersion);
        iviAndroid.setImageResource(imageVersion);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}

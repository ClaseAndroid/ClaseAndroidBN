package com.project.jebus.appsolar.ui.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.project.jebus.appsolar.R;
import com.project.jebus.appsolar.model.UserEntity;
import com.project.jebus.appsolar.model.VideoEntity;
import com.project.jebus.appsolar.model.VideoResponse;
import com.project.jebus.appsolar.presenter.ListVideoPresenter;
import com.project.jebus.appsolar.storage.AppSolarPreferences;
import com.project.jebus.appsolar.ui.adapter.CityExpandableAdapter;
import com.project.jebus.appsolar.ui.adapter.VideoAdapter;
import com.project.jebus.appsolar.ui.coreJebus.AnimationJebus;
import com.project.jebus.appsolar.ui.coreJebus.BaseJebusCompatActivity;
import com.project.jebus.appsolar.ui.coreJebus.CircleTransform;
import com.project.jebus.appsolar.ui.coreJebus.ScreenUtilsJebus;
import com.project.jebus.appsolar.ui.view.ListVideoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListVideoActivity extends BaseJebusCompatActivity implements ListVideoView, ExpandableListView.OnChildClickListener, AnimationJebus.OnAnimationJebusListener {

    private static final int INDEX_ANIMATION_OPEN = 1001;
    private static final int INDEX_ANIMATION_CLOSE = 1002;

    @Bind(R.id.rviVideo) RecyclerView rviVideo;
    @Bind(R.id.incLoading) View incLoading;
    @Bind(R.id.vKitkat) View vKitkat;
    @Bind(R.id.spnCountry) Spinner spnCountry;
    @Bind(R.id.elviCity) ExpandableListView elviCity;
    @Bind(R.id.tviCity) TextView tviCity;
    @Bind(R.id.rlaContentCity) View rlaContentCity;
    @Bind(R.id.rlaContentSpinnerCity) View rlaContentSpinnerCity;
    @Bind(R.id.iviUserFacebook) ImageView iviUserFacebook;

    private ListVideoPresenter listVideoPresenter;
    private int citySelect = 0;
    private String urlProfile = "";

    private String city[];
    private List<VideoEntity> videoEntityList = new ArrayList<>();
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private AnimationJebus animationJebus;
    private int height = 0;
    private int width = 0;
    private UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);
        ButterKnife.bind(this);

        initUI();
        loadData();
    }

    private void initUI(){
        Display display = getWindowManager().getDefaultDisplay();
        height = display.getHeight();
        width = display.getWidth();
        animationJebus = new AnimationJebus(this);
        rviVideo.setHasFixedSize(true);
        rviVideo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        validateVersion();

        elviCity.getLayoutParams().width = width/2 + ScreenUtilsJebus.dpToPx(25);
    }

    private void loadData(){

        city = getResources().getStringArray(R.array.array_city);
        listVideoPresenter = new ListVideoPresenter(this);
        userEntity = AppSolarPreferences.getUser(ListVideoActivity.this);

        ArrayAdapter<String> spinnerArrayAdapterCountry = new ArrayAdapter<>(this, R.layout.simple_spinner_item, getResources().getStringArray(R.array.array_country)); //selected item will look like a spinner set from XML
        spinnerArrayAdapterCountry.setDropDownViewResource(R.layout.simple_spinner_down_item);
        spnCountry.setAdapter(spinnerArrayAdapterCountry);

        prepareListData();
        elviCity.setAdapter(new CityExpandableAdapter(this, listDataHeader, listDataChild));
        elviCity.setOnChildClickListener(this);

        rlaContentCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rlaContentSpinnerCity.getVisibility() == View.GONE)
                    animationJebus.setAlphaAnimation(rlaContentSpinnerCity, 0, 1, 300, INDEX_ANIMATION_OPEN);
                else
                    animationJebus.setAlphaAnimation(rlaContentSpinnerCity, 1, 0, 300, INDEX_ANIMATION_CLOSE);
            }
        });

        rlaContentSpinnerCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rlaContentSpinnerCity.getVisibility() == View.VISIBLE){
                    animationJebus.setAlphaAnimation(rlaContentSpinnerCity, 1, 0, 300, INDEX_ANIMATION_CLOSE);
                }
            }
        });

        incLoading.setVisibility(View.VISIBLE);
        String key = getString(R.string.token_youtube);
        String part = "snippet";
        String q = getString(R.string.musica_peru);
        tviCity.setText(getString(R.string.ciudad));
        int maxResults = 50;
        String regionCode = "PE";
        videoEntityList.clear();
        listVideoPresenter.serviceGetListVideo(key, part, q, maxResults, regionCode);


        loadDataProfile();
    }

    private void loadDataProfile(){
        try{
            String url = "http://graph.facebook.com/"+userEntity.getIdFacebook()+"/picture?type=large";
            Picasso.with(ListVideoActivity.this).load(url).transform(new CircleTransform()).into(iviUserFacebook);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding headers
        String[] headers = getResources().getStringArray(R.array.array_city);
        listDataHeader = Arrays.asList(headers);

        listDataChild.put(listDataHeader.get(0),  Arrays.asList(getResources().getStringArray(R.array.array_amazonas))); // Header, Child data
        listDataChild.put(listDataHeader.get(1),  Arrays.asList(getResources().getStringArray(R.array.array_ancash))); // Header, Child data
        listDataChild.put(listDataHeader.get(2),  Arrays.asList(getResources().getStringArray(R.array.array_apurimac))); // Header, Child data
        listDataChild.put(listDataHeader.get(3),  Arrays.asList(getResources().getStringArray(R.array.array_arequipa))); // Header, Child data
        listDataChild.put(listDataHeader.get(4),  Arrays.asList(getResources().getStringArray(R.array.array_ayacucho))); // Header, Child data
        listDataChild.put(listDataHeader.get(5),  Arrays.asList(getResources().getStringArray(R.array.array_cajamarca))); // Header, Child data
        listDataChild.put(listDataHeader.get(6),  Arrays.asList(getResources().getStringArray(R.array.array_callao))); // Header, Child data
        listDataChild.put(listDataHeader.get(7),  Arrays.asList(getResources().getStringArray(R.array.array_cusco))); // Header, Child data
        listDataChild.put(listDataHeader.get(8),  Arrays.asList(getResources().getStringArray(R.array.array_huancavelica))); // Header, Child data
        listDataChild.put(listDataHeader.get(9),  Arrays.asList(getResources().getStringArray(R.array.array_huanuco))); // Header, Child data
        listDataChild.put(listDataHeader.get(10),  Arrays.asList(getResources().getStringArray(R.array.array_ica))); // Header, Child data
        listDataChild.put(listDataHeader.get(11),  Arrays.asList(getResources().getStringArray(R.array.array_junin))); // Header, Child data
        listDataChild.put(listDataHeader.get(12),  Arrays.asList(getResources().getStringArray(R.array.array_la_libertad))); // Header, Child data
        listDataChild.put(listDataHeader.get(13),  Arrays.asList(getResources().getStringArray(R.array.array_lambayeque))); // Header, Child data
        listDataChild.put(listDataHeader.get(14),  Arrays.asList(getResources().getStringArray(R.array.array_lima))); // Header, Child data
        listDataChild.put(listDataHeader.get(15),  Arrays.asList(getResources().getStringArray(R.array.array_loreto))); // Header, Child data
        listDataChild.put(listDataHeader.get(16),  Arrays.asList(getResources().getStringArray(R.array.array_madre_de_dios))); // Header, Child data
        listDataChild.put(listDataHeader.get(17),  Arrays.asList(getResources().getStringArray(R.array.array_moquegua))); // Header, Child data
        listDataChild.put(listDataHeader.get(18),  Arrays.asList(getResources().getStringArray(R.array.array_pasco))); // Header, Child data
        listDataChild.put(listDataHeader.get(19),  Arrays.asList(getResources().getStringArray(R.array.array_piura))); // Header, Child data
        listDataChild.put(listDataHeader.get(20),  Arrays.asList(getResources().getStringArray(R.array.array_puno))); // Header, Child data
        listDataChild.put(listDataHeader.get(21),  Arrays.asList(getResources().getStringArray(R.array.array_san_martin))); // Header, Child data
        listDataChild.put(listDataHeader.get(22),  Arrays.asList(getResources().getStringArray(R.array.array_tacna))); // Header, Child data
        listDataChild.put(listDataHeader.get(23),  Arrays.asList(getResources().getStringArray(R.array.array_tumbes))); // Header, Child data
        listDataChild.put(listDataHeader.get(24),  Arrays.asList(getResources().getStringArray(R.array.array_ucayali))); // Header, Child data

    }

    private void validateVersion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            vKitkat.setVisibility(View.VISIBLE);
            vKitkat.setPadding(0, 0, 0, ScreenUtilsJebus.dpToPx(24));
        } else{
            vKitkat.setVisibility(View.GONE);
        }
    }

    @Override
    public void serviceResult(Object object, int type) {
        incLoading.setVisibility(View.GONE);
        try{
            VideoResponse videoResponse = (VideoResponse) object;
            if(videoResponse != null){
                videoEntityList = videoResponse.getItems();

                VideoAdapter videoAdapter = new VideoAdapter(ListVideoActivity.this, videoEntityList);
                rviVideo.setAdapter(videoAdapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void serviceError(Object object, int type) {
        incLoading.setVisibility(View.GONE);

    }

    @Override
    public Context getViewContext() {
        return ListVideoActivity.this;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        citySelect = childPosition;
        incLoading.setVisibility(View.VISIBLE);
        String key = getString(R.string.token_youtube);
        String part = "snippet";
        //String q = city[citySelect] + " musica";
        String q = listDataChild.get(city[groupPosition]).get(childPosition) + " musica";
        tviCity.setText(listDataChild.get(city[groupPosition]).get(childPosition));
        int maxResults = 50;
        String regionCode = "PE";
        videoEntityList.clear();
        listVideoPresenter.serviceGetListVideo(key, part, q, maxResults, regionCode);
        animationJebus.setAlphaAnimation(rlaContentSpinnerCity, 1, 0, 300, INDEX_ANIMATION_CLOSE);
        return false;
    }

    @Override
    public void onAnimationStart(int index, View view) {
        rlaContentSpinnerCity.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(int index, View view) {
        switch (index){
            case INDEX_ANIMATION_OPEN: rlaContentSpinnerCity.setVisibility(View.VISIBLE);break;
            case INDEX_ANIMATION_CLOSE: rlaContentSpinnerCity.setVisibility(View.GONE);break;
        }
    }

    @Override
    public void onAnimationCancel(int index) {

    }

    @Override
    public void onAnimationRepeat(int index) {

    }


}

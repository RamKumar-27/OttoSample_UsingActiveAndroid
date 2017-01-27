package com.otto.hp_pc.ottosample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.otto.hp_pc.ottosample.MyApplication;
import com.otto.hp_pc.ottosample.OttoModel;
import com.otto.hp_pc.ottosample.R;
import com.otto.hp_pc.ottosample.adapter.ListAdapter;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.data_list)
    ListView mDataList;
    @BindView(R.id.add_data)
    ImageView mAddData;
    ListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_to);
        ButterKnife.bind(this);
        MyApplication.getBusInstance().register(this);
        getDatasFromDb();
    }

    private void getDatasFromDb() {
        List<OttoModel> mList = OttoModel.getAllDatas();
        if (mList.size() != 0 && mList != null)
            setDataToList(mList);
        else
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_LONG).show();
    }

    private void setDataToList(final List<OttoModel> mList) {
        mAdapter = new ListAdapter(MainActivity.this, mList);
        mDataList.setAdapter(mAdapter);
        mDataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, UpdateDataActivity.class);
                intent.putExtra("id", mList.get(i).getmId());
                startActivity(intent);

            }
        });
    }

    @Subscribe
    public void getAllData(OttoModel mModel) {
        List<OttoModel> mList = mModel.getAllDatas();
        if (mList.size() != 0 && mList != null)
            setDataToList(mList);
        else
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.add_data)
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, SendDataActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getBusInstance().unregister(this);
    }
}

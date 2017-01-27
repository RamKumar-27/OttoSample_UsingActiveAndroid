package com.otto.hp_pc.ottosample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.otto.hp_pc.ottosample.MyApplication;
import com.otto.hp_pc.ottosample.OttoModel;
import com.otto.hp_pc.ottosample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateDataActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.edt_name)
    EditText mNameEdtTxt;
    @BindView(R.id.edt_age)
    EditText mAgeEdtTxt;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_update)
    @Override
    public void onClick(View view) {
        OttoModel.updateDataById(getIntent().getExtras().getInt("id"),mNameEdtTxt.getText().toString(), mAgeEdtTxt.getText().toString());
        MyApplication.getBusInstance().post(new OttoModel());
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyApplication.getBusInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getBusInstance().unregister(this);
    }
}

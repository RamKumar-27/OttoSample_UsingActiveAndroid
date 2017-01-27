package com.otto.hp_pc.ottosample;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by HP-PC on 25-01-2017.
 */

public class OttoModel extends Model {
    @Column(name = "Sno")
    public int mId;

    @Column(name = "Name")
    public String name;

    @Column(name = "Age")
    public String age;

    public OttoModel(int id, String name, String age) {
        this.mId = id;
        this.name = name;
        this.age = age;
    }


    public OttoModel() {
        super();
    }


    public static void saveAllDatas(String name, String age) {
        ActiveAndroid.beginTransaction();
        try {
            OttoModel mModel = new OttoModel(getAllDatas().size(), name, age);
            mModel.save();
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
    public static void updateDataById(int id,String name,String age){
        new Update(OttoModel.class).set("Name=? , Age=?",name,age).where("Sno=?",id).execute();
    }

    public static List<OttoModel> getAllDatas() {
        return new Select().from(OttoModel.class).execute();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}

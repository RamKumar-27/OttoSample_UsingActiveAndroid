package com.otto.hp_pc.ottosample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.otto.hp_pc.ottosample.OttoModel;
import com.otto.hp_pc.ottosample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP-PC on 25-01-2017.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<OttoModel> mList = new ArrayList<>();

    public ListAdapter(Context context, List<OttoModel> mList) {
        this.context = context;
        this.mList = mList;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = layoutInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.name.setText(mList.get(i).getName());
        holder.age.setText(mList.get(i).getAge());
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.age)
        TextView age;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

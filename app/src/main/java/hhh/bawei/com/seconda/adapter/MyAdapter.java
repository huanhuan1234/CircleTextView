package hhh.bawei.com.seconda.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import hhh.bawei.com.seconda.R;

/**
 * Created by Administrator on 2017/6/10 0010.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return View.inflate(mContext, R.layout.list_item, null);
    }

    static class ViewHolder {

        TextView textContent;
        TextView textTitle;
    }
}

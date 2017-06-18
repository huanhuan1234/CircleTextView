package hhh.bawei.com.seconda.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hhh.bawei.com.seconda.R;
import hhh.bawei.com.seconda.bean.WeekBean;


public class MainAdapter extends BaseAdapter {
    Context context;
    List<WeekBean.ResultBean.DataBean> list;

    public MainAdapter(Context context, List<WeekBean.ResultBean.DataBean> list) {

        this.context=context;
        this.list=list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        VHOne vh;
        if (convertView==null){
            vh=new VHOne();
            convertView=View.inflate(context, R.layout.xlv_item,null);
            vh.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            vh.tv_sum = (TextView) convertView.findViewById(R.id.tv_sum);

            convertView.setTag(vh);
        }else {
           vh= (VHOne) convertView.getTag();
        }
        vh.tv_title.setText(list.get(i).getUpdatetime());
        vh.tv_sum.setText(list.get(i).getContent());

        return convertView;
    }
    class VHOne{
        TextView tv_title;
        TextView tv_sum;
    }
}

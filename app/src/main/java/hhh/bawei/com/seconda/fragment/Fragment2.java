package hhh.bawei.com.seconda.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import hhh.bawei.com.seconda.adapter.MainAdapter;
import hhh.bawei.com.seconda.R;
import hhh.bawei.com.seconda.bean.WeekBean;
import hhh.bawei.com.seconda.xListView.XListView;

/**
 * Created by Huangminghuan on 2017/6/18.
 */

public class Fragment2 extends Fragment implements XListView.IXListViewListener{

    private XListView xlv;

    private MainAdapter adapter;
    private int page=1;
    private int pagesize=5;
    private List<WeekBean.ResultBean.DataBean> list=new ArrayList<WeekBean.ResultBean.DataBean>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2,container,false);
        xlv = (XListView) view.findViewById(R.id.xListView);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        xlv.setPullRefreshEnable(true);
        xlv.setPullLoadEnable(true);
        xlv.setXListViewListener(this);

        // 1.进行网络请求得到数据(10)
        RequestParams params = new RequestParams("http://japi.juhe.cn/joke/content/list.from?key=94fbc7ec2262160140d71e1418322f34%20&page=" + page + "&pagesize=" + pagesize + "&sort=asc&time=1418745237");

        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {

                // 6:使用GSON  解析(15)
                WeekBean newsBean = JSON.parseObject(result, WeekBean.class);
//                2.将json 数据解析装进list集合(10)
                list.addAll(newsBean.getResult().getData());

                //创建适配器 3:更新listview成功(10)
                adapter = new MainAdapter(getActivity(), list);

                xlv.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
//  4:下啦刷新成功(10)


    @Override
    public void onRefresh() {

        page++;
        pagesize++;
        RequestParams params = new RequestParams("http://japi.juhe.cn/joke/content/list.from?key=94fbc7ec2262160140d71e1418322f34%20&page=" + page++ + "&pagesize=" + pagesize++ + "&sort=asc&time=1418745237");

        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {

                list.clear();
                // 6:使用GSON  解析(15)
                WeekBean newsBean = JSON.parseObject(result, WeekBean.class);
//                2.将json 数据解析装进list集合(10)
                list.addAll(newsBean.getResult().getData());

                //创建适配器 3:更新listview成功(10)
                adapter = new MainAdapter(getActivity(), list);

                xlv.setAdapter(adapter);
                xlv.setRefreshTime("刚刚");
                xlv.stopRefresh();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    //5:上拉加载成功(10)
    @Override
    public void onLoadMore() {
        RequestParams params = new RequestParams("http://japi.juhe.cn/joke/content/list.from?key=94fbc7ec2262160140d71e1418322f34%20&page=" + page + "&pagesize=" + pagesize + "&sort=asc&time=1418745237");

        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {

                // 6:使用GSON  解析(15)
                WeekBean newsBean = JSON.parseObject(result, WeekBean.class);
//                2.将json 数据解析装进list集合(10)
                list.addAll(newsBean.getResult().getData());

                adapter.notifyDataSetChanged();
                xlv.stopLoadMore();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}

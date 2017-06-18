package hhh.bawei.com.seconda;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import hhh.bawei.com.seconda.adapter.ViewPagerAdapter;

/**
 * Created by Huangminghuan on 2017/6/17.
 */

public class TwoActivity extends FragmentActivity {

    private ViewPager viewpager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        init();

    }

    private void init() {

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);


       /* viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(adapter.getCount()-1);*/
        //让viewpager和tablayout关联起来
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewpager);
        //选中何为选中的状态变色字体变色
        tablayout.setTabTextColors(Color.GRAY, Color.BLACK);
        //设置指示行的颜色
        tablayout.setSelectedTabIndicatorColor(Color.RED);

        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
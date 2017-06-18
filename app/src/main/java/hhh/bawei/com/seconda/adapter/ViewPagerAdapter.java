package hhh.bawei.com.seconda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hhh.bawei.com.seconda.fragment.Fragment1;
import hhh.bawei.com.seconda.fragment.Fragment2;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    String[] aa = new String[]{"新闻", "国内", "本社介绍", "履行职能", "自我建设", "第六页", "第七页"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position % 2 == 0) {
        fragment = new Fragment1();
        }else {
            fragment = new Fragment2();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return aa.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return aa[position];
    }
}
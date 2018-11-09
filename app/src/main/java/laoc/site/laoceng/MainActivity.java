package laoc.site.laoceng;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.*;

import java.util.ArrayList;
import java.util.List;

import laoc.site.laoceng.adapter.FindAdapter;
import laoc.site.laoceng.view.ConFragment;
import laoc.site.laoceng.view.JiangFragment;
import laoc.site.laoceng.view.ShuoFragment;

public class MainActivity extends AppCompatActivity{

    private TabLayout tab_find_fragment_title;
    private ViewPager tab_find_fragment_find_fragment;

    // 容器列表
    private List<Fragment> fragmentList = new ArrayList<>();
    // 标题列表
    private List<String> titleList = new ArrayList<>();

    private FindAdapter findAdapter;

    private boolean isRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        tab_find_fragment_title = (TabLayout)findViewById(R.id.tab_find_fragment_title);
        tab_find_fragment_find_fragment = (ViewPager)findViewById(R.id.tab_find_fragment_find_fragment);

        titleList.add("演讲");
        titleList.add("小说");
        titleList.add("新闻");

        for(int i = 0;i < titleList.size();i++){
            tab_find_fragment_title.addTab(tab_find_fragment_title.newTab().setText(titleList.get(i)));
        }

        //tab_find_fragment_title.setupWithViewPager(tab_find_fragment_find_fragment);



        fragmentList.add(new ConFragment());
        fragmentList.add(new ShuoFragment());
        fragmentList.add(new JiangFragment());

        findAdapter = new FindAdapter(getSupportFragmentManager(),titleList,fragmentList);
        tab_find_fragment_find_fragment.setAdapter(findAdapter);

        tab_find_fragment_title.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab_find_fragment_find_fragment.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tab_find_fragment_find_fragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab2 = tab_find_fragment_title.getTabAt(position);
                if (!(null == tab2))
                    tab2.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

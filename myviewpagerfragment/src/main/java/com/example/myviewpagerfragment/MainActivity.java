package com.example.myviewpagerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG ="KIN" ;
    ViewPager2 viewPager;
    private LinearLayout llChat,llContacts,llFind,llProfile;

    private ImageView ivChat,ivContacts,ivFind,ivProfile,ivCur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initTabView();
    }

    private void initTabView() {
        llChat = findViewById(R.id.id_tab_weixin);
        llChat.setOnClickListener(this);
        llContacts = findViewById(R.id.id_tab_tongxing);
        llContacts.setOnClickListener(this);
        llFind  = findViewById(R.id.id_tab_friend);
        llFind.setOnClickListener(this);
        llProfile = findViewById(R.id.id_tab_me);
        llProfile.setOnClickListener(this);

        ivChat = findViewById(R.id.tab_iv_weixin);
        ivContacts = findViewById(R.id.tab_iv_tongxing);
        ivFind = findViewById(R.id.tab_iv_friend);
        ivProfile = findViewById(R.id.tab_iv_me);

        ivChat.setSelected(true);
        ivCur = ivChat;

    }

    private void initPager() {
        viewPager = findViewById(R.id.viewp);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment1.newInstance("微信聊天",null));
        fragments.add(BlankFragment1.newInstance("通讯录",null));
        fragments.add(BlankFragment1.newInstance("朋友圈",null));
        fragments.add(BlankFragment1.newInstance("我的",null));
        MyFragementPagerAdapter myFragementPagerAdapter = new MyFragementPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(myFragementPagerAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changePage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changePage(int position) {
        switch(position)
        {
            case R.id.id_tab_weixin:
                Log.e(TAG, "onClick: tab_iv_weixin 1");
                viewPager.setCurrentItem(0);
            case 0:
                ivCur.setSelected(false);
                ivCur = ivChat;
                ivChat.setSelected(true);
                break;
            case R.id.id_tab_tongxing:
                Log.e(TAG, "onClick: tongxing 1" );
                viewPager.setCurrentItem(1);
            case 1:
                ivCur.setSelected(false);
                ivCur = ivContacts;
                ivContacts.setSelected(true);
                break;
            case R.id.id_tab_friend:
                Log.e(TAG, "onClick: frend 1" );
                viewPager.setCurrentItem(2);
            case 2:
                ivCur.setSelected(false);
                ivCur = ivFind;
                ivFind.setSelected(true);
                break;
            case R.id.id_tab_me:
                Log.e(TAG, "onClick: me1");
                viewPager.setCurrentItem(3);
            case 3:
                ivCur.setSelected(false);
                ivCur = ivProfile;
                ivProfile.setSelected(true);
                break;

        }
    }

    @Override
    public void onClick(View v) {
       switch(v.getId())
       {
           case R.id.id_tab_weixin:
                Log.e(TAG, "onClick: tab_iv_weixin ");
               break;
           case R.id.id_tab_tongxing:
               Log.e(TAG, "onClick: tongxing" );
               break;
           case R.id.id_tab_friend:
               Log.e(TAG, "onClick: frend" );
                break;
           case R.id.id_tab_me:
               Log.e(TAG, "onClick: me");
                break;

        }
        changePage(v.getId());
    }
}
package com.lpd.fragmentanim;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnShowFrag;
    private Button mBtnHideFrag;
    private FragmentManager fragmentManager;
    private AnimFragment animFrag;
    private AnimSecondFragment animFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnShowFrag = (Button) findViewById(R.id.id_show_frag);
        mBtnHideFrag = (Button) findViewById(R.id.id_hide_frag);

        mBtnShowFrag.setOnClickListener(this);
        mBtnHideFrag.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        animFrag = new AnimFragment();
        animFrag2 = new AnimSecondFragment();
        transaction.add(R.id.id_fram, animFrag2);
        transaction.add(R.id.id_fram, animFrag);
        transaction.commit();

    }

    @Override
    public void onClick(View v) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_in, R.anim.anim_out);
        //显示
        if (v == mBtnShowFrag) {

            transaction.show(animFrag);
            transaction.hide(animFrag2);
        }
        //隐藏
        else if (v == mBtnHideFrag) {

            transaction.hide(animFrag);
            transaction.show(animFrag2);
        }

        transaction.commit();


    }
}

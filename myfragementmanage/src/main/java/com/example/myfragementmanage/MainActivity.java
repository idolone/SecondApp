package com.example.myfragementmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.cbtn);
        bt1.setOnClickListener(this);

        Button bt2 = findViewById(R.id.rbtn);
        bt2.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.cbtn:
                //replaceFragement(new BlankFragment1());
                Bundle bundle = new Bundle();
                bundle.putString("message","i love u");
                BlankFragment1 bf1 = new BlankFragment1();
                bf1.setArguments(bundle);

                bf1.setFragmentCallback(new iFragmentCallback() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "I'm from Activity";
                    }
                });




                replaceFragement(bf1);

                break;
            case R.id.rbtn:
                replaceFragement(new ItemFragment());
                break;
        }

    }

    private void replaceFragement(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frm,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
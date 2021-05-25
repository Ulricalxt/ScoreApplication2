package com.example.scoreapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.scoreapplication2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private ActivityMainBinding mBinding;
    private int scoreA,scoreB,saveA,saveB;
    private final String KEY ="key";
    private final String SP_A="sp_a";
    private final String SP_B="sp_b";
    private final String MY_SP="my_sp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        if (savedInstanceState!=null){
            int[] i = savedInstanceState.getIntArray(KEY);
            scoreA= i[0];
            scoreB= i[1];
            saveA = i[2];
            saveB = i[3];

        }else {init();}
        readSP();
        show();


        mBinding.buttonAAdd1.setOnClickListener(v ->{
            addA(1);
        });
        mBinding.buttonAAdd2.setOnClickListener(v ->{
            addA(2);
        });
        mBinding.buttonAAdd3.setOnClickListener(v ->{
            addA(3);
        });
        mBinding.buttonBAdd1.setOnClickListener(v ->{
            addB(1);
        });
        mBinding.buttonBAdd2.setOnClickListener(v ->{
            addB(2);
        });
        mBinding.buttonBAdd3.setOnClickListener(v ->{
            addB(3);
        });
        mBinding.imageButtonReset.setOnClickListener(V ->{
            reset();
        });
        mBinding.imageButtonRevoke.setOnClickListener(v ->{
            revoke();

        });




    }
    /**
     * 给A队加分 i要加的分数
     * @param i 要加的分数
     * */
    public void addA(int i){
        save();
        scoreA += i;
        mBinding.textScoreA.setText(String.valueOf(i));
        show();

    }
    /**
     * 给B队加分 i要加的分数
     * @param i 要加的分数
     * */
    public void addB(int i){
        save();
        scoreB += i;
        mBinding.textScoreB.setText(String.valueOf(i));
        show();

    }
    /**
     * 清除
     * */
    public void reset(){
        save();
        scoreA = 0;
        scoreB = 0;
        show();

    }
    /**
     *撤回
     * */
    public void revoke(){
        scoreA = saveA;
        scoreB = saveB;
        show();

    }

    /**
     *保存数据
     * */
    public void save(){
        saveA= Integer.parseInt(mBinding.textScoreA.getText().toString());
        saveB= Integer.parseInt(mBinding.textScoreB.getText().toString());

    }
    /**
     *显示数据
     * */
    public void show(){
        mBinding.textScoreA.setText(String.valueOf(scoreA));
        mBinding.textScoreB.setText(String.valueOf(scoreB));
    }
    /**
     *
     *消除bag
     *
     * */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(KEY,new int[]{scoreA,scoreB,saveA,saveB});
    }
    private void init(){
        scoreA=0;
        scoreB=0;
        saveA=0;
        saveB=0;
        show();
    }
    /**
     *存储数据
     * */
    private void writeSP() {
        SharedPreferences.Editor sp =getSharedPreferences( MY_SP,MODE_PRIVATE).edit();
        sp.putInt(SP_A,scoreA);
        sp.putInt(SP_B,scoreB);
        sp.apply();
    }

    private  void readSP(){
        SharedPreferences sp=getSharedPreferences( MY_SP,MODE_PRIVATE);
        scoreA = sp.getInt(SP_A,0);
        scoreB = sp.getInt(SP_B,0);
    }
    /**
     *读取数据
     * */
    @Override
    protected void onPause() {
        super.onPause();
        writeSP();
        Log.i(TAG,"onPause()， 界面离开前台，可能可见但不能交互");
    }
}
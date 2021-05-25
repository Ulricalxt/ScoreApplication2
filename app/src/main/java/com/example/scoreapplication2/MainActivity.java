package com.example.scoreapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

        }
        else {}
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
     *保存数据
     * */
    public void save(){
        saveA= Integer.parseInt(mBinding.textScoreA.getText().toString());
        saveA= Integer.parseInt(mBinding.textScoreA.getText().toString());

    }
    /**
     *显示数据
     * */
    public void show(){
        mBinding.textScoreA.setText(String.valueOf(scoreA));
        mBinding.textScoreB.setText(String.valueOf(scoreB));
    }
}
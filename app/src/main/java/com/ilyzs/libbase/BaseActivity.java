package com.ilyzs.libbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ilyzs.libbase.util.WaitDialog;

/**
 * Created by zs ...
 */

public abstract class BaseActivity extends AppCompatActivity {

    private WaitDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPara();
        loadView();
        loadData();
        waitDialog = new WaitDialog(this,R.style.WaitDialog);
    }

    public abstract void initPara();
    public abstract void loadView();
    public abstract void loadData();

    public void waitDialogShow(){
        waitDialog.show();
    }

    public void waitDialogDismiss(){
        if(null!=waitDialog){
            waitDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null!=waitDialog){
            waitDialog.dismiss();
        }
    }
}

package com.ilyzs.libbase.util;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ilyzs.libbase.R;

/**
 * Created by zs .
 */

public class WaitDialog extends Dialog {

    private Animation anim;
    private Context context;
    private ImageView loadingIv;

    public WaitDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        anim = AnimationUtils.loadAnimation(this.getContext(),
                R.anim.rotate_repeat);
        anim.setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.PROGRESS_VISIBILITY_ON);
        super.onCreate(savedInstanceState);

        loadingIv = new ImageView(context);
        loadingIv.setImageResource(R.drawable.loading_icon);// 加载中的图片,建议圆形的
        loadingIv.setLayoutParams(new ViewGroup.LayoutParams(50,50));
        // 布局
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;

        addContentView(loadingIv, lp);

        setCanceledOnTouchOutside(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 按下了键盘上返回按钮
            this.hide();
            return true;
        }
        return false;
    }


    @Override
    public void show() {
        super.show();
        loadingIv.startAnimation(anim);
    }
}

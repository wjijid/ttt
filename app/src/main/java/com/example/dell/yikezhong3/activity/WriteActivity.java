package com.example.dell.yikezhong3.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.dell.yikezhong3.R;

public class WriteActivity extends AppCompatActivity {

    private EditText etContent;
    private View popupWindow;
    private PopupWindow mPopupWindow;
    private android.os.Handler mHandler = new android.os.Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        etContent= (EditText) findViewById(R.id.etContent);
        popupWindow=getLayoutInflater().inflate(R.layout.layout_popwindow,new LinearLayout(this),false);
        mPopupWindow = new PopupWindow(popupWindow, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        etContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mPopupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
                mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }, 500);
                mPopupWindow.showAtLocation(WriteActivity.this.findViewById(R.id.line), Gravity.BOTTOM, 0, 0);
            }
        });


    }
}

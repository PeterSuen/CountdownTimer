package com.google.peter.countdowntimer;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private MyCount mc;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.show);
        mc = new MyCount(30000, 1000);
        mc.start();
    }//end func

    /*定义一个倒计时的内部类*/
    class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onFinish() {
            tv.setText("finish");
        }
        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText("请等待30秒(" + millisUntilFinished / 1000 + ")...");
            Toast.makeText(MainActivity.this, millisUntilFinished / 1000 + "", Toast.LENGTH_LONG).show();//toast有显示时间延迟
        }
    }
}

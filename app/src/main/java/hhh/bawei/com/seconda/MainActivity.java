package hhh.bawei.com.seconda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circletextview);

        }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intent);

                break;

            case MotionEvent.ACTION_MOVE:

/*
                //重画  主线程调用刷新
                invalidate();
                //子线程  调用刷新
//                postInvalidate();*/

                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        return true;

    }
        }

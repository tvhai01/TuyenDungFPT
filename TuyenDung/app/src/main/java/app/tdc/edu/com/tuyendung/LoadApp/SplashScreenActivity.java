package app.tdc.edu.com.tuyendung.LoadApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import app.tdc.edu.com.tuyendung.R;
import app.tdc.edu.com.tuyendung.SearchActiviry;



import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashScreenActivity extends Activity {

    Handler handler =  new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imgBlue = (ImageView) findViewById(R.id.imgBlue);
        final TextView txtRemove = (TextView) findViewById(R.id.txtRemove);
        final TextView txtControl = (TextView) findViewById(R.id.txtControl);
        final TextView txtEnd = (TextView) findViewById(R.id.txtend);
        // chuyen dong ben phai
        final Animation slideright = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.slider_right);
        // chuyen dong ben trai
        final Animation slideleft = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.slider_left);
        // chuyen dong lên icon
        Animation slideup = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.slider_up);
        // chuyen dong len chu
        final Animation slideup2 = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.slider_up);

        txtControl.setVisibility(View.INVISIBLE);
        txtRemove.setVisibility(View.INVISIBLE);
        txtEnd.setVisibility(View.INVISIBLE);
        imgBlue.startAnimation(slideup);
        slideup.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //chuyen dong tu ben trai
                txtRemove.startAnimation(slideleft);
                //hien len
                txtRemove.setVisibility(View.VISIBLE);
                txtControl.startAnimation(slideright);
                txtControl.setVisibility(View.VISIBLE);
                slideright.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        txtEnd.startAnimation(slideup2);
                        txtEnd.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        goNextActivity();
    }
    //chuyen layout
    public void goNextActivity(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SearchActiviry.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}

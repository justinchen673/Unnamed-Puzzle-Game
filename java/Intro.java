package com.integraloftan.justin.puzzlegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;


public class Intro extends Activity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setWindowAnimations(0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        imageView = (ImageView) findViewById(R.id.iv);
        int imagesToShow[] = {R.drawable.logo};
        animate(imageView, imagesToShow, 0, false);
    }
    private void animate(final ImageView imageView, final int images[], final int imageIndex, final boolean forever) {
        int fadeInDuration = 700;
        imageView.setVisibility(View.INVISIBLE);
        imageView.setImageResource(images[imageIndex]);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(fadeInDuration);
        AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(fadeIn);
        animation.setRepeatCount(1);
        imageView.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (images.length - 1 > imageIndex) {
                    animate(imageView, images, imageIndex + 1,forever);
                }
                else {
                    if (forever == true){
                        animate(imageView, images, 0,forever);
                    }
                    change();
                }
            }
            public void onAnimationRepeat(Animation animation) {
            }
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void change() {
        synchronized (this) {
            try {
                wait(800);
            } catch (InterruptedException e) {
            }
        }
        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_intro, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

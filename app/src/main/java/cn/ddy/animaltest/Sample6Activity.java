package cn.ddy.animaltest;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.dd.StrokeGradientDrawable;


/**
 * Progress Padding Sample
 */
public class Sample6Activity extends Activity {
    private ImageView imageView;

    public static void startThisActivity(Activity activity) {
        activity.startActivity(new Intent(activity, Sample6Activity.class));
    }
    private StrokeGradientDrawable background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sample_6);
        imageView = (ImageView) findViewById(R.id.imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                background=  createDrawable(ContextCompat.getColor(Sample6Activity.this,R.color.cpb_green));
//                iv.setImageDrawable(background.getGradientDrawable());
//
//                //颜色渐变
//                ObjectAnimator bgColorAnimation = ObjectAnimator.ofInt(background, "color", ContextCompat.getColor(Sample6Activity.this,R.color.cpb_blue),  ContextCompat.getColor(Sample6Activity.this,R.color.cpb_red));
//                bgColorAnimation.setDuration(2000);
//                bgColorAnimation.setEvaluator(new ArgbEvaluator());
//                bgColorAnimation.setTarget(iv);
//                bgColorAnimation.start();

                //加载属性动画需要用到AnimatorInflater类

                ObjectAnimator oa = (ObjectAnimator) AnimatorInflater

                        .loadAnimator(Sample6Activity.this, R.animator.ani);

                //用于动画计算的需要，如果开始和结束的值不是基本类型的时候，这个方法是需要的。

                oa.setEvaluator(new ArgbEvaluator());



                //设置动画的设置目标

                oa.setTarget(imageView);



                oa.start();
            }
        },500);


    }

    private StrokeGradientDrawable createDrawable(int color) {
        GradientDrawable drawable = (GradientDrawable) getResources().getDrawable(R.drawable.cpb_background).mutate();
        drawable.setColor(color);
        drawable.setCornerRadius(3);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(drawable);
        strokeGradientDrawable.setStrokeColor(color);
        strokeGradientDrawable.setStrokeWidth(3);

        return strokeGradientDrawable;
    }
}

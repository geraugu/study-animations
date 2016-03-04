package com.example.testes.animations;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.FlipHorizontalToAnimation;
import com.easyandroidanimations.library.HighlightAnimation;
import com.easyandroidanimations.library.PathAnimation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CardView card1 = (CardView)findViewById(R.id.card);
        final CardView card2 = (CardView)findViewById(R.id.card2);



        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FlipHorizontalToAnimation(card1).setFlipToView(card2)
                        .setInterpolator(new LinearInterpolator()).animate();
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FlipHorizontalToAnimation(card2).setFlipToView(card1)
                        .setInterpolator(new LinearInterpolator())
                        .setListener(new AnimationListener() {
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                new HighlightAnimation(card1)
                                        .setListener(new AnimationListener() {
                                            @Override
                                            public void onAnimationEnd(Animation animation) {
                                                ArrayList<Point> points = new ArrayList<>();
                                                points.add(new Point(0, 100));
                                                points.add(new Point(50, 0));
                                                points.add(new Point(100, 100));
                                                points.add(new Point(0, 50));
                                                points.add(new Point(100, 50));
                                                points.add(new Point(0, 100));
                                                points.add(new Point(50, 50));
                                                TextView text = (TextView)findViewById(R.id.textView1);
                                                new PathAnimation(text).setPoints(points).setDuration(2000)
                                                        .animate();
                                            }
                                        }).animate();

                            }
                        }).animate();
            }
        });


    }
}

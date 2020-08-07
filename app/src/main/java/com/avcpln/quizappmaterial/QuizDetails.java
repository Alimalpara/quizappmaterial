package com.avcpln.quizappmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuizDetails extends AppCompatActivity {
CircleImageView imageView;
ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_details);
        imageView1=findViewById(R.id.circleImageView);
    }

}

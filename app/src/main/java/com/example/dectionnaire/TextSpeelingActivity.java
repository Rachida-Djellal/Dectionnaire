package com.example.dectionnaire;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class TextSpeelingActivity  extends AppCompatActivity implements View.OnClickListener {
    VideoView vid;
    MediaController m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textspeeling);

        TextView def = findViewById(R.id.definition);
        ImageView img = findViewById(R.id.imageView);
        Button btn_video = findViewById(R.id.videobutton);
        vid = (VideoView)findViewById(R.id.videoView);
        def.setText(getIntent().getStringExtra("wordDef"));
        img.setImageResource(getIntent().getIntExtra("wordImage",0));
      btn_video.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.videobutton:
              playVideo(view);
        }
    }
    public void playVideo(View v) {
        MediaController m = new MediaController(this);
        vid.setMediaController(m);

       // String path = "Users/Djallal/AndroidStudioProjects/tdm2/Dectionnaire/app/src/main/res/raw/v.mp4";
        String path = "android.resource://com.example.dectionnaire/"+R.raw.video;

        Uri u = Uri.parse(path);

        vid.setVideoURI(u);

        vid.start();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

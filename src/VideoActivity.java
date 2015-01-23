/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 */

package com.manu.videoplayer;

import android.os.Bundle;
import android.app.Activity;
import com.manu.videoplayer.FakeR;
import android.widget.VideoView;
import android.net.Uri; 
import android.widget.TextView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.os.Handler;
import android.widget.LinearLayout;

public class VideoActivity extends Activity {

	private FakeR fakeR;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_new);
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
        fakeR = new FakeR(this);
        setContentView(fakeR.getId("layout", "activity_new"));
		
		int btnId = fakeR.getId("id", "back_btn");
		Button backBtn = (Button) findViewById(btnId);
		backBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		playVideo1();
	}

    private void playVideo1(){
		
		int desiredWidth = getIntent().getIntExtra("WIDTH", 300);
        int desiredHeight = getIntent().getIntExtra("HEIGHT", 200);
		
		int vid = fakeR.getId("id", "video1");
		VideoView videoView = (VideoView) findViewById(vid);
		LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(desiredWidth, desiredHeight);
		videoView.setLayoutParams(p);
		
		
		videoView.setVideoURI(Uri.parse("http://techslides.com/demos/sample-videos/small.mp4"));
		videoView.start();
    }

    

}

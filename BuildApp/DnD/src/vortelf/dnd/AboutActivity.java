package vortelf.dnd;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.GestureDetector;



public class AboutActivity extends ActionBarActivity implements OnClickListener, OnTouchListener {
	
	
	ImageView Image;
	Button Rotor;
	static boolean Active;
	private static final String DEBUG_TAG = "";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);
        Image = (ImageView) findViewById(R.id.logo);
        Image.setOnTouchListener(new OnTouchListener() {
//            public void onClick(View v) {
//                rollingDiceThrow();
//            }

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				rollingDiceThrow();
				Log.d(DEBUG_TAG,"TouchEvent OK");
				return false;
			}

        });


		Active = true;
		Rotor = (Button)findViewById(R.id.Rotor);
		Rotor.setOnClickListener(this);
    
    }


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu., menu)
		getMenuInflater().inflate(R.menu.global, menu);
		return true;
	}

	@Override	
	public boolean onOptionsItemSelected(MenuItem item){
		//Intent AboutIntent = new Intent(this, AboutActivity.class);
		Intent CustomCharIntent = new Intent(this, CustomCharActivity.class);
		Intent RandomCharIntent = new Intent(this, RandomCharActivity.class);
		switch(item.getItemId()){
			case R.id.action_random_catacter : if(RandomCharActivity.Active) setResult(RESULT_OK, RandomCharIntent); else startActivity(RandomCharIntent);break;
			case R.id.action_custom_catacter : startActivityForResult(CustomCharIntent, RESULT_OK);break;
		default:
			return super.onOptionsItemSelected(item);
		}
	    return true;
	}
	
	
private void rollingDiceThrow() {
		
		Dice D20 = new Dice(20);
		int RND = (int) (Math.random() * 2);
		Toast Critical = Toast.makeText(this, "Critical Hit!", Toast.LENGTH_LONG);
		Toast Fail = Toast.makeText(this, "Critical Failure!", Toast.LENGTH_LONG);
		switch(D20.rollDice()) {
			case 1:Image.setImageResource(R.drawable.d1);Fail.show();break;
			case 2:Image.setImageResource(R.drawable.d2);break;
			case 3:Image.setImageResource(R.drawable.d3);break;case 4:Image.setImageResource(R.drawable.d4);break;
			case 5:Image.setImageResource(R.drawable.d5);break;case 6:Image.setImageResource(R.drawable.d6);break;
			case 7:Image.setImageResource(R.drawable.d7);break;case 8:Image.setImageResource(R.drawable.d8);break;
			case 9:Image.setImageResource(R.drawable.d9);break;case 10:Image.setImageResource(R.drawable.d10);break;
			case 11:Image.setImageResource(R.drawable.d11);break;case 12:Image.setImageResource(R.drawable.d12);break;
			case 13:Image.setImageResource(R.drawable.d13);break;case 14:Image.setImageResource(R.drawable.d14);break;
			case 15:Image.setImageResource(R.drawable.d15);break;case 16:Image.setImageResource(R.drawable.d16);break;
			case 17:Image.setImageResource(R.drawable.d17);break;case 18:Image.setImageResource(R.drawable.d18);break;
			case 19:Image.setImageResource(R.drawable.d19);break;
			case 20:Image.setImageResource(R.drawable.d20);Critical.show();break;
			default: Image.setImageResource(R.drawable.d1);
	        }
		Animation Spin = null ;
        
		
		switch(RND) {
			case 0: Spin = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
	        break;
			case 1: Spin = AnimationUtils.loadAnimation(this, R.anim.anim_bounce);
		}
		
       // final Animation Spin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anim);
        Image.startAnimation(Spin);
	}
	
	
	@Override
	public void onStop(){
		super.onStop();
		Active = false;
	}


	@Override
	public void onClick(View v) {
//		if(v.getId() == Image.getId()) {
//			rollingDiceThrow();
//		}
	}



	@Override
	public boolean onTouch(View v, MotionEvent event) {

		return false;
	}
	

}

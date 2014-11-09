package vortelf.dnd;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutActivity extends ActionBarActivity implements OnClickListener{

	ImageView Image;
	Button Rotor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);
        Image = (ImageView) findViewById(R.id.logo);
		Image.setOnClickListener(this);
		
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
		Intent AboutIntent = new Intent(getApplicationContext(), AboutActivity.class);
		Intent CustomCharIntent = new Intent(getApplicationContext(), CustomCharActivity.class);
		Intent RandomCharIntent = new Intent(getApplicationContext(), RandomCharActivity.class);
		switch(item.getItemId()){
			case R.id.action_random_catacter : startActivityForResult(RandomCharIntent, 0);break;
			case R.id.action_custom_catacter : startActivityForResult(CustomCharIntent, 0);break;
			case R.id.action_about : startActivityForResult(AboutIntent, 0);break;
		}
	    return true;
	}
	

	@Override
	public void onClick(View v) {
		ImageView EE  = (ImageView)findViewById(R.id.logo);
		Toast Critical = Toast.makeText(this, "Critical Hit!", Toast.LENGTH_LONG);
		Toast Fail = Toast.makeText(this, "Critical Failure!", Toast.LENGTH_LONG);
		
        final Animation myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anim);
        Image.startAnimation(myRotation);
		if(v.getId() == Image.getId()) {
			Dice D20 = new Dice(20);
			switch(D20.rollDice()) {
				case 1:EE.setImageResource(R.drawable.d1);Fail.show();break;
				case 2:EE.setImageResource(R.drawable.d2);break;
				case 3:EE.setImageResource(R.drawable.d3);break;case 4:EE.setImageResource(R.drawable.d4);break;
				case 5:EE.setImageResource(R.drawable.d5);break;case 6:EE.setImageResource(R.drawable.d6);break;
				case 7:EE.setImageResource(R.drawable.d7);break;case 8:EE.setImageResource(R.drawable.d8);break;
				case 9:EE.setImageResource(R.drawable.d9);break;case 10:EE.setImageResource(R.drawable.d10);break;
				case 11:EE.setImageResource(R.drawable.d11);break;case 12:EE.setImageResource(R.drawable.d12);break;
				case 13:EE.setImageResource(R.drawable.d13);break;case 14:EE.setImageResource(R.drawable.d14);break;
				case 15:EE.setImageResource(R.drawable.d15);break;case 16:EE.setImageResource(R.drawable.d16);break;
				case 17:EE.setImageResource(R.drawable.d17);break;case 18:EE.setImageResource(R.drawable.d18);break;
				case 19:EE.setImageResource(R.drawable.d19);break;
				case 20:EE.setImageResource(R.drawable.d20);Critical.show();break;
			}
		}
	}
}

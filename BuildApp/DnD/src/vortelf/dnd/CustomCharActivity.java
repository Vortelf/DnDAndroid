package vortelf.dnd;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomCharActivity extends ActionBarActivity implements OnClickListener {
	
	EditText CharacterName;
	EditText CharacterRace;
	EditText CharacterClass;
	TextView OutInput;
	Button Submit;
	String IN;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_custom_char);
		Submit = (Button) findViewById(R.id.CustomCharSubmit);
		CharacterName = (EditText) findViewById(R.id.CharacterName);
		CharacterRace = (EditText) findViewById(R.id.CharacterRace);
		CharacterClass = (EditText) findViewById(R.id.CharacterClass);
		OutInput = (TextView) findViewById(R.id.OutInput);
		IN = CharacterName.getText().toString() + " " + CharacterRace.getText().toString() + " " + CharacterClass.getText().toString();
		
		
		CharacterName.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                	Submit.performClick();
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(CharacterName.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        });
		CharacterRace.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Submit.performClick();
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(CharacterRace.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        });
		CharacterClass.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Submit.performClick();
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(CharacterClass.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        });
		
		Submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Toast Critical = Toast.makeText(this,"Critical Hit!", Toast.LENGTH_LONG);
    			OutInput.setText(IN.toString());
    			
    			//Critical.show();
            }
        });
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
			case R.id.action_random_catacter : startActivity(RandomCharIntent);break;
			case R.id.action_custom_catacter : startActivity(CustomCharIntent);break;
			case R.id.action_about : startActivity(AboutIntent);break;
		}
	    return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == Submit.getId()){
			OutInput.setText(IN.toString());
			//Toast Test = Toast.(this, "Critical Hit!", Toast.LENGTH_LONG);
			//Test.show();
		}
		// TODO Auto-generated method stub
		
	}
}
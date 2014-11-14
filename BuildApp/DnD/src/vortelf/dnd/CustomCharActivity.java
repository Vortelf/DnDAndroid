package vortelf.dnd;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import vortelf.dnd.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher.ViewFactory;

@SuppressWarnings("unused")
public class CustomCharActivity extends ActionBarActivity implements OnClickListener, OnItemSelectedListener {
	

	EditText CharacterName;
	EditText CharacterRace;
	EditText CharacterClass;
	TextView OutInput;
	Button Submit;
	String IN;
	Dice D6 = new Dice();
	static boolean Active = false;
	Spinner STRDropdown, DEXDropdown, CONDropdown,
			INTDropdown,WISDropdown,CHADropdown;
	String[] StatString = {"1", "2","1", "2","1", "2"};
	//int[] StatValHolder = new int[]{18, 11, 12, 14, 10,6};
	String[] StatStringBackup;
	ArrayList<Integer> StatValHolder = new ArrayList<Integer>(6);
	ArrayList<Integer> StatValHolderBackup = new ArrayList<Integer>(6);
	int prevPos;
	int prevPoped = 0;
	private static final String DEBUG_TAG = "";	
	
	
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
		
		
		StatRoll();
		StatValHolderBackup = StatValHolder;
		StatStringBackup = StatString;
		Active = true;
		
		
		Spinner STRDropdow = (Spinner) findViewById(R.id.str_dropdown);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
			        this, R.layout.custom_layout, StatStringBackup);
		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 STRDropdow.setAdapter(adapter);
		 
		 Spinner DEXDropdow = (Spinner) findViewById(R.id.dex_dropdown);
//		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		 DEXDropdow.setAdapter(adapter);
//		 
		 Spinner CONDropdow = (Spinner) findViewById(R.id.con_dropdown);
//		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		 CONDropdow.setAdapter(adapter);
//		 
//		 Spinner INTDropdow = (Spinner) findViewById(R.id.int_dropdown);
//		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		 INTDropdow.setAdapter(adapter);
//		 
//		 Spinner WISDropdow = (Spinner) findViewById(R.id.wis_dropdown);
//		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		 WISDropdow.setAdapter(adapter);
//		 
//		 Spinner CHADropdow = (Spinner) findViewById(R.id.cha_dropdown);
//		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		 CHADropdow.setAdapter(adapter);
//		 
		
		
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
		
		
		//Submit.setOnClickListener(this);
		
		
		//Spinner Listen
		
		STRDropdow.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		    	if(prevPos != position){
			    	Object item = parentView.getItemAtPosition(position);
			    	String[] tempSTR = popNextStats(position,Integer.valueOf((String) item));
			    	Spinner DEXDropdow = (Spinner) findViewById(R.id.dex_dropdown);
			    	ArrayAdapter<String> dex_adapter = new ArrayAdapter<String>(CustomCharActivity.this, R.layout.custom_layout, tempSTR);
			    	dex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					DEXDropdow.setAdapter(dex_adapter);
					Submit.setText(Arrays.toString(tempSTR));
		    	}
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {
		        
		    }

		});
		
		
		DEXDropdow.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		    	if(prevPos != position){
			    	Object item = parentView.getItemAtPosition(position);
			    	String[] tempSTR = popNextStats(position,Integer.valueOf((String) item));
			    	Spinner CONDropdow = (Spinner) findViewById(R.id.dex_dropdown);
			    	ArrayAdapter<String> con_adapter = new ArrayAdapter<String>(CustomCharActivity.this, R.layout.custom_layout, tempSTR);
			    	con_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					CONDropdow.setAdapter(con_adapter);
		    	}
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {
		        
		    }

		});
		
		//Spinner Listen
		
		Submit.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	Toast Critical = Toast.makeText(getApplicationContext(),"Critical Hit!", Toast.LENGTH_LONG);
				
				CharacterCreate();
				OutInput.setText(IN.toString());
				Critical.show();
	    
	        }
	    });
	}
	
	public void CharacterCreate() {
		IN = CharacterName.getText().toString() + " " + CharacterRace.getText().toString() + " " + CharacterClass.getText().toString();
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
		//Intent CustomCharIntent = new Intent(getApplicationContext(), CustomCharActivity.class);
		Intent RandomCharIntent = new Intent(getApplicationContext(), RandomCharActivity.class);
		switch(item.getItemId()){
			case R.id.action_random_catacter : if(RandomCharActivity.Active) setResult(RESULT_OK, RandomCharIntent); else startActivity(RandomCharIntent);break;
			case R.id.action_about :if(AboutActivity.Active) setResult(RESULT_OK, AboutIntent); else startActivity(AboutIntent);break;
			default:
				return super.onOptionsItemSelected(item);
		}
	    return true;
	}
	
	
	
	void StatRoll(){
		for(int i = 0; i < 6; i++)
			StatValHolder.add(D6.RollForStatus()) ;
		Collections.sort(StatValHolder);
		int i = 0;
		for(Integer number : StatValHolder)
			StatString[i++] = "" + number;
	}
	
	 //TODO Fix the list, it's getting empty, it have to restore the previously removed data
	
	String[] popNextStats(int PopStatPos,int popedInt){
		prevPos = PopStatPos;
		
		StatValHolder.remove(PopStatPos);
		//StatValHolder.add(10);
		Log.d(DEBUG_TAG, "List Size = " + StatValHolder.size());
		if(prevPoped != 0)
			StatValHolder.add(prevPoped);
		Collections.sort(StatValHolder);
		int i = 0;
		for(Integer number : StatValHolder)
			StatString[i++] = "" + number;
		
		prevPoped = popedInt;
		Toast Critical = Toast.makeText(getApplicationContext(),"Is the list empty: " + StatValHolder.size(), Toast.LENGTH_SHORT);

  	
    	Critical.show();
		return StatString;
		
		// new class 2 variables - int value & boolean picked
	}
	
	
	
	@Override
	public void onClick(View v) {
		if(v.getId() == Submit.getId()){
			
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
    @Override
    public void onStop() {
       super.onStop();
       Active = false;
    }
}

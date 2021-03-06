package vortelf.dnd;


import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


@SuppressWarnings("unused")
public class RandomCharActivity extends ActionBarActivity implements OnClickListener{
	
	TextView CharName;
	//TextView DiceRoll;
	TextView Stats;
	TextView AbilityMod;
	TextView RaceNClass;
	TextView SkillsFH;
	TextView SkillsSH;
	TextView Level;
	EditText inputCharName;
	Button Button;
	//Button Switch;
	static boolean Active;
	
	static final String STATE_SCORE = "playerScore";
	static final String STATE_LEVEL = "playerLevel";
	int mCurrentScore;
	int mCurrentLevel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_random_char);
		Active = true;
		//DiceRoll = (TextView) findViewById(R.id.Roller);
		CharName = (TextView) findViewById(R.id.CharName);
		Level = (TextView) findViewById(R.id.Level);
		Stats = (TextView) findViewById(R.id.CharStats);
		AbilityMod = (TextView) findViewById(R.id.AbiMod);
		RaceNClass = (TextView) findViewById(R.id.RaceNClass);
		SkillsFH = (TextView) findViewById(R.id.CharSkillsFH);
		SkillsSH = (TextView) findViewById(R.id.CharSkillsSH);
		
	
		
		if (savedInstanceState != null) {
	        // Restore value of members from saved state
	        int mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
	        int mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
	    } 

		
		
		Button = (Button) findViewById(R.id.RandomButton);
		//Switch = (Button) findViewById(R.id.SwitchActivity);
		inputCharName = (EditText) findViewById(R.id.inputCharName);
		
		inputCharName.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Button.performClick();
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(inputCharName.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        });
		
		Button.setOnClickListener(this);
		//Switch.setOnClickListener(this);
	
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	    // Always call the superclass so it can restore the view hierarchy
	    super.onRestoreInstanceState(savedInstanceState);
	   
	    // Restore state members from saved instance
	    mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
	    mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
	}
	

	public void onStart(Bundle savedInstanceState){
		super.onStart();
		onRestoreInstanceState(savedInstanceState); 
	}
	
	public void CharacterCreate() {
		Character Cha = new Character();
		String Name = inputCharName.getText().toString();
		Cha = Cha.RandomCharacterGenerator(Name);
		String STRINGA = new String();
		//Dice D20 = new Dice(20);
		//DiceRoll.setText(String.valueOf(D20.rollDice()));
		CharName.setText(Cha.Name);
		Level.setText("Level " + String.valueOf(Cha.Level));
		Stats.setText(Cha.Stats.Strength + " Strength\n" + Cha.Stats.Dexterity + " Dexterity\n"
				+ Cha.Stats.Constitution + " Constitution\n" + Cha.Stats.Intelligence + " Intelligence\n"
				+ Cha.Stats.Wisdom + " Wisdom\n" + Cha.Stats.Charisma + " Charisma\n");
		AbilityMod.setText(Cha.AM.STRMod + " STRMOD\n" + Cha.AM.DEXMod +  " DEXMOD\n"
				+ Cha.AM.CONMod + " CONMOD\n" + Cha.AM.INTMod + " INTMOD\n"
				+ Cha.AM.WISMod + " WISMOD\n" + Cha.AM.CHAMod + " CHAMOD\n");
		String[] Class = Cha.Class.getClass().getName().split("vortelf.dnd.");
		String[] Race = Cha.Race.getClass().getName().split("vortelf.dnd.");
		RaceNClass.setText(Race[Race.length - 1] + " " + Class[Class.length - 1]);
		
		for(int i = 0; i < Cha.Class.Skills.length / 2; i++)
			STRINGA += Cha.Class.Skills[i].SkillName + " " + Cha.Class.Skills[i].SkillVal + "\n";
		SkillsFH.setText(STRINGA);
		
		STRINGA = new String();
		
		for(int i = Cha.Class.Skills.length / 2; i < Cha.Class.Skills.length; i++)
			STRINGA += Cha.Class.Skills[i].SkillName + " " + Cha.Class.Skills[i].SkillVal + "\n";
		SkillsSH.setText(STRINGA);
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
		Intent AboutIntent = new Intent(this, AboutActivity.class);
		Intent CustomCharIntent = new Intent(this, CustomCharActivity.class);
		//Intent RandomCharIntent = new Intent(this, RandomCharActivity.class);
		switch(item.getItemId()){
			case R.id.action_custom_catacter : if(CustomCharActivity.Active) setResult(RESULT_OK, CustomCharIntent); else startActivity(CustomCharIntent);break;
			case R.id.action_about : setResult(RESULT_OK, AboutIntent); finish();break;
		default:
			return super.onOptionsItemSelected(item);
		}
	    return true;
	}
	
	
	@Override
	public void onClick(View v) {
		if(v.getId() == Button.getId()) {

			findViewById(R.id.CharChar).setVisibility(0); //Visible = 0; Invisible = 1; Gone = 2;
			findViewById(R.id.CharSkillsHolder).setVisibility(0);
			CharacterCreate();
		}
		//if(v.getId() == Switch.getId()) {
			//Intent intent = new Intent(this, MainActivity.class); 
			//startActivity(intent);
		//}
	}
	public void onStop(){
		super.onStop();
		Active = false;
	}

}

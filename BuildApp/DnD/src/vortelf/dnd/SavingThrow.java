package vortelf.dnd;


public class SavingThrow {
		//private final AbilityModifiers AbiMod;
		public String Stat;
		public boolean MainST;
		public int ST;
		
		public SavingThrow(String StatName, int AbMod, int ProfBonus) {
			this.Stat = StatName;
			if(MainST == true)
				this.ST = AbMod + ProfBonus;
			else
				this.ST = AbMod;
		}
		public SavingThrow(String StatName, int AbMod, int ProfBonus,boolean isMain) {
			this.Stat = StatName;
			if (isMain) MainST = true;
			if(MainST == true) {
				this.ST = AbMod + ProfBonus; System.out.println(this.Stat + " is main = " + this.MainST);}
			else
				this.ST = AbMod;
			
		}
		
		public SavingThrow() {
			this.MainST = false;
			this.ST = 0;
			this.Stat = "";
		}
		
		public void isMain(boolean Main) {
			this.MainST = Main;
			//System.out.println("Test!" + this.MainST);
		}
	}
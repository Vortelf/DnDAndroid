package src;


public class Dwarf extends Races {
	boolean DarkVision;
	boolean DwarvenResilience;
	boolean DwarvenCombatTraining;
	boolean HillDwarf;
	boolean MountainDwarf;
	
	public Dwarf() {
		Speed = 25;
		Height = 4.7;
		Weight = 143;
		Age = (int) (Math.random()*300 + 50);
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("CON", 2, BonusST);
		DarkVision = true;
		DwarvenResilience = true;
		DwarvenCombatTraining = true;
		MountainDwarf = true;
		
		if(HillDwarf == true && MountainDwarf == false)
			BonusST = BonusST.initBonus("WIS", 1, BonusST);
		else if (HillDwarf == false && MountainDwarf == true)
			BonusST = BonusST.initBonus("STR", 2, BonusST);
		
		System.out.println("ConBonus -> " + this.BonusST.Constitution);
	}
}
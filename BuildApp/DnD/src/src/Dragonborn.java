package src;


public class Dragonborn extends Races {
	boolean DraconicAncestry;
	boolean DamageResistance;
	
	public Dragonborn() {
		Speed = 30;
		Height = 6.4;
		Weight = 233;
		Age = (int) Math.random() * 70 + 15;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("STR", 2, BonusST);
		BonusST = BonusST.initBonus("CHA", 1, BonusST);
		
		DraconicAncestry = true;
		DamageResistance = true;
	}
}

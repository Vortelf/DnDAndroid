package vortelf.dnd;


public class Human extends Races {
	
	public Human() {
		Speed = 30;
		Height = 5.9;
		Weight = 148;
		Age = (int) Math.random() * 80 + 16;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("STR", 1, BonusST);
		BonusST = BonusST.initBonus("DEX", 1, BonusST);
		BonusST = BonusST.initBonus("CON", 1, BonusST);
		BonusST = BonusST.initBonus("INT", 1, BonusST);
		BonusST = BonusST.initBonus("WIS", 1, BonusST);
		BonusST = BonusST.initBonus("CHA", 1, BonusST);
	}
}

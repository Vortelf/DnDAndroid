package vortelf.dnd;


public class Gnome extends Races {
	boolean DarkVision;
	boolean GnomeCunning;
	boolean ForestGnome;
	boolean RockGnome;
	
	
	public Gnome() {
		Speed = 25;
		Height = 2.9;
		Weight = 48;
		Age = (int) Math.random() * 450 + 40;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("INT", 2, BonusST);
		
		DarkVision = true;
		GnomeCunning = true;
		
		if(ForestGnome == true && RockGnome == false)
			BonusST = BonusST.initBonus("DEX", 1, BonusST);
		else if(ForestGnome  == false && RockGnome == true)
			BonusST = BonusST.initBonus("CON", 1, BonusST);
		
	}
}

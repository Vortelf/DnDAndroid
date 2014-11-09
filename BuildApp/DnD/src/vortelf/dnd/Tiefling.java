package vortelf.dnd;


public class Tiefling extends Races {
	boolean Darkvision;
	boolean HellishResistance;
	boolean InfernalLegacy;
	
	public Tiefling() {
		Speed = 30;
		Height = 5.5;
		Weight = 137;
		Age = (int) Math.random() * 85 + 16;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("INT", 1, BonusST);
		BonusST = BonusST.initBonus("CHA", 2, BonusST);
	
		Darkvision = true;
		HellishResistance = true;
		InfernalLegacy = true;
	}

}

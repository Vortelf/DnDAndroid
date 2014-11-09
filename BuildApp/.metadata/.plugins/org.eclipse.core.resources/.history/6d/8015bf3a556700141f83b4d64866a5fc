package src;


public class Elf extends Races{
	boolean DarkVision;
	boolean KeenSencses;
	boolean FeyAncestry;
	boolean Trance;
	
	boolean HighElf;
	boolean WoodElf;
	boolean DarkElf;
	
	public Elf(){
		Speed = 30;
		Height = 5.1;
		Weight = 126;
		Age = (int) Math.random() * 650 + 100;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("DEX", 2, BonusST);
		DarkVision = true;
		KeenSencses = true;
		FeyAncestry = true;
		Trance = true;
		
		WoodElf = true;
		
		if(HighElf == true && WoodElf == false && DarkElf == false)
			BonusST = BonusST.initBonus("INT", 1, BonusST);
		else if(HighElf == false && WoodElf == true && DarkElf == false) {
			BonusST = BonusST.initBonus("WIS", 1, BonusST);
			Speed = 35;
		} else if(HighElf == false && WoodElf == false && DarkElf == true)
			BonusST = BonusST.initBonus("CHA", 1, BonusST);
		
		
	}
}

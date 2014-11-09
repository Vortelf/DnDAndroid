package src;


public class HalfElf extends Races {
	boolean DarkVision;
	boolean FeyAncestry;
	boolean SkillVersatility;
	
	public HalfElf(String[] BST) {
		Speed = 30;
		Height = 5.4;
		Weight = 48;
		Age = (int) Math.random() * 160 + 20;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("CHA", 2, BonusST);
		BonusST = BonusST.initBonus(BST[0], 1, BonusST);
		BonusST = BonusST.initBonus(BST[1], 1, BonusST);
		
		DarkVision = true;
		FeyAncestry = true;
		SkillVersatility = true;
	}
}

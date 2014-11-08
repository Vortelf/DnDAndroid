
public class Halfling extends Races {
	boolean Lucky;
	boolean Brave;
	boolean HalflingNimbleness;
	
	boolean Lightfoot;
	boolean Scout;
	
	
	public Halfling() {
		Speed = 30;
		Height = 2.7;
		Weight = 43;
		Age = (int) Math.random() * 150 + 20;
		BonusST = new Statuses();
		BonusST = BonusST.initBonus("DEX", 2, BonusST);
		Lucky = true;
		Brave = true;
		HalflingNimbleness = true;
		
		Scout = true;
		
		if(Lightfoot == true && Scout == false)
			BonusST = BonusST.initBonus("CHA", 2, BonusST);
		else if(Lightfoot == false && Scout == true)
			BonusST = BonusST.initBonus("CON", 2, BonusST);
	}
}

public class Character {
	public String Name;
	public Classes Class;
	public Races Race;
	public int Background;
	public int Level;
	public int Experience;

	public Dice dX;
	public int Initiative;
	
	public Statuses Stats;
	public AbilityModifiers AM;
	public Skill Skills;
	
	
	public Character() {
		Class = null;
		Race = null;
		Background = 0;
		Level = 0;
		Experience = 0;
		
		Initiative = 0;
		Stats = null;
		AM  = null;
		Skills  = null;
	}
	
	
	public void initCharacter(int STR, int DEX, int CON, int INT, int WIS, int CHA){
		dX = new Dice(20);
		Race = new Tiefling();
		Stats = new Statuses(STR,DEX,CON,INT,WIS,CHA);
		System.out.println("STR Check ->" + Stats.Strength);
		Stats.addBonus(Race.BonusST);
		System.out.println("STR Check ->" + Stats.Strength);
		AM = new AbilityModifiers(Stats);
		String[] SK ={"Survival","Nature","Athletics","Insight"};
		
		Class = new Monk(AM,SK);
	}
	
	
	public Character RandomCharacterGenerator() {
		Dice D20 = new Dice(20);
		Character Random = new Character();
		Random.initCharacter(D20.rollDice(),D20.rollDice(),D20.rollDice(),
				D20.rollDice(),D20.rollDice(),D20.rollDice());

		return Random;
	}
	
	
	public static void main(String[] args) {
		Character Cha = new Character();
		Cha = Cha.RandomCharacterGenerator();
		Cha.Name = "Mycaka";
		System.out.println(Cha.Name);
		System.out.println("Check ->" + Cha.Stats.Wisdom + "!");
		//System.out.println("Check StatBonus work ->" + Cha.Skills.Athletics);
	}
}

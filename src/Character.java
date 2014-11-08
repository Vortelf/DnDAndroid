
public class Character {
	public String Name;
	public Classes Class;
	public Races Race;
	public int Background;
	public int Level;
	public int Experience;

	public int Initiative;
	
	public Statuses Stats;
	public AbilityModifiers AM;
	public Skill Skills;
	
	
	public Character() {
		Name = null;
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
		Race = new Tiefling();
		Stats = new Statuses(STR,DEX,CON,INT,WIS,CHA);
		System.out.println("STR Check ->" + Stats.Strength);
		Stats.addBonus(Race.BonusST);
		System.out.println("STR Check ->" + Stats.Strength);
		AM = new AbilityModifiers(Stats);
		String[] SK ={"Survival","Nature","Athletics","Insight","Performance","Performance","SleightOfHand","Deceptiin","Medicine"};
		
		Class = new Wizard(AM,SK);
	}
	
	
	public Races RandomRace() {
		int RND = (int) ( Math.random()*9 + 1);
		//System.out.println(RND);
		switch(RND){ 
			case 1: return (new Dwarf());
			case 2: return (new Elf());
			case 3: return (new Halfling());
			case 4: return (new Human());
			case 5: return (new Dragonborn());
			case 6: return (new Gnome());
			case 7: String[] BST = {"CON", "WIS"}; return (new HalfElf(BST));
			case 8: return (new HalfOrc());
			case 9: return (new Tiefling());
			default: return (new Human());
		}
	}
	
	public Classes RandomClass(AbilityModifiers AM, String[] SK) {
		int RND = (int) ( Math.random()*12 + 1);
		//System.out.println(RND);
		switch(RND){
			case 1: return (new Barbarian(AM,SK)); 
			case 2: return (new Bard(AM,SK));
			case 3: return (new Cleric(AM,SK));
			case 4: return (new Druid(AM,SK));
			case 5: return (new Fighter(AM,SK));
			case 6: return (new Monk(AM,SK));
			case 7: return (new Paladin(AM,SK));
			case 8: return (new Ranger(AM,SK));
			case 9: return (new Rogue(AM,SK));
			case 10: return (new Sorcerer(AM,SK));
			case 11: return (new Warlock(AM,SK));
			case 12: return (new Wizard(AM,SK));
			default: return(new Classes(AM));
		}
	}
	
	public Character RandomCharacterGenerator(String Name) {
		Dice D6 = new Dice();
		Character Random = new Character();
		Random.Name = Name;
		Random.Race = RandomRace();
		Random.Stats = new Statuses(D6.RollForStatus(),D6.RollForStatus(),D6.RollForStatus(),
				D6.RollForStatus(),D6.RollForStatus(),D6.RollForStatus());
		Random.Stats.addBonus(Random.Race.BonusST);
		Random.AM = new AbilityModifiers(Random.Stats);
		String[] SK = {"Survival","Nature","Athletics","Insight","Performance","Performance","SleightOfHand","Deceptiin","Medicine"};
		
		Random.Class = RandomClass(Random.AM,SK);

		return Random;
	}
	
	
	public static void main(String[] args) {
		Character Cha = new Character();
		Cha = Cha.RandomCharacterGenerator("Mycaka");
		//Cha.Name = "Mycaka";
//		System.out.println(Cha.Name);
//		System.out.println("Check ->" + Cha.Stats.Wisdom + "!");
//		System.out.println("This is " + Cha.Name + " and he is " + Cha.Race.getClass().getName() + " " + Cha.Class.getClass().getName() + "\n" +
//			 "He has "	+ Cha.Stats.Strength + "STR, " + Cha.Stats.Dexterity + "DEX.\n");
//		System.out.println("Check StatBonus work ->" + Cha.Skills.Athletics);
	}
}

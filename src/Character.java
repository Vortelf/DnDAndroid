import java.lang.reflect.Field;

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
		Races RR;
		int RND = (int) Math.random()*9 + 1;
		switch(RND){ 
			case 1: return (RR = new Dwarf());
			case 2: return (RR = new Elf());
			case 3: return (RR = new Halfling());
			case 4: return (RR = new Human());
			case 5: return (RR = new Dragonborn());
			case 6: return (RR = new Gnome());
			case 7: String[] BST = {"CON", "WIS"}; return (RR = new HalfElf(BST));
			case 8: return (RR = new HalfOrc());
			case 9: return (RR = new Tiefling());
			default: return (RR = new Human());
		}
	}
	
	public Classes RandomClass(AbilityModifiers AM, String[] SK) {
		Classes RC;
		int RND = (int) Math.random()*12 + 1;
		switch(RND){
		case 1: return (RC = new Barbarian(AM,SK));
		case 2: return (RC = new Bard(AM,SK));
		case 3: return (RC = new Cleric(AM,SK));
		case 4: return (RC = new Druid(AM,SK));
		case 5: return (RC = new Fighter(AM,SK));
		case 6: return (RC = new Monk(AM,SK));
		case 7: return (RC = new Paladin(AM,SK));
		case 8: return (RC = new Ranger(AM,SK));
		case 9: return (RC = new Rogue(AM,SK));
		case 10: return (RC = new Sorcerer(AM,SK));
		case 11: return (RC = new Warlock(AM,SK));
		case 12: return (RC = new Wizard(AM,SK));
		default: return(RC = new Classes(AM));
		}
	}
	
	public Character RandomCharacterGenerator() {
		Dice D6 = new Dice();
		Character Random = new Character();
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
		Cha = Cha.RandomCharacterGenerator();
		Cha.Name = "Mycaka";
		System.out.println(Cha.Name);
		System.out.println("Check ->" + Cha.Stats.Wisdom + "!");
		//System.out.println("Check StatBonus work ->" + Cha.Skills.Athletics);
	}
}

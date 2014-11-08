

public class Barbarian extends Classes{

	AllSkills[] BS;
	
	public Barbarian(AbilityModifiers AM) {
		super(AM);
		HitDice = new Dice(12);
		PrimaryStatus = "STR";
		this.initSavingThrows();
		this.MainThrow("STR", true);
		this.MainThrow("CON", true);
		this.initSklls();
		
	}

	
	public AllSkills getSkill(AllSkills BS) {
		return BS;
	}
	
//	public void ChooseSkills(int HowMany) {
//		for(int i = 0; i < HowMany; i++)
//		BS = new BarbarianSkills[] {getSkill()}
//	}
}

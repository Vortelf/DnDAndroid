
public class Barbarian extends Classes{
	
	public Skill[] BarbarianSkills;
	public int MainSkillCount;
	
	public Barbarian(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		BarbarianSkills = new Skill[] {
				new Skill("AnimalHandling"),
				new Skill("Athletics"),
				new Skill("Intimidation"),
				new Skill("Nature"),
				new Skill("Perception"),
				new Skill("Survival"),
		};
		MainSkillCount = 2;
		HitDice = new Dice(12);
		PrimaryStatus = "STR";
		this.initSavingThrows();
		this.MainThrow("STR", true);
		this.MainThrow("CON", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, BarbarianSkills);
//		for(int i = 0; i < SkillArr.length; i++ )
//			for(int cnt = 0; cnt < BarbarianSkills.length; cnt++)
//			if(BarbarianSkills[cnt].SkillName == SkillArr[i])
//				this.isSkillMain(SkillArr[i], true);
		
	}
}

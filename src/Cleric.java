
public class Cleric extends Classes{
	public Skill[] ClericSkills;
	
	public Cleric(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		ClericSkills = new Skill[] {
				new Skill("History"),
				new Skill("Insight"),
				new Skill("Medicine"),
				new Skill("Persuasion"),
				new Skill("Religion"),
		};
		MainSkillCount = 2;
		HitDice = new Dice(8);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "WIS";
		this.initSavingThrows();
		this.MainThrow("WIS", true);
		this.MainThrow("CHA", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, ClericSkills, MainSkillCount);
	}

}

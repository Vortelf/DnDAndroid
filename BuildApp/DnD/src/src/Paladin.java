package src;


public class Paladin extends Classes {
	public Skill[] PaladinSkills;
	
	public Paladin(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		PaladinSkills = new Skill[] {
			new Skill("Athletics"),
			new Skill("Insight"),
			new Skill("Intimidation"),
			new Skill("Medicine"),
			new Skill("Persuation"),
			new Skill("Religion"),
		};
		MainSkillCount = 2;
		HitDice = new Dice(10);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "STR";
		this.initSavingThrows();
		this.MainThrow("WIS", true);
		this.MainThrow("CHA", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, PaladinSkills, MainSkillCount);
	}

}

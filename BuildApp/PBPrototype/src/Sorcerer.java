package src;


public class Sorcerer extends Classes {
	
	public Skill[] SorcererSkills;

	public Sorcerer(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		SorcererSkills = new Skill[] {
			new Skill("Arcana"),
			new Skill("Deceptiin"),
			new Skill("Insight"),
			new Skill("Intimidation"),
			new Skill("Persuasion"),
			new Skill("Religion")
		};
		MainSkillCount = 2;
		HitDice = new Dice(6);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "CHA";
		this.initSavingThrows();
		this.MainThrow("CON", true);
		this.MainThrow("CHA", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, SorcererSkills, MainSkillCount);
	}

}

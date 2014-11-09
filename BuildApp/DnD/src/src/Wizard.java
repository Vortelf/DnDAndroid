package src;


public class Wizard extends Classes {
	
	public Skill[] WizardSkills;

	public Wizard(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		WizardSkills = new Skill[] {
			new Skill("Arcana"),
			new Skill("History"),
			new Skill("Insight"),
			new Skill("Investigation"),
			new Skill("Medicine"),
			new Skill("Religion")
		};
		MainSkillCount = 2;
		HitDice = new Dice(6);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "INT";
		this.initSavingThrows();
		this.MainThrow("WIS", true);
		this.MainThrow("CHA", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, WizardSkills, MainSkillCount);
	}

}

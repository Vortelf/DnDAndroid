
public class Bard extends Classes {
	public Skill[] BardSkills;
	
	public Bard(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		BardSkills = new Skill[] {
			new Skill("Acrobatics"),
			new Skill("AnimalHandling"),
			new Skill("Arcana"),
			new Skill("Athletics"),
			new Skill("Deception"),
			new Skill("History"),
			new Skill("Insight"),
			new Skill("Intimidation"),
			new Skill("Investigation"),
			new Skill("Medicine"),
			new Skill("Nature"),
			new Skill("Perception"),
			new Skill("Performance"),
			new Skill("Persuasion"),
			new Skill("Religion"),
			new Skill("SleightOfHand"),
			new Skill("Stealth"),
			new Skill("Survival")
		};
		MainSkillCount = 3;
		HitDice = new Dice(8);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "CHA";
		this.initSavingThrows();
		this.MainThrow("DEX", true);
		this.MainThrow("CHA", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, BardSkills, MainSkillCount);
	}

}

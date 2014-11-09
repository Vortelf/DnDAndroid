package src;


public class Ranger extends Classes{
	public Skill[] RangerSkills;

	public Ranger(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		RangerSkills = new Skill[] {
				new Skill("AnimalHandling"),
				new Skill("Athletics"),
				new Skill("Insight"),
				new Skill("Investigation"),
				new Skill("Nature"),
				new Skill("Perception"),
				new Skill("Stealth"),
				new Skill("Survival")
			};
			MainSkillCount = 3;
			HitDice = new Dice(10);
			HitPoints = HitDice.getDice_type() + AM.CONMod;
			PrimaryStatus = "DEX";
			this.initSavingThrows();
			this.MainThrow("STR", true);
			this.MainThrow("DEX", true);
			this.initSklls();
			EmptyFunctional.checkSkills(SkillArr, RangerSkills, MainSkillCount);
	}

}

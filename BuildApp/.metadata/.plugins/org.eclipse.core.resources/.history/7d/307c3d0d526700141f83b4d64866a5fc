
public class Rogue extends Classes{
	public Skill[] RogueSkills;

	public Rogue(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		RogueSkills = new Skill[] {
				new Skill("Acrobatics"),
				new Skill("Athletics"),
				new Skill("Deceptiin"),
				new Skill("Insight"),
				new Skill("Intimidation"),
				new Skill("Investigation"),
				new Skill("Perception"),
				new Skill("Performance"),
				new Skill("Persuasion"),
				new Skill("SleightOfHand"),
				new Skill("Stealth")
			};
			MainSkillCount = 4;
			HitDice = new Dice(8);
			HitPoints = HitDice.getDice_type() + AM.CONMod;
			PrimaryStatus = "DEX";
			this.initSavingThrows();
			this.MainThrow("INT", true);
			this.MainThrow("DEX", true);
			this.initSklls();
			EmptyFunctional.checkSkills(SkillArr, RogueSkills, MainSkillCount);
	}

}

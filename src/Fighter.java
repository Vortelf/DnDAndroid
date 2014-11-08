
public class Fighter extends Classes {
	public Skill[] FighterSkills;
	
	public Fighter(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		FighterSkills = new Skill[] {
				new Skill("Acrobatics"),
				new Skill("AnimalHandling"),
				new Skill("Athletics"),
				new Skill("History"),
				new Skill("Insight"),
				new Skill("Intimidation"),
				new Skill("Perception"),
				new Skill("Survival")
				};
		MainSkillCount = 2;
		HitDice = new Dice(10);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "STR";
		this.initSavingThrows();
		this.MainThrow("STR", true);
		this.MainThrow("CON", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, FighterSkills, MainSkillCount);

	}
}

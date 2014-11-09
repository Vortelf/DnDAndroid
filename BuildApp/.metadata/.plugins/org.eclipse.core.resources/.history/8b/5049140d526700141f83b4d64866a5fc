
public class Druid extends Classes {
	public Skill[] DruidSkills;
	
	public Druid(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		DruidSkills = new Skill[] {
			new Skill("AnimalHandling"),
			new Skill("Arcana"),
			new Skill("Insight"),
			new Skill("Medicine"),
			new Skill("Nature"),
			new Skill("Perception"),
			new Skill("Religion"),
			new Skill("Survival")
		};
		MainSkillCount = 2;
		HitDice = new Dice(8);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "WIS";
		this.initSavingThrows();
		this.MainThrow("INT", true);
		this.MainThrow("WIS", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, DruidSkills, MainSkillCount);

	}
}

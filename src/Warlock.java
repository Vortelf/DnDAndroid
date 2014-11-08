
public class Warlock extends Classes {
	
	public Skill[] WarlockSkills;

	public Warlock(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		WarlockSkills = new Skill[] {
			new Skill("Arcana"),
			new Skill("Deceptiin"),
			new Skill("History"),
			new Skill("Intimidation"),
			new Skill("Investigation"),
			new Skill("Nature"),
			new Skill("Religion")
		};
		MainSkillCount = 2;
		HitDice = new Dice(8);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		PrimaryStatus = "CHA";
		this.initSavingThrows();
		this.MainThrow("WIS", true);
		this.MainThrow("CHA", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, WarlockSkills, MainSkillCount);
	}

}

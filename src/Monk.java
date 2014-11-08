
public class Monk extends Classes {
	public Skill[] MonkSkills;
	
	public Monk(AbilityModifiers AM, String[] SkillArr) {
		super(AM);
		
		MonkSkills = new Skill[] {
			new Skill("Acrobatics"),
			new Skill("Athletics"),
			new Skill("History"),
			new Skill("Insight"),
			new Skill("Religion"),
			new Skill("Stealth"),
		};
		MainSkillCount = 2;
		HitDice = new Dice(8);
		HitPoints = HitDice.getDice_type() + AM.CONMod;
		this.initSavingThrows();
		this.MainThrow("STR", true);
		this.MainThrow("DEX", true);
		this.initSklls();
		EmptyFunctional.checkSkills(SkillArr, MonkSkills, MainSkillCount);
	}

}

package src;


public class Classes {
	public Dice HitDice;
	public int HitPoints;
	public int TempHitPoints;
	public String PrimaryStatus;
	public SavingThrow[] Throws;
	public int ProficiencyBonus;
	public int Armor;
	public AbilityModifiers AM;
	public Skill[] Skills;
	int MainSkillCount;
	
	public enum AllSkills {
		Acrobatics,	AnimalHandling,	Arcana,	Athletics, Deception, History, Insight,
		Intimidation, Investigation, Medicine, Nature, Perception, Performance,
		Persuasion, Religion, SleightOfHand, Stealth, Survival
	}
	
//	public Classes(AbilityModifiers AbiMod, Skill[] S) {
//		Skills = S;
//		AM = AbiMod;
//	}
	public Classes(AbilityModifiers AM){
		this.AM = AM;
	}
	
	public void initSavingThrows() {
		Throws = new SavingThrow[] {
				new SavingThrow("STR",AM.STRMod,ProficiencyBonus),
				new SavingThrow("DEX",AM.DEXMod,ProficiencyBonus),
				new SavingThrow("CON",AM.CONMod,ProficiencyBonus),
				new SavingThrow("INT",AM.INTMod,ProficiencyBonus),
				new SavingThrow("WIS",AM.WISMod,ProficiencyBonus),
				new SavingThrow("CHA",AM.CHAMod,ProficiencyBonus),
		};
	}
	public void initSklls() {
		Skills = new Skill[] {
				new Skill("Acrobatics",AM.DEXMod,ProficiencyBonus),
				new Skill("AnimalHandling",AM.WISMod,ProficiencyBonus),
				new Skill("Arcana",AM.INTMod,ProficiencyBonus),
				new Skill("Athletics",AM.STRMod,ProficiencyBonus),
				new Skill("Deception",AM.CHAMod,ProficiencyBonus),
				new Skill("History",AM.INTMod,ProficiencyBonus),
				new Skill("Insight",AM.WISMod,ProficiencyBonus),
				new Skill("Intimidation",AM.CHAMod,ProficiencyBonus),
				new Skill("Investigation",AM.INTMod,ProficiencyBonus),
				new Skill("Medicine",AM.WISMod,ProficiencyBonus),
				new Skill("Nature",AM.INTMod,ProficiencyBonus),
				new Skill("Perception",AM.WISMod,ProficiencyBonus),
				new Skill("Performance",AM.CHAMod,ProficiencyBonus),
				new Skill("Persuasion",AM.CHAMod,ProficiencyBonus),
				new Skill("Religion",AM.INTMod,ProficiencyBonus),
				new Skill("SleightOfHand",AM.DEXMod,ProficiencyBonus),
				new Skill("Stealth",AM.DEXMod,ProficiencyBonus),
				new Skill("Survival",AM.WISMod,ProficiencyBonus)
				};
	}
	public void isSkillMain(String Skill, boolean Main) {
		for(int i = 0; i < Skills.length; i++) {
			if(Skills[i].SkillName == Skill)
				Skills[i].isMain(Main);
		}	
	}
	
	public void MainThrow(String Throw, boolean Main) {
		for(int i = 0; i < Throws.length; i++) {
			if(Throws[i].Stat == Throw)
				Throws[i].isMain(Main);
		}	
	}
	
	public void LevelUpHpUP(int AM) {
		this.HitPoints += HitDice.rollDice() + AM;
	}
	
}

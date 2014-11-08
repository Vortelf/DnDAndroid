
public class Skill {
	public String SkillName;
	public int SkillVal;
	public boolean MainSkill;
	
	public Skill(String SkillName, int AbMod, int ProfBonus){
		this.SkillName = SkillName;
		if(MainSkill == true)
			this.SkillVal = AbMod + ProfBonus;
		else
			this.SkillVal = AbMod;
	}
	
	public Skill(String SkillName) {
		this.SkillName = SkillName;
		SkillVal = 0;
		MainSkill = false;
	}
	
	public Skill() {
		SkillName = "";
		SkillVal = 0;
		MainSkill = false;
	}
	
	public void isMain(boolean Main) {
		this.MainSkill = Main;
		System.out.println("MainSkill ->" + this.SkillName);
	}

	
	
}

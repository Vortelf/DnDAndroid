package src;


public class EmptyFunctional {
	
	public static void checkSkills(String[] SkillArr, Skill[] CharacterSkills, int SkillCount){
		int i = 0;
		int SkillsSet = 0;
		while(i < SkillArr.length) {
			for(int cnt = 0; cnt < CharacterSkills.length; cnt++)
				if(CharacterSkills[cnt].SkillName == SkillArr[i])
					if(SkillsSet < SkillCount) {
						if(CharacterSkills[cnt].MainSkill != true){
							CharacterSkills[cnt].isMain(true); SkillsSet++;}
						} else return;
			i++;
		}
	}
}

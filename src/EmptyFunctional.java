
public class EmptyFunctional {
	
	public static void checkSkills(String[] SkillArr, Skill[] CharacterSkills){
		for(int i = 0; i < SkillArr.length; i++ )
			for(int cnt = 0; cnt < CharacterSkills.length; cnt++)
			if(CharacterSkills[cnt].SkillName == SkillArr[i])
				CharacterSkills[cnt].isMain(true);
	}
}

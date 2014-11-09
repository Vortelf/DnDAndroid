package src;


public class AbilityModifiers {
		public Statuses STAT;
		public int STRMod;
		public int DEXMod;
		public int CONMod;
		public int INTMod;
		public int WISMod;
		public int CHAMod;
		
		public AbilityModifiers(Statuses Stats) {
			STAT = Stats;
			this.STRMod = (STAT.Strength - 10) / 2;
			this.DEXMod = (STAT.Dexterity - 10) / 2;
			this.CONMod = (STAT.Constitution - 10) / 2;
			this.INTMod = (STAT.Intelligence - 10) / 2;
			this.WISMod = (STAT.Wisdom - 10) / 2;
			this.CHAMod = (STAT.Charisma - 10) / 2;
		}

	}
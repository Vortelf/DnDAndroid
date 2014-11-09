package src;



public class Statuses {
		public int Strength;
		public int Dexterity;
		public int Constitution;
		public int Intelligence;
		public int Wisdom;
		public int Charisma;
		
		public Statuses(int STR, int DEX, int CON, int INT, int WIS, int CHA) {
			this.Strength = STR;
			this.Dexterity = DEX;
			this.Constitution = CON;
			this.Intelligence = INT;
			this.Wisdom = WIS;
			this.Charisma = CHA;
		}
		
		public Statuses() {
			this.Strength = 0;
			this.Dexterity = 0;
			this.Constitution = 0;
			this.Intelligence = 0;
			this.Wisdom = 0;
			this.Charisma = 0;
		}
		
		public Statuses initBonus(String ST, int Bonus, Statuses Stats) {
			switch(ST) {
				case "STR": Stats.Strength += Bonus; break;
				case "DEX": Stats.Dexterity += Bonus; break;
				case "CON": Stats.Constitution += Bonus; break;
				case "INT": Stats.Intelligence += Bonus; break;
				case "WIS": Stats.Wisdom += Bonus; break;
				case "CHA": Stats.Charisma += Bonus; break;
				default: return Stats;
			}
			return Stats;
		}
		public void addBonus(Statuses Stats) {
			//System.out.println("STR flat ->" + this.Strength + " STR Bonus->" + Stats.Strength);
			this.Strength += Stats.Strength;
			this.Dexterity += Stats.Dexterity;
			this.Constitution += Stats.Constitution;
			this.Intelligence += Stats.Intelligence;
			this.Wisdom += Stats.Wisdom;
			this.Charisma += Stats.Charisma;
		}		
		
	}
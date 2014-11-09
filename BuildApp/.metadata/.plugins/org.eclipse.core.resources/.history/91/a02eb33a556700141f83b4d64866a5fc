package src;

import java.util.Arrays;

//import java.util.Random;


	public class Dice {
		private int Dice_type;
		//private Random rand = new Random();

		public Dice(int Dice_type) {
			this.Dice_type = Dice_type;
			//System.out.println("Dice d" + Dice_type );
		}
		
		public Dice() {
			this.Dice_type = 6;
		}

		public int getDice_type() {
			return Dice_type;
		}

		public void setDice_type(int dice_type) {
			Dice_type = dice_type;
		}

		public int rollDice() {
			if (this.Dice_type == 10) 
				return (int) (Math.random()*Dice_type);
			else if (this.Dice_type == 100)
				return (int)  (Math.random()*Dice_type / 10) * 10;
			else return (int) (Math.random()*Dice_type + 1);
		}

		public int RollForStatus() {
			Dice Normal = new Dice();
			int[] rollKeeper = new int[] {
					Normal.rollDice(),
					Normal.rollDice(),
					Normal.rollDice(),
					Normal.rollDice()
			};
			Arrays.sort(rollKeeper);
			int BestSum = rollKeeper[3] + rollKeeper[2] + rollKeeper[1];
			return BestSum;
		}
		
		static void RollAllDices(Dice[] AllDices) {
			for (int i = 0; i < AllDices.length ;i++ ) {
				//System.out.println("Rolling d" + AllDices[i].Dice_type + "...\nRolled " + AllDices[i].rollDice());
			}
		}

		static Dice[] initDices() {
			Dice[] Dices = new Dice[] {
				new Dice(4),
				new Dice(6),
				new Dice(8),
				new Dice(10),
				new Dice(12),
				new Dice(20),
				new Dice(100),
			};
			return Dices;
		}
		
	}
	

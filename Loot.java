import java.util.Random;

public class Loot {
	
	public static int[] loot_Drops() {
		
		
		Random num = new Random();
		int return_Data [] = new int[3];
		int low = 0, high = 0, loot_Num = 0, potion = 0, gold = 0, key = 0;
		
		for(int counter = 0; counter < 2; counter++) {
			
			low = 1;
			high = 10;
			
			loot_Num = num.nextInt(high - low) + low;
		}
		
		if(loot_Num == 1) {
			
			key = 1;
		}
		else if(loot_Num == 2) {
			
			gold = 10;
		}
		else if(loot_Num == 3) {
			
			potion = 1;
			
		}
		else if(loot_Num == 4) {
			
			key = 1;
		}
		else if(loot_Num == 5) {
			
			gold = 20;
		}
		else if(loot_Num == 6) {
			
			potion = 1;
		}
		else if(loot_Num == 7) {
			
			gold = 50;
		}
		else if(loot_Num == 8) {
			
			gold = 30;
		}
		else if(loot_Num == 9) {
			
			potion = 1;
		}
		else if(loot_Num == 10) {
			
			key = 1;
			potion = 1;
			gold = 10;	
		}
		
		return_Data[0] = key;
		return_Data[1] = potion;
		return_Data[2] = gold;
		
	
		return return_Data;
	
	}

}

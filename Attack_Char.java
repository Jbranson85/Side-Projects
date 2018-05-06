import java.util.Random;

public class Attack_Char {
	
	public static int[] attacking(int chr_Life, int monster_Life, int death) {
		
		int return_Data[] = new int[6];
		int damage_Taken = 0, damage_Given = 0, score = 0;
		monster_Life = 10;
		
		do{
			
			int damage = 0;
			Random num = new Random();
			
			for (int counter  = 0; counter < 1; counter++) {
				
				damage = num.nextInt(10);
				
				if(damage == 0) {
					
					monster_Life -= 1;
					damage_Given++;
					
				}
				else if (damage == 1) {
					
					chr_Life -= 1;
					damage_Taken++;
					
				}
				else if (damage == 2) {
					
					monster_Life -= 1;
					damage_Given++;
					
				}
				else if (damage == 3) {
					
					monster_Life -= 1;
					damage_Given++;
					
				}
				else if (damage == 4) {
					
					chr_Life -= 1;
					damage_Taken++;
					
				}
				else if (damage == 5) {
					
					chr_Life -= 1;
					damage_Taken++;
					
				}
				else if (damage == 6) {
					
					monster_Life -= 1;
					damage_Given++;
					
				}
				else if (damage == 7) {
					
					monster_Life -= 1;
					damage_Given++;
					
				}
				else if (damage == 8) {
					
					monster_Life -= 1;
					damage_Given++;
					
				}
				else if (damage == 9) {
					
					chr_Life -= 1;
					damage_Taken++;
					
				}
			}
			
			
		}while((chr_Life > 0) && (monster_Life > 0)) ;
		
		if(chr_Life < 1) {
			
			death = 1;
			
		}
		
		else if(monster_Life < 1) {
			
			death = 2;
			score = 5000;
			chr_Life += 5;
		}
		
		return_Data[0] = death;
		return_Data[1] = chr_Life;
		return_Data[2] = monster_Life;
		return_Data[3] = damage_Given;
		return_Data[4] = damage_Taken;
		return_Data[5] = score;
		
		return return_Data;
		
	}
	
	

}

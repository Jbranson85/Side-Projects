import java.util.Random;

public class Monster {
	

	
	public static int spawn_Monster(int spawn_Location, double chr_X, double chr_Y, int low, int high) {
		
		Random x = new Random();

		
		if((chr_X == 155) && (chr_Y == 60)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 1;
				high = 4;
			
				//spawn_Location = 2;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 560) && (chr_Y == 195)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 5;
				high = 8;
			
				//spawn_Location = 7;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 425) && (chr_Y == 600)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 9;
				high = 12;
			
				//spawn_Location = 12;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 20) && (chr_Y == 465)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 13;
				high = 15;
			
				//spawn_Location = 12;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 155) && (chr_Y == 195)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 16;
				high = 18;
			
				//spawn_Location = 12;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 425) && (chr_Y == 330)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 19;
				high = 20;
			
				//spawn_Location = 12;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 290) && (chr_Y == 465)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 21;
				high = 22;
			
				//spawn_Location = 12;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		else if((chr_X == 155) && (chr_Y == 330)){
			
			for(int counter = 0; counter < 5; counter++) {
			
				low = 23;
				high = 24;
			
				//spawn_Location = 12;
				spawn_Location = x.nextInt(high - low) + low;
				
			}
		}
		
		
		return spawn_Location;
		
	}

}

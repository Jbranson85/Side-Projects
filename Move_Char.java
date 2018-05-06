
public class Move_Char {
	
	public static double moving_W (double chr_Y, double chr_X) {
		
		if (chr_Y > 60) {
			
			if((chr_X != 425) && (chr_X != 290) && (chr_X != 155) &&
			   (chr_X != 20)|| (chr_Y != 195)) {
				
				chr_Y -= 135;
			}
		}
		return chr_Y;	
	}
	
	public static double moving_D(double chr_Y, double chr_X) {
		
		if (chr_X < 560) {
			
			chr_X += 135;
		}
		return chr_X;
	}
	
	public static double moving_S(double chr_Y, double chr_X) {
		
		if(chr_Y < 600) {
			
			if ((chr_X != 20) && (chr_X != 155) && (chr_X != 290) && 
				(chr_X != 425) || (chr_Y != 60)) {
				
				chr_Y += 135;
			}
		}
		return chr_Y;
	}
	
	public static double moving_A(double chr_Y, double chr_X) {
		
		if(chr_X > 20) {
			
			chr_X -= 135;
		}
		
		return chr_X;
		
	}

}

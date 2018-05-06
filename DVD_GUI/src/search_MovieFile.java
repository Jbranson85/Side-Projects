
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class search_MovieFile {
	
	public static Boolean search_ForMovie(String input_Search) throws IOException {
		
		BufferedReader scan_File;
		
		Boolean found = null;
		
		scan_File = new BufferedReader(new FileReader("Movies.txt"));
		
		File file = new File("Movies.txt");
		
		if(file.length() == 0) {
			
			found = false;
			
		}
		
		String search_Movies = "";
		
		while((search_Movies = scan_File.readLine()) != null) {
			
			if (search_Movies.equals(input_Search)) {
				
				found = true;
				break;
			}
			
			else {
				
				found = false;
			}
		}
		
		scan_File.close();
		return found;
	}

}

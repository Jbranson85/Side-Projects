
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class DVD_Main {
	
	public static void main(String[] args) throws Exception{
		
		
		
		System.out.println("Enter DVD Title");
		
		//Getting user input to include full input
		BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
		String dvd_input = user_input.readLine();//Getting user input
		String output_File = "input.txt";//File to write too
		
		//Adding new DVDs to list
		BufferedWriter writer = new BufferedWriter(new FileWriter(output_File, true));
		
		writer.append(dvd_input);//Adding input to list
		writer.newLine();//New line after input
		writer.close();//Close file
		
		//Sorting A-Z of the DVD list
		FileReader fileReader = new FileReader(output_File);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String inputLine;//File lines input
		
		List<String> lineList = new ArrayList<String>();//storing DVDs to be sorted
		
		//Loop - Get lines from file and add them to list
		while ((inputLine = bufferedReader.readLine()) != null){
			
			lineList.add(inputLine);
		}
		
		//Close file
		fileReader.close();
		
		//Sort list A-Z
		Collections.sort(lineList);
		
		FileWriter fileWriter = new FileWriter(output_File);
		PrintWriter out = new PrintWriter(fileWriter);
		
		//Loop - Write list back to file now sorted
		for (String outputLine : lineList){
			
			out.println(outputLine);
		}
		
		out.flush();
		out.close();//Closing file
		fileWriter.close();//Closing file writer

	}

}


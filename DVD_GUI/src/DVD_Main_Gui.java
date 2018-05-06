/*
 *  	Things to work on
 * 
 * 	case sensitive figure for add and search - DONE for now All lower case
 * 	something to catch duplicates - DONE
 * 	empty text field for search - DONE
 *  close program menu option - DONE
 * 
 */



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class DVD_Main_Gui extends Application {
	
	//Variables for window, border pane, buttons, stages, etc
	Stage window;
	BorderPane layout, viewFile_layout, add_layout, search_layout;
	Scene Main, View_File, Add_Movie, Search_Movie;
	Button mainMenu_Button, search_Button, clear_Button;
	BufferedReader reader_Movie;
	

	
	@Override
	public void start(Stage Main_Stage) throws Exception {
		
		//Call create File
		createFile();
		
		//Creating Window
		window = Main_Stage;
		window.setTitle("Movie Tracker");
		
		//File drop down menu - includes shortcut
				Menu file_Menu = new Menu("_File");
				
				//View List for drop down menu
				MenuItem view_List = new MenuItem("View List...");
				//Set action for view list choice
				view_List.setOnAction(e -> {
					
					window.setScene(View_File);//setting scene to view file scene
					try {
						View_Movies();//call view movies function
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				});
				
				//Add Movie for drop down menu
				MenuItem add_List = new MenuItem("Add Movie...");
				add_List.setOnAction(e ->{
					
					window.setScene(Add_Movie);//Changing scene to add movie scene
					try {
						Add_Movies();//Call add movie function
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				});
				
				MenuItem search_List = new MenuItem("Search List...");
				search_List.setOnAction(e -> {
					
					window.setScene(Search_Movie);
					
					try {
						search_File();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				//Close program
				MenuItem close = new MenuItem("Close");
				close.setOnAction(e -> {
					
					window.close();
					
				});
				
				//Adds options to drop down list
				file_Menu.getItems().add(view_List);
				file_Menu.getItems().add(add_List);
				file_Menu.getItems().add(search_List);
				file_Menu.getItems().add(close);
				
				//Menu bar for the scene
				MenuBar menu_Bar = new MenuBar();
				menu_Bar.getMenus().addAll(file_Menu);
		
		//Image of Logo for main scene
		ImageView image_View = new ImageView("MovieTracker.PNG");
		
		//Setting up Border Pane for Main scene
		layout = new BorderPane();
		layout.setTop(menu_Bar);
		layout.setCenter(image_View);
		layout.setBackground(Background.EMPTY);//Formating Border Panes
		
		//Setting up Border Pane for View scene, add_layout
		viewFile_layout = new BorderPane();
		add_layout = new BorderPane();
		search_layout = new BorderPane();
		
		
		//Creating Scenes
		Main =  new Scene(layout, 400, 400);
		View_File = new Scene(viewFile_layout, 400, 400);
		Add_Movie = new Scene(add_layout, 400, 400);
		Search_Movie = new Scene(search_layout, 400, 400);
		
		//Formating Scene
		Main.setFill(Color.RED);
		window.setScene(Main);
		window.show();
	}

	//Creating File if not it doesn't not exist
	public void createFile() {
		
		File Movies = new File("Movies.txt");
		
		if (!Movies.exists()) {
			
			try {
				Movies.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//View movie list
	public void View_Movies() throws IOException {
		
		viewFile_layout.setBackground(Background.EMPTY);//Formating Border Panes
		View_File.setFill(Color.RED);//Changing background color of Panes
		
		//Label for title 
		Label label_List = new Label("OWNED MOVIES");
		
		//Formating for label - Size and placement
		label_List.setFont(new Font("Arial", 18));
		viewFile_layout.setTop(label_List);
		viewFile_layout.setPadding((new Insets(10,20, 10, 20)));
		BorderPane.setAlignment(label_List, Pos.CENTER);
		
		
		//Read file
		FileReader input = new FileReader("Movies.txt");
		reader_Movie = new BufferedReader(input);
		String Movie;//Stores movies
		
		//Text Area to display movies
		TextArea movie_List = new TextArea();
		movie_List.setEditable(false);//Disabling the text area
		movie_List.setMaxHeight(300);
		
		//Loop - Read the line in the file
		while((Movie = reader_Movie.readLine()) != null) {
			
			movie_List.setText(movie_List.getText() + Movie + "\n");//Read line, adds to text area, moves to next line
			
		}
		
		//Closing file
		input.close();
		reader_Movie.close();
		
		viewFile_layout.setCenter(movie_List);//Displays the text area once list is made
		
		int scene_Check = 1;
		return_MainButton(scene_Check);

	}
	
	//Add Movies and Sort Movies
	public void Add_Movies() throws IOException {
		
		int scene_Check = 2;
		return_MainButton(scene_Check);
		
		add_layout.setBackground(Background.EMPTY);//Formating Border Panes
		Add_Movie.setFill(Color.RED);//Changing background color of Panes
		
		//Label for title
		Label label_Add = new Label("ADD MOVIES");
		
		//Formating for label - Size and placement and formating 
		label_Add.setFont(new Font("Arial", 18));
		add_layout.setTop(label_Add);
		add_layout.setPadding((new Insets(10,10, 10, 10)));
		BorderPane.setAlignment(label_Add, Pos.CENTER);
			
		//TextField for user input
		TextField movie_Input = new TextField();
		
		//Formating for Text Field and placement
		//movie_Input.setFocusTraversable(true);
		movie_Input.setPromptText("Enter Movie Title Here");//Set prompt text
		//File to add movies too
		String out_File = ("Movies.txt");
		
		//Text area for previously entered movies
		TextArea previous_Add = new TextArea("**RECENTLY ADDED MOVIES**\n");
		previous_Add.setEditable(false);//text area disable
		previous_Add.setMaxHeight(200);//Setting max height
		
		//Using Vbox to insert text field and text area into center broader pane includes formatting
		VBox Center = new VBox();
		Center.setPadding(new Insets(20,5, 10, 5));
		Center.setSpacing(50);
		Center.getChildren().addAll(movie_Input,previous_Add);
		
		//Setting Vbox in center pane
		add_layout.setCenter(Center);
		
		//TextField action on key press
		movie_Input.setOnKeyPressed(e -> {
			
			//Checks for empty text field --> Needs pop up window
			if(movie_Input.getText().isEmpty() && (e.getCode() == KeyCode.ENTER)) {
				
				error_PopOut.display("Empty Entry", "Movie Title Entered Was Blank");
			}
			
			//Check for enter press and input is not empty
			if((e.getCode() == KeyCode.ENTER) && !(movie_Input.getText().isEmpty())) {
				
				//Getting user input
				String user_Movie = movie_Input.getText();
				user_Movie = user_Movie.toLowerCase();//Setting input to lower case for validation

				//Try and catch for add movie to list and sort list A-Z
				try {
					
					//Checking to see if Movie is already in the file
					if(search_MovieFile.search_ForMovie(user_Movie).equals(true)) {
						
						//Writing User input to text area
						previous_Add.setText(previous_Add.getText() + user_Movie + " - Already on List" +"\n");
						error_PopOut.display("ALREADY EXIST", "Movie Is Already On List");
					}
					
					//If movie is not in file, movie will be added and sorted
					else if (search_MovieFile.search_ForMovie(user_Movie).equals(false)) {
						
						//Writing User input to text area
						previous_Add.setText(previous_Add.getText() + user_Movie + "\n");
				
						BufferedWriter writer = new BufferedWriter(new FileWriter(out_File, true));
				
						writer.append(user_Movie);//Adding input to list
						writer.newLine();//New line after input
						writer.close();//Close file
				
						//Sorting A-Z of the DVD list
						FileReader fileReader = new FileReader(out_File);
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
				
						//File Writer and Print Writer
						FileWriter fileWriter = new FileWriter(out_File);
						PrintWriter out = new PrintWriter(fileWriter);
				
						//Loop - Write list back to file now sorted
						for (String outputLine : lineList){
					
							out.println(outputLine);//Print sorted list into file
						}
				
						out.flush();
						out.close();//Closing file
						fileWriter.close();//Closing file writer
					}
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//End try catch
				
				//Clear Text Field
				movie_Input.clear();
				
			}//End of if
			
		});	
		
	}

	//Function for button return main, set up for each scene using changing variable
	public void return_MainButton(int scene_Check) {
	
		//Button to return to main menu, includes shortcut
		mainMenu_Button = new Button("_RETURN TO MAIN MENU");
	
	
		if(scene_Check == 1) {
		
			viewFile_layout.setBottom(mainMenu_Button);//Formatting button to bottom
		}
		else if(scene_Check == 2) {
		
			add_layout.setBottom(mainMenu_Button);//Formatting button to bottom
		}
		else if(scene_Check == 3) {
			
			search_layout.setBottom(mainMenu_Button);//Formatting button to bottom
		}
	
		BorderPane.setAlignment(mainMenu_Button, Pos.CENTER);//Formatting to center
		mainMenu_Button.setOnAction(e -> window.setScene(Main));//Return the Main Menu Scene
		
	}
	
	//Search file function
	public void search_File()  throws IOException  {
		
		int scene_Check = 3;
		return_MainButton(scene_Check);
		
		search_layout.setBackground(Background.EMPTY);//Formating Border Panes
		Search_Movie.setFill(Color.RED);//Changing background color of Panes
		
		//Label for title
		Label label_Search = new Label("SEARCH MOVIE");
		
		//Formating for label - Size and placement and formating 
		label_Search.setFont(new Font("Arial", 18));
		search_layout.setTop(label_Search);
		search_layout.setPadding((new Insets(10,10, 10, 10)));
		BorderPane.setAlignment(label_Search, Pos.CENTER);
		
		//Label for results
		Label label_Results = new Label();
		
		//Formating for label - Size and placement and formating 
		label_Results.setFont(new Font("Arial", 14));
		
			
		//TextField for user input
		TextField search_Input = new TextField();
		
		//Formating for Text Field and placement
		search_Input.setFocusTraversable(false);
		search_Input.setPromptText("Enter Movie Title Here");//Set prompt text
		
		//Inizaling Buttons
		search_Button = new Button("_Search");
		clear_Button = new Button("_Clear");
		
		//Setting up Hboxs to hold buttons
		HBox Buttons = new HBox();
		Buttons.setAlignment(Pos.CENTER);
		Buttons.setSpacing(50);
		Buttons.getChildren().addAll(search_Button, clear_Button);
		
		//Settup up VBox to hold text field, hbox, labels
		VBox Center = new VBox();
		Center.setPadding(new Insets(20,5, 10, 5));
		Center.setSpacing(50);
		Center.setAlignment(Pos.CENTER);
		Center.getChildren().addAll(search_Input, Buttons, label_Results);
		
		//Setting Vbox to center of boarder pane
		search_layout.setCenter(Center);
		
		//Action for button search press
		search_Button.setOnAction(e -> {
			
			//Checking for empty entry
			if(search_Input.getText().isEmpty()) {
				
				error_PopOut.display("Empty Entry", "Movie Title Entered Was Blank");
			}
			
			//If entry is not empty
			else {
				//Getting user input from text field
				String input_Search = search_Input.getText();
				input_Search = input_Search.toLowerCase();//Setting input to lower case for validation
			
				//Try and Catch to find if input is in the file
				try {
				
					if(search_MovieFile.search_ForMovie(input_Search).equals(true)) {
					
						label_Results.setText(input_Search + " - FOUND");
					
					}
					else {
					
						label_Results.setText(input_Search + " - NOT FOUND");
					}
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			search_Input.clear();//Clearing input
		});
		
		//Action for clear button press
		clear_Button.setOnAction(e ->{ 
			
			search_Input.clear();//Clearing input
			label_Results.setText("");//Clearing label
		});
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
}//Ending

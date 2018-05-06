
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;





public class Main_Dung extends Application{
	
	Stage window;
	
	Scene Main_Scene, Menu_Scene;
	
	Pane map, user_Fullinterface, Menu;
	
	BorderPane gui_layout, Main_menu;
	
	GridPane player_Inv;
	
	Group dungeon;
	
	ImageView Warrior, level1, Gold, Potion, male_Healthbar, keys,
			  monster, loot, main_Menu, choice_Male, choice_Female, female_Warrior,
			  female_Healthbar;
		

	Image mouse_Sword, male, female;
	
	Menu file_Menu;
	
	MenuItem new_Game;
	
	MenuBar menu_Bar, menu_Bar2;
	
	Label user_Gold, user_Potion, health_Bar, player_Name, num_Keys,
		  current_Score, high_Score, game_Title;
	
	HBox user_Interface1, user_Interface2, user_Interface3;
	
	TextArea combat_Log;
	
	TextField name_Choice;
	
	double chr_X = 0, chr_Y = 0;
	
	int chr_Life = 50, chr_Potion = 0, chr_Score = 0, spawn_Location = 0,
		low = 0, high = 0, monster_Respawn = 0, monster_Life = 0, death = 0,
		damage_Taken = 0, damage_Given = 0, chr_Keys = 0, chr_Gold = 0;
	
	int attack_Data[] = new int[6];
	int loot_Data[] = new int[3];
	
	char direction;

	
  @Override 
  public void start(Stage Main_Stage) throws Exception{

    window = Main_Stage;
    window.setTitle("Dungeon Runner"); 
    
    Warrior = new ImageView();
    Warrior.setLayoutX(20);
    Warrior.setLayoutY(60);
    
    male = new Image("Man-2-icon.png");
    female = new Image("HeroF.png");
      
    level1 = new ImageView("Testing.png");
    level1.setFitHeight(675);
    level1.setPreserveRatio(true);
    
    Gold = new ImageView("gold.png");
    Gold.setFitHeight(22);
    Gold.setPreserveRatio(true);
    
    Potion = new ImageView("potion.png");
    Potion.setFitHeight(22);
    Potion.setPreserveRatio(true);
    
    male_Healthbar = new ImageView("HeroM1.png");
    male_Healthbar.setFitHeight(61);
    
    female_Healthbar = new ImageView("HeroF1.png");
    female_Healthbar.setFitHeight(61);
    
    keys = new ImageView("key.png");
    keys.setFitHeight(22);
    keys.setPreserveRatio(true);
    
    monster = new ImageView("Monster.png");
    monster.setFitHeight(60);
    monster.setPreserveRatio(true);
    monster.setVisible(false);
    
    loot = new ImageView("GoldSack.png");
    loot.setFitHeight(30);
    loot.setPreserveRatio(true);
    loot.setVisible(false);
    
    mouse_Sword = new Image("sword.png");
    
    main_Menu = new ImageView("Main_menu.PNG");
    main_Menu.setFitHeight(850);
    main_Menu.setPreserveRatio(true);
    
    choice_Male = new ImageView("MMenu.png");

    choice_Female = new ImageView("FMenu.png");
    
    dungeon = new Group(level1);
     
    user_Fullinterface = new Pane();
    Menu = new Pane();
    
    file_Menu = new Menu("_File");
    
    new_Game = new MenuItem("New Game...");
    /*new_Game.setOnAction(e -> {
    	
    	
    });*/
    
    file_Menu.getItems().add(new_Game);
    
    menu_Bar = new MenuBar();
    menu_Bar.getMenus().addAll(file_Menu);
    
    menu_Bar2 = new MenuBar();
    menu_Bar2.getMenus().addAll(file_Menu);
    
    player_Inv = new GridPane();
    
    user_Interface1 = new HBox();
    user_Interface2 = new HBox();
    user_Interface3 = new HBox();
    
    combat_Log = new TextArea();
    combat_Log.setEditable(false);
    combat_Log.setDisable(true);
    combat_Log.setMaxSize(175, 125);
    combat_Log.setFont(new Font("Gungsuh", 10));
    
    name_Choice = new TextField();
    name_Choice.setPromptText("Enter Initials Then Select Character");
    name_Choice.setPrefSize(210, 15);
    
    user_Gold = new Label(" = " + Integer.toString(chr_Gold));
    user_Gold.setFont(new Font("Gungsuh", 20));
    user_Gold.setTextFill(Color.RED);
    
    user_Potion = new Label(" = " + Integer.toString(chr_Potion));
    user_Potion.setFont(new Font("Gungsuh", 20));
    user_Potion.setTextFill(Color.RED);
    
    num_Keys = new Label(" = " + Integer.toString(chr_Keys));
    num_Keys.setFont(new Font("Gungsuh", 20));
    num_Keys.setTextFill(Color.RED);
    
    health_Bar = new Label("LIFE = " + Integer.toString(chr_Life));
    health_Bar.setFont(new Font("Gungsuh", 24));
    health_Bar.setTextFill(Color.BLACK);
    
    player_Name = new Label();
    player_Name.setFont(new Font("Gungsuh" , 20));
    player_Name.setTextFill(Color.BLACK);
    
    current_Score = new Label("SCORE = " + Integer.toString(chr_Score));
    current_Score.setFont(new Font("Gungsuh", 20));
    current_Score.setTextFill(Color.YELLOW);
    
    high_Score = new Label("HighScore = GUY 100000");
    high_Score.setFont(new Font("Gungsuh", 12));
    high_Score.setTextFill(Color.GREEN);
    
    game_Title = new Label("DUNGEON RUNNER");
    game_Title.setFont(new Font("Gungsuh" , 48));
    game_Title.setTextFill(Color.RED);
    
    user_Interface1.getChildren().addAll(Gold, user_Gold);
    user_Interface2.getChildren().addAll(Potion, user_Potion);
    user_Interface3.getChildren().addAll(keys, num_Keys);
    
    user_Interface1.setTranslateX(25);
    user_Interface1.setTranslateY(20);
    
    user_Interface2.setTranslateX(25);
    user_Interface2.setTranslateY(60);
    
    user_Interface3.setTranslateX(140);
    user_Interface3.setTranslateY(20);
    
    male_Healthbar.setTranslateX(268);
    male_Healthbar.setTranslateY(15);
    
    female_Healthbar.setTranslateX(268);
    female_Healthbar.setTranslateY(15);
    
    health_Bar.setTranslateX(275);
    health_Bar.setTranslateY(50);
    
    player_Name.setTranslateX(335);
    player_Name.setTranslateY(15);
    
    combat_Log.setTranslateX(500);
    combat_Log.setTranslateY(-5);
    
    current_Score.setTranslateX(267);
    current_Score.setTranslateY(100);
    
    high_Score.setTranslateX(5);
    high_Score.setTranslateY(110);
    
    game_Title.setLayoutX(120);
    game_Title.setLayoutY(825);
    
    choice_Male.setLayoutX(-75);
    choice_Male.setLayoutY(600);
    
    choice_Female.setLayoutX(680);
    choice_Female.setLayoutY(600);
    
    name_Choice.setLayoutX(235);
    name_Choice.setLayoutY(600);
    name_Choice.setFocusTraversable(false);
    
    
    Menu.getChildren().addAll(main_Menu,game_Title,choice_Male,choice_Female,name_Choice);
    
    
    user_Fullinterface.getChildren().addAll(user_Interface1,user_Interface2, user_Interface3, 
    										male_Healthbar, female_Healthbar,health_Bar, player_Name,
    										combat_Log, current_Score, high_Score);
    
    Bounds bound = Menu.getBoundsInLocal();
    Timeline menu_Time = new Timeline(new KeyFrame(Duration.seconds(3),
    		new KeyValue(game_Title.layoutYProperty(), 125 + game_Title.getHeight())));
    
    Timeline menu_TimeM = new Timeline(new KeyFrame(Duration.seconds(3),
    		new KeyValue(choice_Male.layoutXProperty(), 112 - game_Title.getWidth())));
    
    Timeline menu_TimeF = new Timeline(new KeyFrame(Duration.seconds(3),
    		new KeyValue(choice_Female.layoutXProperty(), 452 - game_Title.getWidth())));
    
    
    menu_Time.setCycleCount(1);
    menu_Time.play();
    menu_TimeM.setCycleCount(1);
    menu_TimeM.play();
    menu_TimeF.setCycleCount(1);
    menu_TimeF.play();
    
    choice_Male.setOnMouseClicked(event -> {
    	
    	window.setScene(Main_Scene);
    	female_Healthbar.setVisible(false);
    	Warrior.setImage(male);
    	
    	if(!(name_Choice.getText().isEmpty())) {
    		
    		player_Name.setText(name_Choice.getText().substring(0, 3));
    		
    	}
    	
    	if(name_Choice.getText().isEmpty()) {
    		
    		player_Name.setText("GUY");
    		
    	}
    	
    });
    
    choice_Female.setOnMouseClicked(event -> {
    	
    	window.setScene(Main_Scene);
    	male_Healthbar.setVisible(false);
    	Warrior.setImage(female);
    	
    	if(!(name_Choice.getText().isEmpty())) {
    		
    		player_Name.setText(name_Choice.getText().substring(0, 3));
    		
    	}
    	
    	if(name_Choice.getText().isEmpty()) {
    		
    		player_Name.setText("GRL");
    		
    	}
    	
    });
    
    map = new Pane();
    map.getChildren().addAll(dungeon, Warrior, monster, loot);
    
    Main_menu = new BorderPane();
    Main_menu.setCenter(Menu);
    Main_menu.setTop(menu_Bar);
    
    gui_layout = new BorderPane();
    gui_layout.setTop(menu_Bar2);
    gui_layout.setCenter(map);
    gui_layout.setBackground(Background.EMPTY);
    gui_layout.setBottom(user_Fullinterface);
    
    
    Menu_Scene = new Scene(Main_menu, 670,825);
    Main_Scene = new Scene(gui_layout, 670, 825);
    Main_Scene.setFill(Color.BLACK);
    
    Main_Stage.setScene(Menu_Scene);
    Main_Stage.show(); 
    Main_Stage.setResizable(false);
    Main_Scene.setCursor(Cursor.CROSSHAIR);
    
    play_Game();
  }

  
  public void play_Game() {
	  
	    chr_X = Warrior.getLayoutX();
		chr_Y = Warrior.getLayoutY();

	    Main_Scene.setOnKeyPressed(e ->{
	    	
	    	if(monster.isVisible() == false && loot.isVisible() == false) {	    		
	    		
	    		switch(e.getCode()) {
	    	
	    			case W:	    			

	    				Warrior.setLayoutY(Move_Char.moving_W(chr_Y,chr_X));
	    				chr_X = Warrior.getLayoutX();
	    				chr_Y = Warrior.getLayoutY();
	    				break;
	    		
	    			case S:
	    			
	    				Warrior.setLayoutY(Move_Char.moving_S(chr_Y, chr_X));
	    				chr_X = Warrior.getLayoutX();
	    				chr_Y = Warrior.getLayoutY();
	    				break;
	    	
	    			case D:	    			

	    				Warrior.setLayoutX(Move_Char.moving_D(chr_Y, chr_X));
	    				chr_X = Warrior.getLayoutX();
	    				chr_Y = Warrior.getLayoutY();
	    				break;   		
	    		
	    			case A:
	    			
	    				Warrior.setLayoutX(Move_Char.moving_A(chr_Y, chr_X));
	    				chr_X = Warrior.getLayoutX();
	    				chr_Y = Warrior.getLayoutY();
	    				break;
	    			
	    			case Q:
	    			
	    				if (chr_Potion > 0) {
	    				
	    					chr_Life += 5;
	    					chr_Score += 100;
	    					chr_Potion -= 1;
	    				
	    					health_Bar.setText("LIFE = " + Integer.toString(chr_Life));
	    					user_Potion.setText(" = " + Integer.toString(chr_Potion));
	    					current_Score.setText("SCORE = " + Integer.toString(chr_Score));
	    					break;
	    				}
	    		}
	    	}
	    	
	    	monster();
	    	
		    monster.setOnMouseClicked(event ->{
		    		
		    	attack_Data = Attack_Char.attacking(chr_Life, monster_Life,death);
		    	
		    	death = attack_Data[0];
		    	chr_Life = attack_Data[1];
		    	monster_Life = attack_Data[2];
		    	damage_Given = attack_Data[3];
		    	damage_Taken = attack_Data[4];
		    	chr_Score += attack_Data[5];
		    		
		    	combat_Log.appendText("Damage Taken = " + damage_Taken +
		    			"\n" + "Damage Dealt = " + damage_Given + "\n");
		    	
		    	if(death == 1) {
		    		
		    		health_Bar.setText("LIFE = " + Integer.toString(chr_Life));
		    		Warrior.setVisible(false);
		    		
		    		combat_Log.appendText("YOU HAVE DIED!!\n\n");		    		
		    	}
		    	
		    	else if(death == 2) {
		    		
		    		Loot();
		    	}
		    			    	
		    });
		    
    		loot.setOnMouseClicked(event ->{
    			
    			loot.setVisible(false);
    			Main_Scene.setCursor(Cursor.CROSSHAIR);
    			
    			loot_Data = Loot.loot_Drops();
    			
    			chr_Keys += loot_Data[0] ;
    			chr_Potion += loot_Data[1];
    			chr_Gold += loot_Data[2];
    			
    			num_Keys.setText(" = " + Integer.toString(chr_Keys));
    			user_Potion.setText(" = " + Integer.toString(chr_Potion));
    			user_Gold.setText(" = " + Integer.toString(chr_Gold));
    			
    		});

	    });

  }
  
  public void monster() {

  	if(monster_Respawn == 0 && monster.isVisible() == false) {
		
		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 1) && (chr_X == 155) && (chr_Y == 60)) {
			
			monster.setVisible(true);
			monster.setLayoutX(200);
			monster.setLayoutY(50);

		}
	
		else if((spawn_Location == 2) && (chr_X == 290) && (chr_Y == 60)){
    	
			monster.setVisible(true);
			monster.setLayoutX(325);//325
			monster.setLayoutY(50);
		}
	
		else if((spawn_Location == 3) && (chr_X == 425) && (chr_Y == 60)) {
	
			monster.setVisible(true);
			monster.setLayoutX(465);
			monster.setLayoutY(50);
		}

		else if((spawn_Location == 4) && (chr_X == 560) && (chr_Y == 60)) {
	
			monster.setVisible(true);
			monster.setLayoutX(600);
			monster.setLayoutY(50);
		}
	}
	
	if(monster_Respawn == 1 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 5) && (chr_X == 560) && (chr_Y == 195)) {
			
			monster.setVisible(true);
			monster.setLayoutX(600);
			monster.setLayoutY(195);
		}
	
		else if((spawn_Location == 6) && (chr_X == 560) && (chr_Y == 330)){
    	
			monster.setVisible(true);
			monster.setLayoutX(600);
			monster.setLayoutY(320);
		}
	
		else if((spawn_Location == 7) && (chr_X == 560) && (chr_Y == 465)) {
	
			monster.setVisible(true);
			monster.setLayoutX(600);
			monster.setLayoutY(455);
		}

		else if((spawn_Location == 8) && (chr_X == 560) && (chr_Y == 600)) {
	
			monster.setVisible(true);
			monster.setLayoutX(600);
			monster.setLayoutY(590);
		}
	}
	
	if(monster_Respawn == 2 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 9) && (chr_X == 425) && (chr_Y == 600)) {
			
			monster.setVisible(true);
			monster.setLayoutX(465);
			monster.setLayoutY(590);
		}
	
		else if((spawn_Location == 10) && (chr_X == 290) && (chr_Y == 600)){
    	
			monster.setVisible(true);
			monster.setLayoutX(325);
			monster.setLayoutY(590);
		}
	
		else if((spawn_Location == 11) && (chr_X == 155) && (chr_Y == 600)) {
	
			monster.setVisible(true);
			monster.setLayoutX(200);
			monster.setLayoutY(590);
		}

		else if((spawn_Location == 12) && (chr_X == 20) && (chr_Y == 600)) {
	
			monster.setVisible(true);
			monster.setLayoutX(65);
			monster.setLayoutY(590);
		}
	}
	
	if(monster_Respawn == 3 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 13) && (chr_X == 20) && (chr_Y == 465)) {
			
			monster.setVisible(true);
			monster.setLayoutX(65);
			monster.setLayoutY(455);
		}
	
		else if((spawn_Location == 14) && (chr_X == 20) && (chr_Y == 330)){
    	
			monster.setVisible(true);
			monster.setLayoutX(65);
			monster.setLayoutY(320);
		}
	
		else if((spawn_Location == 15) && (chr_X == 20) && (chr_Y == 195)) {
	
			monster.setVisible(true);
			monster.setLayoutX(65);
			monster.setLayoutY(195);
		}

	}
	
	if(monster_Respawn == 4 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 16) && (chr_X == 155) && (chr_Y == 195)) {
			
			monster.setVisible(true);
			monster.setLayoutX(200);
			monster.setLayoutY(185);
		}
	
		else if((spawn_Location == 17) && (chr_X == 290) && (chr_Y == 195)){
    	
			monster.setVisible(true);
			monster.setLayoutX(325);
			monster.setLayoutY(185);
		}
	
		else if((spawn_Location == 18) && (chr_X == 425) && (chr_Y == 195)) {
	
			monster.setVisible(true);
			monster.setLayoutX(465);
			monster.setLayoutY(185);
		}

	}
	
	if(monster_Respawn == 5 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 19) && (chr_X == 425) && (chr_Y == 330)) {
			
			monster.setVisible(true);
			monster.setLayoutX(465);
			monster.setLayoutY(320);
		}
	
		else if((spawn_Location == 20) && (chr_X == 425) && (chr_Y == 465)){
    	
			monster.setVisible(true);
			monster.setLayoutX(465);
			monster.setLayoutY(455);
		}

	}
	
	if(monster_Respawn == 6 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 21) && (chr_X == 290) && (chr_Y == 465)) {
			
			monster.setVisible(true);
			monster.setLayoutX(325);
			monster.setLayoutY(455);
		}
	
		else if((spawn_Location == 22) && (chr_X == 425) && (chr_Y == 465)){
    	
			monster.setVisible(true);
			monster.setLayoutX(200);
			monster.setLayoutY(455);
		}

	}
	
	if(monster_Respawn == 7 && monster.isVisible() == false) {

		spawn_Location = Monster.spawn_Monster(spawn_Location,chr_X, chr_Y, low, high);
		
		if((spawn_Location == 23) && (chr_X == 155) && (chr_Y == 330)) {
			
			monster.setVisible(true);
			monster.setLayoutX(200);
			monster.setLayoutY(320);
		}
	
		else if((spawn_Location == 24) && (chr_X == 290) && (chr_Y == 465)){
    	
			monster.setVisible(true);
			monster.setLayoutX(325);
			monster.setLayoutY(320);
		}

	}
	
	if(monster.isVisible() == true) {
		
		Main_Scene.setCursor(new ImageCursor(mouse_Sword));
	}
	  
  }
  
  public void Loot() {
	  
		monster.setVisible(false);
		monster_Respawn++;
		
		health_Bar.setText("LIFE = " + Integer.toString(chr_Life));
		current_Score.setText("SCORE = " + Integer.toString(chr_Score));
		
		combat_Log.appendText("MONSTER DIED!!\n\n");
		
		Main_Scene.setCursor(Cursor.HAND);
		
		switch(spawn_Location) {
		
			case 1:
				loot.setVisible(true);
				loot.setLayoutX(200);
				loot.setLayoutY(60);
				break;
  			
			case 2:
				loot.setVisible(true);
				loot.setLayoutX(325);
				loot.setLayoutY(60);
				break;
  		
			case 3:
				loot.setVisible(true);
				loot.setLayoutX(465);
				loot.setLayoutY(60);
				break;
  			
			case 4:
				loot.setVisible(true);
				loot.setLayoutX(600);
				loot.setLayoutY(60);
				break;
  			
			case 5:
				loot.setVisible(true);
				loot.setLayoutX(600);
				loot.setLayoutY(195);
				break;
  			
			case 6:
				loot.setVisible(true);
				loot.setLayoutX(600);
				loot.setLayoutY(330);
				break;
  			
			case 7:
				loot.setVisible(true);
				loot.setLayoutX(600);
				loot.setLayoutY(465);
				break;
  			
			case 8:
				loot.setVisible(true);
				loot.setLayoutX(600);
				loot.setLayoutY(600);
				break;
  			
			case 9:
				loot.setVisible(true);
				loot.setLayoutX(465);
				loot.setLayoutY(600);
				break;
  			
			case 10:
				loot.setVisible(true);
				loot.setLayoutX(325);
				loot.setLayoutY(600);
				break;
  			
			case 11:
				loot.setVisible(true);
				loot.setLayoutX(200);
				loot.setLayoutY(600);
				break;
  			
			case 12:
				loot.setVisible(true);
				loot.setLayoutX(65);
				loot.setLayoutY(600);
				break;
  			
			case 13:
	  			loot.setVisible(true);
	  			loot.setLayoutX(65);
	  			loot.setLayoutY(455);
	  			break;
	  			
			case 14:
	  			loot.setVisible(true);
	  			loot.setLayoutX(65);
	  			loot.setLayoutY(320);
	  			break;
	  			
			case 15:
	  			loot.setVisible(true);
	  			loot.setLayoutX(65);
	  			loot.setLayoutY(195);
	  			break;
	  			
			case 16:
	  			loot.setVisible(true);
	  			loot.setLayoutX(200);
	  			loot.setLayoutY(195);
	  			break;
	  			
			case 17:
	  			loot.setVisible(true);
	  			loot.setLayoutX(325);
	  			loot.setLayoutY(195);
	  			break;
	  			
			case 18:
	  			loot.setVisible(true);
	  			loot.setLayoutX(465);
	  			loot.setLayoutY(195);
	  			break;
	  			
			case 19:
	  			loot.setVisible(true);
	  			loot.setLayoutX(465);
	  			loot.setLayoutY(320);
	  			break;
	  			
			case 20:
	  			loot.setVisible(true);
	  			loot.setLayoutX(465);
	  			loot.setLayoutY(455);
	  			break;
	  			
			case 21:
	  			loot.setVisible(true);
	  			loot.setLayoutX(325);
	  			loot.setLayoutY(455);
	  			break;
	  			
			case 22:
	  			loot.setVisible(true);
	  			loot.setLayoutX(200);
	  			loot.setLayoutY(455);
	  			break;
	  			
			case 23:
	  			loot.setVisible(true);
	  			loot.setLayoutX(200);
	  			loot.setLayoutY(320);
	  			break;
	  			
			case 24:
	  			loot.setVisible(true);
	  			loot.setLayoutX(325);
	  			loot.setLayoutY(320);
	  			break;
		
		}
	  
	  
  }
  
  public static void main(String[] args) {
    launch(args);
  }

}
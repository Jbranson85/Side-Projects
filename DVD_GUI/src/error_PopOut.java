

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*;


public class error_PopOut {
	
	public static void display(String window_Title, String error_Message) {
		
		
		Stage error_Window = new Stage();
		
		error_Window.initModality(Modality.APPLICATION_MODAL);
		error_Window.setTitle(window_Title);
		error_Window.setWidth(200);
		error_Window.setHeight(200);
		
		Label error = new Label("!ERROR!");
		error.setFont(new Font("Arial", 20));
		
		Label desc_Error = new Label();
		desc_Error.setText(error_Message);
		desc_Error.setWrapText(true);
		
		Button close_Error = new Button("CLOSE");
		close_Error.setOnAction(e -> error_Window.close());
		
		VBox error_Layout =  new VBox(20);
		error_Layout.getChildren().addAll(error, desc_Error, close_Error);
		error_Layout.setAlignment(Pos.CENTER);
		
		Scene error_Scene = new Scene(error_Layout);
		error_Window.setScene(error_Scene);
		error_Window.showAndWait();
		
		
		
	}

}

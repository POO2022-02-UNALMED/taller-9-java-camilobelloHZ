package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {
	public static void main(String args[]){ 
	      launch(args); //launch
	} 
	
	@Override
	public void start(Stage window) throws Exception {
		VBox vb = new VBox();//VBox
		window.setTitle("Calculadora");//"Calculadora"
		
		vb.getChildren().add(new Calculator());
		Scene sc = new Scene(vb, 270, 270);//vb
		window.setScene(sc);//sc
		window.show();//window
	}

}

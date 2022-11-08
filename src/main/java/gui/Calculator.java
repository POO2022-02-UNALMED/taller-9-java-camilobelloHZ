package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Calculator extends VBox implements EventHandler<ActionEvent>{
	String number1 = "";
	String number2 = "";
	String operator;
	Text displayText;
	Boolean resetPantalla= false;
	
	public Calculator(){
		super(10);
		this.displayText = new Text();
		
		Rectangle rt = new Rectangle(250, 50, Color.TRANSPARENT);
		
		rt.setStroke(Color.GRAY);
		
		StackPane sp =  new StackPane(rt, this.displayText);
		
		sp.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane gd = new GridPane();
		
		gd.setPadding(new Insets(10, 10, 10, 10));
		gd.setVgap(5);
		gd.setHgap(4);
		
		gd.setAlignment(Pos.CENTER);// Puse Center
		
		Button b7 = new Button("7");
		gd.add(b7, 0, 0); //0
		b7.setPrefWidth(50);
		b7.setOnAction(this);
		
		Button b8 = new Button("8");
		gd.add(b8, 1, 0); //1
		b8.setPrefWidth(50);
		b8.setOnAction(this);
		
		Button b9 = new Button("9");//9
		gd.add(b9, 2, 0);//0
		b9.setPrefWidth(50);
		b9.setOnAction(this);
		
		Button div = new Button("/");
		gd.add(div, 3, 0);//3 y 0
		div.setPrefWidth(50);
		div.setOnAction(this);//this
		
		Button b4 = new Button("4");//button
		gd.add(b4, 0, 1);
		b4.setPrefWidth(50);
		b4.setOnAction(this);
		
		Button b5 = new Button("5");//Button
		gd.add(b5, 1, 1);//add
		b5.setPrefWidth(50);
		b5.setOnAction(this);
		
		Button b6 = new Button("6");
		gd.add(b6, 2, 1);//2 y 1
		b6.setPrefWidth(50);
		b6.setOnAction(this);//b6
		
		Button mul = new Button("*");//Button
		gd.add(mul, 3, 1);// 3
		mul.setPrefWidth(50);
		mul.setOnAction(this);
		
		Button b1 = new Button("1");// "1"
		gd.add(b1, 0, 2);
		b1.setPrefWidth(50);
		b1.setOnAction(this);
		
		Button b2 = new Button("2"); //Button
		gd.add(b2, 1, 2);//1
		b2.setPrefWidth(50);
		b2.setOnAction(this);
		
		Button b3 = new Button("3"); //Buttom
		gd.add(b3, 2, 2);//gd
		b3.setPrefWidth(50);
		b3.setOnAction(this);//this
		
		Button minus = new Button("-");//Button
		gd.add(minus, 3, 2);//2
		minus.setPrefWidth(50);
		minus.setOnAction(this);
		
		Button b0 = new Button("0");//Button
		gd.add(b0, 0, 3, 2, 1);//no se 
		b0.setPrefWidth(105);
		b0.setOnAction(this);//b0
		
		Button plus = new Button("+");
		gd.add(plus, 2, 3);//add, 2
		plus.setPrefWidth(50);
		plus.setOnAction(this);
		
		Button equals = new Button("=");//"="
		gd.add(equals, 3, 3);//gd
		equals.setPrefWidth(50);
		equals.setOnAction(this);
		
		Button reset = new Button("C");//Button
		gd.add(reset, 0, 4, 4, 1);//4
		reset.setPrefWidth(215);
		reset.setOnAction(this);//this
		
		this.getChildren().addAll(sp, gd);
	}

	int resultado=0;
	int numAux=0;
	int contadorResta=0;
	int contadorMult=0;
	int contadorDivi=0;
	float numDiv=0;
	@Override
	public void handle(ActionEvent event) {
		
		Button b = (Button) event.getSource();
		String value = b.getText();
		if(value.equals("0") || value.equals("2") || value.equals("3") || value.equals("4") || value.equals("1")
				|| value.equals("5") || value.equals("6") || value.equals("7") || value.equals("8") || value.equals("9")) {
			if(resetPantalla) {
				displayText.setText(value);
				resetPantalla=false;
			}else {
				if(displayText.getText()== "") {
					displayText.setText(value);
				}else {
					displayText.setText(Integer.parseInt(displayText.getText())+value);	
				}
			}
		}
		if(value.equals("+")) {  //SUMA
			number1= displayText.getText();
			int num1 = Integer.parseInt(number1);
			resultado+=num1;
			operator="suma";
			displayText.setText(resultado+"");
			resetPantalla=true;
		}
		if(value.equals("-")) {//RESTA
			number1= displayText.getText();
			int num1 = Integer.parseInt(number1);
			if(contadorResta==0) {
				numAux=num1;
				resultado=num1;
			}else {
				if(contadorResta==1) {
					resultado = numAux - num1; 
				}else {
					resultado = resultado - num1;
				}
				displayText.setText(resultado+"");
				resultado = Integer.parseInt(displayText.getText());
			}
			contadorResta+=1;
			operator="resta";
			resetPantalla=true;
	    }
		if(value.equals("*")) { //Multiplicacion
			number1= displayText.getText();
			int num1 = Integer.parseInt(number1);
			if(contadorMult==0) {
				numAux=num1;
				resultado = num1;
			}else {
				if(contadorMult==1) {
					resultado= numAux*num1;
				}else {
					resultado *= num1;
				}
				displayText.setText(resultado+"");
				resultado = Integer.parseInt(displayText.getText());
			}
			contadorMult+=1;
			operator="multiplicacion";
			resetPantalla=true;
		}
		if(value.equals("/")) {
			number1= displayText.getText();
			int num1 = Integer.parseInt(number1);
			if(contadorDivi==0) {
				numAux=num1;
				resultado = num1;
			}else {
				if(contadorMult==1) {
					resultado= numAux/num1;
				}else {
					resultado /= num1;
				}
				displayText.setText(resultado+"");
				resultado = Integer.parseInt(displayText.getText());
			}
			contadorDivi+=1;
			operator="division";
			resetPantalla=true;
		}
		if (value.equals("=")) { //Igual
			number2 = displayText.getText();
			int num2 = Integer.parseInt(number2);
			if(operator=="suma") {
				displayText.setText((resultado+num2)+"");
				resultado=0;
			}else if(operator=="resta") {
				displayText.setText((resultado-num2)+"");
				resultado=0;
				contadorResta=0;
			}else if(operator=="multiplicacion") {
				displayText.setText((resultado*num2)+"");
				resultado=0;
				contadorMult=0;
			}else if(operator=="division") {
				displayText.setText((resultado/num2)+"");
				resultado=0;
				contadorDivi=0;
			}
		}
	}

}

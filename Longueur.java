package convertisseurlongueurpoidsjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Longueur {
	Tab tab;
	public Longueur(Tab tab) {
		this.tab=tab;
	}
	public void open() {
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setPadding(new Insets(15));
		gp.setHgap(50);
		gp.setVgap(50);
		
		Label label_1 = new Label("VALEUR :");
	    TextField textField_1 = new TextField();
	    textField_1.setPromptText("SVP entrer la valeure ! ");
	   
		gp.add(label_1,0,0);
		gp.add(textField_1, 1,0);
		
		Label unite1 = new Label("Unité");
		ChoiceBox<Object> choice1 = new ChoiceBox<Object>();
		choice1.getItems().addAll("cm", "m", "km");
		choice1.getSelectionModel().selectFirst();
		
		gp.add(unite1,2,0);
		gp.add(choice1,3,0);
		
		Label label_2 = new Label("Valeur");
		TextField textfield_2 = new TextField();
		textfield_2.setDisable(true);
		textfield_2.setId("tf2");
		
		gp.add(label_2,0,1);
		gp.add(textfield_2,1,1);
		
		Label unite2 = new Label("Unité");
		ChoiceBox<Object> choice2 = new ChoiceBox<Object>();
		choice2.getItems().addAll("cm", "m", "km");
		choice2.getSelectionModel().selectFirst();
		
		gp.add(unite2,2,1);
		gp.add(choice2,3,1);
		
		Button convertir = new Button("Convertir");
		Label errorLabel1 = new Label();
		
		gp.add(convertir,0,2);
		gp.add(errorLabel1,1,2);
		
		errorLabel1.setTextFill(Color.RED);
		
		convertir.setOnAction(e -> 
		 {
			 if((!textField_1.getText().matches("\\d*?\\.?\\d+")))
				{
				textField_1.setText("");
				errorLabel1.setText("erreur !! entrer un nomre");
				}
			 else if (textField_1.getText()==null){

				 errorLabel1.setText("erreur !! entrer un nomre");
				 textfield_2.setText("");
				 }
			 
			 else if (choice1.getValue()=="cm" && choice2.getValue()=="cm" || choice1.getValue()=="m" && choice2.getValue()=="m" || choice1.getValue()=="km" && choice2.getValue()=="km"  ) {
				 textfield_2.setText(textField_1.getText());
			      errorLabel1.setText("");
			 }
			 else if (choice1.getValue()=="cm" && choice2.getValue()=="m") {
				 Double num = Double.parseDouble(textField_1.getText());
				 Double result = num*0.01;
			     textfield_2.setText(""+result);
			     errorLabel1.setText("");
			 }
			 else if (choice1.getValue()=="cm" && choice2.getValue()=="km") {
				 Double num = Double.parseDouble(textField_1.getText());
				 Double result = num*0.00001;
			     textfield_2.setText(""+result);
			     errorLabel1.setText("");
			 }
			 else if (choice1.getValue()=="m" && choice2.getValue()=="cm") {
				 Double num = Double.parseDouble(textField_1.getText());
				 Double result = num*100;
			     textfield_2.setText(""+result);
			     errorLabel1.setText("");
			 }
			 else if (choice1.getValue()=="m" && choice2.getValue()=="km") {
				 Double num = Double.parseDouble(textField_1.getText());
				 Double result = num*0.001;
			     textfield_2.setText(""+result);
			     errorLabel1.setText("");
			 }
			 else if (choice1.getValue()=="km" && choice2.getValue()=="m") {
				 Double num = Double.parseDouble(textField_1.getText());
				 Double result = num*1000;
			     textfield_2.setText(""+result);
			     errorLabel1.setText("");
			 }
			 else if (choice1.getValue()=="km" && choice2.getValue()=="cm") {
				 Double num = Double.parseDouble(textField_1.getText());
				 Double result = num*100000;
			     textfield_2.setText(""+result);
			     errorLabel1.setText("");
			 }
			 else
			 {
			        errorLabel1.setText("Wrong !!");
			        textfield_2.setText("");
			 }
			 
		                  
		 }
		 );
		
		
		
		
		
		gp.setStyle("-fx-padding: 250;" +
				    "-fx-text-fill: white;" +
					"-fx-font-weight: bold;" +
					"-fx-font-family: Arial Narrow;" +
					"-fx-font-size: 20px;" 
		 		);
		textfield_2.setStyle("-fx-background-color: white;" + 
		 					"-fx-font-weight: bold;" + 
		 					"-fx-font-color: black;" +
		 					"-fx-font-size: 20px; "
		 					
				);
		
		tab.setContent(gp);
	}

}

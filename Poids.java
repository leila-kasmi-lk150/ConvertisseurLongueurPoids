package convertisseurlongueurpoidsjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Poids {
Tab tab;
	
	public Poids(Tab tab) {
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
		
		
		RadioButton rb1 = new RadioButton("mg");
        RadioButton rb2 = new RadioButton("g");
        RadioButton rb3 = new RadioButton("kg");
		
		gp.add(rb1,2, 0);
		gp.add(rb2, 3, 0);
		gp.add(rb3,4, 0);
		
		ToggleGroup group1 = new ToggleGroup();
		
        rb1.setToggleGroup(group1);
        rb2.setToggleGroup(group1);
        rb3.setToggleGroup(group1);
        
        rb1.setSelected(true);
		
		Label label_2 = new Label("VALEUR :");
		TextField textField_2 = new TextField();
		textField_2.setDisable(true);
		textField_2.setStyle("-fx-border-color: black;" +
							"-fx-background-color: white;"
				);
		gp.add(label_2,0,1);
		gp.add(textField_2, 1, 1);
		
		RadioButton rb4 = new RadioButton("mg");
        RadioButton rb5 = new RadioButton("g");
        RadioButton rb6 = new RadioButton("kg");
        
        gp.add(rb4,2, 1);
		gp.add(rb5, 3, 1);
		gp.add(rb6,4,1);
		
		ToggleGroup group2 = new ToggleGroup();
		
        rb4.setToggleGroup(group2);
        rb5.setToggleGroup(group2);
        rb6.setToggleGroup(group2);
        
        rb4.setSelected(true);
		
		Button convertir = new Button("CONVERTIR");
		Label errorLabel = new Label();
		gp.add(convertir, 0, 2);
		gp.add(errorLabel, 1, 2);
		
		errorLabel.setTextFill(Color.RED);
		
			 convertir.setOnAction(e -> 
			 {
				 if((!textField_1.getText().matches("\\d*?\\.?\\d+"))){
					 textField_1.setText("");
					 errorLabel.setText("error ! enter number");
				 }
				 else if (textField_1.getText()==null) {
					 errorLabel.setText("SVP entrer la valeur !");
					 textField_2.setText("");
				 }
				 else if (rb1.isSelected() && rb4.isSelected() || rb2.isSelected() && rb5.isSelected() || rb3.isSelected() && rb6.isSelected() )
			    {
			      textField_2.setText(textField_1.getText());
			      errorLabel.setText("");
			    }
				 else if(rb3.isSelected() && rb4.isSelected()) {
					 Double num = Double.parseDouble(textField_1.getText());
				     Double result = num*1000000;
				     textField_2.setText(""+result);
				     errorLabel.setText("");
				 }
				 else if(rb3.isSelected() && rb5.isSelected()) {
					 Double num = Double.parseDouble(textField_1.getText());
				     Double result = num*1000;  
				     textField_2.setText(""+result);
				     errorLabel.setText("");
				 }
				 else if(rb2.isSelected() && rb6.isSelected()) {
					 Double num = Double.parseDouble(textField_1.getText());
				     Double result = num/1000;  
				     textField_2.setText(""+result);
				     errorLabel.setText("");
				 }
				 else if(rb2.isSelected() && rb4.isSelected()) {
					 Double num = Double.parseDouble(textField_1.getText());
				     Double result = num*1000;  
				     textField_2.setText(""+result);
				     errorLabel.setText("");
				 }
				 else if(rb1.isSelected() && rb5.isSelected()) {
					 Double num = Double.parseDouble(textField_1.getText());
				     Double result = num/1000;  
				     textField_2.setText(""+result);
				     errorLabel.setText("");
				 }
				 else if(rb1.isSelected() && rb6.isSelected()) {
					 Double num = Double.parseDouble(textField_1.getText());
				     Double result = num/1000000;
				     textField_2.setText(String.format("%.6f", result));
				     errorLabel.setText("");
				 }
			         else
			 {
			        errorLabel.setText("Wrong !!");
			        textField_2.setText("");
			 }           
			 }
			 );
		 
			 gp.setStyle("-fx-padding: 250;" +
					 "-fx-text-fill: white;" +
						"-fx-font-weight: bold;" +
						"-fx-font-family: Arial Narrow;" +
						"-fx-font-size: 20px;" 
			 		);
		tab.setContent(gp);
	}
}

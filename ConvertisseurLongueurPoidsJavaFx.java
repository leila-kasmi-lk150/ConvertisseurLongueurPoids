package convertisseurlongueurpoidsjavafx;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class ConvertisseurLongueurPoidsJavaFx extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane tp = new TabPane();
			tp.setId("tab-pane");
			VBox v1 = new VBox();
			v1.getChildren().add(tp);
			Tab tp1 = new Tab("Longueur");
			tp1.setId("tp12");
			Tab tp2 = new Tab("Poids");
			tp2.setId("tp12");
			tp2.setClosable(false);
			tp1.setClosable(false);
			tp.getTabs().addAll(tp1,tp2);
			tp.prefHeightProperty().bind(primaryStage.heightProperty());
			new Longueur(tp1).open();
			new Poids(tp2).open();
			
			AnchorPane root = new AnchorPane();
			root.getChildren().addAll(v1);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

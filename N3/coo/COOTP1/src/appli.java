import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class appli extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		RadioChat rc = new RadioChat();
		rc.radio();
		
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}

}

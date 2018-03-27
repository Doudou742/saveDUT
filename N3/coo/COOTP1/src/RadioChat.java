import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioChat extends Subject{
	protected String tmp = "";
	protected TextField field=new TextField();

	protected TextArea area=new TextArea();
	
	public void radio() {
		VBox vb = new VBox();
		Stage stage = new Stage();
		area.setEditable(false);
		Button button=new Button("Nouvel Auditeur");
		button.setPrefSize(200, 20);
		button.setOnAction(e-> nouveauAudit() );
		field.setOnAction(e->{
			String texte = field.getText()+"\n";
			area.appendText(texte);
			tmp=texte;
			field.setText("");
			for(Observer ob: observers){
				ob.update();
			}
		});
		vb.getChildren().addAll(button,area,field);
		Scene sc = new Scene(vb,200,200);
		stage.setTitle("RadioChat");
		stage.setScene(sc);
		stage.setResizable(false);
		stage.show();
		
	}
	public void write(String texte) {
		tmp=texte;
		area.appendText(texte);
	}
	
	private void nouveauAudit() {
		new Auditeur(this);
	}	
}



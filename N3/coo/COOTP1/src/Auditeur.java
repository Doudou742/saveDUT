import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Auditeur implements Observer {
	protected RadioChat rc = new RadioChat();

	protected String tmp = "";
	protected TextArea area1=new TextArea();
	
	public Auditeur(RadioChat rc){
		this.rc=rc;
		rc.addObserver(this);

		Stage st=new Stage();
		VBox vb1 = new VBox();
		
		area1.setEditable(false);
		TextField field1 =new TextField();
		Scene sc1 = new Scene(vb1,200,200);
		vb1.getChildren().addAll(area1,field1);
		st.setTitle("Auditeur");
		st.setScene(sc1);
		st.show();
		field1.setOnAction(e->fieldauditor(rc, field1));
	}

	private void fieldauditor(RadioChat rc, TextField field1) {
		String texte = field1.getText()+"\n";
		rc.write(texte);
		field1.setText("");
		for(Observer ob: rc.observers){
			ob.update();
		}
	}

	@Override
	public void update() {
		area1.appendText(rc.tmp);
		
	}

}

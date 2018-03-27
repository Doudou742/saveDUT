package fr.univ_lille1.iut_info.martinet.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "fr.univ_lille1.iut_info.martinet.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the OK button */
    public void doOK(View view) {
        EditText etFirst = (EditText) findViewById(R.id.first);
        EditText etLast = (EditText) findViewById(R.id.last);
        TextView tvP = (TextView) findViewById(R.id.message);

        if ((etFirst.getText().toString() != "") && (etFirst.getText().toString() != "")) {
            String m = getResources().getText(R.string.message) + " " + etFirst.getText() + " " + etLast.getText() + " !";
            tvP.setText(m);
            tvP.setTextColor(getResources().getColor(R.color.myNiceBlue));
        }
    }

    /** Called when the user taps the CANCEL button */
    public void doCANCEL(View view) {
        EditText etFirst = (EditText) findViewById(R.id.first);
        EditText etLast = (EditText) findViewById(R.id.last);
        TextView tvP = (TextView) findViewById(R.id.message);
        etFirst.setText("");
        etLast.setText("");
        tvP.setText(R.string.message);
        tvP.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    /** Called when the user taps the => button to open a new activity */
    public void doNEW(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText etFirst = (EditText) findViewById(R.id.first);
        EditText etLast = (EditText) findViewById(R.id.last);
        String m = getResources().getText(R.string.message)+" "+etFirst.getText()+" "+etLast.getText()+" !";
        intent.putExtra(EXTRA_MESSAGE, m);
        startActivity(intent);
    }

}

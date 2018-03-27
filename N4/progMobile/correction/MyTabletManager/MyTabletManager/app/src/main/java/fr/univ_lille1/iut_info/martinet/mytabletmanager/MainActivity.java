package fr.univ_lille1.iut_info.martinet.mytabletmanager;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static final int PICK_CONTACT_REQUEST = 0;
    static final int DATE_CHANGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvDate = (TextView) findViewById(R.id.date);
        //String today = DateFormat.getDateTimeInstance().format(new Date());
        String today  = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        tvDate.setText(today);

        Spinner spTerminal = (Spinner) findViewById(R.id.terminal);
        ArrayAdapter adTerminal = ArrayAdapter.createFromResource(this, R.array.tablets, android.R.layout.simple_spinner_item) ;
        spTerminal.setAdapter(adTerminal) ;
        spTerminal.setOnItemSelectedListener(this);

        Spinner spEtudiant = (Spinner) findViewById(R.id.student);
        ArrayAdapter adEtudiant = ArrayAdapter.createFromResource(this, R.array.students, android.R.layout.simple_spinner_item) ;
        spEtudiant.setAdapter(adEtudiant) ;
        spEtudiant.setOnItemSelectedListener(this);


    }

    public void doChangeDate(View view) {
        startActivityForResult(
                new Intent(this, ChangeDateActivity.class),
                DATE_CHANGE_REQUEST);

    }

    public void doPickContact(View view) {
        startActivityForResult(
                new Intent(Intent.ACTION_PICK , ContactsContract.Contacts.CONTENT_URI),
                PICK_CONTACT_REQUEST) ;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, getString(R.string.toastContactSelected), Toast.LENGTH_LONG).show();
            } else Toast.makeText(this, getString(R.string.toastContactCanceled), Toast.LENGTH_LONG).show();
        }

        if (requestCode == DATE_CHANGE_REQUEST) {
            if (resultCode == RESULT_OK) {
                TextView tvDate = (TextView) findViewById(R.id.date);
                String today = data.getStringExtra(ChangeDateActivity.KEY_DATE);
                tvDate.setText(today);
                Toast.makeText(this, String.format("You selected%s", data), Toast.LENGTH_LONG).show();
            }

        }
    }

    public void doCall(View view) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0612345678")));
    }

    public void doSMS(View view) {
        // Create the text message with a string
        Intent smsIntent = new Intent();
        smsIntent.setAction(Intent.ACTION_SEND);
        smsIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this sms was sent by my intent !");
        smsIntent.setType("text/plain");

        // Verify that the intent will resolve to an activity
        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        }
    }

}

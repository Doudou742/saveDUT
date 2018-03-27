package fr.univ_lille1.iut_info.martinet.mytabletmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ChangeDateActivity extends AppCompatActivity {

    public static final String KEY_DATE = "fr.univ_lille1.iut_info.martinet.mytabletmanager.DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_date);
    }

    public void onOk(View view) {
        DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        Intent result = new Intent();
        GregorianCalendar gc = new GregorianCalendar(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
        result.putExtra(KEY_DATE, new SimpleDateFormat("dd-MM-yyyy").format(gc.getTime()));
        setResult(RESULT_OK, result);
        finishActivity(MainActivity.DATE_CHANGE_REQUEST);
    }

    public void onCancel(View view) {
        setResult(RESULT_OK, null);
        finishActivity(MainActivity.DATE_CHANGE_REQUEST);
    }
}

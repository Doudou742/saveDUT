package fr.univ_lille1.iut_info.martinet.maliste;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    String tasks[];
    boolean status[];
    TextView selection;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection=(TextView)findViewById(R.id.selection);

        // init tasks and status
        tasks = getResources().getStringArray(R.array.items);
        int n = tasks.length;
        status = new boolean[n];
        for(int i=0;i<n;i++) status[i] = (Math.random() > 0.5);

        // attach adapter
        aa = new MonTacheAdapter();
        setListAdapter(aa);
    }

    @Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText("You selected: " + tasks[position]);
        if (status[position]) status[position] = false;
        else status[position] = true;
        aa.notifyDataSetChanged();
    }


    class MonTacheAdapter extends ArrayAdapter {
        MonTacheAdapter() {
            super(MainActivity.this, R.layout.row, tasks);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row, parent, false);
            TextView label=(TextView)row.findViewById(R.id.label);

            label.setText(tasks[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.icon);

            if (status[position]) icon.setImageResource(R.drawable.icon_ok);
            else icon.setImageResource(R.drawable.icon_not_ok);

            return(row);
        }
    }

}



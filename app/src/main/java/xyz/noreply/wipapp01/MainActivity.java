package xyz.noreply.wipapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendButton = (Button) findViewById(R.id.sendButton);
        final EditText listEntry = (EditText) findViewById(R.id.listEntryField);
        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ListView list = (ListView) findViewById(R.id.listView);
        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.listtextview, arrayList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "ID: " + String.valueOf(id) + ", position: " + String.valueOf(position));
                //arrayList.remove(position);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(listEntry.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });


    }
}

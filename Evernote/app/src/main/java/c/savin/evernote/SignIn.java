package c.savin.evernote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SignIn extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        listView = (ListView)findViewById(R.id.listView);

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");

        List<String> title = MainActivity.myAppDatabase.myNote().allTitle(username);
        final List<Integer> id_n = MainActivity.myAppDatabase.myNote().allId(username);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, title);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                int pos = (int)parent.getItemIdAtPosition(position);

                Intent i = new Intent(SignIn.this, updateNote.class);
                i.putExtra("id", id_n.get(pos));
                startActivity(i);

            }
        });

    }



    public void addNote(View view){

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");

        Intent i = new Intent(SignIn.this, addNote.class);
        i.putExtra("username", username);
        startActivity(i);

    }

    public void refresh(View view){

        finish();
        startActivity(getIntent());

    }

}

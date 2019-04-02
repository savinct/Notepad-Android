package c.savin.evernote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class updateNote extends AppCompatActivity {

    private TextView Title;
    private TextView Content;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        Title = (TextView)findViewById(R.id.title);
        Content = (TextView)findViewById(R.id.content);

        Bundle extras = getIntent().getExtras();
        int int_n = extras.getInt("id");

        note = MainActivity.myAppDatabase.myNote().note(int_n);

        Title.setText(note.getTitle());
        Content.setText(note.getContent());

    }

    public void deleteNote(View view){

        MainActivity.myAppDatabase.myNote().delteNote(note);
        Toast.makeText(this, "The note is deleted!", Toast.LENGTH_SHORT).show();

    }

    public void updateNote(View view){

        String title = Title.getText().toString();
        String content = Content.getText().toString();

        note.setTitle(title);
        note.setContent(content);

        MainActivity.myAppDatabase.myNote().updateNote(note);
        Toast.makeText(this, "Update complete!", Toast.LENGTH_SHORT).show();

    }

}

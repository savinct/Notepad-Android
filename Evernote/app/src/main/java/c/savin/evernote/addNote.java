package c.savin.evernote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class addNote extends AppCompatActivity {

    private TextView Title;
    private TextView Content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

    }

    public void addNoteHandler(View view){


        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");

        Title = (TextView)findViewById(R.id.title);
        Content = (TextView)findViewById(R.id.content);
        String title = Title.getText().toString();
        String content = Content.getText().toString();

        if(title.length() > 0){
            Note n = new Note();
            n.setTitle(title);
            n.setContent(content);
            n.setUserN(username);

            MainActivity.myAppDatabase.myNote().insertNote(n);

            Toast.makeText(addNote.this, "The note was created", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(addNote.this, "Title exists!", Toast.LENGTH_SHORT).show();
        }

        /*
        Intent i = new Intent(addNote.this, SignIn.class);

        startActivity(i);*/

    }

}

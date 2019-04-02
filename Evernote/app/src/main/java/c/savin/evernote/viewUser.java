package c.savin.evernote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
public class viewUser extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);


        textView = (TextView)findViewById(R.id.textView);
        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();

        String info = "";

        for(User usr : users){
            String user = usr.getUsernam();
            String name = usr.getName();
            String email = usr.getEmail();

            info = info + "\n\n" + "Username : " + user + "\n" + "Name : " + name + "\n" + "Email : " + email;
        }

        textView.setText(info);

    }
}

package c.savin.evernote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class updateUser extends AppCompatActivity {

    private Spinner Spiner;
    private TextView Name;
    private TextView Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        Spiner = (Spinner)findViewById(R.id.spinner2);
        List<String> list = MainActivity.myAppDatabase.myDao().allUser();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        Spiner.setAdapter(dataAdapter);

        Spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Name = (TextView)findViewById(R.id.name);
                Email = (TextView)findViewById(R.id.mail);


                String usr = Spiner.getSelectedItem().toString();
                User u =  MainActivity.myAppDatabase.myDao().infoUser(usr);

                Name.setText(u.getName());
                Email.setText(u.getEmail());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void onUpdate(View view){

        Name = (TextView)findViewById(R.id.name);
        Email = (TextView)findViewById(R.id.mail);
        Spiner = (Spinner)findViewById(R.id.spinner2);

        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String user = Spiner.getSelectedItem().toString();
        String password = MainActivity.myAppDatabase.myDao().ceckPassword(user);


        User u = new User();
        u.setUsernam(user);
        u.setName(name);
        u.setEmail(email);
        u.setPasswor(password);

        MainActivity.myAppDatabase.myDao().updateUser(u);

        Toast.makeText(updateUser.this, "Update complete!", Toast.LENGTH_SHORT).show();

    }

    public void onDelete(View view){

        String u = Spiner.getSelectedItem().toString();

        User user = new User();
        user.setUsernam(u);
        MainActivity.myAppDatabase.myDao().deleteUser(user);

        Toast.makeText(updateUser.this, "User successfully removed", Toast.LENGTH_SHORT).show();

        List<String> list = MainActivity.myAppDatabase.myDao().allUser();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        Spiner.setAdapter(dataAdapter);


    }
}

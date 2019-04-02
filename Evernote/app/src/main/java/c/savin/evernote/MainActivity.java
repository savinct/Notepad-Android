package c.savin.evernote;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    private TextView Username;
    private TextView Password;

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
    }

    public void onSignIn(View v){
        /*
        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                myAppDatabase.myDao().updateUser();
            }
        });*/

       // Log.d("SAVIN: ", "onSignIn: I'm here1");
        Username = (TextView)findViewById(R.id.username);
        Password = (TextView)findViewById(R.id.password);

        String username = Username.getText().toString();
        String password = Password.getText().toString();

        if(username.equals("admin") && password.equals("admin")){

            Intent i = new Intent(MainActivity.this, AdminUser.class);
            startActivity(i);

        }else{

            String p = encodePassword(password);

            if(MainActivity.myAppDatabase.myDao().ceckUsername(username) != null) {
                if(p.equals(MainActivity.myAppDatabase.myDao().ceckPassword(username))){

                    Intent i = new Intent(MainActivity.this, SignIn.class);
                    i.putExtra("username", username);
                    startActivity(i);

                }else{
                    Toast.makeText(MainActivity.this, "Passwords or/and Username is/are incorrect!", Toast.LENGTH_SHORT).show();

                }

            }else{
                Toast.makeText(MainActivity.this, "Passwords or/and Username is/are incorrect!", Toast.LENGTH_SHORT).show();

            }

        }

    }

    public void onSingUp(View v){

        Intent i = new Intent(MainActivity.this, SignUp.class);
        startActivity(i);

    }

    private String encodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

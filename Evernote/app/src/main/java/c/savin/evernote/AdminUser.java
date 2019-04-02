package c.savin.evernote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);
    }

    public void addUser(View view){

        Intent i = new Intent(AdminUser.this, SignUp.class);
        startActivity(i);

    }

    public void onView(View v){

        Intent i = new Intent(AdminUser.this, viewUser.class);
        startActivity(i);

    }


    public void onUpdate(View v){

        Intent i = new Intent(AdminUser.this, updateUser.class);
        startActivity(i);

    }

}

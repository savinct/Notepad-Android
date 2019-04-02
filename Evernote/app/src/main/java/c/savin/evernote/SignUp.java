package c.savin.evernote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

public class SignUp extends AppCompatActivity {

    private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private TextView Usernam;
    private TextView Name;
    private TextView Email;
    private TextView Passwor;
    private TextView Cpasswor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void addUser1(View view){

        Usernam = (TextView)findViewById(R.id.username);
        Name = (TextView)findViewById(R.id.name);
        Email = (TextView)findViewById(R.id.mail);
        Passwor = (TextView)findViewById(R.id.password);
        Cpasswor = (TextView)findViewById(R.id.cpassword);


        String usernam = Usernam.getText().toString();
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String passwor = Passwor.getText().toString();
        String cpassword = Cpasswor.getText().toString();

        if(usernam.length() > 0 && name.length() > 0 && email.length() > 0 && passwor.length() > 0) {
            if (passwor.equals(cpassword)) {
                if (email.matches(EMAIL_VALIDATION_REGEX)) {
                    if (MainActivity.myAppDatabase.myDao().ceckUsername(usernam) == null) {
                        User user = new User();
                        user.setUsernam(usernam);
                        user.setName(name);
                        user.setEmail(email);

                        String p = encodePassword(passwor);
                        user.setPasswor(p);

                        MainActivity.myAppDatabase.myDao().addUser(user);
                        Toast.makeText(SignUp.this, "User added successfully!", Toast.LENGTH_SHORT).show();

                        Usernam.setText("");
                        Name.setText("");
                        Email.setText("");
                        Passwor.setText("");
                        Cpasswor.setText("");

                    } else {
                        Toast.makeText(SignUp.this, "Username exists!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast pass = Toast.makeText(SignUp.this, "Invalid email! ", Toast.LENGTH_SHORT);
                    pass.show();
                }
            } else {
                Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(SignUp.this, "All fields are required!", Toast.LENGTH_SHORT).show();
        }

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

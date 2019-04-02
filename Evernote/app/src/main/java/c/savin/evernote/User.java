package c.savin.evernote;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {

    @NonNull
    @PrimaryKey
    String usernam;

    @ColumnInfo(name = "user_name")
    String name;

    @ColumnInfo(name = "user_email")
    String email;

    @ColumnInfo(name = "user_passwor")
    String passwor;

    public String getUsernam() {
        return usernam;
    }

    public void setUsernam(String usernam) {
        this.usernam = usernam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }
}

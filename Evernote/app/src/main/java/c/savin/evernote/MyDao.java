package c.savin.evernote;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.provider.ContactsContract;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);


    @Query("SELECT usernam FROM users WHERE usernam = :User")
    public String ceckUsername(String User);

    @Query("SELECT user_passwor FROM users WHERE usernam = :User")
    public String ceckPassword(String User);

    @Query("SELECT usernam FROM users")
    public List<String> allUser();

    @Query("SELECT * FROM users WHERE usernam = :User")
    public User infoUser(String User);

    //@Query("select * from users where  usernam ="
}

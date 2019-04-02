package c.savin.evernote;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyNote {

    @Insert
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void delteNote(Note note);

    @Query("SELECT * FROM notes WHERE noteId = :id")
    public Note note(int id);

    @Query("SELECT note_title FROM notes WHERE note_userN = :userN")
    public List<String> allTitle(String userN);

    @Query("SELECT noteId FROM notes WHERE note_userN = :userN")
    public List<Integer> allId(String userN);


}

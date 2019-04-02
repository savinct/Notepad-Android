package c.savin.evernote;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class, Note.class}, version = 2)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
    public  abstract MyNote myNote();

}

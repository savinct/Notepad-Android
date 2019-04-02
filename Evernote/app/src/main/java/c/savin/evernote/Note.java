package c.savin.evernote;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Note {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    int noteId;

    @ColumnInfo(name = "note_title")
    String title;

    @ColumnInfo(name = "note_content")
    String content;

    @ColumnInfo(name = "note_userN")
    String userN;

    @NonNull
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(@NonNull int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }
}

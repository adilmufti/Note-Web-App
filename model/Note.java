package ucl.ac.uk.model;

import java.util.ArrayList;

public class Note {
    private String title;
    private String noteBody;

    public Note(ArrayList<String> notes) {
        this.title = notes.get(0).replace("=*+", ",");
        this.noteBody = notes.get(1).replace("=*+", ",");
    }

    public void setName(String title) {this.title = title.replace("--", ","); }
    public void setNoteBody(String noteBody) {this.noteBody = noteBody.replace("--", ","); }

    public String getTitle() {
        return this.title;
    }

    public String getNoteBody() {
        return this.noteBody;
    }
    //public  String getDate() {return this.date;}
}

//Add note objects to a note arraylist. The arraylist holds each of the parts of the notes, at different
//indexes. To do this, it stops scanning and appends everytime it spots a comma. This means we need to
//replace the commas in the notes. Then after the notes adn their indexes have been created and initialised
//we replace the special random characters into commas.
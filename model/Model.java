package ucl.ac.uk.model;

import java.io.*;
import java.util.*;


public class Model {
  public ArrayList<Note> notes = new ArrayList<>();
  public ArrayList<String> onenote = new ArrayList<>();

  public void readFile(File file) throws FileNotFoundException {
    notes.clear();

    //System.out.println("read file at: " + file.getPath());
    Scanner scan = new Scanner(file);
    scan.useDelimiter(",");
    int count = 0;
    while (scan.hasNext() & count < 2) {
      onenote.add(scan.next());
      count++;
      if (count == 2) {
        Note note = new Note(onenote);
        onenote.remove(0);
        onenote.remove(0);
        count = 0;
        String titles = note.getTitle();
        //System.out.println(titles);
        notes.add(note);
      }
    }
    scan.close();


    // Read a data file and store the data in your data structure.
  }

  public List<Note> getNotes() {return new ArrayList<>(notes);}

  public Note getNoteFromName(String title) {
    for (Note note : notes) {
      if (note.getTitle().equals(title)) return note;
    }
    return null;
  }

  public void createNote(String filename, String filebody) {
    filename = filename.replace(",", "=*+");
    filebody = filebody.replace(",", "=*+");
    String title = filename + ".txt";
    try {
      File file = new File("./data" + "/" + title);
      System.out.println(file);
      if (file.createNewFile()) {
        System.out.println("File created: " + file.getName());
        FileWriter note= new FileWriter(file);
        note.write(filebody);
        note.close();

        FileWriter allnotes = new FileWriter("./data/allNotes.txt", true);
        allnotes.write(filename+"," + filebody+",");
        allnotes.close();
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static String fileToString(String path) throws Exception{
    String input = null;
    Scanner sc = new Scanner(new File(path));
    StringBuffer sb = new StringBuffer();
    while (sc.hasNextLine()) {
      input = sc.nextLine();
      sb.append(input);
    }
    return sb.toString();
  }

  public List<String> searchFor(String keyword) {
      ArrayList<String> noteNames = new ArrayList<>();
      for (Note note : notes) {
          String name = note.getTitle();
          if (name.contains(keyword)) noteNames.add(name);
      }
      return noteNames;
  }

  public void deleteNote(String deletion) throws Exception {
    String result = fileToString("./data/allNotes.txt");
    result = result.replaceAll(deletion, "");
    //Rewriting the contents of the file
    PrintWriter writer = new PrintWriter(new File("./data/allNotes.txt"));
    writer.append(result);
    writer.flush();
    readFile(new File("./data/allNotes.txt"));
  }

  public void editNote(String modify, String modified) throws Exception {
    System.out.println("modify: " + modify);
    System.out.println("modified: " + modified);

    String result = fileToString("./data/allNotes.txt");
    result = result.replaceAll(modify, modified);

    //Rewriting the contents of the file
    PrintWriter writer = new PrintWriter(new File("./data/allNotes.txt"));
    writer.append(result);
    writer.flush();
    readFile(new File("./data/allNotes.txt"));
    // TODO: When click edit note it takes you to input boxes done
    // TODO: Input boxes are already filled in with previous text done
    // TODO: When edited, replace old note string with new note string in txt file
    // TODO: Then readfile();
  }

  public List<Note> sorted (ArrayList<Note> data){
    data.sort(Comparator.comparing(Note::getTitle));
    return data;
  }

  public List<String> sortarray (List<String> data){
    Collections.sort(data);
    // TODO: Create an ordered list holding Object references except now the object references are in order by title
    // TODO: Take the returned strings and return their objects?
    return data;
  }
}
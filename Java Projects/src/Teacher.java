import java.util.*;
import java.io.*;

class Teacherrec implements Serializable {
  String name;
  String qualification;
  String contact_no;

  void input() {
    Scanner se = new Scanner(System.in);
    System.out.println("Teacher name; qualifications; contact_no:");
    name = se.nextLine();
    qualification = se.nextLine();
    contact_no = se.nextLine();

  }

  public String toString() {
    return (name + qualification + contact_no);

  }
}

class Teacher {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    System.out.println();
    writeObject();
    Teacherrec s = (Teacherrec)readObj();
    System.out.println(s);
    
    

  }
  
  public static void writeObject(){
      try {
      FileOutputStream fout = new FileOutputStream("teacher.txt");
      Teacherrec s = new Teacherrec();
      ObjectOutputStream out = new ObjectOutputStream(fout);
      s.input();
      out.writeObject(s);
      System.out.println("Record Saved");
      fout.flush();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Object readObj() throws IOException, ClassNotFoundException{
    Teacherrec s = null;
    try {
      FileInputStream fin = new FileInputStream("teacher.txt");

      ObjectInputStream in = new ObjectInputStream(fin);
      s = (Teacherrec) in.readObject();
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    return s;

  }

}
import java.util.*;
import java.io.*;

class Studentrec implements Serializable {
  int rno;
  String name;
  String address;
  String contact_no;

  void input() {
    Scanner se = new Scanner(System.in);
    System.out.println("Student name; address; contact_no; rno:");
    name = se.nextLine();
    address = se.nextLine();
    contact_no = se.nextLine();
    rno = se.nextInt();

  }

  public String toString() {
    return (name + address + contact_no);

  }
}

class Student {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    System.out.println();
    writeObject();
    Studentrec s = (Studentrec)readObj();
    System.out.println(s);
    
    

  }
  
  public static void writeObject(){
      try {
      FileOutputStream fout = new FileOutputStream("student.txt");
      Studentrec s = new Studentrec();
      ObjectOutputStream out = new ObjectOutputStream(fout);
      s.input();
      out.writeObject(s);
      System.out.println("Record Saved");
      // fout.flush();
      fout.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Object readObj() throws IOException, ClassNotFoundException{
    Studentrec s = null;
    try {
      FileInputStream fin = new FileInputStream("student.txt");

      ObjectInputStream in = new ObjectInputStream(fin);
      s = (Studentrec) in.readObject();
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    return s;

  }

}
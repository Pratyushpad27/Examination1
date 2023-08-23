import java.util.*;
import java.io.*;
class Examinationrec implements Serializable{
    int room_num;
    int time;
    int capacity;
    void input() {
        Scanner se = new Scanner(System.in);
        System.out.println("Exmaination Room Number; Time; Capacity:");
        room_num = se.nextInt();
        time = se.nextInt();
        capacity = se.nextInt();

    }
    public String toString() {
      String srno=Integer.toString(room_num);
      String st=Integer.toString(time);
      String sc=Integer.toString(capacity);
        return (srno+st+sc);

}
}
public class Examination {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    System.out.println();
    writeObject();
    Examinationrec i = (Examinationrec)readObj();
    System.out.println(i);
}

 public static void writeObject(){
      try {
      FileOutputStream fout = new FileOutputStream("examination.txt");
      Examinationrec i = new Examinationrec();
      ObjectOutputStream out = new ObjectOutputStream(fout);
      i.input();
      out.writeObject(i);
      System.out.println("Record Saved");
      fout.flush();
      
    } catch (IOException e) {
      e.printStackTrace();
    
    }

    
  }

  public static Object readObj() throws IOException, ClassNotFoundException{
    Examinationrec i = null;
    try {
      FileInputStream fin = new FileInputStream("examination.txt");

      ObjectInputStream in = new ObjectInputStream(fin);
      i = (Examinationrec) in.readObject();
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    return i;
  }
}

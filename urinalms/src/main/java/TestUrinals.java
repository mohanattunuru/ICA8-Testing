import java.io.*;
import java.util.Scanner;

public class TestUrinals {

    public static void main(String[] args) throws IOException {

        Urinals u = new Urinals();

        Scanner countIn = new Scanner(new File("src\\main\\resources\\count.txt"));

        int count = 0;
        try{
            count = Integer.parseInt(countIn.next());
        }catch (Exception ignore){}

        // updating counter var
        FileWriter countW = new FileWriter("src\\main\\resources\\count.txt");
        count++;
        countW.write(count+"");
        countW.close();

        // creating output file
        FileWriter outputW = new FileWriter("src\\main\\resources\\rule"+count+".txt");

        String eol = "";
        String input = u.getString();
        while (input!=null){
            boolean goodString = u.goodString(input);
            if (goodString) {
                int uCount = u.countUrinals(input);
                outputW.write(eol+uCount);
                input = u.getString();
            }else{
                System.out.println("Bad input: '"+input+"'");
                break;
            }
            eol = "\n";
        }
        outputW.close();

        System.out.println("OUTPUT SAVED TO: 'src\\main\\resources\\rule"+count+".txt'");

    }

}

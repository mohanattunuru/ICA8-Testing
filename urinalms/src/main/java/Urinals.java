
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Mohana Narasimha Reddy Attunuru */
public class Urinals {

    Scanner input;


    public Urinals(){
        try {
            input = new Scanner(new File("src\\main\\resources\\urinal.txt"));
        } catch (FileNotFoundException ignore) {
        }
    }



    String getString(){
        if (input.hasNextLine())
            return input.nextLine();
        return null;
    }


    int countUrinals(String str){
        int length = str.length();

        if (length==1){
            return str.equals("0") ? 1 : 0;
        }
        //if found two
        Pattern pattern = Pattern.compile("[1]{2}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())return -1;

        if(length == 2){
            return str.contains("1")? 0 : 1;
        }

        char[] chars = str.toCharArray();


        int count = 0;


        char lastCh=chars[0];

        for (int i = 0 ; i<length; i++) {
            char c = chars[i];

            char nextCh = i==length-1 ? str.charAt(i) : str.charAt(i+1);
            if (c=='0' && lastCh != '1' && nextCh != '1'){
                count++;
                chars[i]='1';
            }
            lastCh = chars[i];
        }

        return count;
    }

    // checks to see if valid string
    boolean goodString(String str) {
        //1 <= Length <= 20
        if(1<=str.length() && str.length() <= 20)
            return str.matches("[0-1]+");
        else
            return false;
    }

}


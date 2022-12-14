import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UrinalsTest {

    @Mock
    static Urinals urinals;
    static Urinals u;

    Scanner fileIn;
    Scanner fileInBad;
    Scanner fileOut;


    @BeforeEach
    void setup() {
        urinals = mock(Urinals.class);

        try {
            fileInBad = new Scanner(new File("src\\test\\resources\\badInput.txt"));
            fileIn = new Scanner(new File("src\\test\\resources\\input.txt"));
            fileOut = new Scanner(new File("src\\test\\resources\\output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        u = new Urinals();
    }


    @Test()
    void getString() {
        assertEquals("101000", fileIn.nextLine());
    }

    @Test
    void getWrongString() {
        assertNotEquals("11111",fileIn.nextLine());
    }

    @Test
    void goodString() {
        String str = fileIn.nextLine();
        assertTrue(u.goodString(str));
    }

    @Test
    void badString() {
        assertFalse(u.goodString(fileInBad.nextLine()));
    }




    @Test
    void countAllUrinals() {
        while (fileIn.hasNextLine() && fileOut.hasNextLine()) {
            String in = fileIn.nextLine();
            String out = fileOut.nextLine();
            assertEquals(out, u.countUrinals(in)+"");
        }
    }

    @Test
    void countOneUrinals() {
        String in = fileIn.nextLine();
        String out = fileOut.nextLine();
        assertEquals(out, u.countUrinals(in)+"");
    }
}
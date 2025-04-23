import org.junit.Before;
import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
    private String hamletRegex;
    private Pattern horatio;
    private Pattern hamlet;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
        this.hamletRegex = hamletParser.loadNewScript();
        this.horatio = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        this.hamlet = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
    }

    @Test
    public void testMakeNewFile() {
        String expected = "hamletRegex.txt";
        String actual = hamletParser.makeNewFile();
        assertEquals(expected, actual);
    }

    @Test
    public void testNewFileNotNull() {
        assertNotNull(this.hamletRegex);
    }

    @Test
    public void testNewFileNotEmpty() {
        assertNotEquals(this.hamletRegex, "");
    }

    @Test
    public void testChangeHamletToLeon() {
        //check before changes
        assertTrue(this.hamletText.contains("Hamlet"));
        assertFalse(this.hamletText.contains("Leon"));
        //make changes
        this.hamletParser.loadNewScript();
        //check after changes
        assertFalse(this.hamletRegex.contains("Hamlet"));
        assertTrue(this.hamletRegex.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        //check before changes
        assertTrue(this.hamletText.contains("Horatio"));
        assertFalse(this.hamletText.contains("Tariq"));
        //make changes

        //check after changes
        assertFalse(this.hamletRegex.contains("Horatio"));
        assertTrue(this.hamletRegex.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {
        assertTrue(hamletParser.findHoratio());
    }

    @Test
    public void testFindHamlet() {
        assertTrue(hamletParser.findHamlet());
    }
}
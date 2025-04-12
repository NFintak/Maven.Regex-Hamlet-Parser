import org.junit.Before;
import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
    private Pattern horatio;
    private Pattern hamlet;
    private Matcher matchHoratio;
    private Matcher matchHamlet;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
        this.horatio = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        this.hamlet = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        this.matchHoratio = horatio.matcher(this.hamletText);
        this.matchHamlet = hamlet.matcher(this.hamletText);
    }

    @Test
    public void testChangeHamletToLeon() {
        //check before changes
        assertTrue(this.hamletText.contains("Hamlet"));
        assertFalse(this.hamletText.contains("Leon"));
        //make changes

        //check after changes
        assertFalse(this.hamletText.contains("Hamlet"));
        assertTrue(this.hamletText.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        //check before changes
        assertTrue(this.hamletText.contains("Horatio"));
        assertFalse(this.hamletText.contains("Tariq"));
        //make changes

        //check after changes
        assertFalse(this.hamletText.contains("Horatio"));
        assertTrue(this.hamletText.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {
        assertTrue(this.matchHoratio.find());
    }

    @Test
    public void testFindHamlet() {
        assertTrue(this.matchHamlet.find());
    }
}
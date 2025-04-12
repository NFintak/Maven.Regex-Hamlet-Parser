import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private Pattern horatio;
    private Pattern hamlet;
    private Matcher matchHoratio;
    private Matcher matchHamlet;

    public HamletParser(){
        this.hamletData = loadFile();
        this.horatio = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        this.hamlet = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        this.matchHoratio = horatio.matcher(this.hamletData);
        this.matchHamlet = hamlet.matcher(this.hamletData);
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String makeNewScript() {
        File newScript = null;
        try {
            newScript = new File("hamletRegex.txt");
            if (newScript.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println(newScript.getName() + " already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newScript.getName();
    }

    public void replaceHamletAndHoratio() {

    }

    public boolean findHoratio() {
        return this.matchHoratio.find();
    }

    public boolean findHamlet() {
        return this.matchHamlet.find();
    }

    public String getHamletData(){
        return hamletData;
    }

}

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;



public class ShortLister {
    public static void main(String[] args) {

        try {
            JFileChooser fileChooser = new JFileChooser();
            File workingDirectory = new File(System.getProperty("user.dir") + "\\src\\");

            fileChooser.setCurrentDirectory(workingDirectory);

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File readFile = fileChooser.getSelectedFile();
                Path readFilePath = readFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(readFilePath, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                String rec = "";
                ArrayList<Object> lines = new ArrayList<>();
                ArrayList<Object> wordList = new ArrayList<Object>();
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
                    System.out.printf("\n\tReading line %d\t %-60s", line, rec);
                }
                reader.close();
                System.out.print("\n\n\t----------------------");
                System.out.println("\n\tData File read.");
                System.out.print("\t----------------------\n");

                //for(Object wordUnfiltered : lines) wordList.add(wordUnfiltered);

                wordList = ShortWordFilter.collectAll(lines, new ShortWordFilter());

                System.out.print("\n\n\t---------------------------------");
                System.out.println("\n\tThe filter to display short worf from the file:");
                System.out.print("\t---------------------------------\n");
                for (Object tempobj : wordList) System.out.println("\t" + ((String) tempobj));

                for (int i = 0; i < 51; i++) System.out.print((i < 7 ? ' ' : '-'));
                System.out.print("\n\n\n");
            } else {
                System.out.println("\tFailed to choose a file to process...");
                System.out.println("\t Run the program again.");
                System.exit(0);
            }

        } catch (FileNotFoundException e) {
            System.out.println("\tFile is not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

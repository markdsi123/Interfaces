import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        //setting up to choose file in specific directory
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        File selectedFile;

        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> shortWords = new ArrayList<>();
        ShortWordFilter filter = new ShortWordFilter();

        try
        {
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while(reader.ready())
                {
                    //Add any line read in txt file into an arraylist
                    rec = reader.readLine();
                    lines.add(rec);

                    String[] words;
                    //Checking every single line in txt file from an array list
                    for(String line : lines)
                    {
                        //Split "," to retrieve all the word
                        words = line.split(",");
                        //For every single word in words, check if its length < 5, if yes
                        //then print out
                        for(String word : words) {
                            if (filter.accept(word)) {
                                //Add short word into an array list
                                shortWords.add(word);
                            }
                        }
                    }
                }
                //In case there is no short word in txt file
                if(shortWords.isEmpty())
                {
                    System.out.println("There is no short word in this file");
                }else
                    //Print out short words from array list
                    System.out.println("Words that are less than 5 character: " + shortWords);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
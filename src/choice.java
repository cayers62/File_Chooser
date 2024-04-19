import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class choice
{

        public static void main(String[] args)
            {
                JFileChooser chooser = new JFileChooser();
                Scanner inFile;
                String line;
                Path target = new File(System.getProperty("user.dir")).toPath();
                target = target.resolve("");
                chooser.setCurrentDirectory(target.toFile());

                try  // Code that might trigger the exception goes here
                {

                    if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                    {
                        target = chooser.getSelectedFile().toPath();
                        inFile = new Scanner(target);

                        while(inFile.hasNextLine())
                        {
                            line = inFile.nextLine();
                            System.out.println(line);
                        }

                        inFile.close();
                    }
                    else
                    {
                        System.out.println("Sorry, you must select a file! Termininating!");
                        System.exit(0);
                    }
                }
                catch (FileNotFoundException e)
                {
                    System.out.println("File Not Found Error");
                    e.printStackTrace();
                }
                catch (IOException e) // code to handle this exception
                {
                    System.out.println("IOException Error");
                    e.printStackTrace();
                }
            }

        }



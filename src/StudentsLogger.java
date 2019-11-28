
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2ndyrGroupA
 */
public class StudentsLogger {
    
    public static File getFile()
    {
        File file = new File("./src/log.txt");
        try {
            file.createNewFile();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return file;
    }

    public static void main(String[] args) {
//        File file = new File("./src/log.txt");
        System.out.println("Welcome to my life!!!");
        Scanner scanner = new Scanner (System.in);
        String name = scanner.nextLine();
        try {
            
            File file = getFile();
            if (file.canWrite()) {
                FileWriter fw = new FileWriter(file, true);
                fw.write(name +" log in @ "+ new Date().toString()+ " ");
                fw.append("\n");
                fw.close();
            }
            
//            if(file.delete()) {
//                System.out.println("Delete succesfully");
//            }
//            else {
//                System.out.println("Not deleted");
//            }

//            if(file.canRead()) {
//                System.out.println("Current log: ");
//                Scanner reader = new Scanner(file);
//                while(reader.hasNextLine()) {
//                    String line = reader.nextLine();
//                    System.out.println(line);
//                }
//                reader.close();
//            }
//            

            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

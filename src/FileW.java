package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileW {
    private static String name;
    private static File file;
    private static BufferedWriter p;

    public static void setFileName(String name) {
        FileW.name = name;
        try {
            FileW.file = new File(name);
            FileW.file.delete();
            FileW.p = new BufferedWriter(new FileWriter(FileW.file, true));
        } catch(IOException e) {
            System.out.println("ERROR. Couldnt append to " + FileW.name + " file :(");
        }
    }

    public static void print(String l) {
        try {
            p.write(l);
            p.newLine();
            p.flush();
        } catch (IOException e) {
            System.out.println("ERROR. Couldnt append to " + FileW.name + " file :(");
        }
    }

    public static void closeFile() {
        try {
            if (p != null) p.close();
        } catch (IOException e) {
            System.out.println("ERROR. Couldnt append to " + FileW.name + " file :(");
        }
    }
     
     
}
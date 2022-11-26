package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class Writer {

    public static int pontokSzama(String dirname){
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i< Main.MAIN_DIR_INDEX.toString().length(); i++){
            if(Main.MAIN_DIR_INDEX.toString().charAt(i) == '/'){
                count1++;
            }
        }
        for(int i=0; i< dirname.length(); i++){
            if(dirname.charAt(i) == '/'){
                count2++;
            }
        }
        return count2-count1;
    }
    public static void writeindex(String dirname){
        try {
            FileWriter myWriter = new FileWriter(dirname);
            //START PAGE ELERES IRASA
            myWriter.write("<a href=\"");
                for(int i=0; i<pontokSzama(dirname)-1; i++) {
                    myWriter.write("./");
                }
            myWriter.write("\">Start</a>");
            myWriter.write("EZ EGY INDEX");
            System.out.println("Successfully written to index");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void write(String fname){
        try {
            String htmlnev = "";
            if(fname.endsWith(".jpg")|| fname.endsWith(".png")) {
                htmlnev = fname.substring(0,fname.length()-3) + "html";
            }
            else if(fname.endsWith(".jpeg")){
                htmlnev = fname.substring(0,fname.length()-4) + "html";
            }

            FileWriter myWriter = new FileWriter(htmlnev);
            myWriter.write("<a href=\"" + Main.MAIN_DIR_INDEX + "\">Start</a>\n");
            myWriter.write("<html><img src= \"" + fname + "\" alt=\"alternatetext\"></html>");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writelast(String fname){
        try {
            FileWriter myWriter = new FileWriter(fname);
            myWriter.write("<a href=\"" + Main.MAIN_DIR_INDEX + "/index.html\">Start</a>");
            myWriter.write("<html><img src= \"" + fname.substring(0, fname.length()-5) + "\" alt=\"UTOLSOO\"></html>");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writefirst(String fname){
        try {
            FileWriter myWriter = new FileWriter(fname);
            myWriter.write("<a href=\"" + Main.MAIN_DIR_INDEX + "/index.html\">Start</a>");
            myWriter.write("<html><img src= \"" + fname.substring(0, fname.length()-5) + "\" alt=\"ELSOO\"></html>");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

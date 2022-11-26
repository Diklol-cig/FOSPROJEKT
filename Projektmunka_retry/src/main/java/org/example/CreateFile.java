package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

public class CreateFile {
    public static void create(String fname) {
        try {
            if(fname.endsWith(".jpg")|| fname.endsWith(".png")) {
                File myObj = new File(fname.substring(0,fname.length()-3) + "html");
                CreateFile.checkFileExists(myObj);
            }
            else if(fname.endsWith(".jpeg")){
                File myObj = new File(fname.substring(0,fname.length()-4) + "html");
                CreateFile.checkFileExists(myObj);
            }
            else{
                System.out.println("Nem jo kiterjesztes");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void checkFileExists(File myObj) throws IOException {
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        }
        else
        {
            System.out.println("File already exists.");
        }
    }

    public static void indexCreate(String fname) {
        try {
            File myObj = new File(fname);
            if (myObj.createNewFile()) {
                System.out.println("Index created successfully");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

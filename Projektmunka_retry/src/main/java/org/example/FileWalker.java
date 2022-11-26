package org.example;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static org.example.Writer.write;
import static org.example.Writer.writeindex;

public class FileWalker {

    private static String ujfile = "";
    private static String kep = "";

    private static String index = "";
    private static String MAIN_DIR_INDEX = "";

    private static List<File> kepek = new ArrayList<File>(); //Mukodik yee(beleteszi a kepek eleresi utjat)

    public static void makefiles(File dir) {
        CreateFile.indexCreate(dir.toString());
        writeindex(dir.toString() + "/index.html");
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    String index = file.getCanonicalPath() + "/index.html";
                    System.out.println("Index? " + index);
                    CreateFile.indexCreate(index);
                    writeindex(index);
                    makefiles(file);
                }
                else
                {
                    System.out.println("     file:" + file.getCanonicalPath());

                    if(file.getCanonicalPath().endsWith(".jpg") || file.getCanonicalPath().endsWith(".jpeg") || file.getCanonicalPath().endsWith(".png")){
                        kepek.add(file);
                        CreateFile.create(file.getCanonicalPath());
                        write(file.getCanonicalPath());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.io.File;

public class Main {

    public static File MAIN_DIR_INDEX =new File("");

    public static void main(String[] args) {
        MAIN_DIR_INDEX = new File("/home/dani/Documents/Prog2/Projektmunka");
        FileWalker.makefiles(MAIN_DIR_INDEX);
    }
}
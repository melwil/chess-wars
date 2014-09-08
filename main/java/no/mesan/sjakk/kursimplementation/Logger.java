package no.mesan.sjakk.kursimplementation;

import java.io.*;

/**
 * @author Håvard Slettvold
 */
public class Logger {

    static String filename = "ourlog.log";

    public static void clean() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        writer.print("");
        writer.close();
    }

    public static void log(String message) {
        File fout = new File(filename);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.print(message+"\n");
        writer.close();
    }
}

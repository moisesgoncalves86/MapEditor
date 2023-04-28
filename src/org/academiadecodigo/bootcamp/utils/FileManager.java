package org.academiadecodigo.bootcamp.utils;

import java.io.*;

public class FileManager {

    private final static String FILE_PATH = "resources/save.txt";

    public static void write(String string) {
        BufferedWriter bWriter = null;

        try {
            bWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            bWriter.write(string);
            bWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(bWriter != null){
                try {
                    bWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String read(){
        BufferedReader bReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bReader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = bReader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();

        } catch (IOException e){
            e.printStackTrace();
            return null;
        } finally {
            if(bReader != null){
                try {
                    bReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

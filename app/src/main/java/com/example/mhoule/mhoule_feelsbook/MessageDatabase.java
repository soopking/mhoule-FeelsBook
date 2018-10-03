package com.example.mhoule.mhoule_feelsbook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class MessageDatabase {
    private static final String FILENAME = "messages.sav";

    static public ArrayList<EmotionMessage> getFromDatabase(File contextDirPath) {
        try {
            File file = new File(contextDirPath, FILENAME);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type typeListMessage = new TypeToken<ArrayList<EmotionMessage>>(){}.getType();
            ArrayList<EmotionMessage> result = gson.fromJson(reader,typeListMessage);
            reader.close();
            isr.close();
            fis.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    static public void setDatabase(File contextDirPath, ArrayList<EmotionMessage> messageArrayList) {
        try {
            File file = new File(contextDirPath, FILENAME);
            FileOutputStream fos = new FileOutputStream(file, false);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            Gson gson = new Gson();
            gson.toJson(messageArrayList, osw);
            osw.flush();
            osw.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.mhoule.mhoule_feelsbook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
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

    static public ArrayList<Message> getFromDatabase() {
        try {
            FileInputStream fis = new FileInputStream(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type typeListMessage = new TypeToken<ArrayList<Message>>(){}.getType();
            ArrayList<Message> result = gson.fromJson(reader,typeListMessage);
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

    static public void setDatabase(ArrayList<Message> messageArrayList) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME, false);
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

package com.example.mhoule.mhoule_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MessageHolder messageList;
    private ArrayAdapter<Message> messageArrayAdapter;
    private RecyclerView recyclerView;
    private TextView editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        messageList = new MessageHolder();
        messageArrayAdapter = new ArrayAdapter<>(this, R.layout.message_item, messageList);
    }
}

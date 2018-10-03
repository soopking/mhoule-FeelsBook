//    FeelsBook: Track your emotions.

//    Copyright (C) 2018, Maxime Houle mhoule@ualberta.ca
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <https://www.gnu.org/licenses/>.

package com.example.mhoule.mhoule_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private MessageHolder messageList;
    private TextViewListAdapter<EmotionMessage> messageArrayAdapter;
    private RecyclerView recyclerView;
    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);

        Button joyButton = findViewById(R.id.joyButton);
        Button angerButton = findViewById(R.id.angerButton);
        Button fearButton = findViewById(R.id.fearButton);
        Button loveButton = findViewById(R.id.loveButton);
        Button sadnessButton = findViewById(R.id.sadnessButton);
        Button surpriseButton = findViewById(R.id.surpriseButton);

        Button extraButton = findViewById(R.id.extraButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Emotion emotion = new JoyEmotion();
                try {
                    addToMessageList(new EmotionMessage(text, emotion));
                } catch (MessageTooLongException e) {
                    editText.setError("Please use less than 100 characters.");
                }
                editText.setText("");
            }
        });

        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Emotion emotion = new AngerEmotion();
                try {
                    addToMessageList(new EmotionMessage(text, emotion));
                } catch (MessageTooLongException e) {
                    editText.setError("Please use less than 100 characters.");
                }
                editText.setText("");
            }
        });

        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Emotion emotion = new FearEmotion();
                try {
                    addToMessageList(new EmotionMessage(text, emotion));
                } catch (MessageTooLongException e) {
                    editText.setError("Please use less than 100 characters.");
                }
                editText.setText("");
            }
        });

        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Emotion emotion = new LoveEmotion();
                try {
                    addToMessageList(new EmotionMessage(text, emotion));
                } catch (MessageTooLongException e) {
                    editText.setError("Please use less than 100 characters.");
                }
                editText.setText("");
            }
        });

        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Emotion emotion = new SadnessEmotion();
                try {
                    addToMessageList(new EmotionMessage(text, emotion));
                } catch (MessageTooLongException e) {
                    editText.setError("Please use less than 100 characters.");
                }
                editText.setText("");
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Emotion emotion = new SurpriseEmotion();
                try {
                    addToMessageList(new EmotionMessage(text, emotion));
                } catch (MessageTooLongException e) {
                    editText.setError("Please use less than 100 characters.");
                }
                editText.setText("");
            }
        });

        extraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                messageList.clear();
                messageArrayAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        messageList = new MessageHolder(this.getFilesDir());
        messageArrayAdapter = new TextViewListAdapter<>(messageList);
        recyclerView.setAdapter(messageArrayAdapter);
    }

    protected void addToMessageList(EmotionMessage message) {
        messageList.add(message);
        messageArrayAdapter.notifyDataSetChanged();
    }
}

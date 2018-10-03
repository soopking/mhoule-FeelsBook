package com.example.mhoule.mhoule_feelsbook;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ExtraActivity extends AppCompatActivity {
    private TextView joyTextView;
    private TextView surpriseTextView;
    private TextView loveTextView;
    private TextView fearTextView;
    private TextView angerTextView;
    private TextView sadnessTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_activity);

        Button clearAllButton = findViewById(R.id.extraActivityClearAllButton);

        joyTextView = findViewById(R.id.joyCountTextView);
        surpriseTextView = findViewById(R.id.surpriseCountTextView);
        loveTextView = findViewById(R.id.loveCountTextView);
        fearTextView = findViewById(R.id.fearCountTextView);
        angerTextView = findViewById(R.id.angerCountTextView);
        sadnessTextView = findViewById(R.id.sadnessCountTextView);

        updateEmotionCounts();

        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.messageList.clear();
                MainActivity.messageArrayAdapter.notifyDataSetChanged();
                updateEmotionCounts();
            }
        });

    }

    private void updateEmotionCounts() {
        joyTextView.setText(countEmotion(MainActivity.messageList, new JoyEmotion()));
        surpriseTextView.setText(countEmotion(MainActivity.messageList, new SurpriseEmotion()));
        loveTextView.setText(countEmotion(MainActivity.messageList, new LoveEmotion()));
        fearTextView.setText(countEmotion(MainActivity.messageList, new FearEmotion()));
        angerTextView.setText(countEmotion(MainActivity.messageList, new AngerEmotion()));
        sadnessTextView.setText(countEmotion(MainActivity.messageList, new SadnessEmotion()));
    }

    private String countEmotion(ArrayList<EmotionMessage> arrayList, Emotion toMatch) {
        Integer count = 0;
        for (EmotionMessage emotionMessage: arrayList) {
            if (Emotion.checkEmotion(emotionMessage.getEmotion(), toMatch)) {
                count++;
            }
        }
        return count.toString();
    }
}

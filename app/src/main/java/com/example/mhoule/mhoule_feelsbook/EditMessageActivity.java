package com.example.mhoule.mhoule_feelsbook;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditMessageActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private RadioGroup radioGroup;
    private TextView datePicker;
    private TextView textView;
    private int index;
    private EmotionMessage emotionMessage;

    private Date date;
    private Date tempDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_message);

        Button confirmButton = findViewById(R.id.editMessageConfirmButton);
        Button cancelButton = findViewById(R.id.editMessageCancelButton);
        Button deleteButton = findViewById(R.id.editMessageDeleteButton);

        radioGroup = findViewById(R.id.emotionsRadioGroup);
        final RadioButton joyRadioButton = findViewById(R.id.joyRadioButton);
        RadioButton surpriseRadioButton = findViewById(R.id.surpriseRadioButton);
        RadioButton loveRadioButton = findViewById(R.id.loveRadioButton);
        RadioButton fearRadioButton = findViewById(R.id.fearRadioButton);
        RadioButton sadnessRadioButton = findViewById(R.id.sadnessRadioButton);
        RadioButton angerRadioButton = findViewById(R.id.angerRadioButton);

        datePicker = findViewById(R.id.editMessageDatePicker);
        textView = findViewById(R.id.editMessageCommentView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            index = extras.getInt("index");
        }
        emotionMessage = MainActivity.messageList.get(index);
        date = (Date) emotionMessage.getDate().clone();

        if (Emotion.checkEmotion(emotionMessage.getEmotion(), new FearEmotion())) {
            fearRadioButton.setChecked(true);
        } else if (Emotion.checkEmotion(emotionMessage.getEmotion(), new JoyEmotion())) {
            joyRadioButton.setChecked(true);
        } else if (Emotion.checkEmotion(emotionMessage.getEmotion(), new SurpriseEmotion())) {
            surpriseRadioButton.setChecked(true);
        } else if (Emotion.checkEmotion(emotionMessage.getEmotion(), new LoveEmotion())) {
            loveRadioButton.setChecked(true);
        } else if (Emotion.checkEmotion(emotionMessage.getEmotion(), new SadnessEmotion())) {
            sadnessRadioButton.setChecked(true);
        } else if (Emotion.checkEmotion(emotionMessage.getEmotion(), new AngerEmotion())) {
            angerRadioButton.setChecked(true);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
        datePicker.setText(simpleDateFormat.format(emotionMessage.getDate()));
        textView.setText(emotionMessage.getText());

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dateDialog = new DatePickerDialog(EditMessageActivity.this,
                        EditMessageActivity.this,
                        date.getYear() + 1900, date.getMonth(), date.getDate());
                dateDialog.show();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.messageList.remove(index);
                MainActivity.messageArrayAdapter.notifyDataSetChanged();
                finish();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emotion emotion = null;
                EmotionMessage emotionMessage;
                if (radioGroup.getCheckedRadioButtonId() == R.id.joyRadioButton) {
                    emotion = new JoyEmotion();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.surpriseRadioButton) {
                    emotion = new SurpriseEmotion();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.loveRadioButton) {
                    emotion = new LoveEmotion();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.fearRadioButton) {
                    emotion = new FearEmotion();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.sadnessRadioButton) {
                    emotion = new SadnessEmotion();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.angerRadioButton) {
                    emotion = new AngerEmotion();
                }
                try {
                    emotionMessage = new EmotionMessage(textView.getText().toString(), date, emotion);
                } catch (MessageTooLongException e) {
                    textView.setError("Please use less than 100 characters.");
                    return;
                }

                MainActivity.messageList.replaceMessage(emotionMessage, index);
                MainActivity.messageArrayAdapter.notifyDataSetChanged();
                finish();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        tempDate = new Date();
        tempDate.setYear(year-1900);
        tempDate.setMonth(month);
        tempDate.setDate(dayOfMonth);

        TimePickerDialog timePickerDialog = new TimePickerDialog(EditMessageActivity.this,
                EditMessageActivity.this,
                date.getHours(), date.getMinutes(), false);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        tempDate.setHours(hourOfDay);
        tempDate.setMinutes(minute);
        date = (Date) tempDate.clone();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
        datePicker.setText(simpleDateFormat.format(date));
    }
}

package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddFlashcardActivity extends AppCompatActivity {

    private EditText questionInput, answerInput;
    private Button saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flashcard);

        questionInput = findViewById(R.id.editQuestion);
        answerInput = findViewById(R.id.editAnswer);
        saveButton = findViewById(R.id.btnSave);
        cancelButton = findViewById(R.id.btnCancel);

        saveButton.setOnClickListener(v -> {
            String question = questionInput.getText().toString().trim();
            String answer = answerInput.getText().toString().trim();

            if(!question.isEmpty() && !answer.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("question", question);
                resultIntent.putExtra("answer", answer);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        cancelButton.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}

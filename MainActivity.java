package com.example.flashcards;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FlashcardAdapter adapter;
    private ArrayList<Flashcard> flashcards;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        fabAdd = findViewById(R.id.fabAdd);

        flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("Capital of France?", "Paris"));
        flashcards.add(new Flashcard("2 + 2 = ?", "4"));
        flashcards.add(new Flashcard("Largest planet?", "Jupiter"));

        adapter = new FlashcardAdapter(this, flashcards);
        listView.setAdapter(adapter);

        // Register for result
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String q = result.getData().getStringExtra("question");
                        String a = result.getData().getStringExtra("answer");
                        flashcards.add(new Flashcard(q, a));
                        adapter.notifyDataSetChanged();
                    }
                }
        );

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddFlashcardActivity.class);
            launcher.launch(intent);
        });
    }
}

package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private FlashcardAdapter adapter;
    private ArrayList<Flashcard> flashcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("Capital of France?", "Paris"));
        flashcards.add(new Flashcard("2 + 2 = ?", "4"));
        flashcards.add(new Flashcard("Largest planet?", "Jupiter"));
        flashcards.add(new Flashcard("Java or Kotlin?", "Both!"));
        flashcards.add(new Flashcard("OS of Android?", "Linux"));
        flashcards.add(new Flashcard("Sun rises in?", "East"));

        adapter = new FlashcardAdapter(this, flashcards);
        gridView.setAdapter(adapter);
    }
}

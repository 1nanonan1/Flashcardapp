//Nan Ouk
//CS453

package com.example.notesflashcardapp;

public class Flashcard {
    private String Q;
    private String A;


    public Flashcard(String Q, String A) {
        this.Q = Q;
        this.A = A;

    }

    public String getQuestion() {
        return Q;
    }

    public String getAnswer(){
        return A;
    }
}

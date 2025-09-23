package com.example.flashcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FlashcardAdapter extends BaseAdapter {

    private Context context;
    private List<Flashcard> flashcardList;
    private LayoutInflater inflater;

    public FlashcardAdapter(Context context, List<Flashcard> flashcardList) {
        this.context = context;
        this.flashcardList = flashcardList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return flashcardList.size();
    }

    @Override
    public Object getItem(int position) {
        return flashcardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_flashcard, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.cardText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Flashcard flashcard = flashcardList.get(position);
        holder.textView.setText(flashcard.getQuestion());

        // toggle Q/A when clicked
        convertView.setOnClickListener(v -> {
            if(holder.textView.getText().equals(flashcard.getQuestion())) {
                holder.textView.setText(flashcard.getAnswer());
            } else {
                holder.textView.setText(flashcard.getQuestion());
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}

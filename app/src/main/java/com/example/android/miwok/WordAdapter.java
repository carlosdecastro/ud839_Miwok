package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColor;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        mColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        ImageView imageImageView = (ImageView) listItemView.findViewById(R.id.image_image_view);

        defaultTextView.setText(currentWord.getDefaultTranslation());
        miwokTextView.setText(currentWord.getMiwokWord());

        LinearLayout itemLayout = (LinearLayout)listItemView.findViewById(R.id.item_layout);
        int color = ContextCompat.getColor(getContext(), mColor);
        itemLayout.setBackgroundColor(color);



        if (currentWord.hasImage()) {
            imageImageView.setVisibility(View.VISIBLE);
            imageImageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageImageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}

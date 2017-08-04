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
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;

/**
 * Created by Abhishek Prasad on 27-Jul-17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mBgColor;
    public WordAdapter(Context context,int textViewResourceId,ArrayList<Word> objects,int bgColor)
    {
        super(context,textViewResourceId,objects);
        mBgColor=bgColor;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        if(v==null)
        {
            v=LayoutInflater.from(getContext()).inflate(R.layout.list_items_view,parent,false);
        }
        Word word=getItem(position);
        TextView miwokTextView=(TextView)v.findViewById(R.id.miwok_text_view);
        TextView defaultTextView=(TextView)v.findViewById(R.id.default_text_view);
        miwokTextView.setText(word.getMiwokTranslation());
        defaultTextView.setText(word.getDefaultTranslation());
        View vertical_linear_layout =v.findViewById(R.id.translations_linear_layout);
        int color= ContextCompat.getColor(getContext(),mBgColor);
        vertical_linear_layout.setBackgroundColor(color);
        if(mBgColor!=R.color.category_phrases){
            ImageView imageView=(ImageView)v.findViewById(R.id.imageview);
            imageView.setImageResource(word.getImageResourceId());
        }
        else {
            View view=v.findViewById(R.id.imageview);
            view.setVisibility(GONE);
        }
        final int audioId=word.getAudioResourceId();
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer media=MediaPlayer.create(getContext(),audioId);
                media.start();
            }
        });
        return v;
    }
}

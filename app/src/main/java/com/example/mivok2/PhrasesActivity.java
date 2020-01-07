package com.example.mivok2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private  MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_word);

        final ArrayList<Word> words= new ArrayList<Word>();
        words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinne otaase'ne",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oteeset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michekses?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","eeues'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm feeling good.","hee'eeuem",R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming","eeuem",R.raw.phrase_im_coming));
        words.add(new Word("Let's go.","yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.","enni'nem",R.raw.phrase_come_here));
        //
        WordAdapter adapter= new  WordAdapter(this,words,R.color.category_phrases);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PhrasesActivity.this, "List item clicked",Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                releaseMediaPlayer();
                 mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer(){
        if(mMediaPlayer !=null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}

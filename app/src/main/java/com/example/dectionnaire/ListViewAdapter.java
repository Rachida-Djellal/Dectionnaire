package com.example.dectionnaire;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter  {

    Context context;
    private static final String myPreference = "Mypreference";
    private static final int VR_REQUEST = 999;

    private int MY_DATA_CHECK_CODE = 0;

    public TextToSpeech tts;
    ArrayList<Word> wordLists;



    public ListViewAdapter(Context context, ArrayList<Word> words) {
        this.context = context;
        this.wordLists = words;

    }

    @Override
    public int getCount() {

        return wordLists.size();
    }

    @Override
    public Object getItem(int position) {
        return wordLists.get(position);
    }

    private void speakOut(String text) {


        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,text)  ;


    }

    public class ViewHolder {
        TextView eng_word, bang_word;
        ImageButton imageButton;

    }

    @Override
    public long getItemId(int position) {
        return wordLists.indexOf(getItem(position));
    }



    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.e2b_list_view, null);
            holder.eng_word = (TextView) convertView.findViewById(R.id.view_eng);
            holder.bang_word = (TextView) convertView.findViewById(R.id.view_bang);
            holder.imageButton = (ImageButton) convertView.findViewById(R.id.soundButton);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.eng_word.setText(wordLists.get(position).getEngWord());
        holder.bang_word.setText(wordLists.get(position).getBangWord());

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS){
                            int result = tts.setLanguage(Locale.ENGLISH);
                          String word_eng = wordLists.get(position).getEngWord();
                            result = tts.setLanguage(Locale.ENGLISH);

                            String toSpeak = word_eng;
                            Log.w("Dictinary Data:", toSpeak);
                            tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null,toSpeak);
                        }else{
                            Toast.makeText(context, "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        return convertView;
    }



}

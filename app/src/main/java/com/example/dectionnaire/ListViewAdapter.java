package com.example.dectionnaire;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

   private Context context;
    private static final String myPreference = "Mypreference";
    private static final int VR_REQUEST = 999;

    private int MY_DATA_CHECK_CODE = 0;

    private TextToSpeech tts;
    private OnWordListener onWordListener ;
    private ArrayList<Word> wordLists;



    public ListViewAdapter(Context context, ArrayList<Word> words , OnWordListener onWordListener) {
        this.context = context;
        this.wordLists = words;
        this.onWordListener=onWordListener;

    }

    private void speakOut(String text) {
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,text)  ;

    }

    public interface OnWordListener{
        void onClickListener(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.e2b_list_view,parent,false);
        return new ViewHolder(view, onWordListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.bang_word.setText( wordLists.get(position).getBangWord());
        holder.eng_word.setText(wordLists.get(position).getEngWord());
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

    }

    @Override
    public int getItemCount() {
        return wordLists.size();
    }


public  class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener

{
    TextView eng_word, bang_word;
    ImageButton imageButton;
    OnWordListener onWordListener ;

     ViewHolder(@NonNull View itemView , OnWordListener onWordListener) {
        super(itemView);
        this.eng_word = (TextView) itemView.findViewById(R.id.view_eng);
        this.bang_word =(TextView) itemView.findViewById(R.id.view_bang);
        this.imageButton = (ImageButton) itemView.findViewById(R.id.soundButton);
        this.onWordListener = onWordListener;
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        onWordListener.onClickListener(getAdapterPosition());
    }

}


}



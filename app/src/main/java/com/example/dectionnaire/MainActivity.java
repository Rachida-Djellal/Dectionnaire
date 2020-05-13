package com.example.dectionnaire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListViewAdapter.OnWordListener {
    RecyclerView lv;
    private boolean isChackBookmarks = false;
    ArrayList<Word> wordList=new ArrayList<Word>();;
    ListViewAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (RecyclerView) findViewById(R.id.dictionaryList);
        initilizeList();
        setAdapter();

    }





    private void setAdapter(){

        lv.setLayoutManager(new LinearLayoutManager(this));
        listAdapter=new ListViewAdapter(this, wordList ,this);
        System.out.println(wordList.size());

        lv.setAdapter(listAdapter);
    }

    private void initilizeList(){

        wordList.add( new Word("houce","nom féminin",
                "La houce est un vêtement au Moyen Age qui ressemblait à une robe et qui se portait par-dessus les vêtements.",1));
        wordList.add( new Word("hospitalièrement","adverbe","De façon hospitalière, gratuite, généreuse, désintéressée.\n" +
                "Exemple : Elle fut accueillie hospitalièrement.\n" +
                "Traduction anglais : hospitably",2));

        wordList.add( new Word("homme à tout faire","locution","Personne de sexe masculin capable de réaliser de nombreuses tâches " +
                "dans des domaines variés, sans nécessairement être un spécialiste dans ces domaines.",3));

        wordList.add( new Word("orgueil","nom masculin","Opinion trop avantageuse, estime exagérée de soi-même.",4));

        wordList.add( new Word("carpe diem","locution","\n" +
                "Jouir, profiter de l'instant présent. • Expression tirée des vers d'Horace," +
                " un philosophe romain de l'Antiquité : \"Carpe diem, quam minimum credula postero\"." +
                " Cela signifie \"cueille le jour sans te soucier du lendemain, et sois moins crédule pour " +
                "le jour suivant\". Son sens," +
                " proche de la philosophie épicurienne, a traversé les siècles jusqu'à nos jours sans qu'il soit altéré.",5));

        wordList.add( new Word("vanité","nom féminin","Orgueil, prétention, défaut d'une personne trop satisfaite d'elle-même.",6));

        wordList.add( new Word("perspicace","adjectif","Être doté d'un esprit pénétrant et réfléchi, qui comprend rapidement et avec clairvoyance.",7));

        wordList.add( new Word("narcissique","adjectif, nom","Relatif au narcissisme, " +
                "à l'admiration de soi-même. Ce terme est issu de la mythologie grecque. " +
                "Narcisse tombe amoureux de son propre reflet et meurt de cette passion qu'il" +
                " ne peut assouvir. Près de son corps, poussent des fleurs blanches : les narcisses.",8));

        wordList.add( new Word("le cas échéant","locution","Si le cas se présente, à l'occasion, au besoin, si nécessaire...",9));

        wordList.add( new Word("hypocrite","adjectif, nom","Qui relève de l'hypocrisie, qui dissimule ses sentiments, " +
                "ses pensées, sa véritable personnalité, qui est fourbe et sournois.",10));
    }



   /* public void openAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Add Bookmarks");
        builder.setMessage("do you add bookmarks...");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                isChackBookmarks = true;

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                isChackBookmarks = false;
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }*/


    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(getApplicationContext(),TextSpeelingActivity.class);
        intent.putExtra("wordDef", wordList.get(position).getDef());
        startActivity(intent);

    }
}

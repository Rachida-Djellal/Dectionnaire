package com.example.dectionnaire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    private boolean isChackBookmarks = false;
    ArrayList<Word> wordList=new ArrayList<Word>();;
    ListViewAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.dictionaryList);

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
         listAdapter=new ListViewAdapter(this,wordList);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
               Toast.makeText(getApplicationContext(),"ddddddddd",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),TextSpeelingActivity.class);

                startActivity(intent);

            }
        });
    }
    public void openAlert() {
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
    }


}

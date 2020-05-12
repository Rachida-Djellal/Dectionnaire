package com.example.dectionnaire;

public class Word {

    private String word;
    private String definition;
    private  String description;
    private int image ;

    public Word( String word, String def,String des,int image){
        this.word= word;
        this.definition = def;
        this.description=des;
        this.image=image;
    }
    public String getEngWord() {
        return word;
    }

    public void setEngWord(String engWord) {
        this.word = engWord;
    }

    public String getBangWord() {
        return definition;
    }

    public void setBangWord(String bangWord) {
        this.definition = bangWord;
    }

    public String getDef() {
        return description;
    }

    public void setDef(String bangWord) {
        this.description = bangWord;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int bangWord) {
        this.image = bangWord;
    }


  /*  @Override
    public String toString() {
        return "Bean [id=" + id + ", engWord=" + engWord + ", bangWord="
                + bangWord + ", status=" + status + ", user=" + user + "]";
    }*/

}

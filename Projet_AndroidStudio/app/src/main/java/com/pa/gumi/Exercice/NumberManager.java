package com.pa.gumi.Exercice;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NumberManager {

    // -- Attribut

    private String typeEx;
    private String difficulté;
    private int nbOperator;
    private ArrayList<Integer> listePos1 = new ArrayList<>();
    private ArrayList<Integer> listePos2 = new ArrayList<>();
    private ArrayList<Integer> listeNumber1 = new ArrayList<>();
    private ArrayList<Integer> listeNumber2 = new ArrayList<>();

    private ArrayList<Integer> listeReponse = new ArrayList<>();

    private int borneSup;

    // -- Constructeur

    public NumberManager(String typeEx, String difficulté, int nbOperator) {
        this.typeEx = typeEx;
        this.difficulté = difficulté;
        this.nbOperator = nbOperator;

        System.out.println(typeEx);
        System.out.println(difficulté);
        System.out.println(nbOperator);


        System.out.println("autre");

        if(difficulté.equals( "Facile")){
            borneSup = 20;
            System.out.println("Facile");

        }
        else if(difficulté.equals( "Normal")){
            borneSup = 50;
            System.out.println("Normal");

        }
        else {
            borneSup = 100;
            System.out.println("difficile");

        }


        int pos1 = 0;
        int pos2 = 0;
        int number1 = 0;
        int number2 = 0;

        for(int i = 0; i < this.nbOperator; i++) {

            // position
            pos1 = 0 + (int)(Math.random() * ((2 - 0) + 1));
            pos2 = 0 + (int)(Math.random() * ((2 - 0) + 1));

            while(pos2 == pos1) {
                pos2 = 0 + (int)(Math.random() * ((2 - 0) + 1));
            }

            // pos2 == pos la plus grande
            if(pos1 > pos2) {
                int tmp = pos1;
                pos1 = pos2;
                pos2 = tmp;
            }

            listePos1.add(pos1);
            listePos2.add(pos2);

            // nombre
            number1 = 0 + (int)(Math.random() * ((borneSup - 0) + 1));
            number2 = 0 + (int)(Math.random() * ((borneSup - 0) + 1));

            // number1 == number la plus grande
            if(typeEx.equals("Soustraction")) {
                if(number1 < number2) {
                    int tmp = number1;
                    number1 = number2;
                    number2 = tmp;


                }
            }
            // number2 == number la plus grande
            else {
                if(number1 > number2) {
                    int tmp = number1;
                    number1 = number2;
                    number2 = tmp;
                }
            }

            listeNumber1.add(number1);
            listeNumber2.add(number2);
            calculReponse(i);


            System.out.println("Pos1 : " + getPos1(i));
            System.out.println("Pos2 : " + getPos2(i));
            System.out.println("Number1 : " + getNumber1(i));
            System.out.println("Number2 : " + getNumber2(i));
            System.out.println("Result : " + getReponse(i));



            System.out.println(affichage(i,true));
        }
    }

    // -- Méthode

    public void  calculReponse(int pos) {

        if(typeEx.equals("Addition") ) {
            if(listePos2.get(pos) != 2) {
                listeReponse.add(listeNumber1.get(pos) + listeNumber2.get(pos));
            }
            else {
                listeReponse.add(listeNumber2.get(pos) - listeNumber1.get(pos));
            }
        }
        else if(typeEx.equals("Soustraction") ) {
            if(listePos1.get(pos) == 0) {
                listeReponse.add(listeNumber1.get(pos) - listeNumber2.get(pos));
            }
            else if(listePos1.get(pos) == 1){
                listeReponse.add(listeNumber1.get(pos) + listeNumber2.get(pos));
            }
        }
    }

    public String affichage(int pos, boolean withAnswer) {

        String sortie = "";
        String sortieRep = "";
        String operator = "";
        if (typeEx.equals("Addition")) {
            operator = " + ";
        }
        else if(typeEx.equals("Soustraction")){
            operator = " - ";
        }


        if(typeEx.equals("Soustraction")) {
            if(listePos1.get(pos) == 0){
                if(listePos2.get(pos) == 1){
                    sortie = getNumber1(pos) + operator + getNumber2(pos) + " = [ ]";
                    sortieRep = getNumber1(pos) + operator + getNumber2(pos) + " = " + getReponse(pos);
                }
                else {
                    sortie = getNumber1(pos) + operator + "[ ]" + " = " + getNumber2(pos);
                    sortieRep = getNumber1(pos) + operator + getReponse(pos) + " = " + getNumber2(pos);
                }

            }
            else {
                sortie = "[ ]" + operator +  getNumber1(pos) + " = " + getNumber2(pos);
                sortieRep = getReponse(pos) + operator +  getNumber1(pos) + " = " + getNumber2(pos);
            }
        }
        else {
            if(listePos1.get(pos) == 0){
                if(listePos2.get(pos) == 1){
                    sortie = getNumber1(pos) + operator + getNumber2(pos) + " = [ ]";
                    sortieRep = getNumber1(pos) + operator + getNumber2(pos) + " = " + getReponse(pos);
                }
                else {
                    sortie = getNumber1(pos) + operator + "[ ]" + " = " + getNumber2(pos);
                    sortieRep = getNumber1(pos) + operator + getReponse(pos) + " = " + getNumber2(pos);
                }

            }
            else {
                sortie = "[ ]" + operator +  getNumber1(pos) + " = " + getNumber2(pos);
                sortieRep = getReponse(pos) + operator +  getNumber1(pos) + " = " + getNumber2(pos);
            }
        }




        String out = "";

        if(withAnswer == true){
            out = sortieRep;
        }
        else  {
            out = sortie;
        }

        return out;
    }

    // -- Getter et Setter

    public int getNumber1(int pos){
        return listeNumber1.get(pos);
    }

    public int getNumber2(int pos){
        return listeNumber2.get(pos);
    }

    public int getPos1(int pos){
        return listePos1.get(pos);
    }

    public int getPos2(int pos){
        return listePos2.get(pos);
    }

    public int getReponse(int pos){
        return listeReponse.get(pos);
    }

    public ArrayList<String> getListOpe(){
        ArrayList<String> liste = new ArrayList<String>();
        int compteur = 0;
        while (compteur != nbOperator)
        {
            liste.add(affichage(compteur,false));
            compteur++;
        }
        return liste;
    }

    public ArrayList<String> getListRep(){
        ArrayList<String> liste = new ArrayList<String>();
        int compteur = 0;
        while (compteur != nbOperator)
        {
            liste.add(affichage(compteur,true));
            compteur++;
        }
        return liste;
    }

    public int getBorneSup() {
        return borneSup;
    }

    public ArrayList<Integer> getListeNumber1() {
        return listeNumber1;
    }

    public ArrayList<Integer> getListeNumber2() {
        return listeNumber2;
    }

    public ArrayList<Integer> getListePos1() {
        return listePos1;
    }

    public ArrayList<Integer> getListePos2() {
        return listePos2;
    }

    public ArrayList<Integer> getListeReponse() {
        return listeReponse;
    }

    public String getDifficulté() {
        return difficulté;
    }

    public int getNbOperator() {
        return nbOperator;
    }

    public String getTypeEx() {
        return typeEx;
    }

    public void setBorneSup(int borneSup) {
        this.borneSup = borneSup;
    }

    public void setDifficulté(String difficulté) {
        this.difficulté = difficulté;
    }

    public void setListeNumber1(ArrayList<Integer> listeNumber1) {
        this.listeNumber1 = listeNumber1;
    }

    public void setListeNumber2(ArrayList<Integer> listeNumber2) {
        this.listeNumber2 = listeNumber2;
    }

    public void setListePos1(ArrayList<Integer> listePos1) {
        this.listePos1 = listePos1;
    }

    public void setListePos2(ArrayList<Integer> listePos2) {
        this.listePos2 = listePos2;
    }

    public void setListeReponse(ArrayList<Integer> listeReponse) {
        this.listeReponse = listeReponse;
    }

    public void setNbOperator(int nbOperator) {
        this.nbOperator = nbOperator;
    }

    public void setTypeEx(String typeEx) {
        this.typeEx = typeEx;
    }


}

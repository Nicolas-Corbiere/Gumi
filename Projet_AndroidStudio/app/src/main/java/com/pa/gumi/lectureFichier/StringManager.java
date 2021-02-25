package com.pa.gumi.lectureFichier;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public class StringManager {
    private static final int MODE_PRIVATE = 0;

    // -- Attribut

    // - Valeur a trouver
    private int nbOperation;
    private int nbVrais;
    private int nbFaux;

    // - Flux d'écriture
    private FileOutputStream fileout;
    private OutputStreamWriter outputWriter;

    // - Flux de lecture
    private FileInputStream fileIn;
    private InputStreamReader InputRead;

    // - Context
    private Context context;

    private String stringForNbPartie = "Nombre d\'opération:";
    private String stringForNbPartieG = "Nombre de d\'opération vrais:";
    private String stringForNbPartieP = "Nombre de d\'opération faux:";

    // Constructeur


    public StringManager(Context context) throws IOException {
        this.context = context;
    }

    // Getter et Setter

    public int getNbFaux() {
        return nbFaux;
    }

    public void setNbFaux(int nbFaux) {
        this.nbFaux = nbFaux;
    }

    public int getNbOperation() {
        return nbOperation;
    }

    public void setNbOperation(int nbOperation) {
        this.nbOperation = nbOperation;
    }

    public int getNbVrais() {
        return nbVrais;
    }

    public void setNbVrais(int nbVrais) {
        this.nbVrais = nbVrais;
    }

    public InputStreamReader getInputRead() {
        return InputRead;
    }

    public Context getContext() {
        return context;
    }

    public FileInputStream getFileIn() {
        return fileIn;
    }

    public FileOutputStream getFileout() {
        return fileout;
    }

    public static int getModePrivate() {
        return MODE_PRIVATE;
    }

    public OutputStreamWriter getOutputWriter() {
        return outputWriter;
    }

    public String getStringForNbPartie() {
        return stringForNbPartie;
    }

    public String getStringForNbPartieG() {
        return stringForNbPartieG;
    }

    public String getStringForNbPartieP() {
        return stringForNbPartieP;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setFileIn(FileInputStream fileIn) {
        this.fileIn = fileIn;
    }

    public void setFileout(FileOutputStream fileout) {
        this.fileout = fileout;
    }

    public void setInputRead(InputStreamReader inputRead) {
        InputRead = inputRead;
    }

    public void setOutputWriter(OutputStreamWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void setStringForNbPartie(String stringForNbPartie) {
        this.stringForNbPartie = stringForNbPartie;
    }

    public void setStringForNbPartieG(String stringForNbPartieG) {
        this.stringForNbPartieG = stringForNbPartieG;
    }

    public void setStringForNbPartieP(String stringForNbPartieP) {
        this.stringForNbPartieP = stringForNbPartieP;
    }

    // -- Méthode

    /**
     *
     * Permet d'écrire dans le fichier de stat
     *
     * @param nbOperation
     * @param nbOperationVrais
     * @param nbOperationFaux
     * @throws IOException
     */
    public void writeStat(int nbOperation, int nbOperationVrais, int nbOperationFaux) throws IOException {
        fileout = context.openFileOutput("stat.conf", MODE_PRIVATE);
        outputWriter=new OutputStreamWriter(fileout);
        outputWriter.write(stringForNbPartie + nbOperation + ":");
        outputWriter.write(stringForNbPartieG + nbOperationVrais + ":");
        outputWriter.write(stringForNbPartieP + nbOperationFaux + ":");
        outputWriter.close();
    }

    /**
     * Permet de lire les information du ficher de stat
     *
     * @throws IOException
     */
    public ArrayList<String> readStat() throws IOException {

        ArrayList<String> rst = new ArrayList<String>();

        fileIn = context.openFileInput("stat.conf");
        InputRead= new InputStreamReader(fileIn);

        char[] inputBuffer= new char[125];
        String s="\n";
        int charRead;

        while ((charRead=InputRead.read(inputBuffer))>0) {
            // char to string conversion
            String readstring=String.copyValueOf(inputBuffer,0,charRead);
            s +=readstring;
        }

        String[] tmp = s.split(":");


        nbOperation = Integer.parseInt(tmp[1]);
        nbVrais = Integer.parseInt(tmp[3]);
        nbFaux = Integer.parseInt(tmp[5]);

        rst.add(nbOperation + "");
        rst.add(nbVrais + "");
        rst.add(nbFaux + "");


        InputRead.close();
        System.out.println("String lue :");
        System.out.println(s);

        System.out.println(stringForNbPartie + " " + nbOperation );
        System.out.println(stringForNbPartieG + " " + nbVrais );
        System.out.println(stringForNbPartieP + " " + nbFaux );

        return rst;

    }

}

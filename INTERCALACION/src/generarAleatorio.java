//Se efectua en grandisimas cantidades de datos y se utiliza para ordenar grandes cantidades de datos 
//donde la ram se ah quedado corta, pero el problema es que se tarda muchisimo en ordenar y se corre en disco
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class generarAleatorio{
    public static void main(String[] args) {

    try{
        PrintStream ps = new PrintStream(new File("entrada2.txt"));
        for(int x=0;x<1000;x++){
            ps.println((int)(Math.random()*1000));
        }
        ps.close();

    }catch(FileNotFoundException e){
        e.printStackTrace();
    }


}}

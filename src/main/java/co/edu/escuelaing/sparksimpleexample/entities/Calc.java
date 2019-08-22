/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.sparksimpleexample.entities;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Calc {

    private LinkedList<Double> linked = new LinkedList<Double>();

    public Calc(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            Double a = Double.parseDouble(sc.nextLine());
            linked.add(a);
        }
        sc.close();
    }
    
    public Calc(LinkedList<Double> linked ){
        this.linked=linked;
    }

    public double mean(){    
        double sum = 0;
        for (int i = 0; i < linked.size(); i++) sum += linked.get(i); 
        double mean = (double)sum/linked.size();
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(mean));
    }

    public double desviation(){
        double avg = mean();
        double sum = 0;
        for (int i = 0; i < linked.size(); i++) {
            
            sum += Math.pow(linked.get(i) - avg, 2);
        }
        double desviation = Math.sqrt((double)sum/(linked.size()-1));
        DecimalFormat df = new DecimalFormat("#.##");   
        return Double.valueOf(df.format(desviation));
    }

    public void setFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        linked.clean();
        while(sc.hasNext()){
            Double a = Double.parseDouble(sc.nextLine());
            linked.add(a);
        }
        sc.close();
    }
    
}
package co.edu.escuelaing.sparksimpleexample.entities;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <h1> Calculator </h1>
 * Esta clase realiza el calculo de la media y la desviacion de una lista de numeros
 *@author Daniel Rosales
 */
public class Calc {

    private LinkedList<Double> linked = new LinkedList<Double>();
    /**
     * Constructor de la clase Calc el cual recibe un archivo con contiene los numeros a calcular
     * @param file archivo con los numeros a calcular
     * @throws FileNotFoundException
     */
    public Calc(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            Double a = Double.parseDouble(sc.nextLine());
            linked.add(a);
        }
        sc.close();
    }
    
    /**
     * Constructor de la clase Calc el cual recibe una lista con los numeros a calcular
     * @param linked LinkedList con los numeros a calcular
     */
    public Calc(LinkedList<Double> linked ){
        this.linked=linked;
    }

    /**
     * Calcula la mediana de la lista de numeros
     * @return double
     */
    public double mean(){    
        double sum = 0;
        for (int i = 0; i < linked.size(); i++) sum += linked.get(i); 
        double mean = (double)sum/linked.size();
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(mean));
    }
    /**
     * Calcula la desviacion de la lista de numeros
     * @return double
     */
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
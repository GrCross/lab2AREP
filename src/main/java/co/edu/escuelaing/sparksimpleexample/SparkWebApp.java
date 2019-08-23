package co.edu.escuelaing.sparksimpleexample;

import co.edu.escuelaing.sparksimpleexample.entities.Calc;
import co.edu.escuelaing.sparksimpleexample.entities.LinkedList;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 * Minimal web app  for Heroku using SparkWeb
 *
 * @author daniel
 */
public class SparkWebApp {

    /**
     * Metodo main de la aplicacion, corre la aplicacion por medio del puerto 5000 o 4567
     * @param args argumentos de entrada de la aplicacion
     */
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    /**
     * Metodo que se encarga de estructurar el html de la pagina de input
     * @param req parametros ingresados
     * @param res respuesta de la pagina
     * @return
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calc</h2>"
                + "<form action=\"/results\">"
                + "  Ingrese los numeros que quiere calcular separados por /:<br>"
                + "  <input type=\"text\" name=\"double\" value=\" \" / \"\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * Metodo que se encarga de estructurar el html de la pagina de response
     * @param req parametros ingresados
     * @param res respuesta de la pagina
     * @return
     */
    private static String resultsPage(Request req, Response res) {
        LinkedList linked = new LinkedList<Double>();
        String[] numbers = req.queryParams("double").split("/");
        for (int i = 0; i < numbers.length; i++) {
            linked.add(Double.parseDouble(numbers[i]));
        }
        Calc calc = new Calc(linked);
        String ansMean = String.valueOf(calc.mean());
        String ansDesviation = String.valueOf(calc.desviation());
        String ans = String.valueOf(ansDesviation);
        
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Respuesta</h2>"
                + "<form action=\"/results\">"
                + "  <br>Media :<br>"
                + "  <br>"
                + ansMean
                + "  </br>"
                + "  <br>Desviacion :<br>"
                + "  <br>"
                + ansDesviation
                + "  </br>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}

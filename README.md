#lab2AREP

Esta aplicación se encarga de calcular la media y la desviación de una lista de numeros.

## instalación

para poder instalar la aplicación seguir los siguientes pasos:

* Clonar el proyecto del ropositorio

````
git clone https://github.com/GrCross/lab2AREP.git
````
* descargar las dependencias
````
mvn package
````
* compilar el proyecto
````
mvn compile
````

## Uso
Para usar la aplicación **localmente** una vez instalada es necesario ir a la raiz del proyecto y desde el cmd usar el siguiente comando:

````
mvn exec:java -Dexec.mainClass="co.edu.escuelaing.sparksimpleexample.SparkWebApp"
````

una vez abierta la aplicación aparecera la siguiente página:

![](images/index.png)

En el cuadro de texto podra colocar una lista de numeros separados por el siguiente caracter "/" ej: *4.5/6.4/3.7/9.0*

se dara submit y se mostraran los resulados en la pantalla.

## Pruebas

para ejecutar las pruebas ejecute el siguiente comando:

````
mvn test
````

existen 2 casos de pruebas, uno para la media y otro para la desviación y usan los siguientes casos

test1

![](images/test1.png)

test2

![](images/test2.png)

Los resultados seran los siguientes

![](images/testResults.png)

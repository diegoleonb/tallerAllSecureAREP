package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkApp{
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getPasswd(), null, null); 
        SecureUrlReader.loadTrustStore(SparkAppTwo.getKeyStore(), SparkAppTwo.getPasswd());
        get("/hello", (req, res) -> "Hello SparkApp 1");
        get("/remote", (req, res) -> SecureUrlReader.readURL(SparkAppTwo.getUrl()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    public static String getKeyStore(){
        return "keystores/ecikeystore.p12";
    }

    public static String getPasswd(){
        return "arep123";
    }

    public static String getUrl(){
        return "https://localhost:5000/hello";
    }

} 
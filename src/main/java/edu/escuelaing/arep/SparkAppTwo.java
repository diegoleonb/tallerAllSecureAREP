package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkAppTwo{
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getPasswd(), null, null); 
        SecureUrlReader.loadTrustStore(SparkApp.getKeyStore(), SparkApp.getPasswd());
        get("/hello", (req, res) -> "Hello SparkApp 2");
        get("/remote", (req, res) -> SecureUrlReader.readURL(SparkApp.getUrl()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    public static String getKeyStore(){
        return "keystores/ecikeystore2.p12";
    }

    public static String getPasswd(){
        return "arep123";
    }

    public static String getUrl(){
        return "https://localhost:5001/hello";
    }

} 
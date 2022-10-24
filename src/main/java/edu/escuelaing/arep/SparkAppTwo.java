package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkAppTwo{
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getKeyStorePasswd(), null, null); 
        SecureUrlReader.loadTrustStore(SparkApp.getKeyStore(), SparkApp.getKeyStorePasswd());
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
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/awskeystore2.p12";
    }

    public static String getKeyStorePasswd(){
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "arep123";
    }

    public static String getUrl(){
        return "https://ec2-23-23-28-13.compute-1.amazonaws.com:5001/hello";
    }

} 
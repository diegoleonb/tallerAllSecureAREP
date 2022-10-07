package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkApp{
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getKeyStorePasswd(), null, null); 
        SecureUrlReader.loadTrustStore(SparkAppTwo.getKeyStore(), SparkAppTwo.getKeyStorePasswd());
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
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore.p12";
    }

    public static String getKeyStorePasswd(){
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "arep123";
    }

    public static String getTrustStore() {
        if (System.getenv("TRUSTSTORE") != null) {
            return System.getenv("TRUSTSTORE");
        }
        return "./keystores/ecitruststore2.p12";
    }

    public static String getTrustStorePasswd() {
        if (System.getenv("TRUSTSTOREPWD") != null) {
            return System.getenv("TRUSTSTOREPWD");
        }
        return "arep123";
    }

    public static String getUrl(){
        return "https://localhost:5000/hello";
    }

} 
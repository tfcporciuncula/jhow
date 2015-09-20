package xyz.jhow;

import static spark.Spark.*;

public class Jhow {

    private static final String PORT_ENV_VARIABLE_NAME = "PORT";
    private static final int DEFAULT_PORT = 8080;

    public static void main(String args[]) {
        setPortFromEnvVariable();

        get("*", (req, res) -> "Hi.");
    }

    private static void setPortFromEnvVariable() {
        String port = System.getenv(PORT_ENV_VARIABLE_NAME);
        if (port != null) {
            port(Integer.parseInt(port));
        } else {
            port(DEFAULT_PORT);
        }
    }

}

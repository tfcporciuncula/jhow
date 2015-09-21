package xyz.jhow;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;

public class Jhow {

    private static final String STATIC_FILES_FOLDER = "/static";
    private static final String PORT_ENV_VARIABLE_NAME = "PORT";
    private static final int DEFAULT_PORT = 8080;

    public static void main(String args[]) {
        setPortFromEnvVariable();
        staticFileLocation(STATIC_FILES_FOLDER);

        get("*", (req, res) -> new ModelAndView(new HashMap(), "index"), new ThymeleafTemplateEngine());
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

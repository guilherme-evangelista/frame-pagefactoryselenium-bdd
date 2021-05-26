package br.com.guilhermeevangelista.selenium.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private Properties prop = new Properties();
    private File file = new File("src/main/resources");

    public PropertiesManager(String fileProperty) {
        try {
            if (System.getProperty("env") == null) {
                prop.load(new FileInputStream( file.getAbsolutePath() + "/propriedades/"+fileProperty+".properties"));
            } else {
                prop.load(new FileInputStream(file.getCanonicalPath() + "/" + System.getProperty("env")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProp(String valor) {
        return prop.getProperty(valor);
    }
}

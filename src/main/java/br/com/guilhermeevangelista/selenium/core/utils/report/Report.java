package br.com.guilhermeevangelista.selenium.core.utils.report;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Gerar report HTML
 *
 * @author Guilherme-Evangelista
 */
public class Report {
    /**
     * Gerar report com o plugin ClueCumber baseado no custom.css acima
     */
    public static void gerarRelarotioClueCumber() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                Process process = Runtime.getRuntime().exec(
                        "cmd /c report.bat", null, new File("./"));

                StringBuilder output = new StringBuilder();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.println("Success!");
                    System.out.println(output);
                    System.exit(0);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }else if (System.getProperty("os.name").toLowerCase().contains("mac")){
            try {
                Runtime.getRuntime().exec("mvn cluecumber-report:reporting");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        gerarRelarotioClueCumber();
    }
}

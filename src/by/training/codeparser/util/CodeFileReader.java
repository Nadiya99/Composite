package by.training.codeparser.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * The type File util.
 */
public class CodeFileReader {
    private static Logger log = LogManager.getLogger(CodeFileReader.class);

    /**
     * Read file string.
     *
     * @param directoryName the directory name
     * @param filename      the filename
     * @return the string
     */
    public static String readFile(String directoryName, String filename) {
        StringBuilder builder = new StringBuilder();
        try (Scanner fileInput = new Scanner(new File(directoryName + "/" + filename))) {
            while (fileInput.hasNextLine()) {
                builder.append(fileInput.nextLine());
            }
        } catch (IOException e) {
            log.fatal("Error reading the file. The program stopped its execution.", e);
            throw new RuntimeException();
        }
        return builder.toString();
    }
}

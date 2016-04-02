package by.training.codeparser.util;

import by.training.codeparser.composite.Component;
import by.training.codeparser.exception.FileWritingException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * The type File writer.
 */
public class ResultFileWriter {
    /**
     * Write file.
     *
     * @param directoryName the directory name
     * @param filename      the filename
     * @param component     the component
     * @throws FileWritingException the file writing exception
     */
    public static void writeFile(String directoryName, String filename, Component component) throws FileWritingException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new java.io.FileWriter(new File(directoryName + "/" + filename))))) {
            writer.print(component.toString());
        } catch (IOException e) {
            throw new FileWritingException(e);
        }
    }

    /**
     * Write file.
     *
     * @param directoryName the directory name
     * @param filename      the filename
     * @param components    the components
     * @throws FileWritingException the file writing exception
     */
    public static void writeFile(String directoryName, String filename, Collection<? extends Component> components) throws FileWritingException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new java.io.FileWriter(new File(directoryName + "/" + filename))))) {
            for (Component component : components) {
                writer.println(component.toString());
            }
        } catch (IOException e) {
            throw new FileWritingException(e);
        }
    }
}

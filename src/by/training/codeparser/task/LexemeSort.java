package by.training.codeparser.task;


import by.training.codeparser.composite.Component;
import by.training.codeparser.composite.Composite;
import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.constant.FileConstants;
import by.training.codeparser.exception.FileWritingException;
import by.training.codeparser.util.ResultFileWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class LexemeSort {
    private static Logger log = LogManager.getLogger(LexemeSort.class);

    private ArrayList<Component> operators = new ArrayList<Component>();

    public void fillList(Composite component) {
        for (Component innerComponent : component.getContent()) {
            if (innerComponent.getType() == CompositeType.LEXEME) {
                operators.add(innerComponent);
                continue;
            }
            Composite composite = (Composite) innerComponent;
            fillList(composite);
        }
    }

    public void sortLexemeAlphabetically(Composite component) {
        fillList(component);
        Collections.sort(operators, ComponentComparator.sortComponentAlphabetically);

        try {
            ResultFileWriter.writeFile(FileConstants.DIRECTORY_NAME, FileConstants.SECOND_TASK_FILENAME, operators);
            log.info("The second task was successfully written to the file.");
        } catch (FileWritingException e) {
            log.error("Error writing second task.", e);
        }
    }
}


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

public class OperatorSort {
    private static Logger log = LogManager.getLogger(OperatorSort.class);

    private ArrayList<Composite> operators = new ArrayList<Composite>();

    public void fillList(Composite component) {
        for (Component innerComponent : component.getContent()) {
            if (innerComponent.getType() == CompositeType.LEXEME) {
                continue;
            }
            Composite composite = (Composite) innerComponent;
            if(innerComponent.getType() == CompositeType.OPERATOR) {
                operators.add(composite);
            }
            fillList(composite);
        }
    }

    public void sortOperatorsByLexemeNumber(Composite component) {
        fillList(component);
        Collections.sort(operators, ComponentComparator.sortCompositeByNumberElements);

        try {
            ResultFileWriter.writeFile(FileConstants.DIRECTORY_NAME, FileConstants.FIRST_TASK_FILENAME, operators);
            log.info("The first task was successfully written to the file.");
        } catch (FileWritingException e) {
            log.error("Error writing first task.", e);
        }
    }
}


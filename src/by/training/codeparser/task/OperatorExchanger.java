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

public class OperatorExchanger {
    private static Logger log = LogManager.getLogger(OperatorExchanger.class);

    private ArrayList<Composite> operators = new ArrayList<Composite>();

    public void fillList(Composite component) {
        for (Component innerComponent : component.getContent()) {
            if (innerComponent.getType() == CompositeType.LEXEME) {
                continue;
            }
            Composite composite = (Composite) innerComponent;
            if (innerComponent.getType() == CompositeType.OPERATOR) {
                ArrayList<Component> a = (ArrayList<Component>) composite.getContent();
                Collections.swap(a, 0, composite.getContent().size() - 1);
                operators.add(composite);
            }
            fillList(composite);
        }
    }

    public void swapLexemeInOperators(Composite component) {
        fillList(component);
        Collections.sort(operators, ComponentComparator.sortCompositeByNumberElements);

        try {
            ResultFileWriter.writeFile(FileConstants.DIRECTORY_NAME, FileConstants.THIRD_TASK_FILENAME, operators);
            log.info("The third task was successfully written to the file.");
        } catch (FileWritingException e) {
            log.error("Error writing third task.", e);
        }
    }
}

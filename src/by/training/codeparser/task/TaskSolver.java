package by.training.codeparser.task;


import by.training.codeparser.constant.FileConstants;
import by.training.codeparser.exception.FileWritingException;
import by.training.codeparser.parser.CodeParser;
import by.training.codeparser.util.ResultFileWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskSolver {
    private static Logger log = LogManager.getLogger(TaskSolver.class);

    public static void solve() {
        CodeParser codeParser = new CodeParser();
        codeParser.parseCode();

        try {
            ResultFileWriter.writeFile(FileConstants.DIRECTORY_NAME, FileConstants.OUTPUT_FILENAME, codeParser.getElement());
            log.info("The restored text is successfully written to the file.");
        } catch (FileWritingException e) {
            log.error("Error writing restored text.", e);
        }

        OperatorSort  operatorSort = new OperatorSort();
        operatorSort.sortOperatorsByLexemeNumber(codeParser.getElement());

        LexemeSort lexemeSort = new LexemeSort();
        lexemeSort.sortLexemeAlphabetically(codeParser.getElement());

        OperatorExchanger operatorExchanger = new OperatorExchanger();
        operatorExchanger.swapLexemeInOperators(codeParser.getElement());
    }
}

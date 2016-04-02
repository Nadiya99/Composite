package by.training.codeparser.parser;

import by.training.codeparser.composite.Composite;
import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.constant.FileConstants;
import by.training.codeparser.util.CodeFileReader;

public class CodeParser {
    private Composite element;

    public void parseCode() {
        PackageParserHandler packageParserHandler = new PackageParserHandler(CompositeType.PACKAGE);
        EntityParserHandler entityParserHandler = new EntityParserHandler(CompositeType.EXTERNAL_ENTITY);
        MethodParserHandler methodParserHandler = new MethodParserHandler(CompositeType.METHOD);
        OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.OPERATOR);

        packageParserHandler.setSuccessor(entityParserHandler);
        entityParserHandler.setSuccessor(methodParserHandler);
        methodParserHandler.setSuccessor(operatorParserHandler);

        element = packageParserHandler.chain(CodeFileReader.readFile(FileConstants.DIRECTORY_NAME, FileConstants.INPUT_FILENAME));
    }

    public Composite getElement() {
        return element;
    }
}

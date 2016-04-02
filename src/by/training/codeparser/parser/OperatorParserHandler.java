package by.training.codeparser.parser;


import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.composite.LexemeLeaf;
import by.training.codeparser.constant.RegExConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorParserHandler extends RequestHandler {

    public OperatorParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String operator) {
        Pattern pattern = Pattern.compile(RegExConstants.LEXEME_REGEX);
        Matcher matcher = pattern.matcher(operator);

        while (matcher.find()) {
            String lexeme = matcher.group();
            LexemeLeaf lexemeLeaf = new LexemeLeaf(lexeme, CompositeType.LEXEME);
            element.add(lexemeLeaf);
        }
    }
}

package by.training.codeparser.parser;


import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.constant.RegExConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PackageParserHandler extends RequestHandler {

    public PackageParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String text) {
        Pattern pattern = Pattern.compile(RegExConstants.PACKAGE_PATTERN);
        Pattern entityPattern = Pattern.compile(RegExConstants.ENTITY_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String group = matcher.group();
            Matcher entityMatcher = entityPattern.matcher(group);
            if (entityMatcher.matches()) {
                element.add(successor.chain(group));
            } else {
                OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.OPERATOR);
                element.add(operatorParserHandler.chain(group));
            }
        }
    }
}

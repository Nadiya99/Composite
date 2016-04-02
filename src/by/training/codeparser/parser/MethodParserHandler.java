package by.training.codeparser.parser;


import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.composite.LexemeLeaf;
import by.training.codeparser.constant.RegExConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodParserHandler extends RequestHandler {

    public MethodParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String method) {
        int position = addSignature(method);
        String methodBody = method.substring(position, method.length() - 1);

        Pattern pattern = Pattern.compile(RegExConstants.OPERATOR_REGEX);
        Matcher matcher = pattern.matcher(methodBody);

        while (matcher.find()) {
            String group = matcher.group();
            element.add(successor.chain(group));
        }
        element.add(new LexemeLeaf(RegExConstants.BLOCK_END, CompositeType.LEXEME));
    }

    private int addSignature(String method) {
        Pattern signaturePattern = Pattern.compile(RegExConstants.SIGNATURE_PATTERN);
        Matcher signatureMatcher = signaturePattern.matcher(method);
        signatureMatcher.find();
        String signature = signatureMatcher.group();
        OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.SIGNATURE);
        element.add(operatorParserHandler.chain(signature));

        return signatureMatcher.end();
    }
}


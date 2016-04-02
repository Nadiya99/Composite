package by.training.codeparser.parser;


import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.composite.LexemeLeaf;
import by.training.codeparser.constant.RegExConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldsParserHandler extends RequestHandler {


    public FieldsParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String fields) {
        addSignature(fields);
        Pattern pattern = Pattern.compile(RegExConstants.FIELD_REGEX);
        Matcher matcher = pattern.matcher(fields);

        while (matcher.find()) {
            String group = matcher.group();
            element.add(successor.chain(group));
        }
        if (getElement().getType() == CompositeType.BLOCK) {
            element.add(new LexemeLeaf(RegExConstants.BLOCK_END, CompositeType.LEXEME));
        }
    }

    private String addSignature(String fields) {
        Pattern signaturePattern = Pattern.compile(RegExConstants.BLOCK_SIGNATURE_REGEX);
        Matcher signatureMatcher = signaturePattern.matcher(fields);
        if (signatureMatcher.find()) {
            fields = fields.substring(signatureMatcher.end(), fields.length() - 1);
            String signature = signatureMatcher.group();
            OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.SIGNATURE);
            element.add(operatorParserHandler.chain(signature));
        }
        return fields;
    }
}

package by.training.codeparser.parser;


import by.training.codeparser.composite.CompositeType;
import by.training.codeparser.composite.LexemeLeaf;
import by.training.codeparser.constant.RegExConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EntityParserHandler extends RequestHandler {
    private CompositeType signatureType;

    public EntityParserHandler(CompositeType type) {
        super(type);
    }

    @Override
    public void parse(String entity) {
        int position = addSignature(entity);
        String entityBody = entity.substring(position);

        switch (signatureType) {
            case CLASS:
                addClass(entityBody);
                break;
            case ENUM:
                addEnum(entityBody);
                break;
            case ANNOTATION_AND_INTERFACE:
                addInterfaceOrAnnotation(entityBody);
                break;
            default:
                addClass(entityBody);
        }
        element.add(new LexemeLeaf(RegExConstants.ENTITY_END, CompositeType.LEXEME));
    }

    private void defineSignatureType(String signature) {
        Pattern classPattern = Pattern.compile(RegExConstants.CLASS_REGEX);
        Matcher classMatcher = classPattern.matcher(signature);

        if (classMatcher.find()) {
            signatureType = CompositeType.CLASS;
        } else {
            Pattern enumPattern = Pattern.compile(RegExConstants.ENUM_REGEX);
            Matcher enumMatcher = enumPattern.matcher(signature);

            if (enumMatcher.find()) {
                signatureType = CompositeType.ENUM;
            } else {
                signatureType = CompositeType.ANNOTATION_AND_INTERFACE;
            }
        }
    }

    private int addSignature(String entity) {
        Pattern pattern = Pattern.compile(RegExConstants.SIGNATURE_REGEX);
        Matcher matcher = pattern.matcher(entity);
        matcher.find();
        String signature = matcher.group();
        OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.SIGNATURE);
        element.add(operatorParserHandler.chain(signature));
        defineSignatureType(signature);
        return matcher.end();
    }

    private void addFields(String fields) {
        if (!fields.isEmpty()) {
            FieldsParserHandler fieldsParserHandler = new FieldsParserHandler(CompositeType.ENTITY_FIELDS);
            OperatorParserHandler operatorHandler = new OperatorParserHandler(CompositeType.OPERATOR);
            fieldsParserHandler.setSuccessor(operatorHandler);
            element.add(fieldsParserHandler.chain(fields));
        }
    }

    private void addEntity(String entity) {
        EntityParserHandler entityParserHandler = new EntityParserHandler(CompositeType.ENTITY);
        MethodParserHandler methodParserHandler = new MethodParserHandler(CompositeType.METHOD);
        OperatorParserHandler handler = new OperatorParserHandler(CompositeType.OPERATOR);

        entityParserHandler.setSuccessor(methodParserHandler);
        methodParserHandler.setSuccessor(handler);
        element.add(entityParserHandler.chain(entity));
    }

    private void addClass(String entityBody) {
        Pattern innerPattern = Pattern.compile(RegExConstants.CLASS_ENTITIES_PATTERN);
        Matcher innerMatcher = innerPattern.matcher(entityBody);

        String fields = FieldsFinder.findClassFields(entityBody);
        addFields(fields);

        while (innerMatcher.find()) {
            String group = innerMatcher.group();
            Pattern entityPattern = Pattern.compile(RegExConstants.INNER_ENTITY_REGEX);
            Matcher matcher = entityPattern.matcher(group);

            if (matcher.find()) {
                addEntity(group);
            } else {
                addMethod(group);
            }
        }
    }


    private void addEnum(String entityBody) {
        Pattern innerPattern = Pattern.compile(RegExConstants.CLASS_ENTITIES_PATTERN);
        Matcher innerMatcher = innerPattern.matcher(entityBody);

        String constants = FieldsFinder.findEnumConstants(entityBody);
        OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.ENUM_CONSTANTS);
        element.add(operatorParserHandler.chain(constants));

        entityBody = entityBody.trim();
        entityBody = entityBody.substring(constants.length());

        String fields = FieldsFinder.findEnumFields(entityBody);
        addFields(fields);

        while (innerMatcher.find()) {
            String group = innerMatcher.group();
            Pattern entityPattern = Pattern.compile(RegExConstants.INNER_ENTITY_REGEX);
            Matcher matcher = entityPattern.matcher(group);

            if (matcher.find()) {
                addEntity(group);
            } else {
                addMethod(group);
            }
        }
    }

    private void addInterfaceOrAnnotation(String entityBody) {
        Pattern innerPattern = Pattern.compile(RegExConstants.INTERFACE_ENTITIES_PATTERN);
        Matcher innerMatcher = innerPattern.matcher(entityBody);

        String fields = FieldsFinder.findInterfaceOrInterfaceFields(entityBody);
        addFields(fields);

        while (innerMatcher.find()) {
            String group = innerMatcher.group();
            Pattern entityPattern = Pattern.compile(RegExConstants.INNER_ENTITY_REGEX);
            Matcher matcher = entityPattern.matcher(group);

            if (matcher.find()) {
                addEntity(group);
            } else {
                addMethod(group);
            }
        }
    }

    private void addMethod(String method) {
        Pattern pattern = Pattern.compile(RegExConstants.METHOD_PATTERN);
        Matcher matcher = pattern.matcher(method);

        if (matcher.find()) {
            Pattern blockPattern = Pattern.compile(RegExConstants.BLOCK_REGEX);
            Matcher blockMatcher = blockPattern.matcher(method);
            if (blockMatcher.find()) {
                FieldsParserHandler fieldsParserHandler = new FieldsParserHandler(CompositeType.BLOCK);
                OperatorParserHandler operatorHandler = new OperatorParserHandler(CompositeType.OPERATOR);
                fieldsParserHandler.setSuccessor(operatorHandler);
                element.add(fieldsParserHandler.chain(method));
            } else {
                OperatorParserHandler operatorParserHandler = new OperatorParserHandler(CompositeType.METHOD);
                element.add(operatorParserHandler.chain(method));
            }
        } else {
            element.add(successor.chain(method));
        }
    }
}


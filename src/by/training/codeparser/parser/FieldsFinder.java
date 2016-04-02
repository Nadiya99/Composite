package by.training.codeparser.parser;


import by.training.codeparser.constant.RegExConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldsFinder {

    public static String findClassFields(String entityBody) {
        Pattern pattern = Pattern.compile(RegExConstants.ENTITY_FIELDS_PATTERN);
        Matcher matcher = pattern.matcher(entityBody);
        String fields = "";
        if (matcher.find()) {
            fields = entityBody.substring(0, matcher.start());
        }

        return fields;
    }

    public static String findInterfaceOrInterfaceFields(String entityBody) {
        Pattern pattern = Pattern.compile(RegExConstants.INTERFACE_FIELDS_PATTERN);
        Matcher matcher = pattern.matcher(entityBody);
        String fields = "";
        if (matcher.find()) {
            fields = entityBody.substring(0, matcher.start());
        }

        return fields;
    }

    public static String findEnumFields(String entityBody) {
        Pattern pattern = Pattern.compile(RegExConstants.ENTITY_FIELDS_PATTERN);
        Matcher matcher = pattern.matcher(entityBody);
        String fields = "";
        if (matcher.find()) {
            fields = entityBody.substring(0, matcher.start());
        }

        return fields;
    }

    public static String findEnumConstants(String entityBody) {
        Pattern pattern = Pattern.compile(RegExConstants.ENUM_CONSTANTS_REGEX);
        Matcher matcher = pattern.matcher(entityBody);
        String constants = "";
        if (matcher.find()) {
            constants = matcher.group();
            String stringEnd = constants.substring(constants.length() - 1);
            if (stringEnd.equals(RegExConstants.END_CURLY_BRACE)) {
                constants = constants.substring(0, constants.length() - 1);
            }
        }

        return constants;
    }
}

package by.training.codeparser.constant;


/**
 * The type Reg ex constants.
 */
public class RegExConstants {
    /**
     * The constant OR.
     */
    public static final String OR = "|";
    /**
     * The constant PACKAGE_HEAD_REGEX.
     */
    public static final String PACKAGE_HEAD_REGEX = "(package|import) .*?;";
    /**
     * The constant INTERFACE_REGEX.
     */
    public static final String INTERFACE_REGEX = "(public )?[^@]?interface \\w+( extends (\\w+,? )+)?(\\s)?\\{";
    /**
     * The constant ENUM_REGEX.
     */
    public static final String ENUM_REGEX = "(public )?enum \\w+( implements (\\w+,? )+)?(\\s)?\\{";
    /**
     * The constant OPERATOR_REGEX.
     */
    public static final String OPERATOR_REGEX = "(final )?\\.*?(\\<[^>]*\\>)?( \\w+( = )?(\\d|(new \\w+(\\<[^>]*\\>))|[^;]*)?)?;";
    /**
     * The constant LEXEME_REGEX.
     */
    public static final String LEXEME_REGEX = "[^\\s]+";
    /**
     * The constant BLOCK_SIGNATURE_REGEX.
     */
    public static final String BLOCK_SIGNATURE_REGEX = "[\\s]{4,}(static \\{|\\{)";
    /**
     * The constant BLOCK_REGEX.
     */
    public static final String BLOCK_REGEX = BLOCK_SIGNATURE_REGEX + ".*?[\\s]{4}\\}";
    /**
     * The constant END_CURLY_BRACE.
     */
    public static final String END_CURLY_BRACE = "}";
    /**
     * The constant INTERFACE_METHOD_SIGNATURE_REGEX.
     */
    public static final String INTERFACE_METHOD_SIGNATURE_REGEX = "(default )?(public )?(abstract )?\\w+(\\<[^\\>]*\\>)? \\w+\\([^\\)]*\\) \\{";
    /**
     * The constant ABSTRACT_METHOD_REGEX.
     */
    public static final String ABSTRACT_METHOD_REGEX = "(public )?(abstract )?\\w+(\\<[^\\>]*\\>)? \\w+\\([^\\)]*\\)(( default .*?;)|;)";
    /**
     * The constant INTERFACE_METHOD_REGEX.
     */
    public static final String INTERFACE_METHOD_REGEX = INTERFACE_METHOD_SIGNATURE_REGEX + ".*?[\\s]{4}\\}";
    /**
     * The constant ENUM_CONSTANTS_REGEX.
     */
    public static final String ENUM_CONSTANTS_REGEX = "(\\w+(\\(.*?\\))?(, |;|}|))+";
    private static final String ACCESS_MODIFIERS_REGEX = "(public |private |protected )?";
    private static final String MODIFICATIONS_REGEX = "(static )?(abstract )?(final )?(strictfp )?";
    /**
     * The constant CLASS_REGEX.
     */
    public static final String CLASS_REGEX = ACCESS_MODIFIERS_REGEX + MODIFICATIONS_REGEX + "class \\w+( extends \\w+)?( implements (\\w+,? )+)?(\\s)?\\{";
    /**
     * The constant ANNOTATION_REGEX.
     */
    public static final String ANNOTATION_REGEX = ACCESS_MODIFIERS_REGEX + MODIFICATIONS_REGEX + "@interface \\w+(\\s)?\\{";
    /**
     * The constant METHOD_SIGNATURE_REGEX.
     */
    public static final String METHOD_SIGNATURE_REGEX = "(@Override )?" + ACCESS_MODIFIERS_REGEX + MODIFICATIONS_REGEX + "\\w+(\\<[^\\>]*\\>)? \\w+\\([^\\)]*\\)(\\s)?\\{";
    /**
     * The constant FIELD_REGEX.
     */
    public static final String FIELD_REGEX = ACCESS_MODIFIERS_REGEX + MODIFICATIONS_REGEX + "\\w+(\\<[^>]*\\>)? \\w+( = )?(\\d|(new \\w+(\\<[^>]*\\>))|[^;]*)?;";
    /**
     * The constant METHOD_REGEX.
     */
    public static final String METHOD_REGEX = METHOD_SIGNATURE_REGEX + ".*?[\\s]{4}\\}";
    /**
     * The constant ENTITY_REGEX.
     */
    public static final String ENTITY_REGEX = "(" + INTERFACE_REGEX + OR + CLASS_REGEX + OR + ENUM_REGEX + OR + ANNOTATION_REGEX + ").*?[^\\s]\\}";
    /**
     * The constant INNER_ENTITY_REGEX.
     */
    public static final String INNER_ENTITY_REGEX = "(" + INTERFACE_REGEX + OR + CLASS_REGEX + OR + ENUM_REGEX + OR + ANNOTATION_REGEX + ").*?(\\}|;|\\w)[\\s]{4}\\}";
    /**
     * The constant SIGNATURE_REGEX.
     */
    public static final String SIGNATURE_REGEX = INTERFACE_REGEX + OR + CLASS_REGEX + OR + ENUM_REGEX + OR + ANNOTATION_REGEX;
    /**
     * The constant BLOCK_END.
     */
    public static final String BLOCK_END = "\t}";

    /**
     * The constant ENTITY_END.
     */
    public static final String ENTITY_END = "}";
    /**
     * The constant SIGNATURE_PATTERN.
     */
    public static final String SIGNATURE_PATTERN = METHOD_SIGNATURE_REGEX + OR + INTERFACE_METHOD_SIGNATURE_REGEX;
    /**
     * The constant PACKAGE_PATTERN.
     */
    public static final String PACKAGE_PATTERN = PACKAGE_HEAD_REGEX + OR + ENTITY_REGEX;
    /**
     * The constant ENTITY_FIELDS_PATTERN.
     */
    public static final String ENTITY_FIELDS_PATTERN = METHOD_REGEX + OR + BLOCK_REGEX;
    /**
     * The constant INTERFACE_FIELDS_PATTERN.
     */
    public static final String INTERFACE_FIELDS_PATTERN = INTERFACE_METHOD_REGEX + OR + ABSTRACT_METHOD_REGEX;
    /**
     * The constant CLASS_ENTITIES_PATTERN.
     */
    public static final String CLASS_ENTITIES_PATTERN = INNER_ENTITY_REGEX + OR + METHOD_REGEX + OR + ABSTRACT_METHOD_REGEX + OR + BLOCK_REGEX;
    /**
     * The constant INTERFACE_ENTITIES_PATTERN.
     */
    public static final String INTERFACE_ENTITIES_PATTERN = INTERFACE_FIELDS_PATTERN + OR + INNER_ENTITY_REGEX;
    /**
     * The constant METHOD_PATTERN.
     */
    public static final String METHOD_PATTERN = ABSTRACT_METHOD_REGEX + OR + BLOCK_REGEX;

    /**
     * The constant SPACE.
     */
    public static final String SPACE = " ";
    /**
     * The constant TAB.
     */
    public static final String TAB = "\t";
    /**
     * The constant DOUBLE_TAB.
     */
    public static final String DOUBLE_TAB = "\t\t";
    /**
     * The constant LINE_BREAK.
     */
    public static final String LINE_BREAK = "\n";
}

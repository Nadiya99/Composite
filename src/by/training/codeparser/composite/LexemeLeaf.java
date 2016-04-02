package by.training.codeparser.composite;


/**
 * The type Lexeme leaf.
 */
public class LexemeLeaf implements Component {
    private CompositeType type;
    private String content;

    /**
     * Instantiates a new Lexeme leaf.
     *
     * @param content the content
     * @param type    the type
     */
    public LexemeLeaf(String content, CompositeType type) {
        this.type = type;
        this.content = content;
    }

    /**
     * Instantiates a new Lexeme leaf.
     *
     * @param type the type
     */
    public LexemeLeaf(CompositeType type) {
        this.type = type;
    }

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    public CompositeType getType() {
        return type;
    }

    @Override
    public String toString() {
        String result = getContent().toString() + " ";

        return result;
    }
}

package by.training.codeparser.composite;

/**
 * The interface Component.
 */
public interface Component {
    /**
     * Gets content.
     *
     * @return the content
     */
    Object getContent();

    /**
     * Gets type.
     *
     * @return the type
     */
    CompositeType getType();
}
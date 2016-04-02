package by.training.codeparser.composite;


import by.training.codeparser.constant.RegExConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Composite.
 */
public class Composite implements Component {
    private ArrayList<Component> content = new ArrayList<Component>();
    private CompositeType type;

    /**
     * Instantiates a new Composite.
     *
     * @param type the type
     */
    public Composite(CompositeType type) {
        this.type = type;
    }

    /**
     * Add.
     *
     * @param component the component
     */
    public void add(Component component) {
        content.add(component);
    }

    @Override
    public List<Component> getContent() {
        return content;
    }

    @Override
    public CompositeType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(CompositeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String result = "";
        switch (type) {
            case EXTERNAL_ENTITY:
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case ENTITY_FIELDS:
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case BLOCK:
                result = RegExConstants.TAB;
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case ENTITY:
                result = RegExConstants.TAB;
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case ENUM_CONSTANTS:
                result = RegExConstants.TAB;
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case OPERATOR:
                result = RegExConstants.DOUBLE_TAB;
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case SIGNATURE:
                result = takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case METHOD:
                result = RegExConstants.TAB;
                result += takeSubComponentString();
                result += RegExConstants.LINE_BREAK;
                break;
            case LEXEME:
                result = takeSubComponentString();
                result += RegExConstants.SPACE;
                break;
            default:
                result = takeSubComponentString();
        }
        return result;
    }

    private String takeSubComponentString() {
        StringBuilder result = new StringBuilder();
        for (Component component : content) {
            result.append(component.toString());
        }

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite that = (Composite) o;

        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}

package by.training.codeparser.parser;


import by.training.codeparser.composite.Composite;
import by.training.codeparser.composite.CompositeType;

public abstract class RequestHandler {
    protected RequestHandler successor;
    protected Composite element;
    private CompositeType type;

    public RequestHandler(CompositeType type) {
        this.type = type;
    }

    abstract public void parse(String text);

    public Composite chain(String text) {
        element = new Composite(type);
        parse(text);
        return element;
    }

    public void setSuccessor(RequestHandler successor) {
        this.successor = successor;
    }

    public Composite getElement() {
        return element;
    }
}

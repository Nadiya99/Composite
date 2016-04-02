package by.training.codeparser.task;


import by.training.codeparser.composite.Component;
import by.training.codeparser.composite.Composite;

import java.util.Comparator;

public class ComponentComparator {

    public static Comparator<Component> sortComponentAlphabetically = new Comparator<Component>() {
        @Override
        public int compare(Component s1, Component s2) {
            String str1 = s1.getContent().toString().toLowerCase();
            String str2 = s2.getContent().toString().toLowerCase();

            return str1.compareTo(str2);
        }
    };

    public static Comparator<Composite> sortCompositeByNumberElements = (s1, s2) -> s1.getContent().size() - s2.getContent().size();
}

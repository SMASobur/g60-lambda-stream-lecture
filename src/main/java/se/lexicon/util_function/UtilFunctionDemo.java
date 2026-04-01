package se.lexicon.util_function;

import se.lexicon.functional_lambda.Todo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UtilFunctionDemo {
    //  boolean test(T t);
    Predicate<Todo> isDone = todo -> todo.isCompleted();
    Predicate<Todo> notCompleted = todo -> !todo.isCompleted();
    //  R apply(T t);
    Function<Todo, String> todoToTitle = todo -> todo.getTitle();

    Consumer<Todo> updateToCompleted = todo -> todo.setCompleted(true);
}

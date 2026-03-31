package se.lexicon.functional_lambda;

@FunctionalInterface
public interface TaskAction {
    void run(Todo task);
}

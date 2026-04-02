package se.lexicon.exercises.Part_1;

@FunctionalInterface
interface PersonRule {
    boolean test(Person person);
}
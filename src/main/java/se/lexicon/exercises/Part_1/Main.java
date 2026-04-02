package se.lexicon.exercises.Part_1;

import se.lexicon.functional_lambda.Todo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    void main (){

        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        System.out.println("\n--- All People (initial list) ---");
        // Iterating through the list using a for-each loop
        for (Person person: people){
            System.out.println("Person: "+person);
        }

        PersonRule isActive = person -> person.isActive();
        PersonRule isAdult = person -> person.getAge()>= 18;
        PersonRule livesInStockholm = person -> person.getCity().equals("Stockholm");

    }

    public static List<Person> filterPeople(List<Person> people, PersonRule rule){
        List<Person> result = new ArrayList<>();
        for (Person p:people){
            if (rule.test(p)){
                result.add(p);
            }
        }
        return result;
    }

    PersonAction printName = person -> System.out.println(person.getName());
    PersonAction sendEmail = person -> System.out.println("Send email to "+ person.getName());



}

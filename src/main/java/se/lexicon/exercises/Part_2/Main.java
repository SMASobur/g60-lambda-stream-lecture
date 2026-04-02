package se.lexicon.exercises.Part_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        for (se.lexicon.exercises.Part_2.Person person: people){
            System.out.println("Person: "+person);
        }


        // 1.Filter all active people.
        System.out.println("\n--- All active People list ---");
        List<Person> activePeople = people.stream()
                .filter(person -> person.isActive())
                .toList();
        System.out.println("\nAll Active people: "+activePeople);

        //2. Map all names.
        System.out.println("\n--- Map all name ---");
        List<String> names = people.stream()
                .map(person -> person.getName())
                .toList();
        System.out.println("\nMap all names: "+ names);

        //3. Count adults.
        System.out.println("\n--- Count adults. ---");
        long adults = people.stream()
                .filter(person -> person.getAge()>= 18)
                .count();
        System.out.println("Adults: "+ adults);

        //4. Sort by age.
        System.out.println("\n--- Sort by age. ---");
        List<String> sortedNameByAge = people.stream()
                .sorted(Comparator.comparingDouble(p-> p.getAge()))
                .map(e-> e.getName())
                .toList();
        System.out.println("Sorted Name: "+ sortedNameByAge);

    }
}

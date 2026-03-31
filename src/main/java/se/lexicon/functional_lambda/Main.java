package se.lexicon.functional_lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    void main() {

        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Fix bugs", 2, false));
        todos.add(new Todo("Write tests", 1, false));
        todos.add(new Todo("Deploy app", 3, false));
        todos.add(new Todo("Refactor code", 1, true));
        todos.add(new Todo("Update documentation", 1, false));
        todos.add(new Todo("Investigate production issue", 5, false));
        todos.add(new Todo("Code review PR #42", 2, true));
        todos.add(new Todo("Optimize database query", 4, false));
        todos.add(new Todo("Plan next sprint", 3, true));
        todos.add(new Todo("Clean up warnings", 2, false));
        todos.add(new Todo("Improve UI layout", 3, false));
        todos.add(new Todo("Release hotfix", 5, true));

        System.out.println("\n--- All tasks (initial list) ---");
        // Iterating through the list using a for-each loop
        for (Todo todo : todos) {
            System.out.println("todo = " + todo);
        }

        // Defining filters using Lambdas : boolean matches(Todo todo);

       TaskFilter highPriority = todo -> todo.getPriority() >= 4;

        // Expanded syntax version
       /* TaskFilter highPriority1 = (Todo todo) -> {
            if (todo.getPriority() >= 4) {
                return true;
            } else {
                return false;
            }
        };*/

        System.out.println("\n--- Tasks with high priority ---");
        System.out.println("High priority tasks:" + findTasks(todos, highPriority));

        TaskFilter mediumPriority = todo -> todo.getPriority() == 3;
        System.out.println("\n--- Tasks with medium priority ---");
        System.out.println("Medium priority tasks:" + findTasks(todos, mediumPriority));

        TaskFilter lowPriority = todo -> todo.getPriority() <= 2;
        System.out.println("\n--- Tasks with low priority ---");
        System.out.println("Low priority tasks:" + findTasks(todos, lowPriority));

        TaskFilter completed = todo -> todo.isCompleted();
        System.out.println("Completed tasks:" + findTasks(todos, completed));

        //TaskFilter notCompleted = todo -> !todo.isCompleted();
        TaskFilter notCompleted = completed.negate();


        //Defining actions using Lambdas : void run(Todo task);
        TaskAction markCompleted = task -> task.setCompleted(true);
        TaskAction increasePriority = task -> task.setPriority(task.getPriority() + 1);
        TaskAction printTask = task -> System.out.println("Updated: " + task);

        System.out.println("\n--- Marking high priority tasks as completed ---");
        List<Todo> updatedHighpriorityTasks= applyToMatchingTasks(todos, highPriority, markCompleted);
        updatedHighpriorityTasks.forEach(task -> printTask.run(task));

        System.out.println("\n--- Updating tasks: Increase priority of not completed tasks ---");
        List<Todo> updatedNotCompletedTsks = applyToMatchingTasks(todos,notCompleted,increasePriority);
        updatedNotCompletedTsks.forEach(task -> printTask.run(task));


    }



    public static List<Todo> findTasks (List<Todo> todos, TaskFilter filter) {
        List<Todo> result = new ArrayList<>();
        for (Todo task : todos) {
            if (filter.matches(task)) {
                result.add(task);
            }
        }
        return result;
    }

    public static List<Todo> applyToMatchingTasks(List<Todo> todos, TaskFilter filter, TaskAction action){
        List<Todo> updated = new ArrayList<>();
        for (Todo task : todos) {
            if (filter.matches(task)) {
                action.run(task);
                updated.add(task);
            }
        }
        return updated;
    }


}




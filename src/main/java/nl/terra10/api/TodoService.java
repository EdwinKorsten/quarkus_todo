package nl.terra10.api;

import nl.terra10.api.Todo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TodoService {

    private List<Todo> todos = new ArrayList<Todo>();

    public List<Todo> list() {
        return this.todos;
    }

    public void add(Todo todo) {
        this.todos.add(todo);
    }

    public void remove(int id) {
        this.todos.removeIf(todo -> todo.getId() == id);
    }

    public void removeAll() {
        this.todos.clear();
    }
}

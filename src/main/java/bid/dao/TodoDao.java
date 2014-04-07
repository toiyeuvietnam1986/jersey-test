package bid.dao;

import bid.model.Todo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a13168 on 2014/04/06.
 */
public enum TodoDao {
    instance;

    private Map<String, Todo> contentProvider = new HashMap<>();

    private TodoDao() {
        Todo todo = new Todo("1", "Learn REST");
        todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Do Something");
        todo.setDescription("Read complete http://www.vogella.com");
        contentProvider.put("2", todo);
        todo = new Todo("3", "Do Something Else");
        todo.setDescription("Read complete http://jersey.com");
        contentProvider.put("3", todo);
    }

    public Map<String, Todo> getModel() {
        return contentProvider;
    }
}

package bid.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by a13168 on 2014/04/06.
 */
@XmlRootElement
public class Todo {
    private String id;
    private String summary;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Todo(){

    }

    public Todo(String id, String summary) {
        this.id = id;
        this.summary = summary;
    }

}

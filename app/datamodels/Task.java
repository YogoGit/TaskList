package datamodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents a task, which can be described as something which needs to be done. Implemented as a datamodel and as such, contains
 * an id and various persistence annotations so that it can work with a persistence strategy such as hibernate.
 *
 * @author afrieze
 *
 */

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private int id;
    private String description;

    /**
     * @return the id of the task
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of this task
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the task's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this task
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

package models;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;

/**
 * A viewmodel of the data associated with a {@link Task}. Meant to transport data between a controller and a view.
 *
 * @author afrieze
 *
 */
public class TaskModel {
    private int id;

    @Constraints.Required(message = "The description is required")
    @MaxLength(value = 256)
    private String description;

    /**
     * @return the positive id of the represented task, or 0 if there is no id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the task.  Note, an id should never be set from a view.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

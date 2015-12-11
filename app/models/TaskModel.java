package app.models;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;

public class TaskModel {
    private int id;

    @Constraints.Required(message = "The description is required")
    @MaxLength(value = 256)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

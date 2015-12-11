package models;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private int id;

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

    @Constraints.Required(message = "The description is required")
    @MaxLength(value = 256)
    private String description;

}

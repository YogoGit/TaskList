import static org.fest.assertions.Assertions.assertThat;

import models.TaskModel;

import java.util.ArrayList;
import java.util.List;

import utils.ModelMapper;
import datamodels.Task;
import org.junit.Test;

public class ModelMapperTest {

    @Test
    public void mapTaskToTaskModel() {
        int expectedId = 1;
        String expectedDescription = "description";
        Task task = new Task();
        task.setId(expectedId);
        task.setDescription(expectedDescription);
        TaskModel result = ModelMapper.modelToViewModel(task);
        assertThat(result.getId()).isEqualTo(expectedId);
        assertThat(result.getDescription()).isEqualTo(expectedDescription);
    }

    @Test
    public void mapTasksToTaskModels() {
        int nbrTasks = 5;
        List<Task> tasks = new ArrayList<Task>();
        for (int i = 1; i <= nbrTasks; i++) {
            Task task = new Task();
            task.setId(i);
            task.setDescription(Integer.toString(i));
            tasks.add(task);
        }
        List<TaskModel> results = ModelMapper.modelsToViewModels(tasks);
        assertThat(results.size()).isEqualTo(nbrTasks);

    }

    @Test
    public void mapTaskModelToTask() {
        int expectedId = 1;
        String expectedDescription = "description";
        TaskModel taskModel = new TaskModel();
        taskModel.setId(expectedId);
        taskModel.setDescription(expectedDescription);
        Task result = ModelMapper.viewModelToModel(taskModel);
        assertThat(result.getId()).isEqualTo(expectedId);
        assertThat(result.getDescription()).isEqualTo(expectedDescription);
    }

    @Test
    public void mapTaskModelsToTasks() {
        int nbrTasks = 5;
        List<TaskModel> taskModels = new ArrayList<TaskModel>();
        for (int i = 1; i <= nbrTasks; i++) {
            TaskModel taskModel = new TaskModel();
            taskModel.setId(i);
            taskModel.setDescription(Integer.toString(i));
            taskModels.add(taskModel);
        }
        List<Task> results = ModelMapper.viewModelsToModels(taskModels);
        assertThat(results.size()).isEqualTo(nbrTasks);
    }

    @Test(expected = NullPointerException.class)
    public void mapNullTaskToTaskModel() {
        ModelMapper.modelToViewModel(null);
    }

    @Test(expected = NullPointerException.class)
    public void mapNullTasksToTaskModels() {
        ModelMapper.modelsToViewModels(null);
    }

    @Test(expected = NullPointerException.class)
    public void mapNullTaskModelToTask() {
        ModelMapper.viewModelToModel(null);
    }

    public void mappNullTaskModelsToTasks() {
        ModelMapper.viewModelsToModels(null);
    }

}

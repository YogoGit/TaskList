package utils;

import models.TaskModel;

import com.google.common.base.Preconditions;
import datamodels.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapping utility for mapping datamodels both to and from their corresponding models for use in views.
 *
 * @author afrieze
 *
 */
public class ModelMapper {

    /**
     * Maps the passed in {@link TaskModel} to a new instance of {@link Task}.
     *
     * @throws NullPointerException if the passed in viewModel is null
     *
     * @param taskModel
     * @return the mapped {@link Task}
     */
    public static Task viewModelToModel(TaskModel taskModel) {
        Preconditions.checkNotNull(taskModel);
        Task mappedTask = new Task();
        mappedTask.setDescription(taskModel.getDescription());
        mappedTask.setId(taskModel.getId());
        return mappedTask;
    }

    /**
     * Maps a list of {@link TaskModel taskModels} to a new list of {@link Task tasks}.
     *
     * @throws NullPointerException if the passed in taskModels parameter is null.
     *
     * @param taskModels
     * @return the mapped list of {@link Task tasks}
     */
    public static List<Task> viewModelsToModels(List<TaskModel> taskModels) {
        Preconditions.checkNotNull(taskModels);
        List<Task> tasks = new ArrayList<Task>();
        for (TaskModel viewModel : taskModels) {
            tasks.add(viewModelToModel(viewModel));
        }
        return tasks;
    }

    /**
     * Maps the passed in {@link Task} to a new instance of {@link TaskModel}
     *
     * @throws NullPointerException if the passed in task is null.
     *
     * @param model
     * @return the mapped {@link TaskModel}
     */
    public static TaskModel modelToViewModel(Task model) {
        Preconditions.checkNotNull(model);
        TaskModel taskModel = new TaskModel();
        taskModel.setDescription(model.getDescription());
        taskModel.setId(model.getId());
        return taskModel;
    }

    /**
     * Maps a list of {@link Task tasks} to a new list of {@link TaskModel taskModels}.
     *
     * @throws NullPointerException if the passed in taskModels parameter is null.
     *
     * @param taskModels
     * @return the mapped list of {@link TaskModel taskModels}
     */
    public static List<TaskModel> modelsToViewModels(List<Task> tasks) {
        Preconditions.checkNotNull(tasks);
        List<TaskModel> viewModels = new ArrayList<TaskModel>();
        for (Task model : tasks) {
            viewModels.add(modelToViewModel(model));
        }
        return viewModels;
    }
}

package com.sofi.tasklist.controllers.utils;

import com.sofi.tasklist.viewmodels.TaskModel;

import models.Task;

import scala.tools.jline_embedded.internal.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author afrieze
 *
 */
public class ModelMapper {

    public static Task viewModelToModel(TaskModel viewModel) {
        Preconditions.checkNotNull(viewModel);
        Task mappedTask = new Task();
        mappedTask.setDescription(viewModel.getDescription());
        mappedTask.setId(viewModel.getId());
        return mappedTask;
    }

    public static  List<Task> viewModelsToModels(List<TaskModel> viewModels) {
        Preconditions.checkNotNull(viewModels);
        List<Task> tasks = new ArrayList<Task>();
        for (TaskModel viewModel : viewModels) {
            tasks.add(viewModelToModel(viewModel));
        }
        return tasks;
    }

    public static  TaskModel modelToViewModel(Task model) {
        Preconditions.checkNotNull(model);
        TaskModel taskModel = new TaskModel();
        taskModel.setDescription(model.getDescription());
        taskModel.setId(model.getId());
        return taskModel;
    }

    public static  List<TaskModel> modelsToViewModels(List<Task> models) {
        Preconditions.checkNotNull(models);
        List<TaskModel> viewModels = new ArrayList<TaskModel>();
        for (Task model : models) {
            viewModels.add(modelToViewModel(model));
        }
        return viewModels;
    }
}

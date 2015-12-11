package controllers;

import models.TaskModel;

import services.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import views.html.index;

import datamodels.Task;

import utils.ModelMapper;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

/**
 * Controller which handles all interactions between the views and models as defined in the mvc design pattern. Datamodels are
 * retrieved through injected services and are mapped to models consumable by views.
 *
 * @author afrieze
 *
 */
@org.springframework.stereotype.Controller
public class Application {

    @Autowired
    private TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * @return a {@link Result} representing this applications index page
     */
    public Result index() {
        logger.trace("Application | index");
        return play.mvc.Controller.ok(index.render(Form.form(TaskModel.class)));
    }

    /**
     * Attempts to add a {@link Task task} through the {@link TaskService}. The added task is mapped from the {@link TaskModel}
     * bound from the request. If a valid taskModel cannot be retrieved from the request, a badRequest response is returned. If
     * successful, an ok response is returned.
     *
     * @return - a {@link Result}, either {@link play.mvc.Http.Status#BAD_REQUEST BAD_REQUEST} or {@link play.mvc.Http.Status#OK
     *         OK}.
     */
    public Result addTask() {
        logger.trace("Application | addTask");
        Form<TaskModel> form = Form.form(TaskModel.class).bindFromRequest();
        if (form.hasErrors()) {
            return play.mvc.Controller.badRequest(index.render(form));
        }
        TaskModel task = form.get();
        taskService.addTask(ModelMapper.viewModelToModel(task));
        return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }

    /**
     * @return a {@link Result} with the {@link TaskModel tasks} retrieved from the {@link TaskService taskService's} {@link TaskService#getAllTasks()} method.
     */
    public Result listTasks() {
        logger.trace("Application | listTasks");
        return play.mvc.Controller.ok(Json.toJson(ModelMapper.modelsToViewModels(taskService.getAllTasks())));
    }

}

package controllers;

//import com.sofi.tasklist.controllers.utils.ModelMapper;
//import com.sofi.tasklist.viewmodels.TaskModel;

import models.Task;
import models.TaskModel;
import services.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import views.html.index;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

@org.springframework.stereotype.Controller
public class Application {

    @Autowired
    private TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public Result index() {
        logger.trace("Application | index");
        return play.mvc.Controller.ok(index.render(Form.form(TaskModel.class)));
    }

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

    public Result listTasks() {
        logger.trace("Application | listTasks");
        return play.mvc.Controller.ok(Json.toJson(ModelMapper.modelsToViewModels(taskService.getAllTasks())));
    }

}

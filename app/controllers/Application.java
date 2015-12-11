package controllers;

import models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.TaskService;
import views.html.index;
import views.html.defaultpages.badRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Controller
public class Application {

    @Autowired
    private TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public Result index() {
        logger.trace("Application | index");
        return play.mvc.Controller.ok(index.render(Form.form(Task.class)));
    }

    public Result addTask() {
        logger.trace("Application | addTask");
        Form<Task> form = Form.form(Task.class).bindFromRequest();
        if (form.hasErrors()) {
            return play.mvc.Controller.badRequest(index.render(form));
        }
        Task task = form.get();
        taskService.addTask(task);
        return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }

    public Result listTasks() {
        logger.trace("Application | listTasks");
        return play.mvc.Controller.ok(Json.toJson(taskService.getAllTasks()));
    }

}

import configs.AppConfig;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import services.TaskService;

import datamodels.Task;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

@ContextConfiguration(classes = {
    AppConfig.class, TestDataConfig.class
})
public class TaskServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private TaskService taskService;

    @Test
    public void createTask() {
        Task task = new Task();
        task.setDescription("foo");
        taskService.addTask(task);
        assertThat(task.getId()).isNotNull();
    }

    @Test
    public void getTasks() {
        createTask();
        List<Task> tasks = taskService.getAllTasks();
        assertThat(tasks.size()).isEqualTo(1);
    }

}

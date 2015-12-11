import configs.AppConfig;
import models.Task;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration(classes = {
    AppConfig.class, TestDataConfig.class
})
public class TaskTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void setTaskDescription() {
        Task task = new Task();
        task.setDescription("foo");
        assertThat(task.getDescription()).isEqualTo("foo");
    }

}

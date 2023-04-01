package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class TaskService {

    private Map<Integer, Task> taskMap;
    private Collection<Task> removedTasks = new ArrayList<>();

    public TaskService(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void addTask(Task task) {
        this.taskMap.put(task.getId(), task);
    }

    public Collection<Task> getRemovedTasks() {
        return removedTasks;
    }

    public Task remove(int id) {
        removedTasks.add(this.taskMap.get(id));
        this.taskMap.remove(id);
        return this.taskMap.get(id);
    }

    public Task getTaskById(int id) {
        return this.taskMap.get(id);
    }

    public Task updateTitle(int id, String title) {
        this.taskMap.get(id).setTitle(title);
        return this.taskMap.get(id);
    }

    public Task updateDescription(int id, String content) {
        this.taskMap.get(id).setContent(content);
        return this.taskMap.get(id);
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        Collection<Task> tasks = new ArrayList<>();
        for (Map.Entry<Integer, Task> task : this.taskMap.entrySet()) {
            if (task.getValue().getDateTime().equals(localDate)) {
                tasks.add(task.getValue());
            }
        }
        return tasks;
    }
}

package task.tasks;

import task.Task;
import task.Type;

import java.time.LocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String content, Type type) {
        super(title, content, type);
    }

    public LocalDate getDateOfNextRun(LocalDate localDate) {
        return this.getLocalDate();
    }

    public String toString() {
        return super.toString() + "Частота повторения = единоразово" + "\n";
    }
}

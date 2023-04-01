package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Task {
    private String title;
    private String content;
    private Type type;
    private static int idGenerator = 1;
    private final int id;
    private LocalDate localDate;
    private LocalTime localTime;

    public Task(String title, String content, Type type) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.id = idGenerator;
        this.localDate = LocalDate.now();
        this.localTime = LocalTime.now();
        idGenerator++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateTime() {
        return localDate;
    }

    public abstract LocalDate getDateOfNextRun();

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    @Override
    public String toString() {
        return "\n" + "Задача: " +
                title + '\n' +
                "Цель = " + content + '\n' +
                "Тип = " + type.getType() + "\n" +
                "Номер задачи = " + id + "\n" +
                "Дата создания = " + localDate + "\n" +
                "Время создания = " + localTime + "\n";
    }
}

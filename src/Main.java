import task.TaskService;
import task.Task;
import task.Type;
import task.tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Task> taskMap = new HashMap<>();
        TaskService taskService = new TaskService(taskMap);
        int startNum = 0;
        while (startNum != 8) {
            printMenu();
            switch (startNum = scanner.nextInt()) {
                case 1:
                    int doStuff = 1;
                    do {
                        System.out.println("Введите название задачи:");
                        String title = scanner.next();
                        System.out.println("Задача:");
                        String content = scanner.next();
                        System.out.println("Выберите тип задачи: \n 1 - Личная \n 2 - Рабочая");
                        int typeNum = scanner.nextInt();
                        Type type = (typeNum == 1 ? Type.PERSONAL : Type.WORK);
                        printMenu2();
                        taskService.addTask(choseTypeOfTask(scanner.nextInt(), title, content, type));
                        System.out.println("Выберите действие: \n 1 - Добавить новую задачу \n 2 - Вернуться в меню");
                        doStuff = scanner.nextInt();
                    } while (doStuff == 1);
                    break;
                case 2:
                    System.out.println(taskService.getAllByDate(LocalDate.now()));
                    break;
                case 3:
                    System.out.println("Список задач на завтрашний день: ");
                    for (Map.Entry<Integer, Task> tasks : taskService.getTaskMap().entrySet()) {
                        if (tasks.getValue().getDateOfNextRun().equals(LocalDate.now().plusDays(1))) {
                            System.out.println(tasks.getValue());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите номер задачи: ");
                    int taskIdForNextDayRun = scanner.nextInt();
                    System.out.println("Дата следующего выплнения задачи: ");
                    System.out.println(taskService.getTaskById(taskIdForNextDayRun).getDateOfNextRun());
                    break;
                case 5:
                    System.out.println("Введите номер задачи, которую хотели бы изменить: ");
                    int taskIdForChange = scanner.nextInt();
                    System.out.println("Что бы вы хотели изменить?: \n 1 - заголовок \n 2 - содержание");
                    int changeActionNum = scanner.nextInt();
                    if (changeActionNum == 1) {
                        System.out.println("Введите новый заголовок: ");
                        String newTitle = scanner.next();
                        taskService.updateTitle(taskIdForChange, newTitle);
                    } else if (changeActionNum == 2) {
                        System.out.println("Введите новое содержание: ");
                        String newContent = scanner.next();
                        taskService.updateDescription(taskIdForChange, newContent);
                    }
                    System.out.println("Изменения внесены");
                    break;
                case 6:
                    System.out.println("Введите номер задачи, которую хотите удалить:");
                    int id = scanner.nextInt();
                    taskService.remove(id);
                    System.out.println("Задача № " + id + " удалена");
                    break;
                case 7:
                    System.out.println(taskService.getRemovedTasks());
                case 8:
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("Выберете что вы хотите сделать:");
        System.out.println("1 - добавить задачи");
        System.out.println("2 - посмотреть весь список задач");
        System.out.println("3 - получить список задач на предстоящий день");
        System.out.println("4 - узнать дату следующего исполнения задачи по номеру");
        System.out.println("5 - редактировать задачу");
        System.out.println("6 - удалить задачу по ее номеру");
        System.out.println("7 - получить список удаленных задач");;
        System.out.println("8 - выход");
    }

    public static void printMenu2() {
        System.out.println("Выберете интервал повторения задачи: ");
        System.out.println("1 - единожды");
        System.out.println("2 - ежедневно");
        System.out.println("3 - еженедельно");
        System.out.println("4 - ежемесячно");
        System.out.println("5 - ежегодно");
    }


    public static Task choseTypeOfTask(int num, String title, String content, Type type) {
        switch (num) {
            case 1:
                return new OneTimeTask(title, content, type);
            case 2:
                return new DailyTask(title, content, type);
            case 3:
                return new WeeklyTask(title, content, type);
            case 4:
                return new MonthlyTask(title, content, type);
            case 5:
                return new YearlyTask(title, content, type);
        }
        return null;
    }
}
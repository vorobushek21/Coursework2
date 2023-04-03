package task.tasks;

import task.Task;
import task.Type;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DailyTask extends Task {
    public DailyTask(String title, String content, Type type) {
        super(title, content, type);
    }

    @Override
    public LocalDate getDateOfNextRun(LocalDate localDate) {
        LocalDate day1 = this.getLocalDate();
        LocalDate day2 = localDate.plusDays(1);
        ArrayList<LocalDate> dateList = day1.datesUntil(day2, Period.ofDays(1)).collect(Collectors.toCollection(ArrayList::new));
        LocalDate day3 = day1.plusDays(dateList.toArray().length);
        return day3;
    }

    @Override
    public String toString() {
        return super.toString() + "Частота повторения = ежедневно" + "\n";
    }
}

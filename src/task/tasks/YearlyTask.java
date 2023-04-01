package task.tasks;

import task.Task;
import task.Type;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class YearlyTask extends Task {
    public YearlyTask(String title, String content, Type type) {
        super(title, content, type);
    }

    public LocalDate getDateOfNextRun() {
        LocalDate day1 = this.getLocalDate();
        LocalDate day2 = LocalDate.now().plusDays(1);
        ArrayList<LocalDate> dateList = day1.datesUntil(day2, Period.ofYears(1)).collect(Collectors.toCollection(ArrayList::new));
        LocalDate day3 = day1.plusYears(dateList.toArray().length);
        return day3;
    }

    public String toString() {
        return super.toString() + "Частота повторения = ежегодно" + "\n";
    }
}

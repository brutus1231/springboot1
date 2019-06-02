package pl.sda.springboot1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class WorkDayCalculator {

    @Value("${name}")
    private String name;

    @Value("${spring.profile}")
    private String yml1;

    @Value("${spring.version}")
    private String yml2;

    public boolean check(Date date) {

        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (dayOfWeek.equals(DayOfWeek.SATURDAY) ||
                dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return false;
        }
        return true;
    }

    public void print() {
        System.out.println("name: " + name);
        System.out.println("yml1: " + yml1);
        System.out.println("yml2: " + yml2);
    }
}

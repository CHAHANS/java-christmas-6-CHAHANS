package christmas.domain.decemberEvent;

import java.time.LocalDate;

public enum SpecialEvenDayEnum {
    DAY1(3),
    DAY2(10),
    DAY3(17),
    DAY4(24),
    DAY5(25),
    DAY6(31);

    private LocalDate eventDay;

    SpecialEvenDayEnum(int date) {
        this.eventDay = LocalDate.of(2023,12,date);
    }

    public LocalDate getEventDay() {
        return eventDay;
    }
}

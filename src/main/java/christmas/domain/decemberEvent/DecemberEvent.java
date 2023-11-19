package christmas.domain.decemberEvent;

import java.time.LocalDate;

public enum DecemberEvent {
    D_DAY_EVENT("크리스마스 디데이 할인", 1000, 1, 25),
    WEEKDAY_EVENT("평일 할인", 2023, 1, 31),
    WEEKEND_EVENT("주말 할인", 2023, 1, 31),
    SPECIAL_EVENT("특별 할인", 1000, 1, 31),
    GIFT_EVENT("증정 이벤트",25000, 1, 31),
    BADGE_EVENT("12월 이벤트 배지",0,1,31);
    private String koreanName;
    private int initBenefit;
    private LocalDate startDate;
    private LocalDate endDate;

    DecemberEvent(String koreanName, int discountBenefit, int startDay, int endDay) {
        this.koreanName = koreanName;
        this.initBenefit = discountBenefit;
        this.startDate = LocalDate.of(2023, 12, startDay);
        this.endDate = LocalDate.of(2023, 12, endDay);
    }

    public String getKoreanName() {
        return koreanName;
    }

    public int getInitBenefit() {
        return initBenefit;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}

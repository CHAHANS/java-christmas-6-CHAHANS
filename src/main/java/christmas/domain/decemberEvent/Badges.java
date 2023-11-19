package christmas.domain.decemberEvent;

public enum Badges {
    STAR("별",5000),
    TREE("트리",10000),
    SANTA("산타",20000);

    private String koreanBadgeName;
    private int benefitCondition;

    Badges(String koreanBadgeName, int benefitCondition) {
        this.koreanBadgeName = koreanBadgeName;
        this.benefitCondition = benefitCondition;
    }

    public int getBenefitCondition() {
        return benefitCondition;
    }

    public String getKoreanBadgeName() {
        return koreanBadgeName;
    }
}

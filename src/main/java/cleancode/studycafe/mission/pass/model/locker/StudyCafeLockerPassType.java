package cleancode.studycafe.mission.pass.model.locker;

public enum StudyCafeLockerPassType {

    USE("사용"),
    NOT_USE("미사용");

    private final String description;

    StudyCafeLockerPassType(String description) {
        this.description = description;
    }

    public boolean isUse() {
        return this == USE;
    }

    public boolean isNotUse() {
        return !isUse();
    }

}

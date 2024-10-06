package cleancode.studycafe.mission.pass.model.locker;

import java.util.List;

import cleancode.studycafe.mission.pass.model.pass.StudyCafePass;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> passes;

    private StudyCafeLockerPasses(List<StudyCafeLockerPass> passes) {
        this.passes = passes;
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> passes) {
        return new StudyCafeLockerPasses(passes);
    }

    public StudyCafeLockerPass getSameTypePasses(StudyCafePass selectedPass) {
        return passes.stream()
                     .filter(option -> option.isSamePassTypeAndDuration(selectedPass.getPassType(), selectedPass.getDuration()))
                     .findFirst()
                     .orElse(null);
    }

}

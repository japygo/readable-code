package cleancode.studycafe.mission.pass.model.pass;

import java.util.Iterator;
import java.util.List;

public class StudyCafePasses implements Iterable<StudyCafePass> {

    private final List<StudyCafePass> passes;

    private StudyCafePasses(List<StudyCafePass> passes) {
        this.passes = passes;
    }

    public static StudyCafePasses of(List<StudyCafePass> passes) {
        return new StudyCafePasses(passes);
    }

    public StudyCafePasses getSameTypePasses(StudyCafePassType type) {
        return StudyCafePasses.of(
            passes.stream()
                  .filter(studyCafePass -> studyCafePass.isSamePassType(type))
                  .toList()
        );
    }

    public StudyCafePass get(int index) {
        return passes.get(index);
    }

    @Override
    public Iterator<StudyCafePass> iterator() {
        return passes.iterator();
    }

}

package cleancode.studycafe.mission.pass.io;

import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPasses;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePasses;

public interface FileHandler {

    StudyCafePasses readStudyCafePasses();

    StudyCafeLockerPasses readLockerPasses();

}

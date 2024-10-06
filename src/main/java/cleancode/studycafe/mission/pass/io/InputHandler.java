package cleancode.studycafe.mission.pass.io;

import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPassType;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePass;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePasses;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(StudyCafePasses passes);

    StudyCafeLockerPassType getLockerPassTypeSelectingUserAction();

}

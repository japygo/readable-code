package cleancode.studycafe.mission.pass.io;

import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePass;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePasses;

public interface OutputHandler {

    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(StudyCafePasses passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

    void showSimpleMessage(String message);

}

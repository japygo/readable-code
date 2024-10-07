package cleancode.studycafe.mission.pass;

import cleancode.studycafe.mission.machine.MachineRunnable;
import cleancode.studycafe.mission.pass.config.PassMachineConfig;
import cleancode.studycafe.mission.pass.exception.PassMachineException;
import cleancode.studycafe.mission.pass.io.FileHandler;
import cleancode.studycafe.mission.pass.io.InputHandler;
import cleancode.studycafe.mission.pass.io.OutputHandler;
import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPassType;
import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPasses;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePass;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePasses;

public class StudyCafePassMachine implements MachineRunnable {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final FileHandler fileHandler;

    public StudyCafePassMachine(PassMachineConfig config) {
        this.inputHandler = config.getInputHandler();
        this.outputHandler = config.getOutputHandler();
        this.fileHandler = config.getFileHandler();
    }

    @Override
    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            StudyCafePassType passType = getPassType();
            StudyCafePasses passes = getPassesBy(passType);
            StudyCafePass selectedPass = getSelectedPassBy(passes);

            StudyCafeLockerPass lockerPass = null;
            if (passType.isFixed()) {
                lockerPass = getLockerPassBy(selectedPass);
                if (lockerPass != null) {
                    StudyCafeLockerPassType lockerPassType = getLockerPassType(lockerPass);
                    if (lockerPassType.isNotUse()) {
                        lockerPass = null;
                    }
                }
            }
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (PassMachineException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePassType getPassType() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePasses getPassesBy(StudyCafePassType type) {
        StudyCafePasses studyCafePasses = fileHandler.readStudyCafePasses();
        return studyCafePasses.getSameTypePasses(type);
    }

    private StudyCafePass getSelectedPassBy(StudyCafePasses studyCafePasses) {
        outputHandler.showPassListForSelection(studyCafePasses);
        return inputHandler.getSelectPass(studyCafePasses);
    }

    private StudyCafeLockerPass getLockerPassBy(StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = fileHandler.readLockerPasses();
        return lockerPasses.getSameTypePasses(selectedPass);
    }

    private StudyCafeLockerPassType getLockerPassType(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerPassTypeSelectingUserAction();
    }

}

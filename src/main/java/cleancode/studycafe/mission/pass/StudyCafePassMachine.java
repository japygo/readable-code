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

            StudyCafePassType studyCafePassType = getStudyCafePassType();
            StudyCafePasses studyCafePasses = getStudyCafePassesBy(studyCafePassType);
            StudyCafePass selectedPass = getSelectedPass(studyCafePasses);

            StudyCafeLockerPass lockerPass = null;
            if (studyCafePassType.isFixed()) {
                lockerPass = getStudyCafeLockerPass(selectedPass);
                if (lockerPass != null) {
                    outputHandler.askLockerPass(lockerPass);
                    StudyCafeLockerPassType lockerPassType = inputHandler.getLockerPassTypeSelectingUserAction();
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

    private StudyCafePassType getStudyCafePassType() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePasses getStudyCafePassesBy(StudyCafePassType type) {
        StudyCafePasses studyCafePasses = fileHandler.readStudyCafePasses();
        return studyCafePasses.getSameTypePasses(type);
    }

    private StudyCafePass getSelectedPass(StudyCafePasses studyCafePasses) {
        outputHandler.showPassListForSelection(studyCafePasses);
        return inputHandler.getSelectPass(studyCafePasses);
    }

    private StudyCafeLockerPass getStudyCafeLockerPass(StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = fileHandler.readLockerPasses();
        return lockerPasses.getSameTypePasses(selectedPass);
    }

}

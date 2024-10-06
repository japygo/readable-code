package cleancode.studycafe.mission.pass.io;

import java.util.Scanner;

import cleancode.studycafe.mission.pass.exception.PassMachineException;
import cleancode.studycafe.mission.pass.model.locker.StudyCafeLockerPassType;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePass;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.pass.model.pass.StudyCafePasses;

public class ConsoleInputHandler implements InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        if ("1".equals(userInput)) {
            return StudyCafePassType.HOURLY;
        }
        if ("2".equals(userInput)) {
            return StudyCafePassType.WEEKLY;
        }
        if ("3".equals(userInput)) {
            return StudyCafePassType.FIXED;
        }
        throw new PassMachineException("잘못된 입력입니다.");
    }

    @Override
    public StudyCafePass getSelectPass(StudyCafePasses passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }

    @Override
    public StudyCafeLockerPassType getLockerPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        if ("1".equals(userInput)) {
            return StudyCafeLockerPassType.USE;
        }
        if ("2".equals(userInput)) {
            return StudyCafeLockerPassType.NOT_USE;
        }
        throw new PassMachineException("잘못된 입력입니다.");
    }

}

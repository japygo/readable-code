package cleancode.studycafe.mission;

import cleancode.studycafe.mission.pass.StudyCafePassMachine;
import cleancode.studycafe.mission.pass.config.PassMachineConfig;
import cleancode.studycafe.mission.pass.io.ConsoleInputHandler;
import cleancode.studycafe.mission.pass.io.ConsoleOutputHandler;
import cleancode.studycafe.mission.pass.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        PassMachineConfig config = PassMachineConfig.of(
            new ConsoleInputHandler(),
            new ConsoleOutputHandler(),
            new StudyCafeFileHandler()
        );

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(config);
        studyCafePassMachine.run();
    }

}

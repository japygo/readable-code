package cleancode.studycafe.mission.pass.config;

import cleancode.studycafe.mission.pass.io.FileHandler;
import cleancode.studycafe.mission.pass.io.InputHandler;
import cleancode.studycafe.mission.pass.io.OutputHandler;

public class PassMachineConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final FileHandler fileHandler;

    private PassMachineConfig(InputHandler inputHandler, OutputHandler outputHandler, FileHandler fileHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.fileHandler = fileHandler;
    }

    public static PassMachineConfig of(InputHandler inputHandler, OutputHandler outputHandler, FileHandler fileHandler) {
        return new PassMachineConfig(inputHandler, outputHandler, fileHandler);
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

}

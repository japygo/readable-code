package cleancode.studycafe.mission.pass.model;

import cleancode.studycafe.mission.pass.model.pass.StudyCafePassType;

public interface StudyCafeBasePass {

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

}

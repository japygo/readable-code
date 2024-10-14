package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;

class StudyCafeLockerPassesTest {

    @DisplayName("같은 이용권 종류와 같은 기간인 사물함 이용권 리스트를 찾는다.")
    @Test
    void findLockerPassBy() {
        // given
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(List.of(
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 100),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 100)
        ));

        // when
        Optional<StudyCafeLockerPass> actual =
            lockerPasses.findLockerPassBy(StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1));

        // then
        assertThat(actual).isPresent();
    }

}

package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;

class StudyCafeLockerPassTest {

    @DisplayName("같은 사물함 이용권 종류인지 확인하여 같으면 참이다.")
    @Test
    void isSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 100);

        // when
        boolean actual = lockerPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("같은 사물함 이용권 기간인지 확인하여 같으면 참이다.")
    @Test
    void isSameDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 100);

        // when
        boolean actual = lockerPass.isSameDuration(1);

        // then
        assertThat(actual).isTrue();
    }

}

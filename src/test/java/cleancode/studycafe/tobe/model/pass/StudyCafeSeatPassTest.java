package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

class StudyCafeSeatPassTest {

    @DisplayName("카페 이용권이 1인 고정석일 경우 사물함을 이용할 수 있다.")
    @Test
    void cannotUseLockerFixed() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1);

        // when
        boolean actual = seatPass.cannotUseLocker();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("카페 이용권이 시간 단위 이용권일 경우 사물함을 이용할 수 있다.")
    @Test
    void cannotUseLockerHourly() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 1, 100, 0.1);

        // when
        boolean actual = seatPass.cannotUseLocker();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("카페 이용권이 주 단위 이용권일 경우 사물함을 이용할 수 있다.")
    @Test
    void cannotUseLockerWeekly() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 100, 0.1);

        // when
        boolean actual = seatPass.cannotUseLocker();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("같은 기간, 같은 이용권 종류인지 확인하여 같으면 참이다.")
    @Test
    void isSameDurationType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 100);

        // when
        boolean actual = seatPass.isSameDurationType(lockerPass);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("같은 이용권 종류인지 확인하여 같으면 참이다.")
    @Test
    void isSamePassType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1);

        // when
        boolean actual = seatPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("할인 가격을 가져온다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1);

        // when
        int actual = seatPass.getDiscountPrice();

        // then
        assertThat(actual).isEqualTo(10);
    }

}

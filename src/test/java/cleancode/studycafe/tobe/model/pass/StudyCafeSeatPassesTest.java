package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassesTest {

    @DisplayName("같은 이용권 종류인 이용권 리스트를 찾는다.")
    @Test
    void findPassBy() {
        // given
        StudyCafeSeatPasses seatPasses = StudyCafeSeatPasses.of(List.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 200, 0.2),
            StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 3, 300, 0.3),
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 400, 0.4)
        ));

        // when
        List<StudyCafeSeatPass> actual = seatPasses.findPassBy(StudyCafePassType.FIXED);

        // then
        assertThat(actual).hasSize(2)
            .extracting("passType", "duration", "price", "discountRate")
            .containsExactlyInAnyOrder(
                tuple(StudyCafePassType.FIXED, 1, 100, 0.1),
                tuple(StudyCafePassType.FIXED, 4, 400, 0.4)
            );
    }

}

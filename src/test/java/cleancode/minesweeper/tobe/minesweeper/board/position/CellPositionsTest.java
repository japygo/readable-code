package cleancode.minesweeper.tobe.minesweeper.board.position;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellPositionsTest {

    @DisplayName("개수만큼 셀 포지션 리스트를 가져온다.")
    @Test
    void extractRandomPositions() {
        // given
        List<CellPosition> cellPositionList = List.of(
            CellPosition.of(0, 0),
            CellPosition.of(0, 1),
            CellPosition.of(1, 0),
            CellPosition.of(1, 1)
        );

        CellPositions cellPositions = CellPositions.of(cellPositionList);

        // when
        List<CellPosition> actual = cellPositions.extractRandomPositions(2);

        // then
        assertThat(actual).hasSize(2);
    }

    @DisplayName("제외할 셀 포지션 리스트를 제외한 후 셀 포지션 리스트를 가져온다.")
    @Test
    void subtract() {
        // given
        List<CellPosition> cellPositionList = List.of(
            CellPosition.of(0, 0),
            CellPosition.of(0, 1),
            CellPosition.of(1, 0),
            CellPosition.of(1, 1)
        );

        CellPositions cellPositions = CellPositions.of(cellPositionList);

        // when
        List<CellPosition> actual = cellPositions.subtract(List.of(
            CellPosition.of(0, 0),
            CellPosition.of(1, 0)
        ));

        // then
        assertThat(actual).hasSize(2)
            .extracting("rowIndex", "colIndex")
            .containsExactlyInAnyOrder(
                tuple(0, 1),
                tuple(1, 1)
            );
    }

}

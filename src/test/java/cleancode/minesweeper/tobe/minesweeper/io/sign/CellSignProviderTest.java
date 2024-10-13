package cleancode.minesweeper.tobe.minesweeper.io.sign;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;

class CellSignProviderTest {

    @DisplayName("빈 셀 스냅샷일 경우 빈 셀 표시를 가져온다.")
    @Test
    void findEmptyCellSign() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofEmpty();

        // when
        String actual = CellSignProvider.findCellSignFrom(cellSnapshot);

        // then
        assertThat(actual).isEqualTo("■");
    }

    @DisplayName("깃발 셀 스냅샷일 경우 깃발 셀 표시를 가져온다.")
    @Test
    void findFlagCellSign() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofFlag();

        // when
        String actual = CellSignProvider.findCellSignFrom(cellSnapshot);

        // then
        assertThat(actual).isEqualTo("⚑");
    }

    @DisplayName("지뢰 셀 스냅샷일 경우 지뢰 셀 표시를 가져온다.")
    @Test
    void findLandMineCellSign() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofLandMine();

        // when
        String actual = CellSignProvider.findCellSignFrom(cellSnapshot);

        // then
        assertThat(actual).isEqualTo("☼");
    }

    @DisplayName("확인 전 셀 스냅샷일 경우 확인 전 셀 표시를 가져온다.")
    @Test
    void findUncheckedCellSign() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofUnchecked();

        // when
        String actual = CellSignProvider.findCellSignFrom(cellSnapshot);

        // then
        assertThat(actual).isEqualTo("□");
    }

}

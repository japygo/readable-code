package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellSnapshotTest {

    @DisplayName("빈 셀 스냅샷을 생성하면 빈 셀 스냅샷 상태이다.")
    @Test
    void createEmptyCellSnapshot() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofEmpty();

        // when
        boolean actual = cellSnapshot.isSameStatus(CellSnapshotStatus.EMPTY);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("깃발 셀 스냅샷을 생성하면 깃발 셀 스냅샷 상태이다.")
    @Test
    void createFlagCellSnapshot() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofFlag();

        // when
        boolean actual = cellSnapshot.isSameStatus(CellSnapshotStatus.FLAG);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("지뢰 셀 스냅샷을 생성하면 지뢰 셀 스냅샷 상태이다.")
    @Test
    void createLandMineCellSnapshot() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofLandMine();

        // when
        boolean actual = cellSnapshot.isSameStatus(CellSnapshotStatus.LAND_MINE);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("숫자 셀 스냅샷을 생성하면 숫자 셀 스냅샷 상태이다.")
    @Test
    void createNumberCellSnapshot() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofNumber(1);

        // when
        boolean actual = cellSnapshot.isSameStatus(CellSnapshotStatus.NUMBER);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("확인 전 셀 스냅샷을 생성하면 확인 전 셀 스냅샷 상태이다.")
    @Test
    void createUncheckedCellSnapshot() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofUnchecked();

        // when
        boolean actual = cellSnapshot.isSameStatus(CellSnapshotStatus.UNCHECKED);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("숫자 셀 스냅샷을 생성하면 근처 지뢰 수를 가진다.")
    @Test
    void numberCellSnapshotNearbyLandMineCount() {
        // given
        CellSnapshot cellSnapshot = CellSnapshot.ofNumber(1);

        // when
        int actual = cellSnapshot.getNearbyLandMineCount();

        // then
        assertThat(actual).isEqualTo(1);
    }

}

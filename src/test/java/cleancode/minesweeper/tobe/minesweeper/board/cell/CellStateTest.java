package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellStateTest {

    @DisplayName("셀 상태를 열 경우 열린 상태이다.")
    @Test
    void cellStatusOpened() {
        // given
        CellState cellState = CellState.initialize();

        // when
        cellState.open();

        // then
        assertThat(cellState.isOpened()).isTrue();
        assertThat(cellState.isFlagged()).isFalse();
    }

    @DisplayName("셀 상태를 깃발 꽂을 경우 깃발 꽂은 상태이다.")
    @Test
    void cellStatusFlagged() {
        // given
        CellState cellState = CellState.initialize();

        // when
        cellState.flag();

        // then
        assertThat(cellState.isOpened()).isFalse();
        assertThat(cellState.isFlagged()).isTrue();
    }

}

package cleancode.minesweeper.tobe.cell;

import java.util.Objects;

public class CellSnapshot {

    private final CellSnapshotStatus status;
    private final int nearbyLandmineCount;

    private CellSnapshot(CellSnapshotStatus status, int nearbyLandmineCount) {
        this.status = status;
        this.nearbyLandmineCount = nearbyLandmineCount;
    }

    public static CellSnapshot of(CellSnapshotStatus status, int nearbyLandmineCount) {
        return new CellSnapshot(status, nearbyLandmineCount);
    }

    public static CellSnapshot ofEmpty() {
        return of(CellSnapshotStatus.EMPTY, 0);
    }

    public static CellSnapshot ofFlag() {
        return of(CellSnapshotStatus.FLAG, 0);
    }

    public static CellSnapshot ofLandMine() {
        return of(CellSnapshotStatus.LAND_MINE, 0);
    }

    public static CellSnapshot ofNumber(int nearbyLandmineCount) {
        return of(CellSnapshotStatus.NUMBER, nearbyLandmineCount);
    }

    public static CellSnapshot ofUnchecked() {
        return of(CellSnapshotStatus.UNCHECKED, 0);
    }

    public CellSnapshotStatus getStatus() {
        return status;
    }

    public int getNearbyLandmineCount() {
        return nearbyLandmineCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellSnapshot snapshot = (CellSnapshot)o;
        return nearbyLandmineCount == snapshot.nearbyLandmineCount && status == snapshot.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, nearbyLandmineCount);
    }

}

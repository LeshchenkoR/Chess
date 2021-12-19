package Praktikum_M8.Chess;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column)) {
            if (line == toLine || column == toColumn) return false;
            if ((toLine - line == 2 && ((toColumn - column == 1) || toColumn - column == -1)) ||
                    (toLine - line == -2 && ((toColumn - column == 1) || toColumn - column == -1)) ||
                    (toLine - line == 1 && ((toColumn - column == 2) || toColumn - column == -2)) ||
                    (toLine - line == -1 && ((toColumn - column == 2) || toColumn - column == -2))) {
                return true;
            } else return false;
        } else return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}

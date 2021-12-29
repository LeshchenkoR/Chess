package Praktikum_M8.Chess;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //все координаты существуют
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column) &&
                // и в этой клетке есть фигура
                chessBoard.board[line][column] != null) {
            // идем прямо, не бъем фигуры
            if (column == toColumn) {
                int dir; // направление движения
                int start;
                if (color.equals("White")) { // для белых фигур
                    dir = 1;
                    start = 1;
                } else { // для черных фигур
                    dir = -1;
                    start = 6;
                }
                // проверяем, можно ли сходить на конечную клетку
                if (line + dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if (line == start && line + 2 * dir == toLine) {
                    // если конечная клетка свободна и на пути нет фигур, вернется true
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][toColumn] == null;
                }
            }
        } else { // если будем бить
            if ((column - toColumn == 1 || column - toColumn == -1) &&
                    (line - toLine == 1 || line - toLine == -1)){
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }else return false;
        }
        return false;
    }
}

package Praktikum_M8.Chess;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column)) {
            //ход по вертикали
            if (column == toColumn) {
                for (int i = getMin(line, toLine); i < getMax(line, toLine); i++) {
                    //если очередная клетка по вертикали занята
                    if (chessBoard.board[i][column] != null) {
                        //нельзя ходить в свою клетку
                        if (chessBoard.board[i][column] == this && i == getMax(line, toLine)) return false;
                            //нельзя бить свои фигуры
                        else if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return false;
                        // чужие фигуры можно бить
                        if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return true;
                    }
                }
                // если на конечной клетке стоит фигура
                if (chessBoard.board[toLine][column] != null) {
                    //свои фигуры не бьем
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this)
                        return false;
                        // если на конечной чужая фигура и конечная клетка не равна начальной
                    else
                        return !chessBoard.board[toLine][column].getColor().equals(this.color) & chessBoard.board[toLine][column] != this;
                } else return true;
                //ход по горизонтали
            } else if (line == toLine) {
                for (int i = getMin(column, toColumn); i < getMax(column, toColumn); i++){
                    if (chessBoard.board[line][i] != null){
                        if (chessBoard.board[line][i] == this && i == getMax(column, toColumn)) return false;
                        else if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return false;
                        if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return true;
                    }
                }
                if (chessBoard.board[toLine][toColumn] != null) {
                    //свои фигуры не бьем
                    if (chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this)
                        return false;
                        // если на конечной чужая фигура и конечная клетка не равна начальной
                    else
                        return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) & chessBoard.board[toLine][toColumn] != this;
                } else return true;
            }else return false;
        }else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

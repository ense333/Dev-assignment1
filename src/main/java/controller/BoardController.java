package controller;

import storage.Board;

import java.util.HashMap;
import java.util.Map;

public class BoardController {

    private final Map<Long, Board> boards = new HashMap<>();
    private static long boardId = 1;

    public void addBoard(String boardName, String description) {
        Board board = new Board(boardName, description, boardId);
        boards.put(boardId++, board);
    }

    public void editBoard(long id, String boardName, String description) {
        Board board = getBoard(id);
        board.editBoard(boardName, description);
    }

    public Board getBoard(long id) {
        return boards.get(id);
    }

}

package controller;

import storage.Board;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class BoardController {

    private final Map<Long, Board> boards = new HashMap<>();
    private static long boardId = 1;

    public void addBoard(String boardName, String description) {
        Board board = new Board(boardName, description, boardId);
        boards.put(boardId++, board);
    }

    public void editBoard(long id, String boardName, String description) {
        try{
            Board board = getBoard(id);
            board.editBoard(boardName, description);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public void deleteBoard(long id) {
        checkBoard(id);
        boards.remove(id);
    }

    public Board getBoard(long id) {
        if (!boards.containsKey(id)) {
            throw new NoSuchElementException("Board not found");
        }
        return boards.get(id);
    }

    public void checkBoard(long id) {
        if (!boards.containsKey(id)) {
            throw new NoSuchElementException("Board not found");
        }
    }

    public void viewBoard(String boardName) {

    }

}

package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final Map<Long, Post> posts = new HashMap<>();
    private String boardName;
    private String boardDescription;
    private final long boardId;

    public Board(String boardName, String boardDescription, long boardId) {
        this.boardName = boardName;
        this.boardDescription = boardDescription;
        this.boardId = boardId;
    }

    public void addBoard(Post post){
        posts.put(post.getPostId(), post);
    }

    public void editBoard(String boardName, String boardDescription){
        this.boardName = boardName;
        this.boardDescription = boardDescription;
    }
}

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

    public void addPost(Post post){
        posts.put(post.getPostId(), post);
    }

    public void editBoard(String boardName, String boardDescription){
        this.boardName = boardName;
        this.boardDescription = boardDescription;
    }

    public String getBoardName() {
        return boardName;
    }

    public void viewPosts(){
        if(!posts.isEmpty()){
            System.out.println("글 번호/글 제목/작성일");
            for (Post post : posts.values()) {
                System.out.print(post.getPostId() + "/" + post.getTitle() + "/" + post.getCreatedAt());
            }
            System.out.println();
        }
    }
}

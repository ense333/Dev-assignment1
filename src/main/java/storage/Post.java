package storage;

import java.time.LocalDateTime;

public class Post {

    private String title;
    private String content;
    private final long postId;
    private final long boardId;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public Post(String title, String content, long postId, long boardId) {
        this.title = title;
        this.content = content;
        this.postId = postId;
        this.boardId = boardId;
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getPostId() {
        return postId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = LocalDateTime.now();
    }
}

package storage;

public class Post {

    private String title;
    private String content;
    private final long postId;

    public Post(String title, String content, long postId) {
        this.title = title;
        this.content = content;
        this.postId = postId;
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

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

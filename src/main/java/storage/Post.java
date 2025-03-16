package storage;

public class Post {

    private String title;
    private String content;
    private long postId;
    private static long incrementId = 1;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.postId = incrementId++;
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

package storage;

public class Post {

    private String title;
    private String content;
    private Long postId;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

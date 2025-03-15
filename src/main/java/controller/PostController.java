package controller;

import storage.Post;

import java.util.Stack;

public class PostController {

    private Stack<Post> posts = new Stack<>();

    public void createPost(String title, String content){
        Post newPost = new Post(title, content);
        posts.push(newPost);
        System.out.println("게시글이 추가되었습니다.");
    }

    public Post readPost(){
        if(posts.isEmpty()){
            System.out.println("게시글이 비어있습니다.");
            return null;
        }
        return posts.peek();
    }

    public Post deletePost(){
        if(posts.isEmpty()){
            System.out.println("게시글이 비어있습니다.");
            return null;
        }
        System.out.println("게시글이 삭제 되었습니다.");
        return posts.pop();
    }

    public void updatePost(String title, String content){
        if(posts.isEmpty()){
            System.out.println("게시글이 비어있습니다.");
            return;
        }
        Post peek = posts.peek();
        peek.updatePost(title, content);
        System.out.println("게시글이 수정되었습니다.");
    }


}

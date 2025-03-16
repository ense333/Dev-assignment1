package controller;

import storage.Post;

import java.util.*;

public class PostController {

    private Map<Long, Post> posts = new HashMap<>();
    private static Long checkId = 1L;

    public void createPost(String title, String content){
        Post newPost = new Post(title, content, checkId);
        posts.put(checkId++, newPost);
        System.out.println("게시글이 추가되었습니다.");
    }

    public Post readPost(long postId){
        if(!posts.containsKey(postId)){
            System.out.println("게시글이 비어있습니다.");
            return null;
        }
        return posts.get(postId);
    }

    public Post deletePost(long postId){
        if(!posts.containsKey(postId)){
            System.out.println("게시글이 비어있습니다.");
            return null;
        }
        System.out.println(postId + "번 게시글이 성공적으로 삭제 되었습니다.");
        return posts.remove(postId);
    }

    public void updatePost(long postId, String title, String content){
        if(!posts.containsKey(postId)){
            System.out.println("게시글이 비어있습니다.");
            return;
        }
        Post peek = posts.get(postId);
        peek.updatePost(title, content);
        System.out.println(postId + "번 게시글이 성공적으로 수정되었습니다.");
    }


}

package controller;

import storage.Post;

import java.net.Socket;
import java.util.*;

public class PostController {

    private Map<Long, Post> posts = new HashMap<>();
    private static Long checkId = 1L;

    public Post createPost(String title, String content, long boardId){
        Post newPost = new Post(title, content, checkId, boardId);
        posts.put(checkId++, newPost);
        System.out.println("게시글이 추가되었습니다.");
        return newPost;
    }

    public Post readPost(long postId){
        return posts.get(postId);
    }

    public Post deletePost(long postId){
        System.out.println(postId + "번 게시글이 성공적으로 삭제 되었습니다.");
        return posts.remove(postId);
    }

    public void updatePost(long postId, String title, String content){
        Post peek = posts.get(postId);
        peek.updatePost(title, content);
        System.out.println(postId + "번 게시글이 성공적으로 수정되었습니다.");
    }

    public void checkExist(long postId){
        if(!posts.containsKey(postId)){
            throw new IllegalArgumentException(postId + "번 게시글은 존재하지 않습니다.");
        }
    }

    public void viewPost(long postId){
        try {
            checkExist(postId);
            Post post = posts.get(postId);
            System.out.println(postId + "번 게시글");
            System.out.println("작성일: " + post.getCreatedAt());
            System.out.println("수정일: " + post.getUpdateAt());
            System.out.println("제목: " + post.getTitle());
            System.out.println("내용: " + post.getContent());
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

    public void printAll(){
        if(posts.isEmpty()){
            throw new IllegalArgumentException("작성되어 있는 게시글이 없습니다.");
        }
        System.out.println("총 게시글은 " + posts.size() + "개 작성되어있습니다.");
        for (Long idx : posts.keySet()) {
            System.out.println(idx + "번 게시글");
            Post post = posts.get(idx);
            System.out.println("제목 : " + post.getTitle());
            System.out.println("내용 : " + post.getContent());
        }
    }


}

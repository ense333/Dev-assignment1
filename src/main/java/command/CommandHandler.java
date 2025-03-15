package command;

import controller.PostController;
import storage.Post;

import java.util.Scanner;

public class CommandHandler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostController postController = new PostController();
        while (true){
            System.out.print("명령어 > ");
            String command = sc.nextLine();

            if(command.equals("종료")){
                System.out.println("프로그램이 종료됩니다.");
                break;
            }else if(command.equals("작성")){
                System.out.print("게시물 제목 입력: ");
                String title = sc.nextLine();
                System.out.print("게시물 내용 작성: ");
                String content = sc.nextLine();
                postController.createPost(title, content);
            }else if(command.equals("조회")){
                Post post = postController.readPost();
                if(post != null){
                    System.out.println("제목: " + post.getTitle());
                    System.out.println("내용: " + post.getContent());
                }
            }else if(command.equals("삭제")){
                postController.deletePost();
            }else if(command.equals("수정")){
                System.out.print("수정할 제목: ");
                String title = sc.nextLine();
                System.out.print("수정할 내용: ");
                String content = sc.nextLine();
                postController.updatePost(title, content);
            }else{
                System.out.println("존재하지 않는 명령어 입니다.");
            }
        }
    }
}

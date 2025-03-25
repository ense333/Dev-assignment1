package command;

import controller.BoardController;
import controller.PostController;
import storage.Board;
import storage.Post;
import util.UrlHandler;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandHandler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostController postController = new PostController();
        BoardController boardController = new BoardController();
        while (true){
            System.out.print("a ");
            String command = sc.nextLine().trim();
            //들어오는 URL -> /구분/기능?파라미터.. split을 main에서 할지 클래스 안에서 할지
            //이게 구분, 기능은 전부 다 있고 파라미터가 없는 경우가 있기에
            //String[] split = command.split("[/?]");
            //String division = split[0];
            //String action = split[1];
            //String parameter = split[2];
            //UrlHandler urlHandler = new UrlHandler(division, action, parameter);
            //URL을 String 째로 넘기고 해당 객체 내에서 private 변수에 split 후 집어넣기
            UrlHandler urlHandler = new UrlHandler(command);
            if(urlHandler.getDivision().equals("boards")){
                //게시판 관련 기능 구현
                String act = urlHandler.getAction();
                if(act.equals("add")){
                    System.out.print("게시판 이름 작성: ");
                    String boardName = sc.nextLine();
                    System.out.print("게시판 설명 작성: ");
                    String boardDescription = sc.nextLine();
                    boardController.addBoard(boardName, boardDescription);
                }else if(act.equals("edit")){
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String boardIdString = parameterMap.get("boardId");
                    long boardId;
                    try{
                        boardId = Long.parseLong(boardIdString);
                        boardController.checkBoard(boardId);
                    } catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                        continue;
                    } catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    System.out.print("수정할 게시판 이름: ");
                    String editBoardName = sc.nextLine();
                    System.out.print("수정할 게시판 설명: ");
                    String editBoardDescription = sc.nextLine();
                    try{
                        boardController.editBoard(boardId, editBoardName, editBoardDescription);
                    } catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                }else if(act.equals("remove")){
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String boardIdString = parameterMap.get("boardId");
                    try{
                        long boardId = Long.parseLong(boardIdString);
                        boardController.checkBoard(boardId);
                    } catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                        continue;
                    }

                }else if(act.equals("view")){
                    //String
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String boardNameString = parameterMap.get("boardName");
                    try {
                        boardController.viewBoard(boardNameString);
                    } catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                        continue;
                    }

                }
            }else if(urlHandler.getDivision().equals("posts")){

                if(urlHandler.getAction().equals("add")){
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String boardIdString = parameterMap.get("boardId");

                    try{
                        long boardId = Long.parseLong(boardIdString);
                        Board board = boardController.getBoard(boardId);

                        System.out.print("게시물 제목 입력: ");
                        String title = sc.nextLine();
                        System.out.print("게시물 내용 작성: ");
                        String content = sc.nextLine();
                        Post newPost = postController.createPost(title, content, boardId);
                        board.addPost(newPost);
                    } catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                }else if(urlHandler.getAction().equals("remove")){
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String postIdString = parameterMap.get("postId");
                    try {
                        long postId = Long.parseLong(postIdString);
                        postController.checkExist(postId);
                        postController.deletePost(postId);
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }

                }else if(urlHandler.getAction().equals("edit")){
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String postIdString = parameterMap.get("postId");
                    try{
                        long postId = Long.parseLong(postIdString);
                        if (checkAndHandle(postController, postId)) continue;
                        System.out.print("수정할 제목: ");
                        String title = sc.nextLine();
                        System.out.print("수정할 내용: ");
                        String content = sc.nextLine();
                        postController.updatePost(postId,title,content);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }else if(urlHandler.getAction().equals("view")){
                    Map<String, String> parameterMap = urlHandler.getParameterMap();
                    String postIdString = parameterMap.get("postId");
                    try{
                        long postId = Long.parseLong(postIdString);
                        postController.viewPost(postId);

                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                }
            }else{
                System.out.println("존재하지 않는 명령어 입니다.");
            }

            /*
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
                System.out.print("어떤 게시물을 조회할까요? ");
                //numberformatException 처리와 알수 없는 예외 처리까지
                long idx = sc.nextLong();
                sc.nextLine();
                if (checkAndHandle(postController, idx)) continue;
                Post post = postController.readPost(idx);
                System.out.println("번호: " + post.getPostId());
                System.out.println("제목: " + post.getTitle());
                System.out.println("내용: " + post.getContent());

            }else if(command.equals("삭제")){
                System.out.print("어떤 게시물을 삭제할까요? ");
                long idx = sc.nextLong();
                sc.nextLine();
                if (checkAndHandle(postController, idx)) continue;
                postController.deletePost(idx);
            }else if(command.equals("수정")){
                System.out.print("어떤 게시물을 수정할까요? ");
                long idx = sc.nextLong();
                sc.nextLine();
                if (checkAndHandle(postController, idx)) continue;
                System.out.print("수정할 제목: ");
                String title = sc.nextLine();
                System.out.print("수정할 내용: ");
                String content = sc.nextLine();
                postController.updatePost(idx,title,content);
            }else if(command.equals("목록")){
                try {
                    postController.printAll();
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("존재하지 않는 명령어 입니다.");
            }

             */
        }
    }

    private static boolean checkAndHandle(PostController postController, long idx) {
        try {
            postController.checkExist(idx);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}

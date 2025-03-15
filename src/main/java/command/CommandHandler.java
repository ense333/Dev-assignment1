package command;

import java.util.Scanner;

public class CommandHandler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("명령어 > ");
            String command = sc.nextLine();
            if(command.equals("종료")){
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            System.out.println("존재하지 않는 명령어 입니다.");
        }
    }
}

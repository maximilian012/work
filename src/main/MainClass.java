package main;

import java.util.Scanner;

import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		AccountDao dao = new AccountDao();
		// menu
		while (true) {

			System.out.println("<<<<<<<<<<<< 가계부(수정됨) >>>>>>>>>>>>");
			System.out.print("1. 입력");
			System.out.print(" 2. 검색");
			System.out.print(" 3. 삭제");
			System.out.print(" 4. 수정");
			System.out.print(" 5. 수입출력");
			System.out.print(" 6. 지출출력");
			System.out.println(" 7. 전체출력");
			System.out.println(" 8. 파일저장");
			System.out.print(">>");

			int a = sc.nextInt();

			if (a == 1) {
				dao.insert();
			} else if (a == 2) {
				dao.select();
			} else if (a == 3) {
				dao.delete();
			} else if (a == 4) {
				dao.update();
			} else if (a == 5) {
				dao.selectInput();
			} else if (a == 6) {
				dao.selectOutput();
			} else if (a == 7) {
				dao.selectAll();
			} else if (a == 8) {
				dao.fileSave();
			}
		}

	}

}

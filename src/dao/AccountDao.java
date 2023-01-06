package dao;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.FileProc;
import dto.AccountDto;

public class AccountDao {

	Scanner sc = new Scanner(System.in);

	private List<AccountDto> list = new ArrayList<AccountDto>();
	// crud
	
	public FileProc f = null;

	public AccountDao() {
		// TODO Auto-generated constructor stub
		f = new FileProc("account");
		fileRoad();
	}

	public void insert() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("======= 가계부를 추가합니다! =======");
		System.out.println("날짜");
		String date = "";
		try {
			date = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("용도");
		String use = sc.next();
		System.out.println("수입/지출");
		String classify = sc.next();
		System.out.println("금액");
		int money = sc.nextInt();
		System.out.println("내용");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AccountDto dto = new AccountDto(date, use, classify, money, memo);
		list.add(dto);

	}

	public void delete() {
		System.out.println("---------------삭제할 메모를 입력하시오 : ----------------");
		String m = sc.next();
		int a = search(m);

		if (a == -1) {
			System.out.println("없는 메모 입니다.");
		} else {
			list.remove(a);
			System.out.println("삭제성공*************************");
		}

	}

	public void select() {
		// 함수로 따로 만들기
		// 연도,월별 결산
		// 수입
		// 지출
		// 용도

	}

	public void selectInput() { // 수입

		String in = "수입";

		for (int i = 0; i < list.size(); i++) {
			if (in.equals(list.get(i).getClassify())) {
				System.out.println(list.get(i));

			}
		}

	}

	public void selectOutput() { // 지출

		String ou = "지출";
		for (int i = 0; i < list.size(); i++) {
			if (ou.equals(list.get(i).getClassify())) {
				System.out.println(list.get(i));

			}
		}

	}

	public void update() {
		// 날짜나 메모로

		System.out.println("$$$$$$$$$$$$$$$$$$$$$  수정할 메모 입력 :  $$$$$$$$$$$$$$$$$$$$$$$$$");
		String mm = sc.next();
		int a = search(mm); // mm 에 수정할 메모 있음

		if (a == -1) {
			System.out.println("없는 메모 입니다.");
		} else {
			System.out.println("수정내용 : ");
			String amm = sc.next();
			list.get(a).setMemo(amm);
			System.out.println("수정 성공*************************");
		}

	}

	public void selectAll() {

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println("===============================================");
		}

	}

	public int search(String name) {

		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getMemo())) {
				index = i;
			}
		}
		return index;

	}

	public void fileSave() {

		String dataArr[] = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {

			dataArr[i] = list.get(i).toString(); // 리스트의 i번째 인덱스번호의 객체를 리턴 하는데 에러뜸 => dataArr는 String라 객체를 String으로 미스매치
			// 그러므로 toString()을 써서 같은 String으로 맞춰줌
		}
		f.write(dataArr);
	}

	public void fileRoad() {

		String datas[] = f.read();
		for (int i = 0; i < datas.length; i++) {
			// : 기준으로 짜르기
			
				
			String split[] = datas[i].split(":");
			                                                             // integer로 형변환을 시켜야 하는데 공백이 있어서 형변환이 안됬었다. 그래서 trim으로 
																		//  앞뒤 공백을 잘라 순수 String만 integer로 형변환되도록 하였다.
			AccountDto ad = new AccountDto(split[0], split[1], split[2], Integer.parseInt(split[3].trim()), split[4]); 
			//System.out.println("fff");

			list.add(ad);
			
		}

	}

}

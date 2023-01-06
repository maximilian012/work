package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProc {

	private File file = null;

	public FileProc(String filename) {
		// TODO Auto-generated constructor stub
		file = new File("c:\\tmp\\" + filename + ".txt");

		try {
			if (file.createNewFile()) {
				System.out.println("파일 생성 성공 !!!");
			} else {
				System.out.println("기존 파일이 있습니다.");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String[] dataArr) {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			for (int i = 0; i < dataArr.length; i++) {
				pw.println(dataArr[i]);
			}
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일에 저장되었습니다");

	}

	public String[] read() {
		// TODO Auto-generated method stub
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			int cnt = 0;
			String str = "";
			
			try {
				while ((str = br.readLine()) != null) {
					cnt++;
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			datas = new String[cnt];
			br = new BufferedReader(new FileReader(file));
			
			int w = 0;
			try {
				while ((str = br.readLine()) != null) {
					datas[w] = str;
					w++;
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}

}

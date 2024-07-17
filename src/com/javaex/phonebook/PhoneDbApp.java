package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PhoneDbApp {

	public static void main(String[] args) throws IOException{

		//입력
		InputStream in = new FileInputStream("C:\\javaStudy\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		BufferedReader br = new BufferedReader(isr);

		//추가
		OutputStream out = new FileOutputStream("C:\\javaStudy\\PhoneDBPlus.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		InputStream scin = System.in;
		InputStreamReader sisr = new InputStreamReader(scin);
		BufferedReader bisr = new BufferedReader(sisr);
		List<PhoneDb> phoneDbList = new ArrayList<PhoneDb>();


		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">  전화번호 관리 프로그램   >");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("");
		System.out.println("1.리스트" + " 2.등록" + " 3.삭제" + " 4.검색" + " 5.종료");


		while(true) {	//읽어오기 list관리
			String num1 = br.readLine();

			if(num1 == null) {
				break;
			}
			String[] sArray = num1.split(",");
			PhoneDb PhoneDb = new PhoneDb(sArray[0],sArray[1],sArray[2]);
			phoneDbList.add(PhoneDb);
		}

		boolean loop = true;;
		while(loop) {

			System.out.println("----------------------");
			System.out.print(">메뉴번호: ");
			String str = bisr.readLine();	//스캐너 입력받은 번호


			if(str.equals("1")) {
				System.out.println("< 1.리스트 >");

				for(int i=0; i<phoneDbList.size();i++) {
					System.out.print((i+1)+".");
					phoneDbList.get(i).showInfo();
				}

			}else if(str.equals("2")) {
				System.out.println("< 2.등록 >");

				System.out.print(">이름: ");
				String n = bisr.readLine();
				System.out.print(">휴대전화: ");
				String h = bisr.readLine();
				System.out.print(">회사전화: ");
				String c = bisr.readLine();
				System.out.println("등록되었습니다.");

				PhoneDb PhoneDb = new PhoneDb(n,h,c);
				phoneDbList.add(PhoneDb);




			}else if(str.equals("3")) {
				System.out.println("< 3.삭제 >");
				System.out.print("번호: ");
				String d = bisr.readLine();
				System.out.println("[삭제되었습니다.]");

				int dn = Integer.parseInt(d);
				//int sum = (dn-1);
				phoneDbList.remove(dn-1);
				

			}else if(str.equals("4")) {
				System.out.println("< 4.검색 >");
				System.out.print("이름: ");
				String n = bisr.readLine();

				for(PhoneDb person : phoneDbList) {
					if(person.getName().contains(n)) {
						System.out.println(phoneDbList.indexOf(person) + 1 + ".");
						person.showInfo();
					}
				}

			}else if (str.equals("5")) {
				System.out.println("마무리");
				loop = false;
				break;
			}else {
				System.out.println("다시 입력");
			}


		}//while
		
		for(int i = 0; i < phoneDbList.size(); i++) {
			bw.write(phoneDbList.get(i).getName()+","+phoneDbList.get(i).getHp()+","+phoneDbList.get(i).getCompany());
			bw.newLine();
		}
		
	
		
	}

	}//main






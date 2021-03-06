package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.StudentVO;

public class StudentRegisterManager {

	// 학생 정보 등록
	public void studentRegistr() throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		SubjectDAO sdao = new SubjectDAO();
		StudentDAO sd = new StudentDAO();
		StudentVO sVo = new StudentVO();
		
		String sd_num;
		String sd_name;
		String sd_id;
		String sd_passwd;
		String s_num;
		String sd_birthday;
		String sd_phone;
		String sd_address;
		String sd_email;
		
		boolean id_check;
		String year;
		
		System.out.println("학생 정보 입력");
		System.out.print("성명 : ");
		sd_name = input.nextLine();
		
		do {
			System.out.print("아이디(8자 이상 12자 이내) : ");
			sd_id = input.nextLine();
			id_check = sd.getStudentIdOverlap(sd_id);
			
			if(id_check) {
				System.out.println("중복된 아이디 입니다. 다시 입력하세요.");
			}
		} while(id_check);
		
		System.out.print("비밀번호(12자 이내) : ");
		sd_passwd = input.nextLine();
		
		sdao.getSubjectTotalList();
		
		System.out.print("학과 번호 : ");
		s_num = input.nextLine();
		
		// 학생번호 8자리
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		year = sdf.format(new Date());
		sd_num = year + s_num + sd.getStudentCount(s_num);
		
		System.out.print("생년월일(8자리)");
		sd_birthday = input.nextLine();
		System.out.print("전화번호 : ");
		sd_phone = input.nextLine();
		System.out.print("도로명 주소 : ");
		sd_address = input.nextLine();
		System.out.print("이메일 : ");
		sd_email = input.nextLine();
		
		sVo.setSd_num(sd_num);
		sVo.setSd_name(sd_name);
		sVo.setSd_id(sd_id);
		sVo.setSd_passwd(sd_passwd);
		sVo.setS_num(s_num);
		sVo.setSd_birthday(sd_birthday);
		sVo.setSd_phone(sd_phone);
		sVo.setSd_address(sd_address);
		sVo.setSd_email(sd_email);
		
		sd.setStudentRegiste(sVo);
		
		System.out.println();
		System.out.println("등록 학생 정보");
		sd.getStudent(sVo.getSd_id(), sVo.getSd_passwd());
		System.out.println();
	}
	
	// 학생 정보 수정
	public void studentUpdate() throws Exception {
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		
		StudentDAO sdao = new StudentDAO();
		StudentVO sVo = new StudentVO();
		
		String id;
		String pw;
		String sd_num;
		String sd_passwd;
		String sd_phone;
		String sd_address;
		String sd_email;
		
		boolean success = false;
		
		System.out.println("학생 정보 수정");
		
		do {
			System.out.print("아이디 : ");
			id = input.nextLine();
			System.out.print("비밀번호 : ");
			pw = input.nextLine();
			
			success = sdao.getStudentLogin(id, pw);
			
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
			}
		} while (!success);
		
		sd_num = sdao.getStudentNum(id, pw);
		System.out.println();
		System.out.println("수정할 학생");
		System.out.println("학생번호 : " + sd_num);
		
		System.out.println("비밀번호(12자 이내) : ");
		sd_passwd = input.nextLine();
		System.out.println("전화번호 : ");
		sd_phone = input.nextLine();
		System.out.println("도로명 주소 : ");
		sd_address = input.nextLine();
		System.out.println("이메일 : ");
		sd_email = input.nextLine();
		
		sVo.setSd_num(sd_num);
		sVo.setSd_passwd(sd_passwd);
		sVo.setSd_phone(sd_phone);
		sVo.setSd_address(sd_address);
		sVo.setSd_email(sd_email);
		
		sdao.setStudentUpdate(sVo);
		
		System.out.println();
		System.out.println("학생 정보 수정 결과");
		sdao.getStudent(id, sVo.getSd_passwd());
		System.out.println();
	}
	
	// 학생 전체 목록
	public void studentTotalList() throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		StudentDAO sdao = new StudentDAO();
		
		String pw;
		
		System.out.println("학생 정보 전체 목록");
		System.out.print("관리자 비밀번호 : ");
		pw = input.nextLine();
		
		if (pw.equals("admin1234")) {
			sdao.getStudentTotalList();
		}
		else {
			System.out.println("관리자 비밀번호가 틀립니다.");
		}
	}
	
}

import controller.LessonRegisterManager;
import controller.StudentRegisterManager;
import controller.SubjectRegisterManager;
import controller.TraineeRegisterManager;
import view.LESSON_CHOICE;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.STUDENT_CHOICE;
import view.SUBJECT_CHOICE;
import view.TRAINEE_CHOICE;

public class UniversityRegisterCoursesMain {

	public static void main(String[] args) {

		mainmenu();

	}
	
	public static void mainmenu() {
		
		int choiceNum;
		
		while(true) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = MenuViewer.choice.nextInt();
				MenuViewer.choice.nextLine();
				
				switch (choiceNum) {
				case MENU_CHOICE.SUBJECT :
					subjectMenu();
					break;
				case MENU_CHOICE.STUDENT :
					studentMenu();
					break;
				case MENU_CHOICE.LESSON :
					lessonMenu();
					break;
				case MENU_CHOICE.TRAINEE :
					traineeMenu();
					break;
				case MENU_CHOICE.EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
				default :
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다. \n프로그램을 다시 시작하세요.");
				return;
			}
		}
	}
	
	// 학과 메뉴
	public static void subjectMenu() throws Exception {
		
		int choice;
		
		SubjectRegisterManager subjectManager = new SubjectRegisterManager();
		MenuViewer.subjectMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		
		switch (choice) {
		case SUBJECT_CHOICE.LIST :
			System.out.println("");
			subjectManager.subjectList();
			break;
		case SUBJECT_CHOICE.INSERT :
			System.out.println();
			subjectManager.subjectRegistr();
			break;
		case SUBJECT_CHOICE.UPDATE :
			System.out.println();
			subjectManager.subjectUpdate();
			break;
		case SUBJECT_CHOICE.DELETE :
			System.out.println();
			subjectManager.subjectDelete();
			break;
		case SUBJECT_CHOICE.MAIN :
			return;
		default :
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
	
	// 학생 메뉴
	public static void studentMenu() throws Exception {
		
		int choice;
		
		StudentRegisterManager studentManager = new StudentRegisterManager();
		MenuViewer.studentMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		
		switch (choice) {
		case STUDENT_CHOICE.INSERT :
			System.out.println("");
			studentManager.studentRegistr();
			break;
		case STUDENT_CHOICE.UPDATE :
			System.out.println("");
			studentManager.studentUpdate();
			break;
		case STUDENT_CHOICE.LIST :
			System.out.println("");
			studentManager.studentTotalList();
			break;
		case STUDENT_CHOICE.MAIN :
			return;
		default :
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
	
	// 과목 메뉴
	public static void lessonMenu() throws Exception {
		
		int choice;
		
		LessonRegisterManager lessonmanager = new LessonRegisterManager();
		MenuViewer.lessonMenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		
		switch (choice) {
		case LESSON_CHOICE.LIST : 
			System.out.println("");
		//	lessonmanager.lessonList();
			break;
		case LESSON_CHOICE.INSERT :
			System.out.println("");
		//	lessonmanager.lessonRegistr();
			break;
		case LESSON_CHOICE.UPDATE :
			System.out.println("");
		//	lessonmanager.lessonUpdate();
			break;
		case LESSON_CHOICE.DELETE :
			System.out.println("");
		//	lessonmanager.lessonDelete();
			break;
		case LESSON_CHOICE.MAIN :
			return;
		default :
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
	
	// 수강 신청 메뉴
	public static void traineeMenu() throws Exception {
		
		int choice;
		
		TraineeRegisterManager traineemanager = new TraineeRegisterManager();
		MenuViewer.traineemenuView();
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		
		switch (choice) {
		case TRAINEE_CHOICE.LIST :
			System.out.println("");
		//	traineemanager.traineeList();
			break;
		case TRAINEE_CHOICE.INSERT :
			System.out.println("");
		//	traineemanager.traineeRegistr();
			break;
		case TRAINEE_CHOICE.UPDATE :
			System.out.println("");
		//	traineemanager.traineeDelete();
			break;
		case TRAINEE_CHOICE.MAIN :
			return;
		default :
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

}

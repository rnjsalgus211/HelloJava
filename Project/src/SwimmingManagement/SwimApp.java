package SwimmingManagement;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

//실행 클래스
public class SwimApp {
	MailApp app = new MailApp();

	public static void main(String[] args) {
		SwimDAO swimDao = new SwimDAO();
		Scanner scn = new Scanner(System.in);
		MailApp app = new MailApp();

		boolean checked = false;
		String name = null;
		Login login = null;
		String name1 = null;
		// 로그인 테이블
		while (!checked) {
			System.out.println("-----------------------------------");
			System.out.println("Welcome! 대구수영장 회원관리 프로그램입니다.");
			System.out.println("-----------------------------------");
			System.out.println("1.로그인 2.회원가입 3.회원탈퇴 4.아이디찾기 5.비밀번호찾기");
			int num = Integer.parseInt(scn.nextLine());
			if (num == 1) {
				System.out.println("-----------------------------------");
				System.out.print("아이디: ");
				String id = scn.nextLine();
				System.out.print("비밀번호: ");
				String passwd = scn.nextLine();
				System.out.println("-----------------------------------");

				int a = swimDao.login(id, passwd);
				if (a == 1) {
					name = id;
						name1 = swimDao.getId(name).getUserName();
						System.out.println("-----------------------------------");
						System.out.println("     ******로그인 성공 ! *******");
						System.out.println("-----------------------------------");
			
					break;
				} else {
					System.out.println("----------------------------------");
					System.out.println("     ******로그인 실패 ******");
					System.out.println("     아이디와 비밀번호를 확인하세요!");
					System.out.println("----------------------------------");
					checked = false;
				}
				// 회원가입
			} else if (num == 2) {
				System.out.println("-----------------------------------");
				System.out.println("          < 회원가입 창입니다. >");
				System.out.println("-----------------------------------");
				System.out.print("아이디>>  ");
				String userId = scn.nextLine();
				boolean run1 = true;
				while (run1) {
					System.out.println("비밀번호>> ");
					String userPw = scn.nextLine();
					System.out.println("비밀번호 확인>> ");
					String userPw2 = scn.nextLine();
					if (userPw.equals(userPw2)) {
						System.out.println("이름>> ");
						String userName = scn.nextLine();
						Swim user = swimDao.getName2(userName);
						if (user != null) {
							if (userName.equals(user.getUserName())) {
								System.out.println("이메일>> (비밀번호 찾기시 이용됩니다.)");
								String userEmail = scn.nextLine();
								System.out.println("입력하신 정보가 " + "[ID:" + userId + "] [Passwd:" + userPw + "] [이름:"
										+ userName + "] [이메일:" + userEmail + "]이 맞습니까? Y or N");
								String answer = scn.nextLine();
								if (answer.equals("Y")) {
									System.out.println("이메일 인증창으로 이동합니다.");

									Random random = new Random();
									int createNum = 0;
									String ranNum = "";
									int letter = 6;
									String resultNum = "";
									for (int i = 0; i < letter; i++) {

										createNum = random.nextInt(9);
										ranNum = Integer.toString(createNum);
										resultNum += ranNum;
									}

									String mail = userEmail;
									String from = "" + mail + "";
									String to = "rnjsalgus211@naver.com";
									String subject = "대구수영장 회원 인증번호입니다.";
									String content = "인증번호는 " + resultNum + " 입니다. 확인 창에 입력해주세요.";
									app.sendMail(from, to, subject, content);

									System.out.println("입력하신 이메일[" + userEmail + "]로 인증번호를 발송하였습니다.");
									System.out.println("인증번호를 입력하면 회원가입이 완료됩니다.");

									boolean run = true;
									while (run) {
										System.out.println("-----------------------------------");
										System.out.println("인증번호>> (6자리) ");
										String num1 = scn.nextLine();
										if (num1.equals(resultNum)) {
											System.out.println("인증번호가 확인되었습니다.");
											login = new Login(userId, userPw, userName, userEmail);
											swimDao.membership(login);
											System.out.println("-----------------------------------");
											System.out.println("회원가입이 완료되었습니다! 축하합니다!");
											System.out.println("※[ID:" + userId + "] [Pw:" + userPw + "]");
											run = false;
										} else {
											System.out.println("인증번호가 틀렸습니다.");
											System.out.println("다시 입력하시겠습니까? Y or N");
											String answer1 = scn.nextLine();
											if (answer1.equals("Y")) {
												continue;
											} else if (answer1.equals("N")) {
												System.out.println("처음메뉴로 돌아갑니다.");
												break;
											} else {
												System.out.println("잘못된 응답입니다.");
												break;
											}
										}
									}
								} else if (answer.equals("N")) {
									System.out.println("처음메뉴로 돌아갑니다.");
								}
							}
							run1 = false;
						} else {
							System.out.println("회원을 찾을 수 없습니다.");
							break;
						}
					} else {
						System.out.println("비밀번호가 일치하지않습니다. 다시 입력해주세요.");
						continue;
					}
				}
				// 회원탈퇴
			} else if (num == 3) {
				System.out.println("-----------------------------------");
				System.out.println("         < 회원탈퇴 창입니다. >");
				System.out.println("-----------------------------------");
				System.out.println("회원탈퇴를 진행할 ID를 입력하세요.");
				String userId = scn.nextLine();
				if (swimDao.getId(userId) != null) {
					if (userId.equals(swimDao.getId(userId).getUserId())) {
						System.out.println("탈퇴 할 회원 정보가 " + swimDao.getId(userId).toDetail() + "가 맞습니까? Y or N");
						String answer = scn.nextLine();
						if (answer.equals("Y")) {
							Random random = new Random();
							int createNum = 0;
							String ranNum = "";
							int letter = 6;
							String resultNum = "";
							for (int i = 0; i < letter; i++) {

								createNum = random.nextInt(9);
								ranNum = Integer.toString(createNum);
								resultNum += ranNum;
							}

							System.out.println("회원가입시 입력한 이메일로 인증번호를 발송합니다.");
							String mail = swimDao.getId(userId).getUserEmail();
							String from = "" + mail + "";
							String to = "rnjsalgus211@naver.com";
							String subject = "대구수영장 회원 인증번호입니다.";
							String content = "인증번호는 " + resultNum + " 입니다. 확인 창에 입력해주세요.";
							app.sendMail(from, to, subject, content);
							System.out.println("인증번호를 입력하면 회원탈퇴가 완료됩니다.");

							boolean run = true;
							while (run) {
								System.out.println("-----------------------------------");
								System.out.println("인증번호>> (6자리) ");
								String num1 = scn.nextLine();
								if (num1.equals(resultNum)) {
									System.out.println("인증번호가 확인되었습니다.");
									System.out.println("정말 탈퇴하시겠습니까? Y or N");
									String answer3 = scn.nextLine();
									if (answer3.equals("Y")) {
										swimDao.delMember(userId);
										System.out.println("-----------------------------------");
										System.out.println("   < 회원탈퇴가 완료되었습니다. 감사합니다. >");
										System.out.println("-----------------------------------");
									} else if (answer3.equals("N")) {
										System.out.println("처음메뉴로 돌아갑니다.");
									} else {
										System.out.println("잘못된 응답입니다.");
										break;
									}
									run = false;

								} else {
									System.out.println("인증번호가 틀렸습니다.");
									System.out.println("다시 입력하시겠습니까? Y or N");
									String answer2 = scn.nextLine();
									if (answer2.equals("Y")) {
										continue;
									} else if (answer2.equals("N")) {
										System.out.println("처음메뉴로 돌아갑니다.");
										break;
									} else {
										System.out.println("잘못된 응답입니다.");
										break;
									}
								}
							}

						} else if (answer.equals("N")) {
							System.out.println("회원정보를 유지합니다.");
							System.out.println("처음화면으로 돌아갑니다.");
						} else {
							System.out.println("잘못된 응답입니다.");
							continue;
						}
					}
				} else {
					System.out.println("아이디를 확인하세요.");
				}

				// 아이디찾기
			} else if (num == 4) {
				System.out.println("-----------------------------------");
				System.out.println("  < 아이디를 찾을 회원 이름을 입력하세요. >");
				System.out.println("-----------------------------------");
				String userName = scn.nextLine();
				Login u = swimDao.getName(userName);
				if (u != null && userName.equals(u.getUserName())) {
					System.out.println("[" + userName + "]회원님의 ID는 [" + u.getUserId() + "] 입니다.");

				} else {
					System.out.println("-----------------------------------");
					System.out.println("일치하는 정보가 없습니다.");
				}
			}

			// 비밀번호찾기
			else if (num == 5) {
				Random random = new Random();
				int createNum = 0;
				String ranNum = "";
				int letter = 6;
				String resultNum = "";

				for (int i = 0; i < letter; i++) {

					createNum = random.nextInt(9);
					ranNum = Integer.toString(createNum);
					resultNum += ranNum;
				}
				System.out.println("-----------------------------------------------------------");
				System.out.println("비밀번호를 찾을 ID를 입력하세요. 회원가입 시 입력한 메일로 인증번호를 발송합니다.");
				System.out.println("-----------------------------------------------------------");

				String userId = scn.nextLine();
				Login u = swimDao.getId(userId);
				if (u != null && userId.equals(u.getUserId())) {
					String mail = swimDao.getId(userId).getUserEmail();

					String from = "" + mail + "";
					String to = "rnjsalgus211@naver.com";
					String subject = "대구수영장 회원 인증번호입니다.";
					String content = "인증번호는 " + resultNum + " 입니다. 확인 창에 입력해주세요.";
					app.sendMail(from, to, subject, content);

					boolean run = true;
					while (run) {
						System.out.println("-----------------------------------");
						System.out.println("인증번호>> (6자리) ");
						String num1 = scn.nextLine();
						if (num1.equals(resultNum)) {
							System.out.println("인증번호가 확인되었습니다.");
							System.out.println("아이디: [" + userId + "] 의 비밀번호는 [" //
									+ swimDao.getId(userId).getPasswd() + "] 입니다.");
							System.out.println("-----------------------------------");
							run = false;
						} else {
							System.out.println("인증번호가 틀렸습니다.");
							System.out.println("다시 입력하시겠습니까? Y or N");
							String answer = scn.nextLine();
							if (answer.equals("Y")) {
								continue;
							} else if (answer.equals("N")) {
								System.out.println("처음메뉴로 돌아갑니다.");
								break;
							} else {
								System.out.println("잘못된 응답입니다.");
								break;
							}
						}
					}
				} else {
					System.out.println("-----------------------------------");
					System.out.println("일치하는 정보가 없습니다.");
				}
			} else {
				System.out.println("잘못된 번호를 입력하였습니다.");
			}

		}

		// 본문
		while (true) {
			int menu = 0;
			int menu1 = 0;
			if (name.equals("manager")) {
				System.out.println("-----------------------------------");
				System.out.println("       < 관리자로 접속하였습니다. >");
				System.out.println("-----------------------------------");
				System.out.println("1.회원등록 2.조회 3.상세조회 4.정보수정 5.삭제 6.강사평가 조회 9.종료");
				System.out.println("입력>>  ");
				menu = Integer.parseInt(scn.nextLine());
			} else {
				System.out.println("-----------------------------------");
				System.out.println("       < "+name1+" 회원님 환영합니다. >");
				System.out.println("-----------------------------------");
				System.out.println("1.회원조회 2.강사조회 3.강사평가조회 4.종료");
				menu1 = Integer.parseInt(scn.nextLine());
				// -----회원화면-------
				// 회원조회
				if (menu1 == 1) {
					System.out.println("----------------------------------");
					System.out.println("         < 회원 목록입니다. >");
					System.out.println("----------------------------------");
					List<Swim> swimUser = swimDao.search();
					for(int i=0; i<swimUser.size(); i++) {
						Swim a = swimUser.get(i);
						String userName = a.getUserName();
						userName =userName.substring(0, 1);

						System.out.println("[회원번호:"+a.getUserSeq()+"] [회원이름:"+userName+"**"//
											+"] [성별 및 나이:"+a.getUserAge()+"] [소속 반:"+a.getCourse()
											+"] [등록일시:"+a.getcDate()+"]");
						
					}

					// 강사조회 및 강사평가
				} else if (menu1 == 2) {
					System.out.println("----------------------------------");
					System.out.println("        < 강사목록입니다. >");
					System.out.println("----------------------------------");
					List<Teacher> teachers = swimDao.teacherInfo();
					for (Teacher teacher : teachers) {
						System.out.println(teacher);
					}
					System.out.println("----------------------------------");
					System.out.println("평가를 작성하시겠습니까? Y or N");
					System.out.println("----------------------------------");
					String answer = scn.nextLine();
					if (answer.equals("Y")) {
						System.out.println("----------------------------------");
						System.out.println("       어떤 강사를 평가하시겠습니까?");
						System.out.println("----------------------------------");
						
						String tName = scn.nextLine();
						Teacher t = swimDao.getTeacher(tName);
						Swim u = swimDao.getName2(name1);
						
						if (t != null) {
							if(t.getCourse().equals(u.getCourse())) {
							if (tName.equals(t.gettName())) {
								System.out.println("----------------------------------");
								System.out.println("평가 내용을 입력하세요.");
								String content = scn.nextLine();
								System.out.println("작성자 이름을 입력하세요.");
								System.out.println("----------------------------------");
								String userName = scn.nextLine();
								Swim t1 = swimDao.getName2(userName);
								if (t1 != null && userName.equals(t1.getUserName())) {
									if (userName.equals(name1)) {
										Reply rep = new Reply(0, t.getCourse(), tName, content, userName);
										swimDao.reply(rep);
										System.out.println("평가가 입력되었습니다.");
									}

								} else if(userName.equals("손님")) {
									System.out.println("손님은 작성할 수 없습니다.");
								}else {
									System.out.println("로그인 정보와 일치하지 않습니다.");
								}
							}
							}else {
								System.out.println("해당 반의 학생이 아닙니다.");
							}
						} else if (t == null) {
							System.out.println("강사 이름을 확인하세요.");
						}

					} else if (answer.equals("N")) {
						System.out.println("처음 메뉴로 돌아갑니다.");
					} else {
						System.out.println("잘못된 응답입니다.");

					}

					// 강사평 조회 및 삭제
				} else if (menu1 == 3) {
					System.out.println("----------------------------------");
					System.out.println("       < 강사평가 조회 메뉴입니다. >");
					System.out.println("----------------------------------");
					System.out.print("강사 이름>> ");
					String tName = scn.nextLine();
					List<Reply> rep = swimDao.repSearch(tName);
					for (Reply rep1 : rep) {
						System.out.println(rep1);
					}
					Teacher t = swimDao.getTeacher(tName);
					if (t != null && tName.equals(t.gettName())) {
						System.out.println("----------------------------------");
						System.out.println("    강사평을 삭제하시겠습니까? Y or N");
						System.out.println("----------------------------------");
						String answer = scn.nextLine();
						if (answer.equals("Y")) {
							System.out.println("----------------------------------");
							System.out.print("삭제할 번호를 입력하세요.");
							int repNum = Integer.parseInt(scn.nextLine());
							System.out.println("----------------------------------");
							Reply r = swimDao.repDetail(repNum);
							if (r != null && r.getUserName().equals(name1)) {
								swimDao.repDelete(repNum);
								System.out.println("평가 삭제가 완료되었습니다.");
								System.out.println("-----------------------------------");
							} else {
								System.out.println("삭제가 불가능합니다. 본인 확인 실패.");
							}
						} else if (answer.equals("N")) {
							System.out.println("처음메뉴로 돌아갑니다.");
						}
					} else {
						System.out.println("해당 강사 정보가 없습니다.");
					}
				} else if (menu1 == 4) {
					System.out.println("-----------------------------------");
					System.out.println("           프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("잘못된 번호입니다.");
				}
			}

			// -----관리자화면-----
			Swim swim = null;
			int payment = 0;
			int menu2 = 0;
			String course = "";

			// 등록
			if (menu == 1) {
				System.out.println("-----------------------------------");
				System.out.println("        < 회원등록메뉴입니다. >");
				System.out.println("----------------------------------");
				System.out.println("----------------------------------");
				System.out.print("회원이름을 입력하세요.");
				String userName = scn.nextLine();
				System.out.print("나이/성별을 입력하세요.");
				String userAge = scn.nextLine();
				boolean run = true;
				while (run) {
					System.out.println("휴대폰번호를 입력하세요. ex)010-xxxx-xxxx");
					String phoneNum = scn.nextLine();
					if (12 <= phoneNum.length() && phoneNum.length() <= 13) {
						System.out.println("반을 선택하세요 1.초급 2.중급 3.고급");
						menu2 = Integer.parseInt(scn.nextLine());
						if (menu2 == 1) {
							course = "초급";

						} else if (menu2 == 2) {
							course = "중급";

						} else if (menu2 == 3) {
							course = "고급";

						} else {
							System.out.println("반을 올바르게 선택하세요.");
						}
						swim = new Swim(0, userName, userAge, phoneNum, course, null);
						swimDao.insert(swim);
						System.out.println("-----------------------------------");
						System.out.println("회원정보가 등록되었습니다.");
					} else {
						System.out.println("휴대폰 번호를 올바르게 입력하세요. ");
						continue;
					}
					run = false;
				}

				// 조회
			} else if (menu == 2) {
				System.out.println("----------------------------------");
				System.out.println("         < 회원 목록입니다. >");
				System.out.println("----------------------------------");
				List<Swim> swimUser = swimDao.search();
				for (Swim swim1 : swimUser) {
					System.out.println(swim1);
				}


				// 상세조회
			} else if (menu == 3) {
				System.out.println("-----------------------------------");
				System.out.println("         회원 번호를 입력하세요.");
				System.out.println("----------------------------------");
				int userSeq = Integer.parseInt(scn.nextLine());
				Swim t = swimDao.getNum(userSeq);
				if (t != null) {
					if (userSeq == t.getUserSeq()) {
						System.out.println(t.toDetail());
					}
				} else {
					System.out.println("회원 정보가 없습니다.");
				}

				// 정보수정
			} else if (menu == 4) {
				System.out.println("-----------------------------------");
				System.out.println("  < 정보를 수정 할 회원번호를 입력하세요. >");
				System.out.println("----------------------------------");
				int userSeq = Integer.parseInt(scn.nextLine());
				Swim sw = swimDao.getNum(userSeq);
				if (sw != null && userSeq == sw.getUserSeq()) {
					System.out.println(swimDao.getNum(userSeq).toDetail());
					System.out.println("----------------------------------");
					System.out.println("     정말 수정하시겠습니까? Y or N");
					System.out.println("----------------------------------");
					String answer1 = scn.nextLine();
					if (answer1.equals("Y")) {
						Swim swim2 = swimDao.getNum(userSeq);

						if (swim2 != null) {
							if (userSeq == swim2.getUserSeq()) {
								int userNum = userSeq;
								System.out.print("회원이름은?>> ");
								String name2 = scn.nextLine();
								System.out.print("나이, 성별은?>> ");
								String age2 = scn.nextLine();
								System.out.print("전화번호는?>> ");
								String num2 = scn.nextLine();
								System.out.print("수강 코스는?>> ");
								String course2 = scn.nextLine();
								System.out.print("등록일시는?>> ");
								String cDate = scn.nextLine();

								swim = new Swim(userNum, name2, age2, num2, course2, cDate);
								swimDao.update(swim);
								System.out.println("-----------------------------------");
								System.out.println("회원수정이 완료되었습니다.");

							}
						}
					} else if (answer1.equals("N")) {
						System.out.println("처음메뉴로 돌아갑니다.");
						continue;
					}else {
						System.out.println("잘못된 응답입니다.");
					}
				} else {
					System.out.println("회원번호를 확인하세요.");
				}

				// 삭제
			} else if (menu == 5) {
				System.out.println("-----------------------------------");
				List<Swim> swimUser = swimDao.search();
				for (Swim swim1 : swimUser) {
					System.out.println(swim1);
				}
				System.out.println("----------------------------------");
				System.out.println("  < 정보를 삭제할 회원 번호를 입력하세요. >");
				System.out.println("----------------------------------");
				int userSeq = Integer.parseInt(scn.nextLine());
				Swim swim2 = swimDao.getNum(userSeq);
				if (swim2 != null) {
					System.out.println("----------------------------------");
					System.out.println("      정말 삭제하시겠습니까? Y or N");
					System.out.println("----------------------------------");
					String answer2 = scn.nextLine();
					if (answer2.equals("Y")) {
						if (swimDao.delete(userSeq)) {
							System.out.println("-----------------------------------");
							System.out.println("정상적으로 삭제.");
						}
					} else if (answer2.equals("N")) {
						System.out.println("처음메뉴로 돌아갑니다.");
						continue;
					} else {
						System.out.println("잘못된 명령어 입니다.");
						continue;
					}
				} else {
					System.out.println("회원 번호를 확인하세요!");
				}
				// 종료
			} else if (menu == 6) {
				System.out.println("-----------------------------------");
				System.out.println("       < 강사평가 조회 메뉴입니다. >");
				System.out.println("----------------------------------");
				List<Teacher> teachers = swimDao.teacherInfo();
				for (Teacher teacher : teachers) {
					System.out.println(teacher);
				}
				System.out.print("강사 이름>> ");
				String tName = scn.nextLine();
				List<Reply> rep = swimDao.repSearch(tName);
				for (Reply rep1 : rep) {
					System.out.println(rep1);
				}
			} else if (menu == 9) {
				System.out.println("-----------------------------------");
				System.out.println("           프로그램을 종료합니다.");
				break;
			}
		}
		scn.close();
		System.out.println("             안녕히가세요 !");
		System.out.println("-----------------------------------");
	}

}

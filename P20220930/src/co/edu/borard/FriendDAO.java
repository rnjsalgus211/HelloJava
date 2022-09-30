package co.edu.borard;

import java.util.Scanner;

//기능 입력
public class FriendDAO {
	private static FriendDAO instance = new FriendDAO();
	private FriendDAO() {}
	public static FriendDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Friend[] myFriend = new Friend[100];
	
	//1. 연락처 등록(연락처 순서, 이름, 
	//
	
}

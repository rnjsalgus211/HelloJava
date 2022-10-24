package co.edu.service;

import java.util.List;

import co.edu.vo.MemberVO;

//CRUD 기능
public interface MemberService {
	public void addMember(MemberVO vo); //추가 멤버VO
	public void modifymember (MemberVO vo); //수정
	public void removeMember (String id);
	public MemberVO findMember(String id);
	public List<MemberVO> memeberList();
	
	
}

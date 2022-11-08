package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo); //한사람 정보.
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	MemberVO memberLogin(String id, String password); //인터페이스를 왜 두개만드는지 보여줄려고 생성해놓음. 보통은 memberSelect 하나로 확인 가능.
	boolean isMemberIdCheck(String id); //아이디를 넘겨서 존재하면 false(사용할수없는id), 존재하지않으면 true를 리턴.
	        //is 붙이는 이유? 존재하면 false를 리턴시켜주기 위해서. is가 들어가면 관례적으로 false가 리턴된다고 보면 됨. boolean타입을 쓸 때는 초기값을 false로 선택하는게 좋다.
	
	
	
	
	
}

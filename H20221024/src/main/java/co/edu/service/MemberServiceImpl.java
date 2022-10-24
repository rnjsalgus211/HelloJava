package co.edu.service;

import java.util.List;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

//서비스 로직 : 실제 데이터베이스 - 등록,수정,삭제,조회
//MemberDAO에는 가장 작은(기본) 기능을 구현해놓고 서비스 로직에서 기능을 복합적으로 실행해주기 (ex. 조회후 삭제, 조회 후 입력 등)
//왜 memberService를 구현하는 것으로 만들것이냐? : .....답은 안나옴
public class MemberServiceImpl implements MemberService{

	MemberDAO dao = new MemberDAO();
	
	@Override
	public void addMember(MemberVO vo) {
		dao.memberInsert(vo);
	}

	@Override
	public void modifymember(MemberVO vo) {
		dao.memberUpdate(vo);
	}

	@Override
	public void removeMember(String id) {
		dao.memberDelete(id);
	}

	@Override
	public MemberVO findMember(String id) {
		return dao.memberSearch(id);
	}

	@Override
	public List<MemberVO> memeberList() {
		return dao.memberList();
	}

}

package co.newcomers.prj.member.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.newcomers.prj.common.DataSource;
import co.newcomers.prj.member.mapper.MemberMapper;
import co.newcomers.prj.member.service.MemberService;
import co.newcomers.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	@Override
	public List<MemberVO> memberList() {
		//회원 전체 리스트
		return map.memberList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		//회원 개인 리스트
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 회원가입
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 회원탈퇴
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		//회원수정
		return map.memberUpdate(vo);
	}

	@Override
	public MemberVO memberLogin(String id, String password) {
		//로그인
		return map.memberLogin(id, password);
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		//중복체크
		return map.isMemberIdCheck(id);
	}

}

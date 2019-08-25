package services;

import domains.MemberBean;

/**
 * 요구사항 (기능정의)
 * ****************
 * <사용자기능>
 * 1.회원가입
 * 2.마이페이지
 * 3.비번 수정
 * 4.회원탈퇴
 * 5.아이디 존재 체크
 * 6.로그인
 * *****************
 * <관리자기능>
 * 1.회원목록
 * 2.아이디검색
 * 3.이름검색
 * 4.전체 회원수
 *  
 **/
public class MemberService {
	private  MemberBean[] members;
	private int count;
	
	public MemberService() {
		members = new MemberBean[3];
		count = 0;
	}
	/**
	 * 1.회원가입
	 */
	public String join(MemberBean param) {
		String msg = "회원가입 완료";
		members[count] = param;
		count++;
		return msg;
	}
	/**
	 *2.마이 페이지
	 */
	public String getMyPage(MemberBean param) {
		return param.toString();
	}
	/**
	 * 3.비번변경(ID, 옛날비번, 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경 )
	 * 		       비번변경후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공, 옛날비번 로그인 실패
	 */
	public String changePw(MemberBean param) {
		String msg = "비밀번호가 변경되었습니다.";
		String pw = param.getPw();
		String[] pws = pw.split(",");
		String oldPw = pws[0];
		String newPw = pws[1];
		for(int i=0; i < count;i++) {
			if(param.getId().equals(members[i].getId())
					&& oldPw.equals(members[i].getPw())) {
				members[i].setPw(newPw);
				break;
			
			}
		}
		return msg;
	}/**
	 * 4.회원탈퇴
	 */
	public String withdrawal() {
		String msg = "";
		return msg;
	}/**
	 * 5.아이디 존재 체크
	 */
	public String existId(String id) {
		String msg = "없는 아이디입니다";
		for(int i = 0 ; i < count ; i++) {
			if(id.equals(members[i].getId())) {
				msg = "존재하는 아이디";
				break;
			}
		}		
		return msg;
	}/**
	 * 6.로그인(파라미터로 ID, PW 만 입력받은 상태)
	 */
	public String login(MemberBean param) {
		String msg = "로그인실패";
		for(int i = 0 ; i < count; i++) {
			if(param.getId().equals(members[i].getId())&& param.getPw().equals(members[i].getPw())) {
				msg = "로그인 성공";
				break;
			}
		}
		
		return msg;
	}
	
	
	
	
	
	/**
	 * 1.회원목록
	 */
	public String list() {
		String msg = "";
		for(int i = 0 ; i < count; i++) {
			msg += members[i].toString()+"\n";
		}
		return msg;
	}
}

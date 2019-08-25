package controllers;
import domains.MemberBean;
import services.MemberService;

import javax.swing.JOptionPane;

public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = null;
		String[] arr = null;
		String temp = "";
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료1.회원가입2.마이페이지3.비번변경4.회원탈퇴5.아이디존재체크6.로그인")) {
			case "0": JOptionPane.showMessageDialog(null, "종료");
				
				return;
			case "1":
				temp = JOptionPane.showInputDialog("이름, 아이디, 비밀번호, 주민번호, 혈액형, 키, 몸무게");
				arr = temp.split(",");
				System.out.println("****"+temp);
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				
				JOptionPane.showMessageDialog(null, service.join(member));
				
				break;
			case "2":
				
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				
				
				break;
			case "3":
				temp = JOptionPane.showInputDialog("아이디, 비밀번호, 새로운비밀번호");
				
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1] + ","+arr[2]);
				JOptionPane.showMessageDialog(null, service.changePw(member));
				break;
				
			case "4":
				
				break;
			case "5":
				String searchId = JOptionPane.showInputDialog("아이디 입력");
				String msg = service.existId(searchId);
				JOptionPane.showMessageDialog(null, msg);
				
				break;
			case "6":
				String loginValue = JOptionPane.showInputDialog("아이디, 비밀번호 입력");
				arr = loginValue.split(",");
				String loginId = arr[0];
				String loginPw = arr[1];
				member = new MemberBean();
				member.setId(loginId);
				member.setPw(loginPw);
				msg = service.login(member);
				JOptionPane.showMessageDialog(null, msg);
				
				break;

			default:
				break;
			}
		}
		
	}
}
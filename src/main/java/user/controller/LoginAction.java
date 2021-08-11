package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import movie.daogroup.UserDAO;
import movie.vogroup.UserVO;

public class LoginAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		String userid = req.getParameter("user_id");
		String pwd = req.getParameter("pwd");
		
		UserVO user = new UserVO(userid, pwd);
		
		UserDAO dao = new UserDAO();
		
		UserVO loginUser = dao.login(user);
		
		if(loginUser == null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println("id : " + loginUser.getUser_id());
			System.out.println("pwd : " + loginUser.getUser_pass());
			
			HttpSession ses = req.getSession();
			ses.setAttribute("loginUser", loginUser);
			
		}
		
		this.setRedirect(true);
		this.setViewPage("/Cinema/main/main.do");
	}

}

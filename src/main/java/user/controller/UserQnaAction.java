package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import movie.daogroup.UserDAO;
import movie.vogroup.ServiceVO;
import movie.vogroup.UserVO;

public class UserQnaAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("user_id");
		String con  = req.getParameter("pwd");
		
		
		System.out.println("title: "+ title);
		
		HttpSession ses = req.getSession();
		UserVO loginUser = (UserVO) ses.getAttribute("loginUser");
		
		ServiceVO service = new ServiceVO(null, title, con, null, loginUser.getUser_num());
		
		UserDAO dao = new UserDAO();
		
		boolean b = dao.addQna(service);
		if(b) {
			System.out.println("¼º°ø");
		}
		
		this.setRedirect(true);
		this.setViewPage("/Cinema/main/main.do");
		
	}

}

package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import movie.daogroup.UserDAO;
import movie.vogroup.UserVO;

public class JoinAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String user_id = req.getParameter("user_id");
		String pwd = req.getParameter("pwd");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String zip = "aaa";
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		
		UserVO user = new UserVO(user_id, pwd, "aaa", "144", "b","ABa",
				hp1, hp2, hp3, zip, addr1, addr2);
		
		System.out.println("join");
		
		UserDAO dao = new UserDAO();
		boolean b = dao.join(user);
		if(b) {
			System.out.println("추가완료");
			this.setRedirect(true);
			this.setViewPage("/Cinema/main/main.do");
		}
	}

}

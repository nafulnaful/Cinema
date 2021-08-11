package service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import movie.daogroup.ServiceDAO;
import movie.vogroup.AnswerVO;
import movie.vogroup.ServiceVO;
import movie.vogroup.UserVO;

public class AnswerAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String con = req.getParameter("user_id");
		
		HttpSession ses = req.getSession();
		UserVO loginUser = (UserVO) ses.getAttribute("loginUser");
		
		ServiceDAO dao = new ServiceDAO();
		ServiceVO service = dao.selectService(5);
		
		AnswerVO answer = new AnswerVO(null, loginUser.getUser_id(), null, con, service.getService_num());
		boolean b = dao.answer(answer);
		if(b) {
			System.out.println("답변 성공");
		}
		this.setRedirect(true);
		this.setViewPage("/Cinema/main/main.do");
		
		
	}

}

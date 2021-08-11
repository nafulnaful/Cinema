package user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import movie.daogroup.UserDAO;
import movie.vogroup.ServiceVO;
import movie.vogroup.UserVO;

public class MyQnaListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		HttpSession ses = req.getSession();
		UserVO loginUser = (UserVO) ses.getAttribute("loginUser");
		UserDAO dao = new UserDAO();
		List<ServiceVO> service =  dao.myQnaList(loginUser);
		
		for(ServiceVO s : service) {
			System.out.println(s.getService_title() + "/ " + s.getService_con());
		}
		this.setRedirect(true);
		this.setViewPage("/Cinema/main/main.do");
		
	}

}

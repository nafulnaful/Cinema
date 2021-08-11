package book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import movie.daogroup.BookDAO;
import movie.vogroup.BookVO;
import movie.vogroup.UserVO;

public class BookAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession ses = req.getSession();
		UserVO loginUser = (UserVO) ses.getAttribute("loginUser");
		if(loginUser == null) {
			//로그인 안되어있음
			this.setViewPage("/Cinema/user/login.do");
			this.setRedirect(false);
			return;
		}
		
		String np = req.getParameter("book_np");
		String seat = req.getParameter("book_seat");
		String point = req.getParameter("book_point");
		String price = req.getParameter("book_price");
		String time_num = req.getParameter("time_num");
	
	/*	
		String np = "5";
		String seat = "a1/a2/a3/a4/a5";
		String point = "1000";
		String price = "50000";
	*/		
		BookVO book = new BookVO(null, Integer.parseInt(np), seat, Integer.parseInt(point),
				Integer.parseInt(price), null, "y", time_num, loginUser.getUser_num());
		
		BookDAO dao = new BookDAO();
		boolean b = dao.addBook(book);
		if(b) {
			// 성공
			req.setAttribute("myBook", book);
			this.setViewPage("/book/checkBook.jsp");
			this.setRedirect(false);
		} else {
			// 실패
			this.setViewPage("/book/book.jsp");
			this.setRedirect(false);
		}
		
		
	}

}

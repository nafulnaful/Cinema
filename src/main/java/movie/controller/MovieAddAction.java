package movie.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import movie.daogroup.MovieDAO;

public class MovieAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		
		String inputDate= "2021-08-21";
		java.sql.Date d = java.sql.Date.valueOf(inputDate);
		
		MovieDAO dao = new MovieDAO();
	}

}

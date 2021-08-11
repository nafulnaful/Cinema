<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="net.sf.json.*, movie.vogroup.*,movie.daogroup.*, java.util.*"%>
<jsp:useBean id="CinemaDao" class="movie.daogroup.CinemaDAO" scope="session"/>
<%
	String str = request.getParameter("room");
	List<TimeVO> arr=CinemaDao.timeList(str);
	
	JSONArray jsonArr=JSONArray.fromObject(arr);
	//fromObject(arr) : static 메소드
	//ArrayList를 JSONArray유형으로 변환해줌.

%>
<%=jsonArr.toString()%>
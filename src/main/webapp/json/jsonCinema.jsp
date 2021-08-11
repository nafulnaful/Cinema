<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="net.sf.json.*, movie.vogroup.*,movie.daogroup.*, java.util.*"%>
<jsp:useBean id="CinemaDao" class="movie.daogroup.CinemaDAO" scope="session"/>
<%
	List<CinemaVO> arr=CinemaDao.cinemaList();
	
	JSONArray jsonArr=JSONArray.fromObject(arr);
	//fromObject(arr) : static 메소드
	//ArrayList를 JSONArray유형으로 변환해줌.

%>
<%=jsonArr.toString()%>
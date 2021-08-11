package movie.daogroup;

import java.util.List;

import common.dao.DAOMyBatis;
import movie.vogroup.CinemaVO;
import movie.vogroup.RoomVO;
import movie.vogroup.SeatVO;
import movie.vogroup.TimeVO;

public class CinemaDAO extends DAOMyBatis {

	private final String NS = "movie.mapper.CinemaMapper";

	// ±ØÀå
	public List<CinemaVO> cinemaList() {
		try {
			ses = this.getSessionFactory().openSession();
			List<CinemaVO> cinema = ses.selectList(NS+".cinemaList");
			return cinema;
		} finally {
			close();
		}
	}

	// »ó¿µ°ü
	public List<RoomVO> roomList(String str) {
		try {
			ses = this.getSessionFactory().openSession();
			List<RoomVO> room = ses.selectList(NS+".roomList", str);
			return room;
		} finally {
			close();
		}
	}

	// ½Ã°£
	public List<TimeVO> timeList(String str) {
		try {
			ses = this.getSessionFactory().openSession();
			List<TimeVO> time = ses.selectList(NS+".timeList", str);
			return time;
		} finally {
			close();
		}
	}
	
	public boolean addTime(TimeVO timeVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addTime", timeVo);
			return transaction(cnt);
		}finally {
			close();
		}
	}

	// ÁÂ¼®
	public List<SeatVO> seatList(String str) {
		try {
			ses = this.getSessionFactory().openSession();
			List<SeatVO> seat = ses.selectList(NS+".seatList", str);
			return seat;
		} finally {
			close();
		}
	}
	
	public boolean updateSeat(SeatVO seatVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.update(NS+".updateSeat", seatVo);
			return transaction(cnt);
		} finally {
			close();
		}
	}
}
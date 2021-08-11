package movie.daogroup;

import java.util.List;

import common.dao.DAOMyBatis;
import movie.vogroup.EventVO;
import movie.vogroup.StoreVO;

public class EventDAO extends DAOMyBatis {

	private final String NS="movie.mapper.EventMapper";
	
	// 스토어
	public List<StoreVO> storeList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<StoreVO> store = ses.selectList(NS+".storeList");
			return store;
		} finally {
			close();
		}
	}
	
	public boolean addStore(StoreVO storeVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addStore", storeVo);
			return transaction(cnt);
		} finally {
			close();
		}
	}
	
	
	// 이벤트
	public List<EventVO> eventList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<EventVO> event = ses.selectList(NS+".eventList");
			return event;
		} finally {
			close();
		}
	}
	
	public boolean addEvent(EventVO eventVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addEvent", eventVo);
			return this.transaction(cnt);
		} finally {
			close();
		}
	}
	
}
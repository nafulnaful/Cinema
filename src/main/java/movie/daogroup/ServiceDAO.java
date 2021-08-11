package movie.daogroup;

import java.util.List;

import common.dao.DAOMyBatis;
import movie.vogroup.AnswerVO;
import movie.vogroup.ServiceVO;

public class ServiceDAO extends DAOMyBatis {

	private final String NS="movie.mapper.ServiceMapper";
	
	// qna
	public List<ServiceVO> qnaList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<ServiceVO> service = ses.selectList(NS+".qnaList");
			return service;
		} finally {
			close();
		}
	}
	
	// 문의 답변
	public boolean answer(AnswerVO answerVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".answer", answerVo);
			return this.transaction(cnt);
		} finally {
			close();
		}
		
	}
	
	public ServiceVO selectService(int num) {
		try {
			ses = this.getSessionFactory().openSession();
			ServiceVO service = ses.selectOne(NS+".selectService", num);
			return service;
		}finally {
			close();
		}
	}
	
}
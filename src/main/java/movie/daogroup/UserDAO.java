package movie.daogroup;

import java.util.List;

import common.dao.DAOMyBatis;
import movie.vogroup.ServiceVO;
import movie.vogroup.UserVO;

public class UserDAO extends DAOMyBatis {

	private final String NS="movie.mapper.UserMapper";
	
	// �α���
	public UserVO login(UserVO userVo) {
		try {
			ses = this.getSessionFactory().openSession();
			UserVO user = ses.selectOne(NS + ".login", userVo);
			return user;
		}finally {
			close();
		}
	}
	// ȸ������
	public boolean join(UserVO userVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".join", userVo);
			return this.transaction(cnt);
		}finally {
			close();
		}
	}
	
	// qna
	public List<ServiceVO> myQnaList(UserVO userVo){
		try {
			ses = this.getSessionFactory().openSession();
			List<ServiceVO> qnaList = ses.selectList(NS + ".myQnaList", userVo);
			return qnaList;
			
		} finally {
			close();
		}
	}
	
	public boolean addQna(ServiceVO serviceVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addQna", serviceVo);
			return transaction(cnt);
		} finally {
			close();
		}
		
		
	}
	
	// ���ų��� - ��ȭ��, �̹���, �󿵰�, �ð�
	
}
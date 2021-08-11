package movie.daogroup;

import common.dao.DAOMyBatis;
import movie.vogroup.BookVO;

public class BookDAO extends DAOMyBatis {

	private final String NS="movie.mapper.BookMapper";
	// ¿¹¸Å
	
	public boolean addBook(BookVO bookVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addBook", bookVo);
			return transaction(cnt);
		} finally {
			close();
		}
	}
}
package movie.daogroup;

import java.util.List;

import common.dao.DAOMyBatis;
import movie.vogroup.MovieVO;
import movie.vogroup.ReviewVO;

public class MovieDAO extends DAOMyBatis {

	private final String NS="movie.mapper.MovieMapper";
	
	// 영화관련 
	public List<MovieVO> boxOfficeList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<MovieVO> movie = ses.selectList(NS+".boxOfficeList");
			return movie;
		} finally {
			close();
		}
	}
	
	public List<MovieVO> newMovieList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<MovieVO> movie = ses.selectList(NS+".newMovieList");
			return movie;
		} finally {
			close();
		}
	}
	
	public List<MovieVO> planMovieList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<MovieVO> movie = ses.selectList(NS+".planMovieList");
			return movie;
		} finally {
			close();
		}
	}
	
	public List<MovieVO> findMovieList(String name){
		try {
			ses = this.getSessionFactory().openSession();
			List<MovieVO> movie = ses.selectList(NS+".findMovieList", name);
			return movie;
		} finally {
			close();
		}
	}
	
	public boolean addMovie(MovieVO movieVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addMovie", movieVo);
			return transaction(cnt);
		} finally {
			close();
		}
	}
	
	// 리뷰
	public List<ReviewVO> reviewList(){
		try {
			ses = this.getSessionFactory().openSession();
			List<ReviewVO> review = ses.selectList(NS+".reviewList");
			return review;
		} finally {
			close();
		}
	}
	
	public boolean addReview(ReviewVO reviewVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".addReview", reviewVo);
			return this.transaction(cnt);
		} finally {
			close();
		}
	}
	
}
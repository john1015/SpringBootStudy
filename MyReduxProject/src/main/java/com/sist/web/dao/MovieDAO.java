package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;

@Repository
public interface MovieDAO extends JpaRepository<MovieEntity, Integer>{
	//9개의 데이터 ==> Main에 출력
	@Query(value="SELECT mno,mtitle,mposter,msynop,mtime,mdirector,likecount,mgenre "
			+ "   FROM movie ORDER BY mrate DESC "
			+ "   LIMIT 0,5",nativeQuery = true) 
	public List<MovieVO> MovieHitTOP5();
	
	
	public MovieEntity findBymno(int mno);
	
	@Query(value="SELECT mno,mtitle,mposter,mgenre,mgrade"
			+ "	  FROM movie ORDER BY mcount ASC "
			+ "   LIMIT :start,12",nativeQuery = true)
	public List<MovieVO> movieListData(@Param("start") int start);
	
	@Query(value = "SELECT mno, mtitle, mposter, mgenre, mgrade " +
            "FROM movie " +
            "WHERE (:mtitle = 'all' OR mtitle LIKE concat('%', :mtitle, '%')) " +
            "ORDER BY mno ASC " +
            "LIMIT :start, 12", nativeQuery = true)
	public List<MovieVO> movieFindData(@Param("start") int start, @Param("mtitle") String mtitle);


	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) " +
            "FROM movie " +
            "WHERE (:mtitle = 'all' OR mtitle LIKE concat('%', :mtitle, '%'))")
	public int movieFindTotalPage(@Param("mtitle") String mtitle);

	
	
}

package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;

@Repository
public interface MovieStoreDAO extends JpaRepository<MovieStoreEntity, Integer>{
	//9개의 데이터 ==> Main에 출력
	@Query(value="SELECT mgno ,mgname,mgposter,mgprice,mgdetail "
			+ "   FROM movie_store ORDER BY rand() "
			+ "   LIMIT 0,12",nativeQuery = true) 
	public List<MovieStoreVO> MovieStoreHitTOP5();
	public MovieStoreEntity findBymgno(int mgno);
	
}

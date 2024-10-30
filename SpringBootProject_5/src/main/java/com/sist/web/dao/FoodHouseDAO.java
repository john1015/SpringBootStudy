package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;

@Repository
public interface FoodHouseDAO extends JpaRepository<FoodHouseEntity, Integer>{
	//9개의 데이터 ==> Main에 출력
	@Query(value="SELECT fno,name,poster,score,hit,jjimcount,type,content,theme "
			+ "   FROM food_house ORDER BY hit DESC "
			+ "   LIMIT 0,9",nativeQuery = true)
	public List<FoodHouseVO> foodHitTOP9();
	
	// SELECT * FROM food_house WHERE fno=? => 자동 SQL문장 이용
	public FoodHouseEntity findByFno(int fno);
}

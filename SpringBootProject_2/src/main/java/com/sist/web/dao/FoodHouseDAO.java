package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.sist.web.entity.FoodHouseData;
import com.sist.web.entity.FoodHouseEntity;
/*
 *   지원 자격 
 *     Java,Spring,
 *     
 *     Mysql
 *      1. 페이징 => LIMIT 시작 , 갯수  
 *      2. LIKE => '%'||?||'%'  => CONCAT('%',?,'%')
 *      3. DATE => DATETIME => sysdate : now() 
 *      4. NVL => isnull
 *      
 *      => 오라클     mysql(mariadb) => 3306 (driver동일) 
 *         NUMBER      int , double
 *         VARCHAR2    varchar
 *         CLOB        text
 *         DATE        datatime 
 */
@Repository
public interface FoodHouseDAO extends JpaRepository<FoodHouseEntity, Integer>{
   // 목록 출력 
   @Query(value="SELECT fno,poster,name FROM food_house ORDER BY fno ASC "
		 +"LIMIT :start,12",nativeQuery = true)
   // #{start} => :
   public List<FoodHouseData> foodListData(@Param("start") int start);
   // 상세보기
   public FoodHouseEntity findByFno(int fno);
   // SELECT * FROM food_hosue WHERE fno=?
   // Hit 증가 = update (save())
   // 검색 ...
   // CRUD => 게시판 
   
}

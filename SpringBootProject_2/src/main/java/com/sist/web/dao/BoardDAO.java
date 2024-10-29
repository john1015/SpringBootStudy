package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;
import java.util.*;
@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
     public BoardEntity findByNo(int no); // 상세보기 
     // SELECT no,name,subject,content.regdate,hit FROM board where no=?
     // insert(save) , update(save) , delete(delete()) , count()
     // TO_CHAR => date_format(%Y-%m-%d)
     @Query(value="SELECT no,name,subject,content,date_format(regdate,'%Y-%m-%d') as regdate,hit "
    		     +"FROM board ORDER BY no DESC "
    		     +"LIMIT :start,10",nativeQuery = true)
     public List<BoardData> boardListData(@Param("start") int start);
     // => 가독성 (X) , 적은 코딩으로 사용이 가능 
     //    ========= MyBatis => 8:2 => Link
}

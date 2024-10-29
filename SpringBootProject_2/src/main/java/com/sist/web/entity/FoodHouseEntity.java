package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 *   VO
 *   DTO 
 *   Entity : 다른 데이터를 첨부할 수 없다 , 테이블의 컬럼만 추가 
 *            컬럼명과 동일 
 *            => INSERT,UPDATE,DELETE문장을 생성 
 *            => SELECT : SQL문장 / 자동 SQL문장 생성 
 *            => 검색 
 *               findBy컬럼명()
 *               => findByFno(int fno) 
 *               => WHERE fno=
 *               => 메소드로 SQL문장을 처리 
 *               => JPA (Hibernate) => 자동 SQL문장 제작 : 메소드 패턴 
 *               => address="" AND type=""
 *               => findByAddressAndType(String address,String type)
 *                  =================================================
 *                  SQL제작 
 *       FNO int 
NAME text 
TYPE text 
PHONE text 
ADDRESS text 
SCORE double 
THEME text 
POSTER text 
IMAGES text 
TIME text 
PARKING text 
CONTENT text 
RDAYS text 
JJIMCOUNT int 
LIKECOUNT int 
HIT int 
REPLYCOUNT int
 */
@Entity(name = "food_house")
@Data
public class FoodHouseEntity {
   @Id //sequence 
   private int fno;
   private int jjimcount,likecount,hit,replycount;
   private String name,phone,address,theme,poster,images,time,parking,content,rdays,type;
   private double score;
}

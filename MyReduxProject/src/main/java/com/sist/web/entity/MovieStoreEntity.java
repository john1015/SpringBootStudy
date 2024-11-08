package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
 * 	MGNO int 
	MGNAME text 
	MGPOSTER text 
	MGPRICE text 
	MGDETAIL text
 */
@Entity(name="movie_store")
@Data
public class MovieStoreEntity {
	@Id
	private int mgno;
	private String mgname,mgposter,mgprice,mgdetail;
}

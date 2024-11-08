package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "movie")
@Data
public class MovieEntity {
   @Id //sequence 
   private int mno;
	private String mtitle,mgenre,mposter,mtime,mdirector,mactor,
		mgrade,mrdate,msynop,mrate,mnation;
	private int mcount,mtype,mstate,likecount;
}

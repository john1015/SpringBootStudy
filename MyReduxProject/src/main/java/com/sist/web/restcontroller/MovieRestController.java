package com.sist.web.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.dao.*;

@RestController
@CrossOrigin(origins = "*") // ip http://localhost:3000
// port가 같은 경우에만 접근이 가능
// => 3000 => 80 : 해제
public class MovieRestController {
	@Autowired
	private MovieDAO mDao;
	@Autowired
	private MovieStoreDAO msDao;

	// 자동 JSON변환 => Jackson => ObjectMapper
	@GetMapping("/main_react")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Map> foodMainTopData() {
		Map map = new HashMap();
		try {
			List<MovieVO> mList = mDao.MovieHitTOP5();
			List<MovieStoreVO> msList = msDao.MovieStoreHitTOP5();
			map.put("mList", mList);
			map.put("msList", msList);
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/movie/list/{page}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Map> movie_list(@PathVariable("page") int page) {
		Map map = new HashMap();
		try {
			int start = (page*12)-12;
			List<MovieVO> list = mDao.movieListData(start);
			int count=(int)mDao.count();
			int totalpage = (int)(Math.ceil(count/12.0));
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage) endPage=totalpage;
			map.put("mList",list);
			map.put("curpage",page);
			map.put("totalpage",totalpage);
			map.put("startPage",startPage);
			map.put("endPage",endPage);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("store/list/{page}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Map> store_list(@PathVariable("page") int page) {
		Map map = new HashMap();
		try {
			int start = (page*12)-12;
			List<MovieStoreVO> list = msDao.MovieStoreHitTOP5();
			int count=(int)msDao.count();
			int totalpage = (int)(Math.ceil(count/12.0));
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage) endPage=totalpage;
			map.put("sList",list);
			map.put("curpage",page);
			map.put("totalpage",totalpage);
			map.put("startPage",startPage);
			map.put("endPage",endPage);
		} catch (Exception e) {
			new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("movie/find/{page}/{mtitle}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Map> movie_find(@PathVariable("page") int page,@PathVariable("mtitle") String mtitle) {
		Map map = new HashMap();
		try {
			int start = (page*12)-12;
			System.out.println(mtitle);
				List<MovieVO> list = mDao.movieFindData(start,mtitle);
			int totalpage = mDao.movieFindTotalPage(mtitle);
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage) endPage=totalpage;
			
			map.put("fList",list);
			map.put("curpage",page);
			map.put("totalpage",totalpage);
			map.put("startPage",startPage);
			map.put("endPage",endPage);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("movie/detail/{mno}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<MovieEntity> movie_detail(@PathVariable("mno") int mno) {
		
		MovieEntity vo = mDao.findBymno(mno);
		try {
			vo.setMcount(vo.getMcount()+1); // 조회수 증가
			mDao.save(vo);
			vo=mDao.findBymno(mno);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	@GetMapping("store/detail/{mgno}")
	public ResponseEntity<MovieStoreEntity> movie_store_detail(@PathVariable("mgno") int mgno) {
		
		MovieStoreEntity vo = msDao.findBymgno(mgno);
		try {
			vo=msDao.findBymgno(mgno);
		} catch (Exception e) {
			new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	
}

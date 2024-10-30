package com.sist.web.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.dao.*;

@RestController
@CrossOrigin(origins = "*") // ip http://localhost:3000
// port가 같은 경우에만 접근이 가능
// => 3000 => 80 : 해제
public class FoodHouseRestController {
	@Autowired
	private FoodHouseDAO fDao;
	@Autowired
	private RecipeDAO rDao;
	@Autowired
	private ChefDAO cDao;

	// 자동 JSON변환 => Jackson => ObjectMapper
	@GetMapping("food/main_react")
	public Map foodMainTopData() {
		Map map = new HashMap();
		List<FoodHouseVO> fList = fDao.foodHitTOP9();
		List<RecipeEntity> rList = rDao.recipeMainData();
		ChefEntity vo = cDao.findByChef("핑콩이");
		map.put("fList", fList);
		map.put("rList", rList);
		map.put("vo", vo);

		return map;
	}
}

package com.naver.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.reservation.detail.dto.DetailInfo;
import com.naver.reservation.detail.dto.DisplayInfo;
import com.naver.reservation.main.dto.MainProduct;
import com.naver.reservation.service.DetailPageService;
import com.naver.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	DetailPageService detailPageService;

	
	@GetMapping(path = "/products/{id}/{start}")
	public Map<String, Object> ProductList(@PathVariable(name= "id") int id, @PathVariable(name="start") int start){
		Map<String, Object> map = new HashMap<>();
		
		if(id == 0) {
			List<MainProduct> list = reservationService.getProductAll(start);
			Integer length = reservationService.selectCount();
			map.put("product", list);
			map.put("length", length);
			
		}else if (0 < id && id < 6) {
			List<MainProduct> list = reservationService.getProductByCategoryId(id, start);
			Integer length = reservationService.selectCountByCategoryId(id);
			map.put("product", list);
			map.put("length", length);
		}
		return map;
	}
	@GetMapping(path = "/detail/detailInfo/{id}")
	public List<DetailInfo> getDetailInfos(@PathVariable(name="id") int id){
		List<DetailInfo> list = detailPageService.getDetailInfo(id);
		return list;
	}
	@GetMapping(path = "/detail/roadMap/{id}")
	public List<DisplayInfo> getDisplayInfos(@PathVariable(name="id")int id){
		List<DisplayInfo> list = detailPageService.getDisplayInfos(id);
		return list;
	}

}

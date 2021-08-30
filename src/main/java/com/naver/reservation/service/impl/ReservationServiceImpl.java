package com.naver.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.main.dao.MainProductDao;
import com.naver.reservation.main.dto.MainProduct;
import com.naver.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	MainProductDao mainProductDao;
	
	@Override
	@Transactional
	public List<MainProduct> getPromotionInfo(String type) {
		List<MainProduct> list = mainProductDao.getPromotionInfo(type);
		return list;
	}

	@Override
	@Transactional
	public List<MainProduct> getProductAll(int start) {
		List<MainProduct> list = mainProductDao.getProductAll(start);
		return list;
	}

	@Override
	@Transactional
	public List<MainProduct> getProductByCategoryId(int id, int start) {
		List<MainProduct> list = mainProductDao.getProductByCategoryId(id, start);
		return list;
	}
	@Override
	@Transactional
	public List<MainProduct> getAllProductByCategoryId(int id, int start){
		List<MainProduct> list = mainProductDao.getAllProductByCategoryId(id, start);
		return list;
	}
	
	@Override
	@Transactional
	public Integer selectCount() {
		Integer length = mainProductDao.selectCount();
		return length;
	}
	
	@Override
	@Transactional
	public Integer selectCountByCategoryId(int id) {
		Integer length = mainProductDao.selectCountByCategoryId(id);
		return length;
	}

}

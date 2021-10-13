package com.naver.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.main.dao.CategoryDao;
import com.naver.reservation.main.dao.MainProductDao;
import com.naver.reservation.main.dto.Category;
import com.naver.reservation.main.dto.MainProduct;
import com.naver.reservation.service.MainPageService;

@Service
public class MainPageServiceImpl implements MainPageService {
	@Autowired
	MainProductDao mainProductDao;
	
	@Autowired
	CategoryDao categoryDao;
	
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
	public List<MainProduct> getAllProductByCategoryId(int id){
		List<MainProduct> list = mainProductDao.getAllProductByCategoryId(id);
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
	
	@Transactional
	@Override
	public List<Category> getCategories(){
		List<Category> list = categoryDao.getCategory();
		return list;
	}

}

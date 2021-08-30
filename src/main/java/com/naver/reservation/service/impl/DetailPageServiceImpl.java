package com.naver.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.detail.dao.DetailInfoDao;
import com.naver.reservation.detail.dao.DisplayInfoDao;
import com.naver.reservation.detail.dto.DetailInfo;
import com.naver.reservation.detail.dto.DisplayInfo;
import com.naver.reservation.detail.dto.ProductPrice;
import com.naver.reservation.detail.dto.ReservationInfo;
import com.naver.reservation.detail.dao.ProductPriceDao;
import com.naver.reservation.detail.dao.ReservationInfoDao;
import com.naver.reservation.service.DetailPageService;

@Service
public class DetailPageServiceImpl implements DetailPageService {
	@Autowired
	DetailInfoDao detailInfoDao;
	@Autowired
	ProductPriceDao productPriceDao;
	@Autowired
	ReservationInfoDao reservationInfoDao;
	@Autowired
	DisplayInfoDao displayInfoDao;
	
	
	@Override
	@Transactional
	public List<DetailInfo> getDetailInfo(int id) {
		List<DetailInfo> list = detailInfoDao.getDetailInfo(id);
		return list;
	}
	
	@Override
	@Transactional
	public int getDetailInfoCount(int id) {
		int count = detailInfoDao.getDetailInfoCount(id);
		return count;
	}
	
	@Override
	@Transactional
	public List<ProductPrice> getProductPrices(int id){
		List<ProductPrice> list = productPriceDao.getProductPrices(id);
		return list;
	}

	@Override
	@Transactional
	public List<ReservationInfo> getReview(int id){
		List<ReservationInfo> list = reservationInfoDao.getReview(id);
		return list;
	}
	
	@Override
	@Transactional
	public List<DisplayInfo> getDisplayInfos(int id){
		List<DisplayInfo> list = displayInfoDao.getDisplayInfos(id);
		return list;
	}
}

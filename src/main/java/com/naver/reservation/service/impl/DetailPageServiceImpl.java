package com.naver.reservation.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.detail.dao.DetailInfoDao;
import com.naver.reservation.detail.dao.DisplayInfoDao;
import com.naver.reservation.detail.dao.FileNameDao;
import com.naver.reservation.detail.dto.DetailInfo;
import com.naver.reservation.detail.dto.DisplayInfo;
import com.naver.reservation.detail.dto.FileName;
import com.naver.reservation.detail.dto.ProductPrice;
import com.naver.reservation.detail.dto.ProductSpecificInfo;
import com.naver.reservation.detail.dao.ProductPriceDao;
import com.naver.reservation.detail.dao.ProductspecificInfoDao;
import com.naver.reservation.service.DetailPageService;

@Service
public class DetailPageServiceImpl implements DetailPageService {
	@Autowired
	DetailInfoDao detailInfoDao;
	@Autowired
	ProductPriceDao productPriceDao;
	@Autowired
	ProductspecificInfoDao productspecificInfoDao;
	@Autowired
	DisplayInfoDao displayInfoDao;
	@Autowired
	FileNameDao fileNameDao;
	
	
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
	public List<ProductSpecificInfo> getReview(int productId){
		List<ProductSpecificInfo> list = productspecificInfoDao.getReview(productId);
		return list;
	}
	@Transactional
	@Override
	public List<ProductSpecificInfo> getReviewByReservationCommentId(int reservationCommentId){
		List<ProductSpecificInfo> list = productspecificInfoDao.getReviewByReservationCommentId(reservationCommentId);
		List<String> fileNameList = new LinkedList<>();
		getFileNames(list.get(0).getReservationUserCommentId()).forEach((fileName)->{
			String saveFileName = fileName.getSaveFileName(); 
			fileNameList.add(saveFileName);
		});
		list.get(0).setSaveFileName(fileNameList);
		
		return list;
	}
	
	@Override
	@Transactional
	public List<DisplayInfo> getDisplayInfos(int id){
		List<DisplayInfo> list = displayInfoDao.getDisplayInfos(id);
		return list;
	}

	@Override
	@Transactional
	public List<FileName> getFileNames(int reservationUserCommentId) {
		List<FileName> list = fileNameDao.getFileNames(reservationUserCommentId);
		return list;
	}
	
}

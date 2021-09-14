package com.naver.reservation.service;

import java.util.List;

import com.naver.reservation.detail.dto.DetailInfo;
import com.naver.reservation.detail.dto.DisplayInfo;
import com.naver.reservation.detail.dto.ProductPrice;
import com.naver.reservation.detail.dto.ProductSpecificInfo;

public interface DetailPageService {
	public List<DetailInfo> getDetailInfo(int id);
	public int getDetailInfoCount(int id);
	public List<ProductPrice> getProductPrices(int id);
	public List<ProductSpecificInfo> getReview(int id);
	public List<DisplayInfo> getDisplayInfos(int id);
}

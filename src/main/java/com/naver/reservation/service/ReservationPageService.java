package com.naver.reservation.service;

import java.util.List;
import java.util.Map;

import com.naver.reservation.reservation.dto.ReservationInfo;
import com.naver.reservation.reservation.dto.ReservationInfoPrice;
import com.naver.reservation.reservation.dto.ReservationPageInfo;

public interface ReservationPageService {
	public List<ReservationPageInfo> getReservationPageInfo(int id);

	public Integer insertAction(String tableName, Object object);

	public List<ReservationInfo> reservation(ReservationInfo reservationInfo, List<ReservationInfoPrice> reservationInfoPrice, List<ReservationInfo> resultContainer);
	public Map<String, Object> reservation(ReservationInfo reservationInfo, List<ReservationInfoPrice> reservationInfoPrice);
	public List<ReservationInfo> getReservationInfos(int id);
	public List<ReservationInfoPrice> getReservationInfoPrices(int ReservationInfoId);
	public Map<String,Object> cancelReservation(int id);
}

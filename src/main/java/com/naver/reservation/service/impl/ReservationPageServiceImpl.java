package com.naver.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.reservation.dao.ReservationInfoDao;
import com.naver.reservation.reservation.dao.ReservationInfoPriceDao;
import com.naver.reservation.reservation.dao.ReservationPageInfoDao;
import com.naver.reservation.reservation.dto.ReservationInfo;
import com.naver.reservation.reservation.dto.ReservationInfoPrice;
import com.naver.reservation.reservation.dto.ReservationPageInfo;
import com.naver.reservation.service.ReservationPageService;

@Service
public class ReservationPageServiceImpl implements ReservationPageService {
	@Autowired
	ReservationPageInfoDao reservationPageInfoDao;
	@Autowired
	ReservationInfoDao reservationInfoDao;
	@Autowired
	ReservationInfoPriceDao reservationInfoPriceDao;

	@Override
	@Transactional
	public List<ReservationPageInfo> getReservationPageInfo(int id) {
		List<ReservationPageInfo> list = reservationPageInfoDao.getReservationPageInfo(id);
		return list;
	}

	@Override
	@Transactional
	public Integer insertAction(String tableName, Object object) {
		return reservationPageInfoDao.insertAction(tableName, object);
	}

	@Override
	@Transactional
	public HashMap<String, Object> reservation(ReservationInfo reservationInfo,
			List<ReservationInfoPrice> reservationInfoPriceList) {
		int reservationInfoKey = insertAction("reservation_info", reservationInfo);
		for (int i =0; i < reservationInfoPriceList.size(); i++) {
			reservationInfoPriceList.get(i).setReservationInfoId(reservationInfoKey);
			insertAction("reservation_info_price", reservationInfoPriceList.get(i));
		}
		List<ReservationInfo> reservationInfoList = reservationInfoDao.getReservationInfos(reservationInfoKey);
		List<ReservationInfoPrice> rpl = reservationInfoPriceDao
				.getReservationInfoPrices(reservationInfoKey);
		reservationInfo = reservationInfoList.get(0);

		HashMap<String, Object> map = new HashMap<>();
		map.put("reservationInfo", reservationInfo);
		map.put("prices", rpl);
		return map;
	}
	
	@Transactional
	@Override
	public List<ReservationInfo> reservation(ReservationInfo reservationInfo,
			List<ReservationInfoPrice> reservationInfoPriceList, List<ReservationInfo> resultContainer) {
		int reservationInfoKey = insertAction("reservation_info", reservationInfo);
		for (int i =0; i < reservationInfoPriceList.size(); i++) {
			reservationInfoPriceList.get(i).setReservationInfoId(reservationInfoKey);
			insertAction("reservation_info_price", reservationInfoPriceList.get(i));
		}
		resultContainer = reservationInfoDao.getReservationInfos(reservationInfoKey);
	

		return resultContainer;
	}


	@Transactional
	@Override
	public List<ReservationInfo> getReservationInfos(int id) {
		List<ReservationInfo> list = reservationInfoDao.getReservationInfos(id);
		return list;
	}

	@Transactional
	@Override
	public List<ReservationInfoPrice> getReservationInfoPrices(int ReservationInfoId) {
		List<ReservationInfoPrice> list = reservationInfoPriceDao.getReservationInfoPrices(ReservationInfoId);
		return list;

	}
	
	@Transactional
	@Override
	public Map<String, Object> cancelReservation(int id) {
		int key = reservationInfoDao.cancelReservation(id);
		List<ReservationInfo> reservationInfoList = reservationInfoDao.getReservationInfos(key);
		int reservationInfoId = reservationInfoList.get(0).getId();
		List<ReservationInfoPrice> reservationInfoPriceList = reservationInfoPriceDao.getReservationInfoPrices(reservationInfoId);
		Map<String, Object> map = new HashMap<>();
		map.put("reservationInfo", reservationInfoList.get(0));
		map.put("prices", reservationInfoPriceList);
		
		return map;
	}
}

package com.naver.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.confirmreservation.dao.ConfirmReservationDao;
import com.naver.reservation.confirmreservation.dao.ReservationPriceDao;
import com.naver.reservation.confirmreservation.dto.ConfirmReservation;
import com.naver.reservation.confirmreservation.dto.ReservationPrice;
import com.naver.reservation.service.ConfirmReservationPageService;

@Service
public class ConfirmReservationpageServiceImpl implements ConfirmReservationPageService {

	@Autowired
	ConfirmReservationDao confirmReservationDao;

	@Autowired
	ReservationPriceDao reservationPriceDao;

	@Override
	@Transactional
	public List<ConfirmReservation> getConfirmReservation() {
		List<ConfirmReservation> list = confirmReservationDao.getConfirmReservations();
		list.stream().forEach(v -> {
			String[] openingHours = v.getOpeningHours().split("\\n");
			v.setOpeningHours(openingHours[0]);
		});

		return list;
	}

	@Override
	@Transactional
	public List<ConfirmReservation> getConfirmReservation(String reservationEmail) {
		List<ConfirmReservation> list = confirmReservationDao.getConfirmReservations(reservationEmail);
		list.stream().forEach(v -> {
			String[] openingHours = v.getOpeningHours().split("\\n");
			v.setOpeningHours(openingHours[0]);
		});

		return list;
	}

	@Override
	@Transactional
	public int cancelingReservation(int id) {
		Date date = new Date();
		int count = confirmReservationDao.updateCancelFlag(id, date);
		return count;
	}

	@Override
	@Transactional
	public int usingReservation(int id) {
		Date date = new Date();
		int count = confirmReservationDao.updateUsedFlag(id, date);
		return count;
	}

	@Override
	@Transactional
	public List<ReservationPrice> getReservationPrice(int id) {
		List<ReservationPrice> list = reservationPriceDao.getReservationPrice(id);
		return list;
	}

}

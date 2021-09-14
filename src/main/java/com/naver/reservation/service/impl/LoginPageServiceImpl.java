package com.naver.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.reservation.login.dao.ReservationCountDao;
import com.naver.reservation.login.dto.ReservationCount;
import com.naver.reservation.service.LoginPageService;

@Service
public class LoginPageServiceImpl implements LoginPageService {
	@Autowired
	ReservationCountDao reservationCountDao;

	@Override
	public int getReservationCount(String reservationEmail) {
		 List<ReservationCount> list = reservationCountDao.getReservationCount(reservationEmail);
		 int count = list.get(0).getCount();
		 return count;
	}

}

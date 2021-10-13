package com.naver.reservation.service;

import java.util.List;

import com.naver.reservation.confirmreservation.dto.ConfirmReservation;
import com.naver.reservation.confirmreservation.dto.ReservationPrice;

public interface ConfirmReservationPageService {
	public List<ConfirmReservation> getConfirmReservation(String reservationEmail);
	public List<ConfirmReservation> getConfirmReservation();
	public int cancelingReservation(int id);
	public int usingReservation(int id);
	public List<ReservationPrice> getReservationPrice(int id);

}

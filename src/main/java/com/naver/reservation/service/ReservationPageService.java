package com.naver.reservation.service;

import java.util.List;
import com.naver.reservation.reservation.dto.ReservationPageInfo;
public interface ReservationPageService {
	public List<ReservationPageInfo> getReservationPageInfo(int id);
	public Integer insertAction(String tableName, Object object);
}

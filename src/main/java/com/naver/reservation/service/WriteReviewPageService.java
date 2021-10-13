package com.naver.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.naver.reservation.writereview.dto.FileInfo;
import com.naver.reservation.writereview.dto.ProductDescription;
import com.naver.reservation.writereview.dto.ReservationUserComment;
import com.naver.reservation.writereview.dto.ReservationUserCommentImage;

public interface WriteReviewPageService {
	public List<ProductDescription> getProductDescriptions(int id);
	public int insertAction(ReservationUserComment object);
	public int insertAction(ReservationUserCommentImage object);
	public int insertAction(FileInfo object);
	public int insertAction(ReservationUserComment object1, FileInfo object3);
	public int insertAction(ReservationUserComment object1, List<FileInfo> object3);
	public Map<String, Object> writeReview(ReservationUserComment reservationUserComment, MultipartFile[] files);
}

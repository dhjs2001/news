package com.naver.reservation.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.reservation.detail.dto.DetailInfo;
import com.naver.reservation.detail.dto.ProductPrice;
import com.naver.reservation.detail.dto.ReservationInfo;
import com.naver.reservation.main.dto.MainProduct;
import com.naver.reservation.service.DetailPageService;
import com.naver.reservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@Autowired
	DetailPageService detailPageService;

	@GetMapping("main")
	public String getRequestMain(ModelMap model) {
		List<MainProduct> promotionInfo = reservationService.getPromotionInfo("th");
		model.addAttribute("promotionInfo", promotionInfo);

		List<MainProduct> product = reservationService.getProductAll(0);

		model.addAttribute("product", product);
		return "main";
	}

	@GetMapping(path = "detail/{id}")
	public String getRequestDetail(@PathVariable(name = "id") int id, ModelMap model) {
		List<DetailInfo> detail = detailPageService.getDetailInfo(id);
		List<ProductPrice> productPrices = detailPageService.getProductPrices(id);
		List<ReservationInfo> review = detailPageService.getReview(id);
		int reviewSize = review.size();
		double reviewScore = 0;
		double reviewRate = 0;
		if (review.isEmpty() != true) {
			for (ReservationInfo i : review) {
				reviewScore += i.getScore();
			}

			review = review.stream().map(a -> {
				String date = a.getCreateDate();
				String result = date.replace("-", ".");
				a.setCreateDate(result);
				String email = a.getReservationEmail();
				if (email != null) {
					email = email.substring(0, 4) + "****";
				}
				a.setReservationEmail(email);
				return a;
			}).collect(Collectors.toList());

			reviewRate = reviewScore / reviewSize;
		} else {
			System.out.println("review 객체가 비었음");
		}

		DecimalFormat form = new DecimalFormat("#.#");
		model.addAttribute("reviewRate", form.format(reviewRate));

		model.addAttribute("detail", detail);
		int count = detailPageService.getDetailInfoCount(id);
		model.addAttribute("count", count);
		model.addAttribute("productPrices", productPrices);
		model.addAttribute("review", review);
		model.addAttribute("reviewSize", reviewSize);
		model.addAttribute("id",id);

		return "detail";
	}

	@GetMapping(path = "review/{id}")
	public String moreReview(@PathVariable(name="id")int id, ModelMap model) {
		List<DetailInfo> detail = detailPageService.getDetailInfo(id);
		List<ReservationInfo> review = detailPageService.getReview(id);
		int reviewSize = review.size();
		double reviewScore = 0;
		double reviewRate = 0;
		if (review.isEmpty() != true) {
			for (ReservationInfo i : review) {
				reviewScore += i.getScore();
			}

			review = review.stream().map(a -> {
				String date = a.getCreateDate();
				String result = date.replace("-", ".");
				a.setCreateDate(result);
				String email = a.getReservationEmail();
				if (email != null) {
					email = email.substring(0, 4) + "****";
				}
				a.setReservationEmail(email);
				return a;
			}).collect(Collectors.toList());

			reviewRate = reviewScore / reviewSize;
		} else {
			System.out.println("review 객체가 비었음");
		}

		DecimalFormat form = new DecimalFormat("#.#");
		model.addAttribute("reviewRate", form.format(reviewRate));
		model.addAttribute("review", review);
		model.addAttribute("reviewSize", reviewSize);
		model.addAttribute("detail", detail);
		return "review";
	}

}

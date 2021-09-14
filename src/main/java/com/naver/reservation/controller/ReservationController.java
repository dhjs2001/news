package com.naver.reservation.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import com.naver.reservation.detail.dto.DetailInfo;
import com.naver.reservation.detail.dto.ProductPrice;
import com.naver.reservation.detail.dto.ProductSpecificInfo;
import com.naver.reservation.main.dto.MainProduct;
import com.naver.reservation.reservation.dto.ReservationInfo;
import com.naver.reservation.reservation.dto.ReservationInfoPrice;
import com.naver.reservation.reservation.dto.ReservationPageInfo;
import com.naver.reservation.service.DetailPageService;
import com.naver.reservation.service.LoginPageService;
import com.naver.reservation.service.MainPageService;
import com.naver.reservation.service.ReservationPageService;

@Controller
public class ReservationController {

	@Autowired
	MainPageService mainPageService;

	@Autowired
	DetailPageService detailPageService;

	@Autowired
	ReservationPageService reservationPageservice;
	
	@Autowired
	LoginPageService loginPageService;

	@GetMapping("main")
	public String getRequestMain(ModelMap model, HttpSession session) {
		String email = (String)session.getAttribute("email");
		session.setMaxInactiveInterval(-1);
		
		if(email != null && !email.equals("null")) {
			System.out.println("작동함");
			model.addAttribute("email", email);
		}else {
			session.setAttribute("email", "null");
		}
		
		List<MainProduct> promotionInfo = mainPageService.getPromotionInfo("th");
		model.addAttribute("promotionInfo", promotionInfo);

		List<MainProduct> product = mainPageService.getProductAll(0);

		model.addAttribute("product", product);
		
		return "main";
	}
	
	
	

	@GetMapping(path = "detail/{id}")
	public String getRequestDetail(@PathVariable(name = "id") int id, ModelMap model, @SessionAttribute("email") String loginEmail) {
		if(!loginEmail.equals("null")) {
			model.addAttribute("email", loginEmail);
		}
		
		
		List<DetailInfo> detail = detailPageService.getDetailInfo(id);
		List<ProductPrice> productPrices = detailPageService.getProductPrices(id);
		List<ProductSpecificInfo> review = detailPageService.getReview(id);
		int reviewSize = review.size();
		double reviewScore = 0;
		double reviewRate = 0;
		if (review.isEmpty() != true) {
			for (ProductSpecificInfo i : review) {
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
		model.addAttribute("id", id);

		return "detail";
	}

	
	
	
	
	@GetMapping(path = "review/{id}")
	public String moreReview(@PathVariable(name = "id") int id, ModelMap model) {
		List<DetailInfo> detail = detailPageService.getDetailInfo(id);
		List<ProductSpecificInfo> review = detailPageService.getReview(id);
		int reviewSize = review.size();
		double reviewScore = 0;
		double reviewRate = 0;
		if (review.isEmpty() != true) {
			for (ProductSpecificInfo i : review) {
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

	
	
	
	
	@GetMapping(path = "reservation/{id}")
	public String getRequestReservation(@PathVariable(name = "id") int id, ModelMap model, @SessionAttribute("email")String email) {
		List<ReservationPageInfo> list = reservationPageservice.getReservationPageInfo(id);
		String[] openingDate = list.get(0).getOpeningHours().split("\\n");

		model.addAttribute("reservationPageInfo", list);
		model.addAttribute("openingDate", openingDate);
		
		if(!email.equals("null")) {
			model.addAttribute("email", email);
		}
		
		return "reservation";
	}

	
	@PostMapping(path = "/reservationAction")
	@Transactional
	public String postRequestReservation(HttpServletRequest request,@SessionAttribute("email")String email, HttpSession session) {
		
		Enumeration<String> names = request.getParameterNames();
		ReservationInfo reservationInfo = new ReservationInfo();
		List<Integer> productPriceId = new ArrayList<>();
		List<Integer> count = new ArrayList<>();

		String reservationEmail = null;
		Date reservationDate = new Date();
		int cancelFlag = 0;
		Date createDate = reservationDate;
		Date modifyDate = reservationDate;
		int usedFlag = 0;

		String parameterValue;
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();

			switch (string) {
			case "reservationName": {
				parameterValue = request.getParameter(string);
				reservationInfo.setReservationName(parameterValue);
				break;
			}
			case "reservationTel": {
				parameterValue = request.getParameter(string);
				reservationInfo.setReservationTel(parameterValue);
				break;
			}
			case "reservationEmail": {
				reservationEmail = request.getParameter(string);
				reservationInfo.setReservationEmail(reservationEmail);
				break;
			}
			case "displayInfoId": {
				parameterValue = request.getParameter(string);
				reservationInfo.setDisplayInfoId(Integer.parseInt(parameterValue));
				break;
			}
			case "productId": {
				parameterValue = request.getParameter(string);
				reservationInfo.setProductId(Integer.parseInt(parameterValue));
				break;
			}
			default: {
				parameterValue = request.getParameter(string);
				productPriceId.add(Integer.parseInt(string));
				count.add(Integer.parseInt(parameterValue));
			}
			}

		}
		reservationInfo.setCancelFlag(cancelFlag);
		reservationInfo.setReservationDate(reservationDate);
		reservationInfo.setCreateDate(createDate);
		reservationInfo.setModifyDate(modifyDate);

		int key = reservationPageservice.insertAction("reservation_info", reservationInfo);

		ReservationInfoPrice reservationInfoPrice = new ReservationInfoPrice();
		for (int i = 0; i < productPriceId.size(); i++) {

			reservationInfoPrice.setReservationInfoId(key);
			reservationInfoPrice.setProductPriceId(productPriceId.get(i));
			reservationInfoPrice.setCount(count.get(i));

			reservationPageservice.insertAction("reservation_info_price", reservationInfoPrice);
		}
		
		session.setAttribute("email", reservationEmail);
		
		return "redirect:login";

	}

	@GetMapping(path = "login")
	public String getRequestLogin(@SessionAttribute("email")String email) {
		if (!email.equals("null")) {
			return "redirect:confirmReservation";
		} else {
			return "login";
		}
	}

	@PostMapping(path = "login")
	public String postRequestLogin(ModelMap model,@RequestParam("email")String email, HttpSession session) {
		//DB에 email을 이용한 쿼리를 보낸 후에 받아온 정보가 존재한다면 '/confirmReservation'으로 보낸다.
		System.out.println("email:" +email);
		
		int reservationCount = loginPageService.getReservationCount(email);
		if(0 < reservationCount) {
			session.setAttribute("email", email);
			return "redirect:confirmReservation";
		}
		
		
		model.addAttribute("error", 1);
		return "login";
	}

	@GetMapping(path = "confirmReservation")
	public String getRequestConfirmReservation(ModelMap model, @SessionAttribute("email") String email) {
		if (email.equals("null")) {
			return "redirect:login";
		}
		return "confirmReservation";

	}
	
	@GetMapping(path = "logout")
	public String getReqeustlogout(HttpSession session) {
		session.setAttribute("email", null);
		
		return "redirect:main";
	}
	
}

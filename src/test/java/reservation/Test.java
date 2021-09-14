package reservation;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.reservation.dao.ProductDao;
import com.naver.reservation.dto.Product;
import com.naver.reservation.main.dao.MainProductDao;
import com.naver.reservation.main.dto.MainProduct;
import com.naver.reservation.service.MainPageService;
import com.naver.reservation.service.impl.MainPageServiceImpl;


public class Test {
	@Autowired
	private static DataSource dataSource;

	public static void main(String[] args) {
		MainProductDao productDao = new MainProductDao(dataSource);
		List<MainProduct> list =  productDao.getAllProductByCategoryId(3, 0);
		System.out.println(list);

	}

}

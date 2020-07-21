package com.sms.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.pojo.Product;
import com.sms.service.ProductService;
import com.sms.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String cid = request.getParameter("cid");
		String yieldDate = request.getParameter("yieldDate");
		String price = request.getParameter("price");
		String manufacturers = request.getParameter("manufacturers");
		String stock = request.getParameter("stock");
		String nowPrice = request.getParameter("nowPrice");
		if(name!=""&&yieldDate!=""&&price!=""&&manufacturers!=""&&stock!=""&&nowPrice!=""){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Product product = new Product();
			product.setName(name);
			product.setCid(Integer.valueOf(cid));
			try {
				product.setYieldDate(simpleDateFormat.parse(yieldDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			product.setManufacturers(manufacturers);
			product.setPrice(new BigDecimal(price));
			product.setStock(Integer.valueOf(stock));
			product.setNowPrice(new BigDecimal(nowPrice));
			ProductService productService = new ProductServiceImpl();
			productService.addProduct(product);
			request.getRequestDispatcher("/productShow").forward(request, response);
		}else {
			request.getRequestDispatcher("/toAddProduct").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

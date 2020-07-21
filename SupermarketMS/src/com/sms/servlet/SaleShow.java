package com.sms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.pojo.Category;
import com.sms.pojo.Sale;
import com.sms.service.CategoryService;
import com.sms.service.ProductService;
import com.sms.service.SaleService;
import com.sms.service.impl.CategoryServiceImpl;
import com.sms.service.impl.ProductServiceImpl;
import com.sms.service.impl.SaleServiceImpl;

/**
 * Servlet implementation class SaleShow
 */
@WebServlet("/saleShow")
public class SaleShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		String front = request.getParameter("front");
		String rear = request.getParameter("rear");
		CategoryService categoryService = new CategoryServiceImpl();
		
		SaleService saleService = new SaleServiceImpl();
		ProductService productService = new ProductServiceImpl();
		List<Sale> sales = saleService.getSaleByGroup(cid,front,rear);
		for (Sale sale : sales) {
			sale.setProduct(productService.getProductById(sale.getPid()));
			sale.getProduct().setCategory(categoryService.getCategoryById(sale.getProduct().getCid()));
		}
		request.setAttribute("sales", sales);//绑定数据到request对象中	
			 	
		
		List<Category> categories = categoryService.getCategories();
		
		request.setAttribute("categories", categories);//绑定数据到request对象中
		request.getRequestDispatcher("/admin/sale.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

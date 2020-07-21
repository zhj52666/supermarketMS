package com.sms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.pojo.Product;
import com.sms.service.ProductService;
import com.sms.service.SaleService;
import com.sms.service.impl.ProductServiceImpl;
import com.sms.service.impl.SaleServiceImpl;

/**
 * Servlet implementation class CheckstandServlet
 */
@WebServlet("/checkstand")
public class CheckstandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckstandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		if(pid!=null&&count!=null){
		System.out.println(pid + "数量" + count);
		ProductService productService = new ProductServiceImpl();
		SaleService saleService = new SaleServiceImpl();
		Product product = productService.getProductById(Integer.valueOf(pid));
		if(product!=null){
			productService.updateProductCount(product,Integer.valueOf(count));
			saleService.addSale(product,Integer.valueOf(count));
			request.setAttribute("product", product);//绑定数据到request对象中
			System.out.println(product);
		}
		request.setAttribute("count", count);
		}
		request.getRequestDispatcher("/admin/checkstand.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

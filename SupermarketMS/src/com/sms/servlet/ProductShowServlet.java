package com.sms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.pojo.Category;
import com.sms.pojo.Product;
import com.sms.service.CategoryService;
import com.sms.service.ProductService;
import com.sms.service.impl.CategoryServiceImpl;
import com.sms.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductShowServlet
 */
@WebServlet("/productShow")
public class ProductShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryService categoryService = new CategoryServiceImpl();
		ProductService productService = new ProductServiceImpl();
		
		List<Category> categories = categoryService.getCategories();
		request.setAttribute("categories", categories);//绑定数据到request对象中
		
		List<Product> products = productService.getProducts();
		if (products!=null) {
			for (Product product : products) {
				Category category = categoryService.getCategoryById(product.getCid());
				product.setCategory(category);
			}	
		}		
		request.setAttribute("products", products);//绑定数据到request对象中
		request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

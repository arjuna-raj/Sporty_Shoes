package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Autowired
	UserRepo Urepo;
	
	@Autowired
	PurchaseRepRepo PRRepo;
	
	@Autowired
	AdminRepo Arepo;
	
	@Autowired
	ProductRepo Prepo;
	
	@Autowired
	CategoryRepo Crepo;
	
	@Autowired
	ProductDAO pDAO;
	
	RestTemplate temp = new RestTemplate();
	
	String Admin = "admin";
	
	@ResponseBody
	@RequestMapping("AdminLogin")
	public void checkAdmin(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		String adminUser=req.getParameter("username");
		String adminPass=req.getParameter("password");
		if(Arepo.findByAdminName(adminUser) == Arepo.findByAdminPassword(adminPass)) {
			System.out.println("Login Successful");
			res.getWriter().write(
					"<html><body>"
					+ "<h2>Admin Options:</h2>"
					+ "<form action=\"adminDash\"><button type= \"submit\"> Click continue to dashboard</button></form>"
					+ "</body></html>");
		} else {
			System.out.println("Login Failed");
			res.getWriter().write(
					"<html><body>"
							+"<h2>Login failed!</h2>"
							+"<form action=\"Alogin.jsp\">"
							+ "<button type= \"submit\"> Click to go back to Admin login</button>"
							+ "</body></html>");
		}
	}
	
	@RequestMapping("adminDash")
	public ModelAndView adminDash(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("AdminDash.jsp");
		return mv;
	}
	
	@RequestMapping("UserList")
	public ModelAndView userList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mv2= new ModelAndView();
		System.out.println("Exection reached mv2, check 1");
		List<User> ul= Urepo.findAllUsers();
		mv2.setViewName("userList.jsp");
		mv2.addObject("data", ul);
		System.out.println("Exection reached mv2, check 2");
		return mv2;
	}
	
	@RequestMapping("ProductList")
	public ModelAndView productList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mv2= new ModelAndView();
		System.out.println("Exection reached mv2, check 1");
		List<Product> ul= Prepo.findAllProduct();
		mv2.setViewName("productList.jsp");
		mv2.addObject("data", ul);
		System.out.println("Exection reached mv2, check 2");
		return mv2;
	}
	
	@RequestMapping("PurchaseList")
	public ModelAndView purchaseList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mv3= new ModelAndView();
		System.out.println("Execution reached mv2, check 1");
		List<Purchase> ul= PRRepo.findAllPurchase();
		mv3.setViewName("purchaseReports.jsp");
		mv3.addObject("data", ul);
		System.out.println("Execution reached mv2, check 2");
		return mv3;
	}
	
	@RequestMapping("searchUser")
	public void searchUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String userF=req.getParameter("search");
		if(Urepo.findByName(userF)!=null) {
			User s = Urepo.findByName(userF);
			res.getWriter().write(
					"<html><body>"
							+"<h2>User Details:</h2>"
							+ "ID: "+ s.getUid() +"<br>"
							+ "Name: "+ s.getName() +"<br>"
							+ "Email: "+ s.getEmail() +"<br>"
							+ "Password: "+ s.getPassword() +"<br>"
							+ "<form action=\"UserList\">"
							+ "<input type=\"submit\" value=\"Back\">"
							+ "</form>"
							+ "</body></html>");
		} else {
			System.out.println("User not Found");
			res.getWriter().write(
					"<html><body>"
							+"<h2>Unable to find User</h2>"
							+ "<form action=\"UserList\">"
							+ "<input type=\"submit\" value=\"Back\">"
							+ "</form>"
							+ "</body></html>");
		}
	}
	
	@RequestMapping("dateFilter")
	public void filterDate(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List<Purchase> prc = PRRepo.findAll(Sort.by(Sort.DEFAULT_DIRECTION.DESC, "date"));
		res.getWriter().write("<html><body><table border=\"1\">"
				+ "<tr><th>Rid</th><th>days since order</th><th>name</th><th>Category</th></tr>");
		for(Purchase c: prc){
			res.getWriter().write("<tr><th>"+ c.getRid() +"</th><th>"+ c.getDate() +"</th><th>"+ c.getName() +"</th><th>"+ c.getCategory() +"</th></tr>");
			}
		res.getWriter().write("</table>"
				+ "<form action=\"PurchaseList\"><input type=\"submit\" value=\"Back\"></form>"
				+ "</html></body>");
	}
	
	@RequestMapping("categoryFilter")
	public void filterCatg(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List<Purchase> prc = PRRepo.findAll(Sort.by(Sort.DEFAULT_DIRECTION.DESC, "category"));
		res.getWriter().write("<html><body><table border=\"1\">"
				+ "<tr><th>Rid</th><th>Category</th><th>name</th><th>days since order</th></tr>");
		for(Purchase c: prc){
			res.getWriter().write("<tr><th>"+ c.getRid() +"</th><th>"+ c.getCategory() +"</th><th>"+ c.getName() +"</th><th>"+ c.getDate() +"</th></tr>");
			}
		res.getWriter().write("</table>"
				+ "<form action=\"PurchaseList\"><input type=\"submit\" value=\"Back\"></form>"
				+ "</html></body>");
	}
	

	@RequestMapping("manageProducts")
	public void manageProducts(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("traversed to manage Products");
		res.getWriter().write(
				"<html><body>"
				+ "<h2>Admin Options:</h2>"
				+ "<form action=\"InsertProduct\"><button type= \"submit\"> Add a Product </button></form>"
				+ "<form action=\"DeleteProduct\"><button type= \"submit\"> Delete a Product </button></form>"
				+ "<form action=\"ProductList\"><button type= \"submit\"> Return to the Product list</button></form>"
				+ "</body></html>");
	}
	
	@RequestMapping("InsertProduct")
	public ModelAndView InsertP(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mv4= new ModelAndView();
		System.out.println("Exection reached mv2, check 1");
		List<Category> ul= Crepo.findAllCats();
		mv4.setViewName("insertP.jsp");
		mv4.addObject("data", ul);
		System.out.println("Exection reached mv2, check 2");
		return mv4;
	}
	
	@RequestMapping("DeleteProduct")
	public ModelAndView DeleteP(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mv5= new ModelAndView();
		System.out.println("Exection reached mv2, check 1");
		List<Product> ul= Prepo.findAllProduct();
		mv5.setViewName("deleteP.jsp");
		mv5.addObject("data", ul);
		System.out.println("Exection reached mv2, check 2");
		return mv5;
	}
	
	@RequestMapping("addShoe")
	public void addShoe(@RequestParam("shoeName") String name, @RequestParam("category") String category, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Product ss = new Product();
		ss.setName(name);
		ss.setCategory(category);
		Product sp = pDAO.insert(ss);
		if(sp!=null) {
			res.getWriter().write("<html><body>"
					+ "<h2>Product Added!<h2>"
					+ "<form action=\"ProductList\"><button type= \"submit\"> Return to the Product list</button></form>"
					+ "</html></body>");
		} else {
			res.getWriter().write("<html><body>"
					+ "Problem with adding this Product"
					+ "<form action=\"ProductList\"><button type= \"submit\"> Return to the Product list</button></form>"
					+ "</html></body>");			
		}
	}
	
	@RequestMapping("deleteShoe")
	public void deleteShoe(@RequestParam("pid") int Pid, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		pDAO.delete(Pid);
		res.getWriter().write("<html><body>"
				+ "Product Deleted"
				+ "<form action=\"ProductList\"><button type= \"submit\"> Return to the Product list</button></form>"
				+ "</html></body>");	
	}
}
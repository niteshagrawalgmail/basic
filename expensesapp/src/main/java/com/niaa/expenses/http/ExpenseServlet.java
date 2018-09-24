package com.niaa.expenses.http;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.niaa.expenses.entity.EntityHandlerFactory;
import com.niaa.expenses.entity.Expenses;
import com.niaa.expenses.entity.ExpensesDTO;
import com.niaa.expenses.entity.IEntityHandler;
import com.niaa.expenses.entity.Service;
import com.niaa.expenses.path.processor.PathInfo;
import com.niaa.expenses.path.processor.PathProcessor;

/**
 * Servlet implementation class E2eServlet
 */
public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.addHeader("Access-Control-Allow-Origin", "*");
		
		PathInfo pathInfo = PathProcessor.process(request.getPathInfo());
		String resourceName = pathInfo.getResourceName();
		IEntityHandler entityHandler = EntityHandlerFactory.getEntityHandler(resourceName);
		Object res = null;
		if(pathInfo.isCollection()) {
			res = entityHandler.findAll(resourceName);
		}else {
			res = entityHandler.find(resourceName, pathInfo.getResourceId());
		}
		
		//List<Expenses> expenses = new Service().getExpenses();
		response.getOutputStream().write(new JSONUtility().serialize(res));
		System.out.println("got the data");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String extractpayload = Util.extractpayload(request.getInputStream());

		ExpensesDTO payloaddata = new Gson().fromJson(extractpayload, ExpensesDTO.class);
		
		Expenses ex = new Expenses();
		ex.setAmount(payloaddata.getAmount());
		ex.setCategory(payloaddata.getCategory());
		ex.setCurrency(payloaddata.getCurrency());
		ex.setDate(new Timestamp(System.currentTimeMillis()));
		ex.setNotes(payloaddata.getNotes());
		
		new Service().store(ex);
		
		System.out.println(payloaddata);
		
	}
	
	

}

package com.nitesh.e2e.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.niaa.service.api.accoumt.IAccount;

/**
 * Servlet implementation class E2eServlet
 */
public class E2eServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E2eServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			ServiceLoader<IAccount> loader = ServiceLoader.load(IAccount.class);
			
			Iterator<IAccount> iterator = loader.iterator();
			
			List<AccountTO> accountList = new ArrayList<>();
			
			while(iterator.hasNext()) {
				IAccount next = iterator.next();
				AccountTO acc = new AccountTO();
				acc.setAccountId(next.getAccountId());
				acc.setAccountType(next.getAccountType());
				accountList.add(acc);
			}
		
			AccountTO[] accounts = accountList.toArray(new AccountTO[accountList.size()]);
			
			Gson gson = new Gson();
			String accountListAsString = gson.toJson(accounts);
			
			response.getOutputStream().write(getBytes(accountListAsString));
	
		}
		catch(Exception e) {
			
		}finally{
			response.getOutputStream().close();
		}
						
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	private byte[] getBytes(String str) {
		if (str == null || str.isEmpty()) {
			return new byte[0];
		}

		try {
			return str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return str.getBytes();// NOSONAR
		}
	}
	
	

}

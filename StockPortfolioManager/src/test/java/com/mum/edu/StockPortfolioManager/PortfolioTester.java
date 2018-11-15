package com.mum.edu.StockPortfolioManager;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PortfolioTester {
	
  private Portfolio portfolio;	
  private StockService stockService;
	   
   
//   public static void main(String[] args){
//      PortfolioTester tester = new PortfolioTester();
//      tester.setUp();
//      System.out.println(tester.testMarketValue()?"pass":"fail");
//   }
   @Before
   public void setUp()throws Exception{
      //Create a portfolio object which is to be tested		
      portfolio = new Portfolio();		
  
      //Create the mock object of stock service
      stockService = mock(StockService.class);		
  
      //set the stockService to the portfolio
      portfolio.setStockService(stockService);
   }
   @After
   public void tearDown() throws Exception{
	   portfolio=null;
   }
   
   @Test
   public void testMrketValue() {
	   //Creates a list of stocks to be added to the portfolio
	      List<Stock> stocks = new ArrayList<Stock>();
	      Stock googleStock = new Stock("1","Google", 10);
	      Stock microsoftStock = new Stock("2","Microsoft",100);	
	 
	      stocks.add(googleStock);
	      stocks.add(microsoftStock);

	      //add stocks to the portfolio
	      portfolio.setStocks(stocks);

	      //mock the behavior of stock service to return the value of various stocks
	      when(stockService.getPrice(googleStock)).thenReturn(60.00);
	      when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);		

	      double marketValue = portfolio.getMarketValue();		
	      double expected = 100500.0;
	      
	      Assert.assertEquals(expected,marketValue);
	   verify(stockService).getPrice(googleStock);
	   verify(stockService).getPrice(microsoftStock);
	   
   }
}


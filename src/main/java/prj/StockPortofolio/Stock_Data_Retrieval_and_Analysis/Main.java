package prj.StockPortofolio.Stock_Data_Retrieval_and_Analysis;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        Stock stock = YahooFinance.get("INTC");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();

        System.out.println("*************************************");
        String[] symbols = new String[]{"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
        Map<String, Stock> stocks = YahooFinance.get(symbols); // single request
        Stock intel = stocks.get("INTC");
        Stock airbus = stocks.get("AIR.PA");

        intel.print();
        System.out.println("*************************************");
        airbus.print();

    }
}

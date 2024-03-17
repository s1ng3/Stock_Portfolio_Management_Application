**Stocks Portfolio Management Application**

Note: The project uses Lombok. 

## Exercise 1 

Implementing a basic stock portfolio tracker application.

The application should provide following functionalities:
- Authentication (Login) - finish the login implementation. Currently, the credentials are not verified; anyone can access the application.

![login image](./docs/login.png)

- Viewing market stocks and their current value - (this feature is implemented)

![market image](./docs/market.png)

- View user portofolio owned stocks
    - View owned stocks in a table view similar to Market;
    - For each owned stock display in table followings: symbol, quantity, price per unit, total price of the position;
    - Also adding available funds (cash).

![portfolio image](./docs/portfolio.png)

- Buy stock:
    - Implementing "Buy" button functionality;
    - Buy is limited by available cache funds (stored in Portfolio class, attribute "cash");

![buy image](./docs/buy.png)

- Sell stock
    - Creating user interface similar to Buy interface
    - Symbol dropdown button should display only stocks owned by user;
    - When the sell is completed, the available funds should increase with the value of the transaction;

![sell image](./docs/sell.png)
 

### Implementation notes

Note 1 - Stock symbols are hardcoded in StockMarketQueryService      private String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "MSFT", "AAPL", etc.};  An own symbol can be added as long as correspond to some real market symbols.

Note 2 - For getting financial market information the application I've used https://financequotes-api.com/ library:

        <dependency>
            <groupId>com.yahoofinance-api</groupId>
            <artifactId>YahooFinanceAPI</artifactId>
            <version>3.15.0</version>
        </dependency>
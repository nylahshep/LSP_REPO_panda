Class: Order
Responsibilities:
- Store customer and order information (name, email, item, price)
Collaborators: 
- Discount
- TaxCalculator
- PrintReceipt
- SaveOrders
- EmailNotification


Class: TaxCalculator
Responsibilities: 
- Calculate tax for a given order and return total
Collaborators:
- Order


Class: Discount
Responsibilities:
- Calculate discount for order and apply to total
Collaborators:
- Order
- TaxCalculator


Class: PrintReceipt
Responsibilities:
- Generate and print receipt with customer name, item(s) and total
Collaborators:
- Order 
- TaxCalculator
- Discount

Class: SaveOrders
Responsibilities: 
- Save order data and hold records
Collaborators:
- Order


Class: EmailNotification
Responsibilities:
- Send confirmation emails
Collaborators:
- Order
- SaveOrders

Class: OrderProcessor
Responsibilities:
- save ordered information on data including:
- tax, discounts, receipt, email notification
Collaborators:
- Discount
- TaxCalculator
- PrintReceipt
- SaveOrders
- EmailNotification
	
	
	
	
	





Class: Order
Responsibilities:
- Store customer and order information (name, email, item, price)
Collaborators: 
- Discount
- TaxCalculator
- PrintReceipt
- OrderPersistence
- EmailNotifier


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
Responsibilities

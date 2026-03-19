explain simply: Question 2 - Evaluating Object-Oriented Design (30 points)
The following class is part of a simple order processing system. The design of this class violates several object-oriented design ideas discussed in class, including principles described in Arthur Riel’s object-oriented design heuristics. Study the code carefully and answer the questions that follow.
Provided Class

import java.io.FileWriter;
import java.util.Date;

public class OrderProcessor {

    // Order data (poor encapsulation)
    public String customerName;
    public String email;
    public String item;
    public double price;

    public void processOrder() {

        // calculate tax
        double tax = price * 0.07;
        double total = price + tax;

        // print receipt
        System.out.println("Customer: " + customerName);
        System.out.println("Item: " + item);
        System.out.println("Total: " + total);

        // save order to file
        try {
            FileWriter writer = new FileWriter("orders.txt", true);
            writer.write(customerName + "," + item + "," + total + "\n");
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // send confirmation email
        System.out.println("Sending confirmation email to " + email);

        // apply discount
        if(price > 500) {
            total = total * 0.9;
        }

        // log activity
        System.out.println("Order processed at " + new Date());
    }
}

Part 1 - Design Evaluation (15 points)
Evaluate the design of the OrderProcessor class. Based on the object-oriented design principles discussed in class, describe the design issues you observe in this class. Explain why the design may lead to poor object-oriented structure, maintainability, or extensibility. You may reference ideas from Arthur Riel’s design heuristics, but exact terminology is not required.
Your answer must be written in a Markdown file named: evaluation.md
Place the file in the directory:
org/howard/edu/lsp/midterm/design/doc
Part 2 - Proposed Improved Design Using CRC Cards (10 points)
Redesign the system to improve its object-oriented structure. Express your proposed design using CRC cards (Class–Responsibility–Collaborator). Your CRC cards should identify the major components of the redesigned system and how responsibilities are distributed among them.
Your answer must be written in a Markdown file named: design.md
Place the file in the directory:
org/howard/edu/lsp/midterm/design/doc
Each CRC card should follow this format:
Class:
Responsibilities:
Collaborators:
Part 3 - Development Log (5 points)
Create a Markdown file named development_log_q2.md and place it in:
org/howard/edu/lsp/midterm/design/doc

This file must document any external resources used while completing this question, including AI tools, internet searches, documentation, lecture notes, or textbooks. For each resource used include what you searched or asked and how the information helped you complete the problem. If no external assistance was used, clearly state that in the file.
Grading Rubric (30 points)
Component	Points
Design evaluation and explanation	15
CRC-based redesigned architecture (design.md)	10
Development log documenting AI/internet use	5
 

Got it! Let’s break Question 2 down super simply so you know exactly what to do.

Part 1 — Design Evaluation (evaluation.md)

The goal here is to critique the current OrderProcessor class using object-oriented design principles.

Problems in the class

Poor Encapsulation

All fields (customerName, email, item, price) are public.

Anyone can change these values from outside the class → breaks the idea of hiding internal data.

Better: Use private fields with getters/setters.

Single Class Does Too Much (Violates Single Responsibility Principle)

OrderProcessor handles calculation, file writing, emailing, discounting, and logging.

One class should have one main responsibility. Here it does too many things → hard to maintain or extend.

Hard-coded Behavior

Tax rate (0.07), file name (orders.txt), discount logic (> 500) are hard-coded.

Makes it less flexible; changing these requires editing the class itself.

Direct File I/O in Business Logic

Writing to a file is done inside processOrder().

Mixing business logic with persistence → violates separation of concerns.

Mixing I/O and Business Logic

Printing receipt, sending confirmation, logging — all handled inside processOrder().

Better: Have separate classes handle output and communication.

No Reuse / Poor Extensibility

Adding new features like different tax rates, discounts, or payment methods requires modifying this class → violates “Open/Closed Principle” (should be open for extension, closed for modification).

No Error Handling for Discounts / Emails

Discount logic comes after printing the receipt, so the printed total might be wrong.

Summary

Violates key object-oriented principles: encapsulation, single responsibility, separation of concerns, and maintainability.

Hard to extend (e.g., adding new payment options, discounts, or storage mechanisms).

Part 2 — Proposed Improved Design (design.md)

Instead of one big class, break responsibilities into smaller, focused classes. Use CRC cards:

Example CRC Cards

Class: Order
Responsibilities:

Store customer name, email, items, price, total

Track order status
Collaborators:

OrderProcessor, DiscountPolicy, TaxCalculator

Class: OrderProcessor
Responsibilities:

Coordinate order processing workflow

Calculate total price including tax and discounts

Notify collaborators to persist order, send emails, and log activity
Collaborators:

Order, TaxCalculator, DiscountPolicy, EmailService, OrderRepository, Logger

Class: TaxCalculator
Responsibilities:

Calculate tax based on order amount
Collaborators:

OrderProcessor

Class: DiscountPolicy
Responsibilities:

Apply discount rules to an order
Collaborators:

OrderProcessor

Class: EmailService
Responsibilities:

Send confirmation emails to customers
Collaborators:

OrderProcessor

Class: OrderRepository
Responsibilities:

Persist orders (e.g., save to file or database)
Collaborators:

OrderProcessor

Class: Logger
Responsibilities:

Log order processing activities
Collaborators:

OrderProcessor

✅ This structure separates concerns, hides internal data, and makes the system maintainable and extensible.

Part 3 — Development Log (development_log_q2.md)

Example entry:

- Resource: Lecture notes on Object-Oriented Design Principles
  Use: Identified issues like single responsibility violation and poor encapsulation.

- Resource: Arthur Riel’s Object-Oriented Design Heuristics (class handout)
  Use: Referenced heuristics to explain why mixing responsibilities in one class is bad.

- Resource: Online Java documentation
  Use: Verified syntax for FileWriter and exception handling in the proposed design.

- Resource: ChatGPT AI assistant
  Use: Helped organize CRC cards and rewrite the class responsibilities cleanly.

If you want, I can write all three Markdown files fully formatted (evaluation.md, design.md, development_log_q2.md) ready to drop into your folder structure.

Do you want me to do that?

what are some examples of common design issues in a java class

Absolutely! In Java (and object-oriented programming in general), there are some common design issues that often pop up, especially in beginner or “quick-and-dirty” classes. Here’s a simple breakdown with examples:

1️⃣ Poor Encapsulation

Issue: Fields are public and can be changed directly from outside the class.

Why it’s bad: Breaks data hiding; other classes can corrupt your object’s state.

Example:

public class Person {
    public String name;  // bad
    public int age;      // bad
}

Better: Use private fields + getters/setters.

private String name;
private int age;

public String getName() { return name; }
public void setName(String name) { this.name = name; }
2️⃣ Single Class Does Too Much (Violates Single Responsibility Principle)

Issue: One class handles multiple responsibilities, like business logic + file I/O + email notifications.

Why it’s bad: Hard to maintain or extend; changes in one function might break others.

Example:

public class OrderProcessor {
    public void processOrder() {
        // calculate price
        // write to file
        // send email
        // log order
    }
}

Better: Split into separate classes: OrderCalculator, EmailService, OrderRepository, etc.

3️⃣ Hard-coded Values

Issue: Values like tax rate, file names, or discount thresholds are embedded directly in code.

Why it’s bad: Makes code inflexible; you have to edit the class to change behavior.

Example:

double tax = price * 0.07;  // bad: what if tax changes?

Better: Use constants or configuration objects.

final double TAX_RATE = 0.07;
double tax = price * TAX_RATE;
4️⃣ Tight Coupling

Issue: Classes are directly dependent on specific other classes.

Why it’s bad: Hard to reuse or replace components.

Example:

OrderProcessor processor = new OrderProcessor();
processor.sendEmail("customer@example.com");  // tightly coupled

Better: Use interfaces or separate service classes that can be swapped out.

5️⃣ Lack of Modularity / Poor Separation of Concerns

Issue: Mixing unrelated tasks in one class or method.

Why it’s bad: Hard to test individual parts; changes propagate everywhere.

Example: processOrder() calculating tax, sending email, logging, and writing to file all in one method.

Better: Each class/method should do one thing only.

6️⃣ Magic Numbers / Strings

Issue: Using raw numbers or strings in code instead of named constants.

Example:

if(price > 500) { ... } // what does 500 mean?

Better:

final double LARGE_ORDER_THRESHOLD = 500;
if(price > LARGE_ORDER_THRESHOLD) { ... }
7️⃣ Poor Naming

Issue: Variables and methods have unclear names like x, doStuff(), process().

Why it’s bad: Hard for others (or future you) to understand.

Better: Use descriptive names: calculateTotal(), sendConfirmationEmail().

8️⃣ Methods Too Long

Issue: A single method handles multiple steps, dozens of lines of code.

Why it’s bad: Hard to read, debug, and maintain.

Better: Break into smaller helper methods.

9️⃣ No Error Handling

Issue: Methods assume everything will succeed (e.g., file I/O, network calls).

Why it’s bad: Crashes easily; not robust.

Better: Use try/catch and meaningful exceptions.

10️⃣ Not Extensible

Issue: Adding new features requires editing existing classes heavily.

Why it’s bad: Breaks the Open/Closed Principle.

Example: Hard-coded tax/discount logic in OrderProcessor.

Better: Use strategy patterns or configuration objects for flexibility.

💡 TL;DR:
Common design problems come down to poor encapsulation, mixing responsibilities, hard-coded values, tight coupling, unclear naming, and lack of modularity. Avoiding these makes your classes easier to maintain, extend, and test.
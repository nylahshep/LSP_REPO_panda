# AI Prompts – Assignment 3

## Prompt 1: Object-Oriented Redesign Strategy

**My Prompt:**
How can I redesign my Java ETL pipeline from Assignment 2 to be more object-oriented while keeping the exact same behavior?

**AI Response Summary:**
The AI suggested separating responsibilities into multiple classes, such as a Product class to represent each record, and moving transformation logic into methods within that class. It emphasized encapsulation and keeping behavior identical to Assignment 2.

**What I Used:**
I created a Product class and moved business logic such as:
- Uppercasing the product name
- Applying discount rules
- Determining premium category
- Computing price range

I kept ETLPipeline responsible only for coordinating the workflow.

---

## Prompt 2: Moving Business Logic into Product

**My Prompt:**
Where should I move discount and price range logic in an object-oriented redesign?

**AI Response Summary:**
The AI suggested placing transformation logic inside the Product class using methods like applyBusinessRules() and computePriceRange().

**What I Used:**
I implemented:
- normalizeName()
- applyBusinessRules()
- computePriceRange()

This reduced logic inside ETLPipeline and improved encapsulation.

---

## Prompt 3: Eclipse Setup Help

**My Prompt:**
How do I properly create packages and classes in Eclipse?

**AI Response Summary:**
The AI guided me step-by-step in creating the assignment3 package and ensuring files were placed in the correct structure.

**What I Used:**
I followed the instructions to:
- Create the org.howard.edu.lsp.assignment3 package
- Add Product.java and ETLPipeline.java
- Ensure correct package declarations

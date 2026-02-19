# Reflection – Assignment 3: Object-Oriented Redesign

## Overview

In Assignment 2, I implemented the ETL pipeline using a single class that handled reading the file, applying all transformation logic, and writing the output. While the program worked correctly, most of the logic was centralized inside the main method, making it more procedural than object-oriented.

In Assignment 3, I redesigned the same solution to follow object-oriented principles while preserving the exact same functionality, input/output paths, transformations, and error handling behavior.

---

## Differences Between Assignment 2 and Assignment 3

The most significant difference between the two assignments is how responsibilities are organized.

In Assignment 2:
- All parsing, transformation, and writing logic existed inside the ETLPipeline class.
- Business rules such as discounts, premium category logic, and price range determination were directly embedded inside the main loop.
- The program was functionally correct but not strongly object-oriented.

In Assignment 3:
- I introduced a Product class to represent each product record.
- Transformation logic was moved into methods inside the Product class.
- ETLPipeline now acts mainly as a coordinator instead of performing all logic itself.

This separation of concerns made the program more modular and easier to understand.

---

## Object-Oriented Concepts Used

### 1. Classes and Objects

I created a Product class to model a single product record. Each row from the CSV file is now represented as a Product object rather than separate primitive variables.

### 2. Encapsulation

Business rules are encapsulated inside the Product class. Instead of ETLPipeline manually modifying fields, it now calls methods such as:

- normalizeName()
- applyBusinessRules()
- computePriceRange()

This ensures that the object manages its own data and behavior.

### 3. Responsibility Separation

ETLPipeline is now responsible only for:
- Reading input
- Creating Product objects
- Calling transformation methods
- Writing output

The transformation details are no longer directly embedded in the pipeline logic.

### 4. Improved Maintainability

If business rules change in the future (for example, a different discount rate), modifications can be made inside the Product class without altering the overall pipeline structure.

---

## Verifying Correctness

To ensure that Assignment 3 behaves exactly the same as Assignment 2, I:

1. Used the same input and output file paths:
   - data/products.csv
   - data/transformed_products.csv

2. Confirmed that:
   - The header row remains identical.
   - Discount logic works the same.
   - Premium Electronics classification behaves the same.
   - Price rounding is unchanged.
   - Price range categories match Assignment 2.

3. Verified that the console summary output (rows read, transformed, skipped) matches the Assignment 2 output.

4. Tested edge cases:
   - Missing input file
   - Empty file
   - Invalid rows

The program produces identical output while using a more object-oriented design.

---

## Reflection on the Redesign Process

Using an AI assistant helped me think through how to restructure the program into separate classes and move logic into object methods. However, I ensured that all behavior remained consistent with Assignment 2 requirements.

The redesign improved the clarity of the code by separating data representation from pipeline control logic. Overall, Assignment 3 demonstrates a stronger use of object-oriented principles while maintaining full correctness.

package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class ETLPipeline {

    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

	public static void main(String[] args) {
		int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;
        
        File inputFile = new File(INPUT_PATH);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found: " + INPUT_PATH);
            return;
        }
        
        
        File outputFile = new File(OUTPUT_PATH);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Read header line from input (could be null if file is empty)
            String header = br.readLine();

            // Always write header row to output
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            // If input file was empty or header-only, we are done
            if (header == null) {
                printSummary(rowsRead, rowsTransformed, rowsSkipped, OUTPUT_PATH);
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {

                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }
                
                String[] parts = line.split(",", -1);

                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String productIdStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();
                
                int productId;
                try {
                    productId = Integer.parseInt(productIdStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                BigDecimal price;
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }
                
                String upperName = name.toUpperCase();
                String originalCategory = category;
                
                BigDecimal finalPrice = price;

                if (category.equals("Electronics")) {
                    finalPrice = finalPrice.multiply(new BigDecimal("0.90"));
                }
                
                finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);
		
                if (finalPrice.compareTo(new BigDecimal("500.00")) > 0 && originalCategory.equals("Electronics")) {
                    category = "Premium Electronics";
                }

                String priceRange;

                if (finalPrice.compareTo(new BigDecimal("10.00")) <= 0) {
                    priceRange = "Low";
                } else if (finalPrice.compareTo(new BigDecimal("100.00")) <= 0) {
                    priceRange = "Medium";
                } else if (finalPrice.compareTo(new BigDecimal("500.00")) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }
                
                bw.write(productId + "," + upperName + "," + finalPrice.toPlainString() + "," + category + "," + priceRange);
                bw.newLine();
                rowsTransformed++;

                
            }
            printSummary(rowsRead, rowsTransformed, rowsSkipped, OUTPUT_PATH);


        } catch (IOException e) {
            System.out.println("ERROR: An I/O error occurred: " + e.getMessage());
            return;
        }

		
		



	}

	
	
    private static void printSummary(int rowsRead,
            int rowsTransformed,
            int rowsSkipped,
            String outputPath) {

    	System.out.println("----- RUN SUMMARY -----");
    	System.out.println("Rows read (non-header): " + rowsRead);
    	System.out.println("Rows transformed:       " + rowsTransformed);
    	System.out.println("Rows skipped:           " + rowsSkipped);
    	System.out.println("Output written to:      " + outputPath);
    }

	}

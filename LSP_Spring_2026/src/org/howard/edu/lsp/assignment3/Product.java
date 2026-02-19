package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a single product record from the CSV file.
 * Encapsulates product data.
 */
public class Product {
    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public String getCategory() { return category; }
    public String getPriceRange() { return priceRange; }

    public void setName(String name) { this.name = name; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }
    
    /**
     * Converts the product name to uppercase.
     */
    public void normalizeName() {
        this.name = this.name.toUpperCase();
    }

    /**
     * Sets the price range based on the current price.
     */
    public void computePriceRange() {
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            priceRange = "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            priceRange = "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }
    }
    
    /**
     * Applies discount and premium category logic for Electronics.
     */
    public void applyBusinessRules() {

        String originalCategory = this.category;

        if (this.category.equals("Electronics")) {
            this.price = this.price.multiply(new BigDecimal("0.90"));
        }

        this.price = this.price.setScale(2, java.math.RoundingMode.HALF_UP);

        if (this.price.compareTo(new BigDecimal("500.00")) > 0 
                && originalCategory.equals("Electronics")) {
            this.category = "Premium Electronics";
        }
    }

}

		
    
    
    
    
    


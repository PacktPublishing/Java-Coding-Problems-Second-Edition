package modern.challenge.record;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bookstore.bestseller")
public record BestSellerConfig(String author, String book) {}

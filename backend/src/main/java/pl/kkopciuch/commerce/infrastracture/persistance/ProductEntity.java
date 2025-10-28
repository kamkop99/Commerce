package pl.kkopciuch.commerce.infrastracture.persistance;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity @Table(name = "products")
public class ProductEntity {
    @Id @GeneratedValue private UUID id;
    private String name;
    @Column(length = 2000) private String description;
    @Column(unique = true, nullable = false) private String sku;
    private String categoryName;
    private BigDecimal priceAmount;
    private String priceCurrency;
}

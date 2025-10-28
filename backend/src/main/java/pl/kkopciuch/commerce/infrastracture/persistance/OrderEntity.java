package pl.kkopciuch.commerce.infrastracture.persistance;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.*;


@Entity @Table(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id @GeneratedValue private UUID id;
    private BigDecimal totalAmount;
    private String totalCurrency;
    private String status;

    @ElementCollection
    @CollectionTable(name = "order_lines", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderLineEmbeddable> lines;

    @Embeddable
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class OrderLineEmbeddable {
        private UUID productId;
        private String name;
        private int quantity;
        private BigDecimal unitPriceAmount;
        private String unitPriceCurrency;
    }
}

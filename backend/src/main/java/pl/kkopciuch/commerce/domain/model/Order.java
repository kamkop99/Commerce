package pl.kkopciuch.commerce.domain.model;


import pl.kkopciuch.commerce.domain.value.Money;

import java.util.List;
import java.util.UUID;

public record Order(UUID id, List<Line> lines, Money total, String status) {
    public record Line(UUID productId, String name, int quantity, Money unitPrice) {}
}

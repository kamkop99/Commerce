package pl.kkopciuch.commerce.domain.model;

import pl.kkopciuch.commerce.domain.value.Money;

import java.util.UUID;

public record Product(UUID id, String name, String description, String sku, String categoryName, Money price) {
}

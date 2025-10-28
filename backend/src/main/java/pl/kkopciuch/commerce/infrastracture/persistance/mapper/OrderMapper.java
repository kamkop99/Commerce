package pl.kkopciuch.commerce.infrastracture.persistance.mapper;

import org.mapstruct.*;
import pl.kkopciuch.commerce.domain.model.Order;
import pl.kkopciuch.commerce.domain.value.Money;
import pl.kkopciuch.commerce.infrastracture.persistance.OrderEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "total", expression = "java(new Money(e.getTotalAmount(), e.getTotalCurrency()))")
    Order toDomain(OrderEntity e);

    @Mapping(target = "totalAmount", expression = "java(o.total().amount())")
    @Mapping(target = "totalCurrency", expression = "java(o.total().currency())")
    OrderEntity toEntity(Order o);

    default List<Order.Line> toDomainLines(List<OrderEntity.OrderLineEmbeddable> es) {
        return es.stream().map(e ->
                new Order.Line(e.getProductId(), e.getName(), e.getQuantity(), new Money(e.getUnitPriceAmount(), e.getUnitPriceCurrency()))
        ).toList();
    }
    default List<OrderEntity.OrderLineEmbeddable> toEntityLines(List<Order.Line> ls) {
        return ls.stream().map(l ->
                OrderEntity.OrderLineEmbeddable.builder()
                .name(l.name())
                .productId(l.productId())
                .quantity(l.quantity())
                .unitPriceAmount(l.unitPrice().amount())
                .unitPriceCurrency(l.unitPrice().currency())
                .build()
        ).toList();
    }
}

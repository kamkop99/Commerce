package pl.kkopciuch.commerce.infrastracture.persistance.mapper;

import org.mapstruct.*;
import pl.kkopciuch.commerce.domain.model.Product;
import pl.kkopciuch.commerce.infrastracture.persistance.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "price", expression = "java(new Money(e.getPriceAmount(), e.getPriceCurrency()))")
    Product toDomain(ProductEntity e);

    @InheritInverseConfiguration
    @Mapping(target = "priceAmount", expression = "java(p.price().amount())")
    @Mapping(target = "priceCurrency", expression = "java(p.price().currency())")
    ProductEntity toEntity(Product p);
}

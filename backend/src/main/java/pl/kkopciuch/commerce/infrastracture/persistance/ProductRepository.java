package pl.kkopciuch.commerce.infrastracture.persistance;

import java.util.UUID;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    @Query("""
      SELECT p FROM ProductEntity p
      WHERE (:q = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%')))
      """)
    Page<ProductEntity> search(@Param("q") String q, Pageable pageable);
}

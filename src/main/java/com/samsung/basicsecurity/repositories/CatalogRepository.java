package com.samsung.basicsecurity.repositories;

import com.samsung.basicsecurity.repositories.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}

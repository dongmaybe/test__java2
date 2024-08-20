package com.samsung.basicsecurity.services;

import com.samsung.basicsecurity.repositories.CatalogRepository;
import com.samsung.basicsecurity.repositories.models.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    public Catalog getCatalogById(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }
}

package com.example.add_cart.model.service.serviceImpl;

import com.example.add_cart.model.entity.Product;
import com.example.add_cart.model.repository.IProductRepository;
import com.example.add_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}

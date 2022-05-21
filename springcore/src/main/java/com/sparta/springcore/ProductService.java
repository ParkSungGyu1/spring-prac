package com.sparta.springcore;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);

        this.productRepository.createProduct(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = this.productRepository.getProduct(id);
        if(product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }

        this.productRepository.updateMyPrice(id, requestDto.getMyprice());

        return product;

    }

    public List<Product> getProducts() throws SQLException {
        List<Product> product = this.productRepository.getProducts();

        return product;


    }
}

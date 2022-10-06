package br.com.fabio.produtosapi.service.impl;

import br.com.fabio.produtosapi.dto.ProductDto;
import br.com.fabio.produtosapi.exception.ObjectNotFoundException;
import br.com.fabio.produtosapi.exception.ValidationsExceptions;
import br.com.fabio.produtosapi.resource.model.Product;
import br.com.fabio.produtosapi.repository.ProductRepository;
import br.com.fabio.produtosapi.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto save(ProductDto productDto) {
        validarProductDto(productDto);
        Product product = modelMapper.map(productDto,Product.class) ;
        return modelMapper.map(productRepository.save(product),ProductDto.class);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(p -> modelMapper.map(p,ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Product not found with id -> "+id));
        return modelMapper.map(product,ProductDto.class) ;
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        findById(id);
        Product product = modelMapper.map(productDto,Product.class);
        return modelMapper.map(productRepository.save(product),ProductDto.class) ;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }

    @Override
    public void validarProductDto(ProductDto productDto) {
        if(productDto.getDescription().length() <= 2){
            throw new ValidationsExceptions("The description field is wrong.");
        }
        if(productDto.getDescription() == null ||
                productDto.getCost() == null ||
                productDto.getPrice() == null){
            throw new ValidationsExceptions("Cannot have null fields.");
        }
    }
}

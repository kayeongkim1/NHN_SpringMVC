package com.nhn.commerce.service

import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    fun findProductList(): List<Product> = productRepository.findProductList()

    fun getProductDetail(productNo: Int): Product = productRepository.getProductDetail(productNo)

    fun addProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime) =
        productRepository.addProductWork(productName, salePrice, registerYmdt)

    fun deleteProduct(productNo: Int) = productRepository.deleteProduct(productNo)

    //fun updateProductWork(productNo: Int, productName: String, salePrice: Int, registerYmdt: LocalDateTime) =
    fun updateProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime, productNo: Int) =
        productRepository.updateProductWork(productName, salePrice, registerYmdt, productNo)


}

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

//    fun addProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime) {
//        productRepository.addProductWork(productName, salePrice, registerYmdt)
//    }
    fun addProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime) {
        if (salePrice.numCheck(salePrice)) {
            throw Exception("가격이 0보다 작습니다. ")
        }
        productRepository.addProductWork(productName, salePrice, registerYmdt)
    }

    fun Int.numCheck (salePrice:Int):Boolean {
        if (salePrice < 0) {
            return true
        }
        return false
    }

    fun deleteProduct(productNo: Int) = productRepository.deleteProduct(productNo)

    //fun updateProductWork(productNo: Int, productName: String, salePrice: Int, registerYmdt: LocalDateTime) =
//    fun updateProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime, productNo: Int) =
//        productRepository.updateProductWork(productName, salePrice, registerYmdt, productNo)

    fun updateProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime, productNo: Int) {
        if (salePrice.numCheck(salePrice)) {
            throw Exception("가격이 0보다 작습니다. ")
        }
        productRepository.addProductWork(productName, salePrice, registerYmdt)
    }

}

package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.time.LocalDateTime


@Mapper
@Repository
interface ProductRepository {
    @Select("SELECT * FROM product")
    fun findProductList(): List<Product>

    @Select("SELECT * FROM product WHERE productNo = #{productNo}")
    fun getProductDetail(productNo: Int): Product

    @Delete("DELETE FROM product WHERE productNo = #{productNo}")
    fun deleteProduct(productNo: Int)

    @Insert("INSERT INTO product(productName, salePrice, registerYmdt, updateYmdt) VALUES (#{productName}, #{salePrice}, #{registerYmdt}, #{registerYmdt})")
    fun addProductWork(productName: String, salePrice: Int, registerYmdt: LocalDateTime)

//    @Update("UPDATE product SET productName=#{productName}, updateYmdt = #{registerYmdt}, salePrice=#{salePrice} WHERE productNo=#{productNo)")
//    fun updateProductWork(productNo: Int, productName: String, salePrice: Int, registerYmdt: LocalDateTime)

    @Update("UPDATE product SET productName=#{productName}, salePrice=#{salePrice}, updateYmdt=#{registerView} WHERE productNo=#{productNo}")
    fun updateProductWork(productName: String, salePrice: Int, registerView: LocalDateTime, productNo: Int)

}


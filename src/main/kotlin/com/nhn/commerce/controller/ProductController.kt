package com.nhn.commerce.controller

import com.nhn.commerce.model.Product
import com.nhn.commerce.service.ProductService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime

@Controller
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping("/product")
    fun getProductList(model: Model): String {
        model.addAttribute("productList", productService.findProductList())
        return "product"
    }

    // TODO (상품 상세 조회 기능 + Exception 처리)
    @GetMapping("/product/detail/{productNo}")
    fun getProductDetail(model: Model, @PathVariable("productNo") productNo: Int): String {
        ///// exception 처리...?
        val p: Product = productService.getProductDetail(productNo)
        if (p == null) {
            println("Exception")
            return ("product")
        }
        model.addAttribute("product", productService.getProductDetail(productNo))
        println("상세 조회")
        return "detail"
    }


    //////******** scope function + 확장 함수 사용 ㅜㅜ

    // TODO (상품 추가 기능)
    @GetMapping("/product/add")
    fun addProduct(): String {
        println("추가 시작")

        return "add"
    }

    @PostMapping("/product/addProduct")
    fun addProductWork(productName: String = "Default", salePrice: Int): String {

        productService.addProductWork(productName, salePrice, LocalDateTime.now())
        //println(productName)
        println("와우 추가 완")
        return "redirect:/product"
    }


    // TODO (상품 수정 기능 + Exception 처리)
    @GetMapping("/product/update/{productNo}")
    fun updateProduct(model: Model, @PathVariable("productNo") productNo: Int): String {


        model.addAttribute("product", productService.getProductDetail(productNo))
        //println("수정 시작")
        return "update"
    }


    @PostMapping("/product/updateProduct")
    fun updateProductWork(productName: String = "default", salePrice: Int, productNo: Int): String {
        val p: Product = productService.getProductDetail(productNo)
        
        productService.updateProductWork(productName, salePrice, LocalDateTime.now(), productNo)
        //println("업뎃 완~")
        return "redirect:/product"
    }


    // TODO (상품 삭제 기능 + Exception 처리)
    @GetMapping("/product/delete")

    fun deleteProduct(productNo: Int): String {
        val p: Product = productService.getProductDetail(productNo)
        if (p == null) {
            println("Exception")
            return ("product")
        }

        productService.deleteProduct(productNo)
        return "redirect:/product"
    }
}
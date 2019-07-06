package com.cgh.sell.controller;

import com.cgh.sell.bean.ProductCategory;
import com.cgh.sell.bean.ProductInfo;
import com.cgh.sell.service.ProductCategoryService;
import com.cgh.sell.service.ProductService;
import com.cgh.sell.service.impl.ProductCategoryServiceImpl;
import com.cgh.sell.service.impl.ProductServiceImpl;
import com.cgh.sell.utils.ResultVOUtil;
import com.cgh.sell.vo.ProductInfoVO;
import com.cgh.sell.vo.ProductVO;
import com.cgh.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();


        //2.查询类目（一次性查询）
        //传统方法
//        List<Integer> categoryTypeList =  new ArrayList<>();
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList =  productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVoList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVoList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVoList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();
//        ProductVO productVO = new ProductVO();
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
//        resultVO.setData(Arrays.asList(productVO));


        return ResultVOUtil.success(productVOList);
    }
}

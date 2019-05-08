package com.warehouse.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.warehouse.Dto.ProductDto;
import com.warehouse.config.WebMvcConfig;
import com.warehouse.model.AttributesDetail;
import com.warehouse.model.Brand;
import com.warehouse.model.Product;
import com.warehouse.model.ProductAttribute;
import com.warehouse.model.ProductType;
import com.warehouse.repository.AttributeDetailRepository;
import com.warehouse.repository.ProductAttributeReposiroty;
import com.warehouse.repository.ProductRepository;
import com.warehouse.utill.ProductUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private ProductAttributeReposiroty productAttributeReposiroty;
	
	@Mock
	private AttributeDetailRepository attributeDetailReposiroty;
	
	@Mock
	private ProductUtil productUtil;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(productService,"productRepository", productRepository);
		ReflectionTestUtils.setField(productService,"productAttributeReposiroty", productAttributeReposiroty);
		ReflectionTestUtils.setField(productService,"attributeDetailReposiroty", attributeDetailReposiroty);
		ReflectionTestUtils.setField(productService,"productUtil", productUtil);
	}
	
	@Test
	public void getAllProduct() throws Exception {
		List<Product> productList = getProductList();
		
		when(productRepository.findAll()).thenReturn(productList);
		Assert.assertNotNull(productService.getAllProduct());
	}
	
	@Test
	public void getProductById() throws Exception {
		Product product = getProduct();
		when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(product));
		when(productUtil.convertProducttoProductDtoo(Mockito.any())).thenReturn(getProductDto());
		
		Assert.assertNotNull(productService.getProduct(1));
	}
	
	@Test
	public void daleteProduct() throws Exception {
		String status = "Product Deleted";
		
		Mockito.doNothing().when(productRepository).deleteById(Mockito.anyInt());
		Assert.assertEquals(productService.deleteProduct(1), status);
	}
	
	@Test
	public void saveProduct() throws Exception {
		Product product = getProduct();
		ProductDto productDto = getProductDto();

		Optional<AttributesDetail> attributesDetail = getAttribute();
		
		when(productRepository.save(Mockito.any())).thenReturn(product);
		when(attributeDetailReposiroty.findById(Mockito.anyInt())).thenReturn(attributesDetail);
		
		Assert.assertNotNull(productService.saveProduct(productDto, productDto.getAttributeId() , productDto.getProductAttributeId()));
	}
	
	@Test
	public void updateProduct() throws Exception {
		Product product = getProduct();
		ProductDto productDto = getProductDto();
		productDto.setId(1);
		productDto.setProductAttributeId(1);
		
		Optional<AttributesDetail> attributesDetail = getAttribute();
		ProductAttribute productAttribute = new ProductAttribute();
		productAttribute.setId(1);
		productAttribute.setProduct(product);
		productAttribute.setAttributesDetail(attributesDetail.get());
		
		when(productRepository.save(Mockito.any())).thenReturn(product);
		when(attributeDetailReposiroty.findById(Mockito.anyInt())).thenReturn(attributesDetail);
		when(productAttributeReposiroty.save(productAttribute)).thenReturn(productAttribute);
		when(productUtil.convertProductDtotoProduct(Mockito.any())).thenReturn(getProduct());
		
		Assert.assertNotNull(productService.updateProduct(productDto, productDto.getAttributeId() , productDto.getProductAttributeId()));
	}
	
	public Product getProduct()
	{
		Product product = new Product();
		product.setId(1);
		product.setProductName("Shoe");
		
		Brand brand = new Brand();
		brand.setId(1);
		product.setBrand(brand);
		
		ProductType productType = new ProductType();
		productType.setId(1);
		product.setProductType(productType);
		
		return product;
	}
	
	public List<Product> getProductList()
	{
		Product product = new Product();
		product.setId(1);
		product.setProductName("Shoe");
		product.setMoq(1);
		product.setPrice("200");
		product.setQpb(1);
		product.setReorderPoint(10);
		
		Brand brand = new Brand();
		brand.setId(1);
		product.setBrand(brand);
		
		ProductType productType = new ProductType();
		productType.setId(1);
		product.setProductType(productType);
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		
		return productList;	
	}
	
	public ProductDto getProductDto()
	{
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setProductName("Shoe");
		productDto.setBrandId(1);
		productDto.setProductTypeId(1);
		productDto.setAttributeId(1);
		
		return productDto;
	}
	
	public Optional<AttributesDetail> getAttribute()
	{
		AttributesDetail attributeDetail = new AttributesDetail();
		attributeDetail.setId(1);
//		ProductAttribute productAttribute = new ProductAttribute();
//		productAttribute.setAttributesDetail(attributeDetail);
//		Set<ProductAttribute> productAttributeList = new HashSet<ProductAttribute>();
//		productAttributeList.add(productAttribute);
//		
		return Optional.of(attributeDetail);
	}
}

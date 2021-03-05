package it.academy.service;


import it.academy.dao.ProductDao;
import it.academy.dao.PromoDao;
import it.academy.dto.PromoAndProductDto;
import it.academy.model.Promo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Service("promoService")
@PropertySource("classpath:app.properties")
public class PromoService {

    @Value("${promo.service.name}")
    private String name;

    @Autowired
    @Qualifier("promoDaoImpl")
    private PromoDao promoDao;

    @Autowired
    private ProductDao productDao;

    public void init() {
        System.out.println("Call init()");
        this.name = "promoService3";
    }

    public void destroy() {
        System.out.println("Call destroy()");
    }

    public void printPromo() {
        System.out.println("Hi,I have promo for you!");
        promoDao.findAllPromo().forEach(System.out::println);
    }

    static PromoService create() {
        System.out.println("Call create()");
        PromoService promoService = new PromoService();
        promoService.setName("promoService2");
        return promoService;
    }

    public List<Promo> findAllPromo() {
        return promoDao.findAllPromo();/*.stream()
                .map(promo -> {
                    promo.setDescription("New promo");
                    return promo;
                }).collect(Collectors.toList());*/
    }

    public PromoAndProductDto findPromoAndProduct() {
        PromoAndProductDto dto = new PromoAndProductDto();
        int promoCount = promoDao.getPromoCount();
        int productCount= productDao.getProductCount();

        dto.setPromoCont(promoCount);
        dto.setProductCont(productCount);

        return dto;
    }
}

package com.example.xmlex.model.dto.userDto;

import com.example.xmlex.model.dto.productDto.ProductViewWithBuyerDto;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProducts {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlElement(name = "product")
    @XmlElementWrapper(name = "sold-products")
    private Set<ProductViewWithBuyerDto> products;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductViewWithBuyerDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewWithBuyerDto> products) {
        this.products = products;
    }
}

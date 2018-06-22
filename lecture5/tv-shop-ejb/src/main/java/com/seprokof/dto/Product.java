package com.seprokof.dto;

import java.io.Serializable;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Represents product entity.
 * 
 * @author seprokof
 *
 */
@Entity
@Vetoed
@NamedQuery(name = Product.GET_ALL, query = "SELECT p FROM Product p")
public class Product implements Serializable {
    private static final long serialVersionUID = -4619717116539744019L;
    public static final String GET_ALL = "getAllProducts";

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = true)
    private Integer diagonal;
    @Column(nullable = true)
    private String screenResolution;
    @Column(nullable = true)
    private String screenFormat;
    @Column(nullable = true)
    private String imageName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getScreenFormat() {
        return screenFormat;
    }

    public void setScreenFormat(String screenFormat) {
        this.screenFormat = screenFormat;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((diagonal == null) ? 0 : diagonal.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((screenFormat == null) ? 0 : screenFormat.hashCode());
        result = prime * result + ((screenResolution == null) ? 0 : screenResolution.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (diagonal == null) {
            if (other.diagonal != null) {
                return false;
            }
        } else if (!diagonal.equals(other.diagonal)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (imageName == null) {
            if (other.imageName != null) {
                return false;
            }
        } else if (!imageName.equals(other.imageName)) {
            return false;
        }
        if (model == null) {
            if (other.model != null) {
                return false;
            }
        } else if (!model.equals(other.model)) {
            return false;
        }
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals(other.price)) {
            return false;
        }
        if (screenFormat == null) {
            if (other.screenFormat != null) {
                return false;
            }
        } else if (!screenFormat.equals(other.screenFormat)) {
            return false;
        }
        if (screenResolution == null) {
            if (other.screenResolution != null) {
                return false;
            }
        } else if (!screenResolution.equals(other.screenResolution)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", model=" + model + ", price=" + price + ", diagonal=" + diagonal
                + ", screenResolution=" + screenResolution + ", screenFormat=" + screenFormat + ", imageName="
                + imageName + "]";
    }

}

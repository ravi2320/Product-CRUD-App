package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void createProduct(Product product) {
        this.hibernateTemplate.saveOrUpdate(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return this.hibernateTemplate.loadAll(Product.class);
    }

    // Delete a single product
    @Transactional
    public void deleteProduct(int pid) {
        Product p = this.hibernateTemplate.get(Product.class, pid);
        if (p != null) {
            this.hibernateTemplate.delete(p);
        } else {
            throw new RuntimeException("Product not found with id: " + pid);
        }
    }

    // Get a single product
    @Transactional
    public Product getProduct(int pid) {
        return this.hibernateTemplate.get(Product.class, pid);
    }
}

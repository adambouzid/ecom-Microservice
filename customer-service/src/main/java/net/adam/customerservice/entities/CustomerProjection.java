package net.adam.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="all", types = Customer.class)
public interface CustomerProjection {
    String getemail();
    String getnom();
}

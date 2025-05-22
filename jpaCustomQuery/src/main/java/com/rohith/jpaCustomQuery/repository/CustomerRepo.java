package com.rohith.jpaCustomQuery.repository;

import com.rohith.jpaCustomQuery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.city = :city")
    List<Customer> getCustomerByCity(@Param("city") String city);

    @Query("SELECT c FROM Customer c WHERE c.name LIKE CONCAT(:prefix, '%')")
    List<Customer> getCustomerByInitial(@Param("prefix") String prefix);

    @Query("SELECT c FROM Customer c WHERE c.email LIKE CONCAT('%', :domain)")
    List<Customer> getCustomerByemailDomain(@Param("domain") String domain);

    @Query("SELECT COUNT(c) FROM Customer c WHERE c.email LIKE CONCAT('%', :domain)")
    Long countOfTotalCustomersByDomain(@Param("domain") String domain);

    @Query("SELECT c FROM Customer c WHERE c.city <> :city")
    List<Customer> customerNotInCity(@Param("city") String city);
}

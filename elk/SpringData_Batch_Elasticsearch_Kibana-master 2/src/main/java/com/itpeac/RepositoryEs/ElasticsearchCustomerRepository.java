package com.itpeac.RepositoryEs;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.itpeac.domain.Customer;


// Save customer to ElasticSearch
public interface ElasticsearchCustomerRepository extends ElasticsearchCrudRepository<Customer, Integer> {

}

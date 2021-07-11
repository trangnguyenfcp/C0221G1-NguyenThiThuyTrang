package com.codegym.model.repository;

import com.codegym.model.entity.Username;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<Username, String> {
}

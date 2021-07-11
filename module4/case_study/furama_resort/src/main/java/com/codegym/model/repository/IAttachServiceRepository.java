package com.codegym.model.repository;

import com.codegym.model.entity.AttachService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends PagingAndSortingRepository<AttachService, Long> {
}

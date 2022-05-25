package com.spring.springapiprac.repository;

import com.spring.springapiprac.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
}

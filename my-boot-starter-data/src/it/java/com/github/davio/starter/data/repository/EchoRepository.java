package com.github.davio.starter.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EchoRepository extends JpaRepository<EchoEntity, Long> {
}

package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Author;

@Repository
public interface IAuthRepo extends JpaRepository<Author, Long> {

}

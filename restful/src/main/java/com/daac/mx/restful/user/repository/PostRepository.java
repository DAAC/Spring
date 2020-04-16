package com.daac.mx.restful.user.repository;

import com.daac.mx.restful.user.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

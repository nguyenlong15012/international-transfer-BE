package com.example.InternationalTransfer.repository;

import com.example.InternationalTransfer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Thêm các phương thức tùy chỉnh nếu cần
}

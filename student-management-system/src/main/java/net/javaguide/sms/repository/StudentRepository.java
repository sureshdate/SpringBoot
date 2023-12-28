package net.javaguide.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
//jpa repository contains 2 value first 1 is entity name second is primary value type.
}

package org.likelion.likelionassignmentcrud.rent.domain.repository;

import java.util.List;
import org.likelion.likelionassignmentcrud.user.domain.Student;
import org.likelion.likelionassignmentcrud.rent.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

// 제너릭스 타입으로 엔티티의 타입과 속성을 지정한다.
public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByStudent(Student student);
}

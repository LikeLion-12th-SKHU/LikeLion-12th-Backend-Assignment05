package org.likelion.likelionassignmentcrud.user.domain.respository;

import org.likelion.likelionassignmentcrud.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// 제너릭스 타입으로 엔티티의 타입과 속성을 지정한다.
public interface StudentRepository extends JpaRepository<Student, Long> {
}

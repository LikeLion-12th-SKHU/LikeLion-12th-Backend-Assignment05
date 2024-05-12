package org.likelion.likelionassignmentcrud.rant.domain.repository;

import java.util.List;
import org.likelion.likelionassignmentcrud.user.domain.Student;
import org.likelion.likelionassignmentcrud.rant.domain.Rant;
import org.springframework.data.jpa.repository.JpaRepository;

// 제너릭스 타입으로 엔티티의 타입과 속성을 지정한다.
public interface RantRepository extends JpaRepository<Rant, Long> {
    List<Rant> findByStudent(Student student);
}

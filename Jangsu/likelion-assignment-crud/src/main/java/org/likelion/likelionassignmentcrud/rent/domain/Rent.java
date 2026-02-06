package org.likelion.likelionassignmentcrud.rent.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.likelionassignmentcrud.user.domain.Student;

@Entity // 이 클래스가 엔티티임을 알림
@Getter // get 함수를 사용할 수 있게 함
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자 생성(기본 생성자를 protected 로 설정)
public class Rent {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentId")
    private Long rentId;            // 대출 고유번호, PK
    private String rentTime;        // 대출한 시간
    private String returnTime;      // 반납할 시간
    private String bookName;        //책 이름

    @ManyToOne(fetch = FetchType.LAZY)  // N : 1, 책은 여러권 빌릴수 있으므로.(지연 로딩)
    @JoinColumn(name = "studentId")       // 외래키를 맵핑할 때 사용.
    private Student student;

    // 초기화
    @Builder // 빌더 패턴을 이용해 만들 수 있게 지정하는 어노테이션
    private Rent(Long rentId, String rentTime, String returnTime, String bookName, Student student) {
        this.rentId = rentId;
        this.rentTime = rentTime;
        this.returnTime = returnTime;
        this.bookName = bookName;
        this.student = student;
    }
}
// 엔티티 : 데이터베이스 테이블과 매핑되는 자바 클래스
// 어노테이션 : 다른 프로그램에게 유용한 정보를 제공하기 위해 사용되는 것으로 주석과 같은 의미
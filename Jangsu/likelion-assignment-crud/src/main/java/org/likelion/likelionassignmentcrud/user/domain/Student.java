package org.likelion.likelionassignmentcrud.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.likelionassignmentcrud.rant.domain.Rant;

import java.util.ArrayList;
import java.util.List;

@Entity // 이 클래스가 엔티티임을 알림
@Getter // get 메소드를 사용 가능하게 함
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터가 없는 기본 생성자 생성(기본 생성자를 protected 로 설정)
public class Student {

    @Id     //PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 설정을 데이터베이스에 위임
    @Column(name = "studentId")   //맵핑할 테이블의 컬럼 이름을 지정
    private Long studentId;       // 학번, PK

    private String name;          // 이름

    // 열거형, 사전에 정리된 상수들의 집합, 가독성 향상, 값 할당의 무결을 담당함.
    @Enumerated(EnumType.STRING)
    private Major major;        // 전공, 열거형

    /*
       1 : N, 사람은 한명만 있을 수 있으므로.
       (연관관계의 주인을 정하기 위해서 사용,
       특정 엔티티를 영속상태를 만들기 위해, 부모자식을 한번에 영속화 / 엔티티를 모두 제거할 때 사용(두 기능을 모두 수행함),
       고아가 된 자식객체를 삭제를 허용할 것인지 말것인지 설정)
    */
    @OneToMany(mappedBy = "rantId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rant> rants = new ArrayList<>();

    // 초기화
    @Builder // 빌더 패턴을 이용해 만들 수 있게 지정하는 어노테이션
    private Student(Long studentId, String name, Major major) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
    }
}
// 엔티티 : 데이터베이스 테이블과 매핑되는 자바 클래스
// 어노테이션 : 다른 프로그램에게 유용한 정보를 제공하기 위해 사용되는 것으로 주석과 같은 의미
// 영속화 : 자바는 JVM 안에서 존재하는데 JVM에 있던 객체를 밖에서도 지속하게 할 수 있는 것(?)
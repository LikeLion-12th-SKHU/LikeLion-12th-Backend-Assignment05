package org.likelion.likelionassignmentcrud.rent.application;

import org.likelion.likelionassignmentcrud.rent.api.dto.request.RentSaveReqDto;
import org.likelion.likelionassignmentcrud.rent.api.dto.response.RentInfoResDto;
import org.likelion.likelionassignmentcrud.rent.api.dto.response.RentListResDto;
import org.likelion.likelionassignmentcrud.rent.domain.Rent;
import org.likelion.likelionassignmentcrud.rent.domain.repository.RentRepository;
import org.likelion.likelionassignmentcrud.user.domain.Student;
import org.likelion.likelionassignmentcrud.user.domain.respository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RentService {
    private final RentRepository rentRepository;
    private final StudentRepository studentRepository;

    public RentService(RentRepository rentRepository, StudentRepository studentRepository) {
        this.rentRepository = rentRepository;
        this.studentRepository = studentRepository;
    }

    // 생성
    @Transactional
    public void rentSave(RentSaveReqDto rentSaveReqDto) {
        Student student = studentRepository.findById(rentSaveReqDto.rentId())
                .orElseThrow(IllegalArgumentException::new);

        Rent rent = Rent.builder()
                .rentId(rentSaveReqDto.rentId())
                .rentTime(rentSaveReqDto.rentTime())
                .returnTime(rentSaveReqDto.returnTime())
                .bookName(rentSaveReqDto.bookName())
                .student(student).build();

        rentRepository.save(rent);
    }

    // 대출 보기
    public RentListResDto rentStatusFind(Long rentId) {
        Student student = studentRepository.findById(rentId)
                .orElseThrow(()-> new IllegalArgumentException("해당하는 학생은 없습니다. id" + rentId));

        List<Rent> rants = rentRepository.findByStudent(student);
        List<RentInfoResDto> rentInfoResDtoList = rants.stream()
                .map(RentInfoResDto::from).toList();

        return RentListResDto.from(rentInfoResDtoList);
    }
}
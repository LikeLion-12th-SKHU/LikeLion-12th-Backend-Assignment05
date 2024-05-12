package org.likelion.likelionassignmentcrud.rant.application;

import org.likelion.likelionassignmentcrud.rant.api.dto.request.RantSaveReqDto;
import org.likelion.likelionassignmentcrud.rant.api.dto.response.RantInfoResDto;
import org.likelion.likelionassignmentcrud.rant.api.dto.response.RantListResDto;
import org.likelion.likelionassignmentcrud.rant.domain.Rant;
import org.likelion.likelionassignmentcrud.rant.domain.repository.RantRepository;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentInfoResDto;
import org.likelion.likelionassignmentcrud.user.api.dto.response.StudentListResDto;
import org.likelion.likelionassignmentcrud.user.domain.Student;
import org.likelion.likelionassignmentcrud.user.domain.respository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RantService {
    private final RantRepository rantRepository;
    private final StudentRepository studentRepository;

    public RantService(RantRepository rantRepository, StudentRepository studentRepository) {
        this.rantRepository = rantRepository;
        this.studentRepository = studentRepository;
    }

    // 생성
    @Transactional
    public void rantSave(RantSaveReqDto rantSaveReqDto) {
        Student student = studentRepository.findById(rantSaveReqDto.rantId())
                .orElseThrow(IllegalArgumentException::new);

        Rant rant = Rant.builder()
                .rantId(rantSaveReqDto.rantId())
                .rantTime(rantSaveReqDto.rantTime())
                .returnTime(rantSaveReqDto.returnTime())
                .bookName(rantSaveReqDto.bookName())
                .student(student).build();

        rantRepository.save(rant);
    }

    // 대출 보기
    public RantListResDto rantStatusFind(Long rantId) {
        Student student = studentRepository.findById(rantId)
                .orElseThrow(IllegalArgumentException::new);

        List<Rant> rants = rantRepository.findByStudent(student);
        List<RantInfoResDto> rantInfoResDtoList = rants.stream()
                .map(RantInfoResDto::from).toList();

        return RantListResDto.from(rantInfoResDtoList);
    }
}
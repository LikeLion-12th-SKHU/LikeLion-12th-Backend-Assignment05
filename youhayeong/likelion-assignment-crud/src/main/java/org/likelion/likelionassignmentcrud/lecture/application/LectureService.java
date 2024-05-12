package org.likelion.likelionassignmentcrud.lecture.application;

import org.likelion.likelionassignmentcrud.lecture.api.dto.request.LectureSaveReqDto;
import org.likelion.likelionassignmentcrud.lecture.api.dto.response.LectureInfoResDto;
import org.likelion.likelionassignmentcrud.lecture.api.dto.response.LectureListResDto;
import org.likelion.likelionassignmentcrud.lecture.domain.Lecture;
import org.likelion.likelionassignmentcrud.lecture.domain.repository.LectureRepository;
import org.likelion.likelionassignmentcrud.professor.domain.Professor;
import org.likelion.likelionassignmentcrud.professor.domain.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LectureService {
    private final ProfessorRepository professorRepository;
    private final LectureRepository lectureRepository;

    public LectureService(ProfessorRepository professorRepository, LectureRepository lectureRepository) {
        this.professorRepository = professorRepository;
        this.lectureRepository = lectureRepository;
    }

    //Create
    @Transactional
    public void lectureSave(LectureSaveReqDto lectureSaveReqDto) {
        Professor professor = professorRepository.findById(lectureSaveReqDto.professorId()).orElseThrow(IllegalArgumentException::new);

        Lecture lecture = Lecture.builder()
                .title(lectureSaveReqDto.title())
                .grade(lectureSaveReqDto.grade())
                .professor(professor)
                .build();

        lectureRepository.save(lecture);
    }

    //교수에 따른 강의 조회
    public LectureListResDto lectureFindProfessor(Long professorId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow(IllegalArgumentException::new);

        List<Lecture> lectures = lectureRepository.findByProfessor(professor);
        List<LectureInfoResDto> lectureInfoResDtoList = lectures.stream()
                .map(LectureInfoResDto::from)
                .toList();

        return LectureListResDto.from(lectureInfoResDtoList);
    }
}
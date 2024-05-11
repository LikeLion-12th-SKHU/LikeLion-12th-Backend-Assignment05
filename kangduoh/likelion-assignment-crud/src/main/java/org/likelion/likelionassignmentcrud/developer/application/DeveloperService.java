package org.likelion.likelionassignmentcrud.developer.application;

import org.likelion.likelionassignmentcrud.developer.api.dto.request.DeveloperSaveReqDto;
import org.likelion.likelionassignmentcrud.developer.api.dto.response.DeveloperInfoResDto;
import org.likelion.likelionassignmentcrud.developer.api.dto.response.DeveloperListResDto;
import org.likelion.likelionassignmentcrud.developer.domain.Developer;
import org.likelion.likelionassignmentcrud.developer.domain.repository.DeveloperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    // 개발사 저장
    @Transactional
    public void developerSave(DeveloperSaveReqDto developerSaveReqDto) {
        Developer developer = Developer.builder()
                .name(developerSaveReqDto.name())
                .country(developerSaveReqDto.country())
                .establishedDate(developerSaveReqDto.establishedDate())
                .build();

        developerRepository.save(developer);
    }

    // 개발사 조회(모두)
    public DeveloperListResDto developerFindAll() {
        List<Developer> developers = developerRepository.findAll();

        List<DeveloperInfoResDto> developerInfoResDtoList = developers.stream()
                .map(DeveloperInfoResDto::from)
                .toList();

        return DeveloperListResDto.from(developerInfoResDtoList);
    }
}

package com.BaGulBaGul.BaGulBaGul.domain.recruitment.service;

import com.BaGulBaGul.BaGulBaGul.domain.recruitment.Recruitment;
import com.BaGulBaGul.BaGulBaGul.domain.recruitment.dto.RecruitmentRequestDto;
import com.BaGulBaGul.BaGulBaGul.domain.recruitment.dto.RecruitmentResponseDto;
import com.BaGulBaGul.BaGulBaGul.domain.recruitment.repository.RecruitmentCommentRepository;
import com.BaGulBaGul.BaGulBaGul.domain.recruitment.repository.RecruitmentLikeRepository;
import com.BaGulBaGul.BaGulBaGul.domain.recruitment.repository.RecruitmentRepository;
import com.BaGulBaGul.BaGulBaGul.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentCommentRepository recruitmentCommentRepository;
    private final RecruitmentLikeRepository recruitmentLikeRepository;

    // 모집글 저장
    @Transactional
    public ApiResponse save(RecruitmentRequestDto.RInfo requestDto){

        Recruitment recruitment = Recruitment.builder()
                        // 개발 예정
                        .build();
        recruitmentRepository.save(recruitment);
        return ApiResponse.of(recruitment);

    }

    // 모집글 단일 조회
    public RecruitmentResponseDto.RInfo getRecruitment(Long id){

        // 예외 처리 예정
        Recruitment recruitment = recruitmentRepository.findById(id).orElse(null);

        return RecruitmentResponseDto.RInfo.builder()
                .title(recruitment.getTitle())
                .content(recruitment.getContent())
                .tags(recruitment.getTags())
                .imageURL(recruitment.getImageURL())
                .startDate(recruitment.getStartDate())
                .endDate(recruitment.getEndDate())
                .commentCount(recruitmentCommentRepository.countByRecruitmentId(recruitment.getId()))
                .likeCount(recruitmentLikeRepository.countByRecruitmentId(recruitment.getId()))
                // 추후 개발
                .category("")
                // *****
                .createdAt(recruitment.getCreatedAt())
                .lastModifiedAt(recruitment.getLastModifiedAt())
                .build();
    }

    // 모집글 전체 조회
    public List<RecruitmentResponseDto.RInfoWithPaging> getRecruitments(Long id, Integer offset){
        PageRequest pageRequest = PageRequest.of(offset, 20);
        return recruitmentRepository.findRecruitmentByPostId(id, pageRequest);
    }
}

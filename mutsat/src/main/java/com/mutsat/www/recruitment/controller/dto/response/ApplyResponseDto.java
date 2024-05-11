package com.mutsat.www.recruitment.controller.dto.response;

import lombok.Builder;

@Builder
public record ApplyResponseDto(long recruitmentId, long memberId) {
	public static ApplyResponseDto of(long recruitmentId, long memberId){
		return ApplyResponseDto.builder()
			.memberId(memberId)
			.recruitmentId(recruitmentId)
			.build();
	}
}

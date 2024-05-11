package com.mutsat.www.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MutsatMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private CareerRank rank;

	@Builder
	private MutsatMember(@NonNull String name, @NonNull String phoneNumber, CareerRank rank) { //rank는 없으면 하사.
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.rank = updateRank(rank);
	}

	public CareerRank updateRank(CareerRank rank){
		if(rank != null){
			return rank;
		}
		return CareerRank.PRIVATE;
	}
}

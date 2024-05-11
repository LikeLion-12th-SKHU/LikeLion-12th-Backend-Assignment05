package org.likelion.likelionassignmentcrud.game.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.likelionassignmentcrud.developer.domain.Developer;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    private String name;
    private String genre;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @Builder
    private Game(String name, String genre, Platform platform, Developer developer) {
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.developer = developer;
    }
}

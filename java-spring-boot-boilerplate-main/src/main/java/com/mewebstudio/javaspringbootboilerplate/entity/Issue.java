package com.mewebstudio.javaspringbootboilerplate.entity;

import com.mewebstudio.javaspringbootboilerplate.enums.IssueStatus;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "issues")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    private String description;

    @Column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

}

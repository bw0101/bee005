package com.bee.bee005.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="File")
@RequiredArgsConstructor
public class Bee {

    @Id
    private Long id;

    private String version;
    private String path;
    private String type;
    private String description;

}

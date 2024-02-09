package com.restAPI.portfolio.Entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;




@Data
@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    private String about;
    private String link;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "project_skill",
        joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
    @Fetch(FetchMode.JOIN)
    private Set<SkillEntity> skills = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @JoinTable(name = "project_tag", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<TagEntity> tags = new HashSet<>();


@Override
public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    ProjectEntity other = (ProjectEntity) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}

@PostLoad
    private void init() {
        skills.size(); 
        tags.size(); 
    }
}

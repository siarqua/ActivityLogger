package org.some.pkg.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by siarqua on 10.08.15.
 */
@Entity
@Table(name = "activities")
@JsonIdentityInfo(scope = Activity.class, property="id", generator=ObjectIdGenerators.PropertyGenerator.class)
public class Activity implements Serializable {

    private static final long serialVersionUID = 1582306582762431421L;

    public Activity() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activities_id_seq")
    @SequenceGenerator(name="activities_id_seq", sequenceName="ACTIVITIES_ENTITY_SEQ")
    private Long id;

    @Column(name = "user_id", nullable = false, unique = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type" ,nullable = false, unique = false)
    private ActivityType type;

    @OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detail> details;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<Detail> getDetails() {
        return details;
    }
    public ActivityType getType() {
        return type;
    }
    public void setType(ActivityType type) {
        this.type = type;
    }
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", details=" + details +
                '}';
    }
}

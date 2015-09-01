package org.some.pkg.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by siarqua on 10.08.15.
 */
@Entity
@Table(name="details")
@JsonIdentityInfo(scope = Detail.class, property="id", generator=ObjectIdGenerators.PropertyGenerator.class)
public class Detail implements Serializable{

    private static final long serialVersionUID = -5175700832040455673L;
    public Detail() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="details_id_seq")
    @SequenceGenerator(name="details_id_seq", sequenceName="DETAILS_ENTITY_SEQ")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start", nullable = false, unique = false)
    private Date startTime;

    @Column(name = "finish", nullable = true, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    @ManyToOne(optional = false)
    private Activity activity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Activity getActivity() {
        return activity;
    }
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
/*                ", activity=" + activity.getId() +*/
                '}';
    }
}

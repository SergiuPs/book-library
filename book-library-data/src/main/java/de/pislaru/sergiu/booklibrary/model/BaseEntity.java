package de.pislaru.sergiu.booklibrary.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "opt_lock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private Long version = 0L;

    private Long createdBy;
    private Long updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void setCreationDate() {this.createdAt = LocalDateTime.now();}

    @PreUpdate
    public void setChangeDate() {this.updatedAt = LocalDateTime.now();}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getVersion() {return version;}
    public void setVersion(Long version) {this.version = version;}
    public Long getCreatedBy() {return createdBy;}
    public void setCreatedBy(Long createdBy) {this.createdBy = createdBy;}
    public Long getUpdatedBy() {return updatedBy;}
    public void setUpdatedBy(Long updatedBy) {this.updatedBy = updatedBy;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        BaseEntity baseEntity = (BaseEntity) object;

        return Objects.equals(id, baseEntity.getId()) &&
                Objects.equals(version, baseEntity.version) &&
                Objects.equals(createdBy, baseEntity.createdBy) &&
                Objects.equals(createdAt, baseEntity.createdAt) &&
                Objects.equals(updatedBy, baseEntity.updatedBy) &&
                Objects.equals(updatedAt, baseEntity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createdBy, createdAt, updatedBy, updatedAt);
    }

    @Override
    public String toString() {
        return "Base Entity { "
                + "id=" + id
                + ", version=" + version
                + ", created-by=" + createdBy
                + ", created-at=" + createdAt
                + ", updated-by=" + updatedBy
                + ", updated-at=" + updatedAt
                + "}";
    }
}

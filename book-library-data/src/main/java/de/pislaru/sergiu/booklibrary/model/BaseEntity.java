package de.pislaru.sergiu.booklibrary.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
        if (!(object instanceof BaseEntity that)) {
            return false;
        }

        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
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

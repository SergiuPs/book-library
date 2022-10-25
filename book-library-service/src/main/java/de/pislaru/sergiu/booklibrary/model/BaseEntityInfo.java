package de.pislaru.sergiu.booklibrary.model;

import javax.persistence.Column;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Objects;

public class BaseEntityInfo {

    private Long id;
    private Long version;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntityInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        BaseEntityInfo baseEntity = (BaseEntityInfo) object;

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
        return "Base Entity Info { "
                + "id=" + id
                + ", version=" + version
                + ", created-by=" + createdBy
                + ", created-at=" + createdAt
                + ", updated-by=" + updatedBy
                + ", updated-at=" + updatedAt
                + "}";
    }
}

package finalProject.dto;

import java.time.LocalDateTime;

public class UpdateLawyerDTO extends LawyerDTO{

    private Integer id;
    private String uuid;
    private LocalDateTime updatedAt;

    public UpdateLawyerDTO(Integer id, String uuid, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

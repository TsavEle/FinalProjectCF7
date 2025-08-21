package finalProject.dto;

public class InsertLawyerDTO extends LawyerDTO{

    private Integer id;
    private String uuid;
    private String created_at;
    private String updated_at;

    public InsertLawyerDTO() {

    }

    public InsertLawyerDTO(Integer id, String uuid, String created_at, String updated_at) {

        this.id = id;
        this.uuid = uuid;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}

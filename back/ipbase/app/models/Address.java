package models;

public class Address {
    private Long    id;
    private String  ip;
    private Integer port;
    private String  description;
    private Long    groupId;

    public Address() { }

    public Address(Long id, String ip, Integer port, String description, Long groupId) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.description = description;
        this.groupId= groupId;
    }

    public Long getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public Integer getPort() {
        return this.port;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
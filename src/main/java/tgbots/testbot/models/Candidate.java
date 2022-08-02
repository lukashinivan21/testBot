package tgbots.testbot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @Column(name = "id_candidate")
    private Long id;

    @Column(name = "name_candidate")
    private String name;

    @Column(name = "username_candidate")
    private String userName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "bot_state")
    private String botState;

    public Candidate(Long id, String name, String userName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public Candidate() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBotState() {
        return botState;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBotState(String botState) {this.botState = botState;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id.equals(candidate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

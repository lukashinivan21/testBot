package tgbots.testbot.models;

import javax.persistence.Entity;



@Entity
public class CatOwner extends Candidate {

    public CatOwner() {
        super();
    }

    public CatOwner(Long id, String name, String userName, String phoneNumber, String botState) {
        super(id, name, userName, phoneNumber, botState);
    }
}

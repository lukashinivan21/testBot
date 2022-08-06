package tgbots.testbot.models;

import javax.persistence.Entity;


@Entity
public class DogOwner extends Candidate{

    public DogOwner() {
        super();
    }

    public DogOwner(Long id, String name, String userName, String phoneNumber, String botState) {
        super(id, name, userName, phoneNumber, botState);
    }
}

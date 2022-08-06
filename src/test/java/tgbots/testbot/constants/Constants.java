package tgbots.testbot.constants;

import tgbots.testbot.models.CatOwner;
import tgbots.testbot.models.DogOwner;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final List<DogOwner> DOG_OWNER_LIST = new ArrayList<>(List.of(
            new DogOwner(125L, "John", "Joe2358", "139", "DIALOG"),
            new DogOwner(23L, "Steve", "ST_12", "235", "DIALOG"),
            new DogOwner(42L, "Frank", "Frey48", "8721", "DIALOG"),
            new DogOwner(30L, "David", "D_D23", "789521", "DIALOG")
    ));


    public static final List<CatOwner> CAT_OWNER_LIST = new ArrayList<>(List.of(
            new CatOwner(235L, "Kate", "Kitty87", "684", "DIALOG"),
            new CatOwner(12L, "Anna", "AN24", "687", "DIALOG"),
            new CatOwner(65L, "Mari", "Masha33", "9574", "DIALOG"),
            new CatOwner(17L, "Lisa", "LiLi12", "9674", "DIALOG")
    ));

    public static final DogOwner DOG_OWNER = new DogOwner(125L, "John", "Joe2358", "139", "DIALOG");

    public static final CatOwner CAT_OWNER = new CatOwner(12L, "Anna", "AN24", "687", "DIALOG");


}

package model;

import lombok.*;

import javax.persistence.OneToMany;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favourite {

    @OneToMany
    private int favouriteId;

    private int userId;

}

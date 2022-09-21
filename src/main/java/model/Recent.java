package model;

import lombok.*;

import javax.persistence.OneToMany;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recent {

    @OneToMany
    private int recentTracksId;

    private int userId;
}

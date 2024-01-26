package boraldan.semi5hw2.domen;

import lombok.*;

import java.io.Serializable;

@Data
public class IdUserProject implements Serializable {
    private Long project;
    private Long user;
}

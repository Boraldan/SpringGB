package boraldan.resource_oauth2.model;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
     Info info;
     List<Result> results;
}

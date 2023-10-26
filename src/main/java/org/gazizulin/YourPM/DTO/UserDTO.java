package org.gazizulin.YourPM.DTO;

import jakarta.websocket.OnOpen;
import lombok.*;

/**
 * @author Timur Gazizulin
 */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;

}

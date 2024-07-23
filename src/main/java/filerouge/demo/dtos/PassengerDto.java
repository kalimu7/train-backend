package filerouge.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class PassengerDto {

    public Long Id;
    public String email;
    public String name;
    public String cin;
    public String password;



}

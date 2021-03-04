package online.shop.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    @NotBlank
    @Size(min = 6,message = "Password lenght sould be at least 6 symbol")
    private String password;
    @Size(min = 6,message = "Password lenght sould be at least 6 symbol")
    private String confirmPassword;
}

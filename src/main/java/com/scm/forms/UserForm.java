package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    // Now we have to validate this feilds so for that we are going to use spring
    // Boot starter validation dependency
    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Min 3 character is required")
    private String name;
    @Email(message = "Invaild Email Address")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Min 6 charater is required")
    private String password;
    @NotBlank(message = "About is complusory required")
    private String about;
    @Size(min = 8, max = 12, message = "Invaild phone number")
    private String phoneNumber;

}

package com.example.food_order.pojo;


import com.example.food_order.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;

    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotEmpty(message = "Full name can't be empty")
    private String fullname;

    @NotEmpty(message = "Mobile Number can't be empty")
    private String mobile_no;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    private MultipartFile image;

    public UserPojo(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.fullname=user.getFullName();
        this.mobile_no=user.getMobileNo();
        this.password=user.getPassword();
    }


}

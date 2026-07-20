package lk.ijse.OrderManagementSystem.Controller;

import lk.ijse.OrderManagementSystem.Constant.CommonResponse;
import lk.ijse.OrderManagementSystem.DTO.AuthDTO;
import lk.ijse.OrderManagementSystem.DTO.UserDTO;
import lk.ijse.OrderManagementSystem.DTO.UserDataDTO;
import lk.ijse.OrderManagementSystem.Security.JwtUtil;
import lk.ijse.OrderManagementSystem.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static lk.ijse.OrderManagementSystem.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.OrderManagementSystem.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("v1/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse authLogin(@RequestBody AuthDTO authDTO){
        UserDTO userDetails = userService.getUserDetails(authDTO.getUserName(), authDTO.getPassword());
        System.out.println("API called here");
        String token = jwtUtil.generateToken(userDetails);

        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setUserId(userDetails.getUserId());
        userDataDTO.setToken(token);
        return new CommonResponse(0,userDataDTO,"JWT Token");
    }

    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse registerUser(@RequestBody UserDTO userDTO) {
        UserDTO saveUser = userService.saveUser(userDTO);
        return new CommonResponse(OPERATION_SUCCESS,saveUser,SUCCESS_MESSAGE);
    }
}

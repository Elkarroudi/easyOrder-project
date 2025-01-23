package com.wora.easyOrder.controller.v1;

import com.wora.easyOrder.dto.group.OnCustomerCreation;
import com.wora.easyOrder.dto.group.OnDeliveryManCreation;
import com.wora.easyOrder.dto.request.AuthRequestDTO;
import com.wora.easyOrder.dto.request.UserRequestDTO;
import com.wora.easyOrder.dto.response.AuthResponseDTO;
import com.wora.easyOrder.dto.response.UserResponseDTO;
import com.wora.easyOrder.entity.projectEnum.UserRole;
import com.wora.easyOrder.repository.DeliveryManRepository;
import com.wora.easyOrder.service.contract.AuthService;
import com.wora.easyOrder.service.contract.CustomerService;
import com.wora.easyOrder.service.contract.DeliveryManService;
import com.wora.easyOrder.util.apiResponse.success.SuccessDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CustomerService customerService;
    private final DeliveryManService deliveryManService;

    @PostMapping("/login")
    public ResponseEntity<SuccessDTO<AuthResponseDTO>> login(@Validated @RequestBody AuthRequestDTO dto) {
        AuthResponseDTO authResponse = authService.login(dto);
        return ResponseEntity.ok(
                new SuccessDTO<AuthResponseDTO>(
                        HttpStatus.OK.value(),
                        "Login successful",
                        authResponse
                )
        );
    }

    @PostMapping("/delivery-man/register")
    public ResponseEntity<SuccessDTO<UserResponseDTO>> registerNewDeliveryMan(@RequestBody @Validated(OnDeliveryManCreation.class) UserRequestDTO dto) {
        UserResponseDTO newUser = deliveryManService.create(UserRole.ROLE_DELIVERY_MAN, dto);
        return ResponseEntity.ok(
                new SuccessDTO<UserResponseDTO>(
                        HttpStatus.CREATED.value(),
                        "Registration successful",
                        newUser
                )
        );
    }

    @PostMapping("/customer/register")
    public ResponseEntity<SuccessDTO<UserResponseDTO>> registerNewCustomer(@RequestBody @Validated(OnCustomerCreation.class) UserRequestDTO dto) {
        UserResponseDTO newUser = customerService.create(UserRole.ROLE_CUSTOMER, dto);
        return ResponseEntity.ok(
                new SuccessDTO<UserResponseDTO>(
                        HttpStatus.CREATED.value(),
                        "Registration successful",
                        newUser
                )
        );
    }

}

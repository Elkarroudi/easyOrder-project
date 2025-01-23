package com.wora.easyOrder.dto.request;

import com.wora.easyOrder.dto.group.OnAdminCreation;
import com.wora.easyOrder.dto.group.OnCustomerCreation;
import com.wora.easyOrder.dto.group.OnDeliveryManCreation;
import com.wora.easyOrder.entity.projectEnum.VehicleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @NotBlank(message = "Name cannot be blank", groups = {OnDeliveryManCreation.class, OnCustomerCreation.class, OnAdminCreation.class})
        String name,

        @NotBlank(message = "Email cannot be blank", groups = {OnDeliveryManCreation.class, OnCustomerCreation.class, OnAdminCreation.class})
        @Email(message = "Email should be valid", groups = {OnDeliveryManCreation.class, OnCustomerCreation.class, OnAdminCreation.class})
        String email,

        @NotBlank(message = "Phone number cannot be blank", groups = {OnDeliveryManCreation.class, OnAdminCreation.class})
        String phone,

        @NotBlank(message = "Password cannot be blank", groups = {OnDeliveryManCreation.class, OnCustomerCreation.class, OnAdminCreation.class})
        @Size(min = 6, message = "Password should have at least 6 characters", groups = {OnDeliveryManCreation.class, OnCustomerCreation.class, OnAdminCreation.class})
        String password,

        @NotBlank(message = "Address cannot be blank", groups = {OnCustomerCreation.class})
        String address,

        @NotNull(message = "Vehicle type cannot be blank", groups = {OnDeliveryManCreation.class})
        VehicleType vehicleType

) {
}

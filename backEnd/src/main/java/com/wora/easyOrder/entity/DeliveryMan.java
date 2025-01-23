package com.wora.easyOrder.entity;

import com.wora.easyOrder.entity.base.BaseUser;
import com.wora.easyOrder.entity.projectEnum.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "deliveryMans")
@EqualsAndHashCode(callSuper = true)
public class DeliveryMan extends BaseUser {

    @Enumerated(EnumType.STRING)
    @Column(
            name = "vehicleType",
            nullable = false
    )
    private VehicleType vehicleType;

}

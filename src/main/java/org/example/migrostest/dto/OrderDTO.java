package org.example.migrostest.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.migrostest.dto.base.MigrosTestBaseDTO;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
public class OrderDTO extends MigrosTestBaseDTO {

    private Long customerId;

    private OffsetDateTime orderDate;

    private Set<OrderProductDTO> products;

}

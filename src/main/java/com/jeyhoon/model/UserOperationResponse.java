package com.jeyhoon.model;

import com.jeyhoon.enums.OperationStatus;
import com.jeyhoon.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOperationResponse {

    private int userId;
    private OperationType operationType;
    private OperationStatus operationStatus;

}

package com.barcode.scanapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScanResponseVO {
    private String barcode;
    private String teacherName;
    private String status;
}

package com.nick.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Nick4Supreme
 * @date 2021/11/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = 999L;

    private Long id;
    private String serial;

}

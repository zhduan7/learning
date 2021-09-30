package com.qf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>title: com.qf</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/25
 * description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private  boolean success;

    private String msg;

}
package cn.uorange.common.webmvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/24
 */
@Data
@ToString
@AllArgsConstructor
public class SysUser {

    private long id;

    private String username;
}

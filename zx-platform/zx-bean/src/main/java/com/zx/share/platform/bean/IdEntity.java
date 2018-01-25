package com.zx.share.platform.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author fenggang
 * @date 7/28/17
 */
@MappedSuperclass
public class IdEntity implements Serializable {

    private static final long serialVersionUID = 8109155258691598416L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

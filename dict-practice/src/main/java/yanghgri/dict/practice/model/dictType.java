package yanghgri.dict.practice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import yanghgri.devform.web.entity.BaseDO;

@Data
@EqualsAndHashCode(callSuper = true)
public class dictType extends BaseDO<Long> {
    /**
     * 字典类名
     */
    private String name;
    /**
     * 父类id
     */
    private Long parentId;
    /**
     * 启用状态
     */
    private Boolean status;
    /**
     * 详细描述
     */
    private String describe;
}
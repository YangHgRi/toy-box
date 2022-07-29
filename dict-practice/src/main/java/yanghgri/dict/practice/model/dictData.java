package yanghgri.dict.practice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import yanghgri.devform.web.entity.BaseDO;

@Data
@EqualsAndHashCode(callSuper = true)
public class dictData extends BaseDO<Long> {
    /**
     * 字典项名
     */
    private String name;
    /**
     * 所属字典类ID
     */
    private Long dictTypeId;
    /**
     * 已设定为默认项
     */
    private Boolean defaulted;
    /**
     * 启用状态
     */
    private Boolean status;
    /**
     * 保存用户声明字典项顺序，返回给前端用
     */
    private Byte order;
    /**
     * 详细描述
     */
    private String describe;
}
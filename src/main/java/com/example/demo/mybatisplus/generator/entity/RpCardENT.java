package com.example.demo.mybatisplus.generator.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 抵用券信息表
 * </p>
 *
 * @author wxq
 * @since 2018-11-01
 */
@TableName("rp_card")
public class RpCardENT implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "n_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField("s_name")
    private String name;

    /**
     * 描述
     */
    @TableField("s_desc")
    private String desc;

    /**
     * 券类型 100：减免券 200：折扣券
     */
    @TableField("n_type")
    private Integer type;

    /**
     * 折扣比例，百分比（值:0-100）
     */
    @TableField("n_discount_ratio")
    private Integer discountRatio;

    /**
     * 抵用券金额
     */
    @TableField("n_money")
    private BigDecimal money;

    /**
     * 满额数  =0 无门槛; >0:有门槛
     */
    @TableField("n_threshold")
    private BigDecimal threshold;

    /**
     * 是否一次性用完 0:否,1:是
     */
    @TableField("n_once_only_status")
    private Integer onceOnlyStatus;

    /**
     * 有效天数
     */
    @TableField("n_effective_day")
    private Integer effectiveDay;

    /**
     * 过期时间
     */
    @TableField("d_expire_time")
    private LocalDateTime expireTime;

    /**
     * 券状态 0:不可用/1可用
     */
    @TableField("n_status")
    private Integer status;

    /**
     * 计划几天后发放，用于计算用户卡券表的sendTime
     */
    @TableField("n_send_day")
    private Integer sendDay;

    @TableField("d_send_time")
    private LocalDateTime sendTime;

    /**
     * 更新人
     */
    @TableField("s_updater")
    private String updater;

    /**
     * 更新时间
     */
    @TableField("d_update_time")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField("s_creator")
    private String creator;

    /**
     * 创建时间
     */
    @TableField("d_create_time")
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(Integer discountRatio) {
        this.discountRatio = discountRatio;
    }
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }
    public Integer getOnceOnlyStatus() {
        return onceOnlyStatus;
    }

    public void setOnceOnlyStatus(Integer onceOnlyStatus) {
        this.onceOnlyStatus = onceOnlyStatus;
    }
    public Integer getEffectiveDay() {
        return effectiveDay;
    }

    public void setEffectiveDay(Integer effectiveDay) {
        this.effectiveDay = effectiveDay;
    }
    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getSendDay() {
        return sendDay;
    }

    public void setSendDay(Integer sendDay) {
        this.sendDay = sendDay;
    }
    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }
    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RpCardENT{" +
        "id=" + id +
        ", name=" + name +
        ", desc=" + desc +
        ", type=" + type +
        ", discountRatio=" + discountRatio +
        ", money=" + money +
        ", threshold=" + threshold +
        ", onceOnlyStatus=" + onceOnlyStatus +
        ", effectiveDay=" + effectiveDay +
        ", expireTime=" + expireTime +
        ", status=" + status +
        ", sendDay=" + sendDay +
        ", sendTime=" + sendTime +
        ", updater=" + updater +
        ", updateTime=" + updateTime +
        ", creator=" + creator +
        ", createTime=" + createTime +
        "}";
    }
}

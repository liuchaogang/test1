package com.yonyou.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcMipMsgLog
 * @Description:
 * @date 2017/8/3 9:08
 */

@Entity
@Table(name = "uh_dc_mip_msg_log", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcMipMsgLog {
    private String id;
    private String msgId;
    private String serviceId;
    private String modelType;
    private String dtoName;
    private String msgWriter;
    private String businessTables;
    private String msgContent;
    private String jsonContent;
    private String msgStatus;
    private String processInfo;
    private Date createTime;
    private Date updateTime;

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "msg_id")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Basic
    @Column(name = "service_id")
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "model_type")
    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    @Basic
    @Column(name = "dto_name")
    public String getDtoName() {
        return dtoName;
    }

    public void setDtoName(String dtoName) {
        this.dtoName = dtoName;
    }

    @Basic
    @Column(name = "msg_writer")
    public String getMsgWriter() {
        return msgWriter;
    }

    public void setMsgWriter(String msgWriter) {
        this.msgWriter = msgWriter;
    }

    @Basic
    @Column(name = "business_tables")
    public String getBusinessTables() {
        return businessTables;
    }

    public void setBusinessTables(String businessTables) {
        this.businessTables = businessTables;
    }

    @Basic
    @Column(name = "msg_content")
    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Basic
    @Column(name = "json_content")
    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    @Basic
    @Column(name = "msg_status")
    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    @Basic
    @Column(name = "process_info")
    public String getProcessInfo() {
        return processInfo;
    }

    public void setProcessInfo(String processInfo) {
        this.processInfo = processInfo;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UhDcMipMsgLog that = (UhDcMipMsgLog) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (msgId != null ? !msgId.equals(that.msgId) : that.msgId != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (modelType != null ? !modelType.equals(that.modelType) : that.modelType != null) return false;
        if (dtoName != null ? !dtoName.equals(that.dtoName) : that.dtoName != null) return false;
        if (msgWriter != null ? !msgWriter.equals(that.msgWriter) : that.msgWriter != null) return false;
        if (businessTables != null ? !businessTables.equals(that.businessTables) : that.businessTables != null)
            return false;
        if (msgContent != null ? !msgContent.equals(that.msgContent) : that.msgContent != null) return false;
        if (jsonContent != null ? !jsonContent.equals(that.jsonContent) : that.jsonContent != null) return false;
        if (msgStatus != null ? !msgStatus.equals(that.msgStatus) : that.msgStatus != null) return false;
        if (processInfo != null ? !processInfo.equals(that.processInfo) : that.processInfo != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (msgId != null ? msgId.hashCode() : 0);
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (modelType != null ? modelType.hashCode() : 0);
        result = 31 * result + (dtoName != null ? dtoName.hashCode() : 0);
        result = 31 * result + (msgWriter != null ? msgWriter.hashCode() : 0);
        result = 31 * result + (businessTables != null ? businessTables.hashCode() : 0);
        result = 31 * result + (msgContent != null ? msgContent.hashCode() : 0);
        result = 31 * result + (jsonContent != null ? jsonContent.hashCode() : 0);
        result = 31 * result + (msgStatus != null ? msgStatus.hashCode() : 0);
        result = 31 * result + (processInfo != null ? processInfo.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}

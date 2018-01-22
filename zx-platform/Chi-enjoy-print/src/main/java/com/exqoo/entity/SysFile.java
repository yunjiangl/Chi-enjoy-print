package com.exqoo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 
 */
@Table(name = "sys_file")
public class SysFile implements Serializable {
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
    private Long id;

    /**
     * 文件的标题
     */
	@Column(name = "file_title")
    private String fileTitle;

    /**
     * 文件类别id
     */
	@Column(name = "file_sort_id")
    private Long fileSortId;

    /**
     * 文件的打印次数
     */
	@Column(name = "file_print_count")
    private Long filePrintCount;

    /**
     * 文件的后缀
     */
	@Column(name = "file_suffix")
    private String fileSuffix;

    /**
     * 文件的存放路径
     */
	@Column(name = "file_url")
    private String fileUrl;

    /**
     * 文件的页数
     */
	@Column(name = "file_pages")
    private Integer filePages;

    /**
     * 文件的创建时间
     */
	@Column(name = "creat_date")
    private Date creatDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public Long getFileSortId() {
        return fileSortId;
    }

    public void setFileSortId(Long fileSortId) {
        this.fileSortId = fileSortId;
    }

    public Long getFilePrintCount() {
        return filePrintCount;
    }

    public void setFilePrintCount(Long filePrintCount) {
        this.filePrintCount = filePrintCount;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getFilePages() {
        return filePages;
    }

    public void setFilePages(Integer filePages) {
        this.filePages = filePages;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysFile other = (SysFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileTitle() == null ? other.getFileTitle() == null : this.getFileTitle().equals(other.getFileTitle()))
            && (this.getFileSortId() == null ? other.getFileSortId() == null : this.getFileSortId().equals(other.getFileSortId()))
            && (this.getFilePrintCount() == null ? other.getFilePrintCount() == null : this.getFilePrintCount().equals(other.getFilePrintCount()))
            && (this.getFileSuffix() == null ? other.getFileSuffix() == null : this.getFileSuffix().equals(other.getFileSuffix()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getFilePages() == null ? other.getFilePages() == null : this.getFilePages().equals(other.getFilePages()))
            && (this.getCreatDate() == null ? other.getCreatDate() == null : this.getCreatDate().equals(other.getCreatDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFileTitle() == null) ? 0 : getFileTitle().hashCode());
        result = prime * result + ((getFileSortId() == null) ? 0 : getFileSortId().hashCode());
        result = prime * result + ((getFilePrintCount() == null) ? 0 : getFilePrintCount().hashCode());
        result = prime * result + ((getFileSuffix() == null) ? 0 : getFileSuffix().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getFilePages() == null) ? 0 : getFilePages().hashCode());
        result = prime * result + ((getCreatDate() == null) ? 0 : getCreatDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileTitle=").append(fileTitle);
        sb.append(", fileSortId=").append(fileSortId);
        sb.append(", filePrintCount=").append(filePrintCount);
        sb.append(", fileSuffix=").append(fileSuffix);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", filePages=").append(filePages);
        sb.append(", creatDate=").append(creatDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.javaclimb.xshopping.entity;

/**
 * Database Table Remarks:
 *   系统文件表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table nx_system_file_info
 */
public class NxSystemFileInfo {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column nx_system_file_info.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   原始文件名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column nx_system_file_info.originName
     *
     * @mbg.generated
     */
    private String originname;

    /**
     * Database Column Remarks:
     *   存储文件名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column nx_system_file_info.fileName
     *
     * @mbg.generated
     */
    private String filename;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column nx_system_file_info.id
     *
     * @return the value of nx_system_file_info.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column nx_system_file_info.id
     *
     * @param id the value for nx_system_file_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column nx_system_file_info.originName
     *
     * @return the value of nx_system_file_info.originName
     *
     * @mbg.generated
     */
    public String getOriginname() {
        return originname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column nx_system_file_info.originName
     *
     * @param originname the value for nx_system_file_info.originName
     *
     * @mbg.generated
     */
    public void setOriginname(String originname) {
        this.originname = originname == null ? null : originname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column nx_system_file_info.fileName
     *
     * @return the value of nx_system_file_info.fileName
     *
     * @mbg.generated
     */
    public String getFilename() {
        return filename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column nx_system_file_info.fileName
     *
     * @param filename the value for nx_system_file_info.fileName
     *
     * @mbg.generated
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }
}
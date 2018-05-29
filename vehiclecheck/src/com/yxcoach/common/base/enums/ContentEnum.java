package com.yxcoach.common.base.enums;

public enum ContentEnum {
	
	UPLOAD_ERROR(2, "文件上传失败"),
	UPLOAD_SUCC(1, "文件上传成功");
	
	
	private int type;

    private String desc;

    ContentEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
 

    public int getType() {
		return type;
	}



	public String getDesc() {
        return desc;
    }

}

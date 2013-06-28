package com.sklay.enums.impl;

import com.sklay.enums.LabeledEnum;

public enum Sex implements LabeledEnum {

	UNKNOWN("未知", 0), MALE("男", 1), FEMALE("女", 2);

	/** 成员变量 */
	private String lable;
	private int value;

	/** 构造方法 */
	private Sex(String lable, int value) {
		this.lable = lable;
		this.value = value;
	}

	/** 接口方法 */
	@Override
	public String getLable() {
		return this.lable;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	public static Sex findByValue(int value) {
		switch (value) {
		case 0:
			return UNKNOWN;
		case 1:
			return MALE;
		case 2:
			return FEMALE;
		default:
			return null;
		}
	}
}

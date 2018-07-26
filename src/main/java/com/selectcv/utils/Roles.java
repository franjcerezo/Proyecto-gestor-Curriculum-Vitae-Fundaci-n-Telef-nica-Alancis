package com.selectcv.utils;

public enum Roles {
	ROLE_ADMIN(1), ROLE_CANDIDATE(2), ROLE_RECRUITER(3);
	private int value;

	Roles(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

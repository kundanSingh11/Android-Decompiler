package com.jwt.model.attributeconveters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TaskStatusAttributeConveter implements AttributeConverter<ApkTaskStatus, String> {

	@Override
	public String convertToDatabaseColumn(ApkTaskStatus apkTaskStatus) {
		switch (apkTaskStatus) {
		case SUBMITED:
			return "submitted";
		case WAITING:
			return "waiting";
		case RUNNING:
			return "running";
		case COMPLETED:
			return "completed";
		case NOTFOUND:
			return "not Found";
		case REJECTED:
			return "rejected";
		case FAILED:
			return "failed";
		default:
			break;
		}
		return null;
	}

	@Override
	public ApkTaskStatus convertToEntityAttribute(String string) {

		if (string.equals("submitted")) {
			return ApkTaskStatus.SUBMITED;
		} else if (string.equals("waiting")) {
			return ApkTaskStatus.WAITING;
		} else if (string.equals("running")) {
			return ApkTaskStatus.RUNNING;
		} else if (string.equals("completed")) {
			return ApkTaskStatus.COMPLETED;
		} else if (string.equals("not Found")) {
			return ApkTaskStatus.NOTFOUND;
		} else if (string.equals("rejected")) {
			return ApkTaskStatus.REJECTED;
		} else if (string.equals("failed")) {
			return ApkTaskStatus.FAILED;
		}
		return null;
	}
}

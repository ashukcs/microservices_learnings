package com.hrs.springboot.exceptionhandling.constants;

public class StatusConstants {

    public enum HttpConstants {

        SUCCESS(1, "Success"),

        CUSTOM_FIELD_VALIDATION(2, null),

        INTERNAL_SERVER_ERROR(0, "System error! Please try after some time");

    	
        private HttpConstants(Integer code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		private Integer code;

        private String desc;

		public Integer getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}
        
    }
}
package com.kafka.practice.constants;

public class AppConstants {
	public static final String BOOTSTRAP_SERVER = "localhost:9092";
	public static final String TOPIC_NAME = "employeeTopic";
	public static final String GROUP_ID = "employeeTopicGroup";
	public static final String CONSUMER_GROUP = "employeeTopicGroup";

	//for producer configuration
	public static final int RETRIES_CONFIG_VALUE = 0;
	public static final int BATCH_SIZE_CONFIG_VALUE = 10;
	public static final String ACKNOWLEDGE_CONFIG_VALUE = "all";
	public static final int LINGER_MS_CONFIG_VALUE = 1;
	public static final int BUFFER_MEMORY_CONFIG_VALUE = 1000;

	//for consumer configuration
	public static final boolean ENABLE_AUTO_COMMIT_CONFIG_VALUE = false;
	public static final int AUTO_COMMIT_INTERVAL_MS_CONFIG_VALUE = 100;
	public static final int MAX_PARTITION_FETCH_BYTES_CONFIG_VALUE = 135;
	public static final int HEARTBEAT_INTERVAL_MS_CONFIG_VALUE = 1000;
	public static final String AUTO_OFFSET_RESET_CONFIG_VALUE="earliest";
	public static final int SESSION_TIMEOUT_MS_CONFIG_VALUE=60000;


}

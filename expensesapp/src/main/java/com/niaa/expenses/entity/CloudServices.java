package com.niaa.expenses.entity;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CloudServices {
	
	private static final String INSTANCE_NAME = "name";
	
	private static final String PASSWORD_KEY = "password"; // NOSONAR
	private static final String USERNAME_KEY = "username";
	private static final String PORT_KEY = "port";
	private static final String HOSTNAME_KEY = "hostname";
	private static final String DBNAME_KEY = "dbname";
	
	private static final String CREDENTIALS_KEY = "credentials";
	private static final String POSTGRES_DATABASE_DRIVER = "org.postgresql.Driver";

	
	private static final String VCAP_SERVICES = "VCAP_SERVICES";
	
	private static final String POSTGRES_DB_SERVICE_INSTANCE_KEY = "postgresql";

	private static BasicDataSource connectionDataSource = null;

	
	public static DataSource getDataSource() {
		
		String vcapServicesJsonStr = System.getenv(VCAP_SERVICES);
		JsonParser jsonParser = new JsonParser();
		JsonElement VCAP_SERVICES = jsonParser.parse(vcapServicesJsonStr);
		JsonElement postgressqlServiceInstanceList = VCAP_SERVICES.getAsJsonObject()
				.get(POSTGRES_DB_SERVICE_INSTANCE_KEY);

		JsonObject postgresService = null;
		postgresService = getServiceInstance(postgressqlServiceInstanceList, "expenses");

		String dbname = null, hostname = null, username = null, password = null, connection_url = null;
		Integer port = null;

		if (postgresService != null) {
			// Extract all the DB related information from the JSON Object of the database
			// service
			dbname = postgresService.get(CREDENTIALS_KEY).getAsJsonObject().get(DBNAME_KEY).getAsString();

			hostname = postgresService.get(CREDENTIALS_KEY).getAsJsonObject().get(HOSTNAME_KEY).getAsString();

			port = (Integer
					.parseInt((postgresService.get(CREDENTIALS_KEY).getAsJsonObject().get(PORT_KEY)).getAsString()));
			username = postgresService.get(CREDENTIALS_KEY).getAsJsonObject().get(USERNAME_KEY).getAsString();
			password = postgresService.get(CREDENTIALS_KEY).getAsJsonObject().get(PASSWORD_KEY).getAsString();
			connection_url = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbname;

			connectionDataSource = new BasicDataSource();
			connectionDataSource.setUsername(username);
			connectionDataSource.setPassword(password);
			connectionDataSource.setDriverClassName(POSTGRES_DATABASE_DRIVER);
			connectionDataSource.setUrl(connection_url);
			connectionDataSource.setInitialSize(1);

		}
		return connectionDataSource;
	}
	
	 
		private static JsonObject getServiceInstance(JsonElement databaseVendorServiceInstances, String tenantId) {
			JsonObject serviceInstanceJsonObj = null;

			if (databaseVendorServiceInstances.isJsonArray()) {

				JsonArray postgresServiceInstanceArr = (JsonArray) databaseVendorServiceInstances;
				for (JsonElement postgresServiceInstanceElem : postgresServiceInstanceArr) {

					if (!(postgresServiceInstanceElem.isJsonNull())) {

						JsonObject postgresServiceInstance = postgresServiceInstanceElem.getAsJsonObject();
						String instanceName = postgresServiceInstance.get(INSTANCE_NAME).getAsString();
						if (tenantId.equals(instanceName)) {
							return postgresServiceInstance;
						}
					}
				}
			}
			return serviceInstanceJsonObj;
		}

}

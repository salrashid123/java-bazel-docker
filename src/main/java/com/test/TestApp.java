package com.test;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class TestApp {

  public static void list() {
    try {

			GoogleCredentials sourceCredentials = GoogleCredentials.getApplicationDefault();
			Storage storage_service = StorageOptions.newBuilder().setCredentials(sourceCredentials).build().getService();
			for (Bucket b : storage_service.list().iterateAll()) {
				System.out.println(b);
			}

    } catch (Exception ex) {
      System.out.println("Error listing bucket: "+ ex);
    }
  }

  public static void main(String... args) throws Exception {
    TestApp app = new TestApp();
    app.list();
  }

}
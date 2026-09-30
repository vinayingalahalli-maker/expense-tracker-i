package com.expensetrackerapisdk;

import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.http.Environment;
import com.expensetrackerapisdk.http.interceptors.DefaultHeadersInterceptor;
import com.expensetrackerapisdk.http.interceptors.LoggingInterceptor;
import com.expensetrackerapisdk.http.interceptors.RetryInterceptor;
import com.expensetrackerapisdk.logging.Logger;
import com.expensetrackerapisdk.services.ExpenseTrackerApiSdkService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * API collection for the Expense Tracker service at Northbeam Consulting.
 *
 * Finance Operations needs to replace a spreadsheet-and-email expense process.
 * Three resources: Categories, Expenses, and Claims.
 *
 * Auth: JWT Bearer token (HS256). Roles: Employee, Approver, Finance.
 */
public class ExpenseTrackerApiSdk {

  public final ExpenseTrackerApiSdkService expenseTrackerApiSdk;

  private final ExpenseTrackerApiSdkConfig config;

  /**
   * Constructs a new instance of ExpenseTrackerApiSdk with default configuration.
   */
  public ExpenseTrackerApiSdk() {
    // Default configs
    this(ExpenseTrackerApiSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of ExpenseTrackerApiSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public ExpenseTrackerApiSdk(ExpenseTrackerApiSdkConfig config) {
    this.config = config;

    // A user-supplied client is augmented (not replaced): the SDK derives its client from
    // the injected instance so its transport settings and interceptors are preserved, then
    // layers the SDK's own interceptors on top.
    final OkHttpClient customHttpClient = config.getHttpClient();
    final OkHttpClient.Builder httpClientBuilder =
      (customHttpClient != null
          ? customHttpClient.newBuilder()
          : new OkHttpClient.Builder()).addInterceptor(new DefaultHeadersInterceptor(config))
        .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
        // Logging is added last so it observes the fully-decorated request (auth headers
        // included, then redacted). Silent by default — see LogConfig.
        .addInterceptor(new LoggingInterceptor(Logger.from(config.getLogConfig())));

    // Only apply the SDK's default read timeout when building the client ourselves; a
    // user-supplied client owns its own transport (timeout) settings.
    if (customHttpClient == null) {
      httpClientBuilder.readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS);
    }

    final OkHttpClient httpClient = httpClientBuilder.build();

    this.expenseTrackerApiSdk = new ExpenseTrackerApiSdkService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  /**
   * Sets the access token (Bearer token) for all API requests.
   *
   * @param token The access token to use for authentication
   */
  public void setAccessToken(String token) {
    this.config.setAccessToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c

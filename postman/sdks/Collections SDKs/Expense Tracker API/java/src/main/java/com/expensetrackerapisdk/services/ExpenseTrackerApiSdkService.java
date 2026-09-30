package com.expensetrackerapisdk.services;

import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.config.RequestConfig;
import com.expensetrackerapisdk.exceptions.ApiError;
import com.expensetrackerapisdk.http.Environment;
import com.expensetrackerapisdk.http.ExpenseTrackerApiSdkResponse;
import com.expensetrackerapisdk.http.HttpMethod;
import com.expensetrackerapisdk.http.ModelConverter;
import com.expensetrackerapisdk.http.util.RequestBuilder;
import com.expensetrackerapisdk.models.CreateCategoryRequest;
import com.expensetrackerapisdk.models.CreateClaimRequest;
import com.expensetrackerapisdk.models.CreateExpenseRequest;
import com.expensetrackerapisdk.models.ListClaimsParameters;
import com.expensetrackerapisdk.models.ListExpensesParameters;
import com.expensetrackerapisdk.models.RejectClaimRequest;
import com.expensetrackerapisdk.models.UpdateExpenseRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ExpenseTrackerApiSdkService Service
 */
public class ExpenseTrackerApiSdkService extends BaseService {

  private RequestConfig listCategoriesConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig createCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig getCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig updateCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig listExpensesConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig createExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig getExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig updateExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig deleteExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig listClaimsConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig createClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig getClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig submitClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig approveClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig rejectClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();
  private RequestConfig reimburseClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST)
    .build();

  /**
   * Constructs a new instance of ExpenseTrackerApiSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ExpenseTrackerApiSdkService(
    @NonNull OkHttpClient httpClient,
    ExpenseTrackerApiSdkConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listCategories}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setListCategoriesConfig(RequestConfig config) {
    this.listCategoriesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setCreateCategoryConfig(RequestConfig config) {
    this.createCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setGetCategoryConfig(RequestConfig config) {
    this.getCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setUpdateCategoryConfig(RequestConfig config) {
    this.updateCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listExpenses}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setListExpensesConfig(RequestConfig config) {
    this.listExpensesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setCreateExpenseConfig(RequestConfig config) {
    this.createExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setGetExpenseConfig(RequestConfig config) {
    this.getExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setUpdateExpenseConfig(RequestConfig config) {
    this.updateExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setDeleteExpenseConfig(RequestConfig config) {
    this.deleteExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listClaims}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setListClaimsConfig(RequestConfig config) {
    this.listClaimsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setCreateClaimConfig(RequestConfig config) {
    this.createClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setGetClaimConfig(RequestConfig config) {
    this.getClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code submitClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setSubmitClaimConfig(RequestConfig config) {
    this.submitClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code approveClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setApproveClaimConfig(RequestConfig config) {
    this.approveClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code rejectClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setRejectClaimConfig(RequestConfig config) {
    this.rejectClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code reimburseClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setReimburseClaimConfig(RequestConfig config) {
    this.reimburseClaimConfig = config;
    return this;
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code Object}
   */
  public Object listCategories() throws ApiError {
    return this.listCategories(null);
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code Object}
   */
  public Object listCategories(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listCategories(requestConfig).getData();
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listCategoriesAsync() throws ApiError {
    return this.listCategoriesAsync(null);
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listCategoriesAsync(RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse()
      .listCategoriesAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListCategoriesRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "categories"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .build();
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createCategory(@NonNull CreateCategoryRequest createCategoryRequest)
    throws ApiError {
    return this.createCategory(createCategoryRequest, null);
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createCategory(
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createCategory(createCategoryRequest, requestConfig).getData();
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createCategoryAsync(
    @NonNull CreateCategoryRequest createCategoryRequest
  ) throws ApiError {
    return this.createCategoryAsync(createCategoryRequest, null);
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createCategoryAsync(
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createCategoryAsync(createCategoryRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateCategoryRequest(
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "categories"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createCategoryRequest)
      .build();
  }

  /**
   * Method getCategory
   * GET /categories/{category_id}
   *
   * @param categoryId String
   * @return response of {@code Object}
   */
  public Object getCategory(@NonNull String categoryId) throws ApiError {
    return this.getCategory(categoryId, null);
  }

  /**
   * Method getCategory
   * GET /categories/{category_id}
   *
   * @param categoryId String
   * @return response of {@code Object}
   */
  public Object getCategory(@NonNull String categoryId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().getCategory(categoryId, requestConfig).getData();
  }

  /**
   * Method getCategory
   * GET /categories/{category_id}
   *
   * @param categoryId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getCategoryAsync(@NonNull String categoryId) throws ApiError {
    return this.getCategoryAsync(categoryId, null);
  }

  /**
   * Method getCategory
   * GET /categories/{category_id}
   *
   * @param categoryId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getCategoryAsync(
    @NonNull String categoryId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getCategoryAsync(categoryId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetCategoryRequest(
    @NonNull String categoryId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "categories/{category_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("category_id", categoryId)
      .build();
  }

  /**
   * Method updateCategory
   * PUT /categories/{category_id}
   *
   * @param categoryId String
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateCategory(
    @NonNull String categoryId,
    @NonNull CreateCategoryRequest createCategoryRequest
  ) throws ApiError {
    return this.updateCategory(categoryId, createCategoryRequest, null);
  }

  /**
   * Method updateCategory
   * PUT /categories/{category_id}
   *
   * @param categoryId String
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateCategory(
    @NonNull String categoryId,
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateCategory(categoryId, createCategoryRequest, requestConfig)
      .getData();
  }

  /**
   * Method updateCategory
   * PUT /categories/{category_id}
   *
   * @param categoryId String
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateCategoryAsync(
    @NonNull String categoryId,
    @NonNull CreateCategoryRequest createCategoryRequest
  ) throws ApiError {
    return this.updateCategoryAsync(categoryId, createCategoryRequest, null);
  }

  /**
   * Method updateCategory
   * PUT /categories/{category_id}
   *
   * @param categoryId String
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateCategoryAsync(
    @NonNull String categoryId,
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateCategoryAsync(categoryId, createCategoryRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateCategoryRequest(
    @NonNull String categoryId,
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "categories/{category_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("category_id", categoryId)
      .setJsonContent(createCategoryRequest)
      .build();
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @return response of {@code Object}
   */
  public Object listExpenses() throws ApiError {
    return this.listExpenses(ListExpensesParameters.builder().build());
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listExpenses(@NonNull ListExpensesParameters requestParameters) throws ApiError {
    return this.listExpenses(requestParameters, null);
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listExpenses(
    @NonNull ListExpensesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().listExpenses(requestParameters, requestConfig).getData();
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listExpensesAsync() throws ApiError {
    return this.listExpensesAsync(ListExpensesParameters.builder().build());
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listExpensesAsync(
    @NonNull ListExpensesParameters requestParameters
  ) throws ApiError {
    return this.listExpensesAsync(requestParameters, null);
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listExpensesAsync(
    @NonNull ListExpensesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listExpensesAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListExpensesRequest(
    @NonNull ListExpensesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "expenses"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setOptionalQueryParameter("status", requestParameters.getStatus())
      .build();
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createExpense(@NonNull CreateExpenseRequest createExpenseRequest) throws ApiError {
    return this.createExpense(createExpenseRequest, null);
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createExpense(
    @NonNull CreateExpenseRequest createExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createExpense(createExpenseRequest, requestConfig).getData();
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createExpenseAsync(
    @NonNull CreateExpenseRequest createExpenseRequest
  ) throws ApiError {
    return this.createExpenseAsync(createExpenseRequest, null);
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createExpenseAsync(
    @NonNull CreateExpenseRequest createExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createExpenseAsync(createExpenseRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateExpenseRequest(
    @NonNull CreateExpenseRequest createExpenseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "expenses"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createExpenseRequest)
      .build();
  }

  /**
   * Method getExpense
   * GET /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code Object}
   */
  public Object getExpense(@NonNull String expenseId) throws ApiError {
    return this.getExpense(expenseId, null);
  }

  /**
   * Method getExpense
   * GET /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code Object}
   */
  public Object getExpense(@NonNull String expenseId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getExpense(expenseId, requestConfig).getData();
  }

  /**
   * Method getExpense
   * GET /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getExpenseAsync(@NonNull String expenseId) throws ApiError {
    return this.getExpenseAsync(expenseId, null);
  }

  /**
   * Method getExpense
   * GET /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getExpenseAsync(
    @NonNull String expenseId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getExpenseAsync(expenseId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetExpenseRequest(@NonNull String expenseId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "expenses/{expense_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("expense_id", expenseId)
      .build();
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expense_id}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateExpense(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest
  ) throws ApiError {
    return this.updateExpense(expenseId, updateExpenseRequest, null);
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expense_id}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateExpense(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateExpense(expenseId, updateExpenseRequest, requestConfig)
      .getData();
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expense_id}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateExpenseAsync(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest
  ) throws ApiError {
    return this.updateExpenseAsync(expenseId, updateExpenseRequest, null);
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expense_id}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateExpenseAsync(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateExpenseAsync(expenseId, updateExpenseRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateExpenseRequest(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "expenses/{expense_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("expense_id", expenseId)
      .setJsonContent(updateExpenseRequest)
      .build();
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code String}
   */
  public String deleteExpense(@NonNull String expenseId) throws ApiError {
    return this.deleteExpense(expenseId, null);
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code String}
   */
  public String deleteExpense(@NonNull String expenseId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().deleteExpense(expenseId, requestConfig).getData();
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<String>}
   */
  public CompletableFuture<String> deleteExpenseAsync(@NonNull String expenseId) throws ApiError {
    return this.deleteExpenseAsync(expenseId, null);
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expense_id}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<String>}
   */
  public CompletableFuture<String> deleteExpenseAsync(
    @NonNull String expenseId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .deleteExpenseAsync(expenseId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteExpenseRequest(
    @NonNull String expenseId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "expenses/{expense_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("expense_id", expenseId)
      .build();
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @return response of {@code Object}
   */
  public Object listClaims() throws ApiError {
    return this.listClaims(ListClaimsParameters.builder().build());
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listClaims(@NonNull ListClaimsParameters requestParameters) throws ApiError {
    return this.listClaims(requestParameters, null);
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listClaims(
    @NonNull ListClaimsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().listClaims(requestParameters, requestConfig).getData();
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listClaimsAsync() throws ApiError {
    return this.listClaimsAsync(ListClaimsParameters.builder().build());
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listClaimsAsync(@NonNull ListClaimsParameters requestParameters)
    throws ApiError {
    return this.listClaimsAsync(requestParameters, null);
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listClaimsAsync(
    @NonNull ListClaimsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listClaimsAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListClaimsRequest(
    @NonNull ListClaimsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setOptionalQueryParameter("status", requestParameters.getStatus())
      .build();
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createClaim(@NonNull CreateClaimRequest createClaimRequest) throws ApiError {
    return this.createClaim(createClaimRequest, null);
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createClaim(
    @NonNull CreateClaimRequest createClaimRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createClaim(createClaimRequest, requestConfig).getData();
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createClaimAsync(@NonNull CreateClaimRequest createClaimRequest)
    throws ApiError {
    return this.createClaimAsync(createClaimRequest, null);
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createClaimAsync(
    @NonNull CreateClaimRequest createClaimRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createClaimAsync(createClaimRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateClaimRequest(
    @NonNull CreateClaimRequest createClaimRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createClaimRequest)
      .build();
  }

  /**
   * Method getClaim
   * GET /claims/{claim_id}
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object getClaim(@NonNull String claimId) throws ApiError {
    return this.getClaim(claimId, null);
  }

  /**
   * Method getClaim
   * GET /claims/{claim_id}
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object getClaim(@NonNull String claimId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getClaim(claimId, requestConfig).getData();
  }

  /**
   * Method getClaim
   * GET /claims/{claim_id}
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getClaimAsync(@NonNull String claimId) throws ApiError {
    return this.getClaimAsync(claimId, null);
  }

  /**
   * Method getClaim
   * GET /claims/{claim_id}
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetClaimRequest(@NonNull String claimId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims/{claim_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claim_id", claimId)
      .build();
  }

  /**
   * Method submitClaim
   * POST /claims/{claim_id}/submit
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object submitClaim(@NonNull String claimId) throws ApiError {
    return this.submitClaim(claimId, null);
  }

  /**
   * Method submitClaim
   * POST /claims/{claim_id}/submit
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object submitClaim(@NonNull String claimId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().submitClaim(claimId, requestConfig).getData();
  }

  /**
   * Method submitClaim
   * POST /claims/{claim_id}/submit
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> submitClaimAsync(@NonNull String claimId) throws ApiError {
    return this.submitClaimAsync(claimId, null);
  }

  /**
   * Method submitClaim
   * POST /claims/{claim_id}/submit
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> submitClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .submitClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildSubmitClaimRequest(@NonNull String claimId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims/{claim_id}/submit"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claim_id", claimId)
      .build();
  }

  /**
   * Method approveClaim
   * POST /claims/{claim_id}/approve
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object approveClaim(@NonNull String claimId) throws ApiError {
    return this.approveClaim(claimId, null);
  }

  /**
   * Method approveClaim
   * POST /claims/{claim_id}/approve
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object approveClaim(@NonNull String claimId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().approveClaim(claimId, requestConfig).getData();
  }

  /**
   * Method approveClaim
   * POST /claims/{claim_id}/approve
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> approveClaimAsync(@NonNull String claimId) throws ApiError {
    return this.approveClaimAsync(claimId, null);
  }

  /**
   * Method approveClaim
   * POST /claims/{claim_id}/approve
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> approveClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .approveClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildApproveClaimRequest(@NonNull String claimId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims/{claim_id}/approve"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claim_id", claimId)
      .build();
  }

  /**
   * Method rejectClaim
   * POST /claims/{claim_id}/reject
   *
   * @param claimId String
   * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
   * @return response of {@code Object}
   */
  public Object rejectClaim(
    @NonNull String claimId,
    @NonNull RejectClaimRequest rejectClaimRequest
  ) throws ApiError {
    return this.rejectClaim(claimId, rejectClaimRequest, null);
  }

  /**
   * Method rejectClaim
   * POST /claims/{claim_id}/reject
   *
   * @param claimId String
   * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
   * @return response of {@code Object}
   */
  public Object rejectClaim(
    @NonNull String claimId,
    @NonNull RejectClaimRequest rejectClaimRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().rejectClaim(claimId, rejectClaimRequest, requestConfig).getData();
  }

  /**
   * Method rejectClaim
   * POST /claims/{claim_id}/reject
   *
   * @param claimId String
   * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> rejectClaimAsync(
    @NonNull String claimId,
    @NonNull RejectClaimRequest rejectClaimRequest
  ) throws ApiError {
    return this.rejectClaimAsync(claimId, rejectClaimRequest, null);
  }

  /**
   * Method rejectClaim
   * POST /claims/{claim_id}/reject
   *
   * @param claimId String
   * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> rejectClaimAsync(
    @NonNull String claimId,
    @NonNull RejectClaimRequest rejectClaimRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .rejectClaimAsync(claimId, rejectClaimRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildRejectClaimRequest(
    @NonNull String claimId,
    @NonNull RejectClaimRequest rejectClaimRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims/{claim_id}/reject"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claim_id", claimId)
      .setJsonContent(rejectClaimRequest)
      .build();
  }

  /**
   * Method reimburseClaim
   * POST /claims/{claim_id}/reimburse
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object reimburseClaim(@NonNull String claimId) throws ApiError {
    return this.reimburseClaim(claimId, null);
  }

  /**
   * Method reimburseClaim
   * POST /claims/{claim_id}/reimburse
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object reimburseClaim(@NonNull String claimId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().reimburseClaim(claimId, requestConfig).getData();
  }

  /**
   * Method reimburseClaim
   * POST /claims/{claim_id}/reimburse
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> reimburseClaimAsync(@NonNull String claimId) throws ApiError {
    return this.reimburseClaimAsync(claimId, null);
  }

  /**
   * Method reimburseClaim
   * POST /claims/{claim_id}/reimburse
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> reimburseClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .reimburseClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildReimburseClaimRequest(
    @NonNull String claimId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST),
      "claims/{claim_id}/reimburse"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claim_id", claimId)
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link ExpenseTrackerApiSdkService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listCategories() throws ApiError {
      return this.listCategories(null);
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listCategories(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listCategoriesConfig, requestConfig);
      Request request = buildListCategoriesRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listCategoriesAsync()
      throws ApiError {
      return this.listCategoriesAsync(null);
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listCategoriesAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listCategoriesConfig, requestConfig);
      Request request = buildListCategoriesRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createCategory(
      @NonNull CreateCategoryRequest createCategoryRequest
    ) throws ApiError {
      return this.createCategory(createCategoryRequest, null);
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createCategory(
      @NonNull CreateCategoryRequest createCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createCategoryConfig, requestConfig);
      Request request = buildCreateCategoryRequest(createCategoryRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createCategoryAsync(
      @NonNull CreateCategoryRequest createCategoryRequest
    ) throws ApiError {
      return this.createCategoryAsync(createCategoryRequest, null);
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createCategoryAsync(
      @NonNull CreateCategoryRequest createCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createCategoryConfig, requestConfig);
      Request request = buildCreateCategoryRequest(createCategoryRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getCategory
     * GET /categories/{category_id}
     *
     * @param categoryId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getCategory(@NonNull String categoryId)
      throws ApiError {
      return this.getCategory(categoryId, null);
    }

    /**
     * Method getCategory
     * GET /categories/{category_id}
     *
     * @param categoryId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getCategory(
      @NonNull String categoryId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getCategoryConfig, requestConfig);
      Request request = buildGetCategoryRequest(categoryId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getCategory
     * GET /categories/{category_id}
     *
     * @param categoryId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getCategoryAsync(
      @NonNull String categoryId
    ) throws ApiError {
      return this.getCategoryAsync(categoryId, null);
    }

    /**
     * Method getCategory
     * GET /categories/{category_id}
     *
     * @param categoryId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getCategoryAsync(
      @NonNull String categoryId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getCategoryConfig, requestConfig);
      Request request = buildGetCategoryRequest(categoryId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method updateCategory
     * PUT /categories/{category_id}
     *
     * @param categoryId String
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateCategory(
      @NonNull String categoryId,
      @NonNull CreateCategoryRequest createCategoryRequest
    ) throws ApiError {
      return this.updateCategory(categoryId, createCategoryRequest, null);
    }

    /**
     * Method updateCategory
     * PUT /categories/{category_id}
     *
     * @param categoryId String
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateCategory(
      @NonNull String categoryId,
      @NonNull CreateCategoryRequest createCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateCategoryConfig, requestConfig);
      Request request = buildUpdateCategoryRequest(
        categoryId,
        createCategoryRequest,
        resolvedConfig
      );
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method updateCategory
     * PUT /categories/{category_id}
     *
     * @param categoryId String
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateCategoryAsync(
      @NonNull String categoryId,
      @NonNull CreateCategoryRequest createCategoryRequest
    ) throws ApiError {
      return this.updateCategoryAsync(categoryId, createCategoryRequest, null);
    }

    /**
     * Method updateCategory
     * PUT /categories/{category_id}
     *
     * @param categoryId String
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateCategoryAsync(
      @NonNull String categoryId,
      @NonNull CreateCategoryRequest createCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateCategoryConfig, requestConfig);
      Request request = buildUpdateCategoryRequest(
        categoryId,
        createCategoryRequest,
        resolvedConfig
      );
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listExpenses() throws ApiError {
      return this.listExpenses(ListExpensesParameters.builder().build());
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listExpenses(
      @NonNull ListExpensesParameters requestParameters
    ) throws ApiError {
      return this.listExpenses(requestParameters, null);
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listExpenses(
      @NonNull ListExpensesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listExpensesConfig, requestConfig);
      Request request = buildListExpensesRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listExpensesAsync()
      throws ApiError {
      return this.listExpensesAsync(ListExpensesParameters.builder().build());
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listExpensesAsync(
      @NonNull ListExpensesParameters requestParameters
    ) throws ApiError {
      return this.listExpensesAsync(requestParameters, null);
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listExpensesAsync(
      @NonNull ListExpensesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listExpensesConfig, requestConfig);
      Request request = buildListExpensesRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createExpense(
      @NonNull CreateExpenseRequest createExpenseRequest
    ) throws ApiError {
      return this.createExpense(createExpenseRequest, null);
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createExpense(
      @NonNull CreateExpenseRequest createExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createExpenseConfig, requestConfig);
      Request request = buildCreateExpenseRequest(createExpenseRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createExpenseAsync(
      @NonNull CreateExpenseRequest createExpenseRequest
    ) throws ApiError {
      return this.createExpenseAsync(createExpenseRequest, null);
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createExpenseAsync(
      @NonNull CreateExpenseRequest createExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createExpenseConfig, requestConfig);
      Request request = buildCreateExpenseRequest(createExpenseRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getExpense
     * GET /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getExpense(@NonNull String expenseId)
      throws ApiError {
      return this.getExpense(expenseId, null);
    }

    /**
     * Method getExpense
     * GET /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getExpense(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getExpenseConfig, requestConfig);
      Request request = buildGetExpenseRequest(expenseId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getExpense
     * GET /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getExpenseAsync(
      @NonNull String expenseId
    ) throws ApiError {
      return this.getExpenseAsync(expenseId, null);
    }

    /**
     * Method getExpense
     * GET /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getExpenseAsync(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getExpenseConfig, requestConfig);
      Request request = buildGetExpenseRequest(expenseId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expense_id}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateExpense(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest
    ) throws ApiError {
      return this.updateExpense(expenseId, updateExpenseRequest, null);
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expense_id}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateExpense(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateExpenseConfig, requestConfig);
      Request request = buildUpdateExpenseRequest(expenseId, updateExpenseRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expense_id}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateExpenseAsync(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest
    ) throws ApiError {
      return this.updateExpenseAsync(expenseId, updateExpenseRequest, null);
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expense_id}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateExpenseAsync(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateExpenseConfig, requestConfig);
      Request request = buildUpdateExpenseRequest(expenseId, updateExpenseRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<String>}
     */
    public ExpenseTrackerApiSdkResponse<String> deleteExpense(@NonNull String expenseId)
      throws ApiError {
      return this.deleteExpense(expenseId, null);
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<String>}
     */
    public ExpenseTrackerApiSdkResponse<String> deleteExpense(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteExpenseConfig, requestConfig);
      Request request = buildDeleteExpenseRequest(expenseId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.toBodyString(bodyBytes)
      );
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<String>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<String>> deleteExpenseAsync(
      @NonNull String expenseId
    ) throws ApiError {
      return this.deleteExpenseAsync(expenseId, null);
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expense_id}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<String>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<String>> deleteExpenseAsync(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteExpenseConfig, requestConfig);
      Request request = buildDeleteExpenseRequest(expenseId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.toBodyString(bodyBytes)
        );
      });
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listClaims() throws ApiError {
      return this.listClaims(ListClaimsParameters.builder().build());
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listClaims(
      @NonNull ListClaimsParameters requestParameters
    ) throws ApiError {
      return this.listClaims(requestParameters, null);
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listClaims(
      @NonNull ListClaimsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listClaimsConfig, requestConfig);
      Request request = buildListClaimsRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listClaimsAsync()
      throws ApiError {
      return this.listClaimsAsync(ListClaimsParameters.builder().build());
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listClaimsAsync(
      @NonNull ListClaimsParameters requestParameters
    ) throws ApiError {
      return this.listClaimsAsync(requestParameters, null);
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listClaimsAsync(
      @NonNull ListClaimsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listClaimsConfig, requestConfig);
      Request request = buildListClaimsRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createClaim(
      @NonNull CreateClaimRequest createClaimRequest
    ) throws ApiError {
      return this.createClaim(createClaimRequest, null);
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createClaim(
      @NonNull CreateClaimRequest createClaimRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createClaimConfig, requestConfig);
      Request request = buildCreateClaimRequest(createClaimRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createClaimAsync(
      @NonNull CreateClaimRequest createClaimRequest
    ) throws ApiError {
      return this.createClaimAsync(createClaimRequest, null);
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createClaimAsync(
      @NonNull CreateClaimRequest createClaimRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createClaimConfig, requestConfig);
      Request request = buildCreateClaimRequest(createClaimRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getClaim
     * GET /claims/{claim_id}
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getClaim(@NonNull String claimId) throws ApiError {
      return this.getClaim(claimId, null);
    }

    /**
     * Method getClaim
     * GET /claims/{claim_id}
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getClaimConfig, requestConfig);
      Request request = buildGetClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getClaim
     * GET /claims/{claim_id}
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.getClaimAsync(claimId, null);
    }

    /**
     * Method getClaim
     * GET /claims/{claim_id}
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getClaimConfig, requestConfig);
      Request request = buildGetClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method submitClaim
     * POST /claims/{claim_id}/submit
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> submitClaim(@NonNull String claimId)
      throws ApiError {
      return this.submitClaim(claimId, null);
    }

    /**
     * Method submitClaim
     * POST /claims/{claim_id}/submit
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> submitClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(submitClaimConfig, requestConfig);
      Request request = buildSubmitClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method submitClaim
     * POST /claims/{claim_id}/submit
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> submitClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.submitClaimAsync(claimId, null);
    }

    /**
     * Method submitClaim
     * POST /claims/{claim_id}/submit
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> submitClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(submitClaimConfig, requestConfig);
      Request request = buildSubmitClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method approveClaim
     * POST /claims/{claim_id}/approve
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> approveClaim(@NonNull String claimId)
      throws ApiError {
      return this.approveClaim(claimId, null);
    }

    /**
     * Method approveClaim
     * POST /claims/{claim_id}/approve
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> approveClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(approveClaimConfig, requestConfig);
      Request request = buildApproveClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method approveClaim
     * POST /claims/{claim_id}/approve
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> approveClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.approveClaimAsync(claimId, null);
    }

    /**
     * Method approveClaim
     * POST /claims/{claim_id}/approve
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> approveClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(approveClaimConfig, requestConfig);
      Request request = buildApproveClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method rejectClaim
     * POST /claims/{claim_id}/reject
     *
     * @param claimId String
     * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> rejectClaim(
      @NonNull String claimId,
      @NonNull RejectClaimRequest rejectClaimRequest
    ) throws ApiError {
      return this.rejectClaim(claimId, rejectClaimRequest, null);
    }

    /**
     * Method rejectClaim
     * POST /claims/{claim_id}/reject
     *
     * @param claimId String
     * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> rejectClaim(
      @NonNull String claimId,
      @NonNull RejectClaimRequest rejectClaimRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(rejectClaimConfig, requestConfig);
      Request request = buildRejectClaimRequest(claimId, rejectClaimRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method rejectClaim
     * POST /claims/{claim_id}/reject
     *
     * @param claimId String
     * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> rejectClaimAsync(
      @NonNull String claimId,
      @NonNull RejectClaimRequest rejectClaimRequest
    ) throws ApiError {
      return this.rejectClaimAsync(claimId, rejectClaimRequest, null);
    }

    /**
     * Method rejectClaim
     * POST /claims/{claim_id}/reject
     *
     * @param claimId String
     * @param rejectClaimRequest {@link RejectClaimRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> rejectClaimAsync(
      @NonNull String claimId,
      @NonNull RejectClaimRequest rejectClaimRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(rejectClaimConfig, requestConfig);
      Request request = buildRejectClaimRequest(claimId, rejectClaimRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method reimburseClaim
     * POST /claims/{claim_id}/reimburse
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> reimburseClaim(@NonNull String claimId)
      throws ApiError {
      return this.reimburseClaim(claimId, null);
    }

    /**
     * Method reimburseClaim
     * POST /claims/{claim_id}/reimburse
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> reimburseClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(reimburseClaimConfig, requestConfig);
      Request request = buildReimburseClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method reimburseClaim
     * POST /claims/{claim_id}/reimburse
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> reimburseClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.reimburseClaimAsync(claimId, null);
    }

    /**
     * Method reimburseClaim
     * POST /claims/{claim_id}/reimburse
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> reimburseClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(reimburseClaimConfig, requestConfig);
      Request request = buildReimburseClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }
  }
}

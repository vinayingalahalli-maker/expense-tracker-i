import { z } from 'zod';
import { BaseService } from '../base-service';
import { ContentType, HttpResponse, SdkConfig } from '../../http/types';
import { RequestBuilder } from '../../http/transport/request-builder';
import { SerializationStyle } from '../../http/serialization/base-serializer';
import { ThrowableError } from '../../http/errors/throwable-error';
import { Environment } from '../../http/environment';
import {
  CreateCategoryRequest,
  createCategoryRequestRequest,
} from './models/create-category-request';
import { ListClaimsParams, ListExpensesParams } from './request-params';
import { CreateExpenseRequest, createExpenseRequestRequest } from './models/create-expense-request';
import { UpdateExpenseRequest, updateExpenseRequestRequest } from './models/update-expense-request';
import { CreateClaimRequest, createClaimRequestRequest } from './models/create-claim-request';
import { RejectClaimRequest, rejectClaimRequestRequest } from './models/reject-claim-request';

/**
 * Service class for ExpenseTrackerApiSdkService operations.
 * Provides methods to interact with ExpenseTrackerApiSdkService-related API endpoints.
 * All methods return promises and handle request/response serialization automatically.
 */
export class ExpenseTrackerApiSdkService extends BaseService {
  protected listCategoriesConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected createCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected getCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected updateCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected listExpensesConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected createExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected getExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected updateExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected deleteExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected listClaimsConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected createClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected getClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected submitClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected approveClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected rejectClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  protected reimburseClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST };

  /**
   * Sets method-level configuration for listCategories.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setListCategoriesConfig(config: Partial<SdkConfig>): this {
    this.listCategoriesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateCategoryConfig(config: Partial<SdkConfig>): this {
    this.createCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetCategoryConfig(config: Partial<SdkConfig>): this {
    this.getCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for updateCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setUpdateCategoryConfig(config: Partial<SdkConfig>): this {
    this.updateCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for listExpenses.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setListExpensesConfig(config: Partial<SdkConfig>): this {
    this.listExpensesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateExpenseConfig(config: Partial<SdkConfig>): this {
    this.createExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetExpenseConfig(config: Partial<SdkConfig>): this {
    this.getExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for updateExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setUpdateExpenseConfig(config: Partial<SdkConfig>): this {
    this.updateExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for deleteExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setDeleteExpenseConfig(config: Partial<SdkConfig>): this {
    this.deleteExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for listClaims.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setListClaimsConfig(config: Partial<SdkConfig>): this {
    this.listClaimsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateClaimConfig(config: Partial<SdkConfig>): this {
    this.createClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetClaimConfig(config: Partial<SdkConfig>): this {
    this.getClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for submitClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setSubmitClaimConfig(config: Partial<SdkConfig>): this {
    this.submitClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for approveClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setApproveClaimConfig(config: Partial<SdkConfig>): this {
    this.approveClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for rejectClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setRejectClaimConfig(config: Partial<SdkConfig>): this {
    this.rejectClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for reimburseClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setReimburseClaimConfig(config: Partial<SdkConfig>): this {
    this.reimburseClaimConfig = config;
    return this;
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async listCategories(requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.listCategoriesConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/categories')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 401,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 201 Created
   */
  async createCategory(
    body: CreateCategoryRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/categories')
      .setRequestSchema(createCategoryRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 201,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 400,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 403,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} categoryId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async getCategory(categoryId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/categories/{category_id}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 404,
      })
      .addPathParam({
        key: 'category_id',
        value: categoryId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} categoryId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async updateCategory(
    categoryId: string,
    body: CreateCategoryRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.updateCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('PUT')
      .setPath('/categories/{category_id}')
      .setRequestSchema(createCategoryRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 403,
      })
      .addPathParam({
        key: 'category_id',
        value: categoryId,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} [params.status] - Filter by status: unclaimed | claimed
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async listExpenses(
    params?: ListExpensesParams,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.listExpensesConfig, requestConfig);
    z.object({ status: z.string().optional() }).parse(params ?? {});
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/expenses')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 401,
      })
      .addQueryParam({
        key: 'status',
        value: params?.status,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 201 Created
   */
  async createExpense(
    body: CreateExpenseRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/expenses')
      .setRequestSchema(createExpenseRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 201,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 400,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 422,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} expenseId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async getExpense(expenseId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/expenses/{expense_id}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 404,
      })
      .addPathParam({
        key: 'expense_id',
        value: expenseId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} expenseId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async updateExpense(
    expenseId: string,
    body: UpdateExpenseRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.updateExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('PUT')
      .setPath('/expenses/{expense_id}')
      .setRequestSchema(updateExpenseRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 409,
      })
      .addPathParam({
        key: 'expense_id',
        value: expenseId,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} expenseId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<string>>} - 204 No Content
   */
  async deleteExpense(expenseId: string, requestConfig?: Partial<SdkConfig>): Promise<string> {
    const resolvedConfig = this.getResolvedConfig(this.deleteExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('DELETE')
      .setPath('/expenses/{expense_id}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.string(),
        contentType: ContentType.Json,
        status: 204,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 409,
      })
      .addPathParam({
        key: 'expense_id',
        value: expenseId,
      })
      .build();
    return this.client.callDirect<string>(request);
  }

  /**
   *
   * @param {string} [params.status] - Filter by status: draft | submitted | approved | rejected | reimbursed
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async listClaims(params?: ListClaimsParams, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.listClaimsConfig, requestConfig);
    z.object({ status: z.string().optional() }).parse(params ?? {});
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/claims')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addQueryParam({
        key: 'status',
        value: params?.status,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 201 Created
   */
  async createClaim(body: CreateClaimRequest, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims')
      .setRequestSchema(createClaimRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 201,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 422,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async getClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/claims/{claim_id}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 404,
      })
      .addPathParam({
        key: 'claim_id',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 200 OK
   */
  async submitClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.submitClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims/{claim_id}/submit')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claim_id',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async approveClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.approveClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims/{claim_id}/approve')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claim_id',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async rejectClaim(
    claimId: string,
    body: RejectClaimRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.rejectClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims/{claim_id}/reject')
      .setRequestSchema(rejectClaimRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claim_id',
        value: claimId,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async reimburseClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.reimburseClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims/{claim_id}/reimburse')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token, 'Bearer')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claim_id',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }
}

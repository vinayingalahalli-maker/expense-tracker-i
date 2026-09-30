# ExpenseTrackerApiSdkService

A list of all methods in the `ExpenseTrackerApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description |
| :-------------------------------- | :---------- |
| [listCategories](#listcategories) |             |
| [createCategory](#createcategory) |             |
| [getCategory](#getcategory)       |             |
| [updateCategory](#updatecategory) |             |
| [listExpenses](#listexpenses)     |             |
| [createExpense](#createexpense)   |             |
| [getExpense](#getexpense)         |             |
| [updateExpense](#updateexpense)   |             |
| [deleteExpense](#deleteexpense)   |             |
| [listClaims](#listclaims)         |             |
| [createClaim](#createclaim)       |             |
| [getClaim](#getclaim)             |             |
| [submitClaim](#submitclaim)       |             |
| [approveClaim](#approveclaim)     |             |
| [rejectClaim](#rejectclaim)       |             |
| [reimburseClaim](#reimburseclaim) |             |

## listCategories

- HTTP Method: `GET`
- Endpoint: `/categories`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listCategories();

    System.out.println(response);
  }
}

```

## createCategory

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| createCategoryRequest | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateCategoryRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.builder()
      .name("Travel")
      .description("Flights, hotels, and ground transport")
      .receiptThreshold(50L)
      .currency("USD")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.createCategory(
      createCategoryRequest
    );

    System.out.println(response);
  }
}

```

## getCategory

- HTTP Method: `GET`
- Endpoint: `/categories/{category_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| categoryId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.getCategory("cat_01");

    System.out.println(response);
  }
}

```

## updateCategory

- HTTP Method: `PUT`
- Endpoint: `/categories/{category_id}`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| categoryId            | String                                                      | ✅       |              |
| createCategoryRequest | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateCategoryRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.builder()
      .name("Travel")
      .description("Flights, hotels, and ground transport")
      .receiptThreshold(50L)
      .currency("USD")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.updateCategory(
      "cat_01",
      createCategoryRequest
    );

    System.out.println(response);
  }
}

```

## listExpenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListExpensesParameters](../models/ListExpensesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.ListExpensesParameters;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    ListExpensesParameters requestParameters = ListExpensesParameters.builder()
      .status("unclaimed")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listExpenses(requestParameters);

    System.out.println(response);
  }
}

```

## createExpense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| createExpenseRequest | [CreateExpenseRequest](../models/CreateExpenseRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateExpenseRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    CreateExpenseRequest createExpenseRequest = CreateExpenseRequest.builder()
      .amount(42.5D)
      .currency("USD")
      .date("2026-09-28")
      .description("Taxi to client site")
      .categoryId("cat_01")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.createExpense(createExpenseRequest);

    System.out.println(response);
  }
}

```

## getExpense

- HTTP Method: `GET`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.getExpense("exp_01");

    System.out.println(response);
  }
}

```

## updateExpense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| expenseId            | String                                                    | ✅       |              |
| updateExpenseRequest | [UpdateExpenseRequest](../models/UpdateExpenseRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.UpdateExpenseRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    UpdateExpenseRequest updateExpenseRequest = UpdateExpenseRequest.builder()
      .amount(55L)
      .currency("USD")
      .date("2026-09-28")
      .description("Taxi to client site (updated fare)")
      .categoryId("cat_01")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.updateExpense(
      "exp_01",
      updateExpenseRequest
    );

    System.out.println(response);
  }
}

```

## deleteExpense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | String | ✅       |             |

**Return Type**

`String`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    String response = expenseTrackerApiSdk.expenseTrackerApiSdk.deleteExpense("exp_01");

    System.out.println(response);
  }
}

```

## listClaims

- HTTP Method: `GET`
- Endpoint: `/claims`

**Parameters**

| Name              | Type                                                      | Required | Description               |
| :---------------- | :-------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListClaimsParameters](../models/ListClaimsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.ListClaimsParameters;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    ListClaimsParameters requestParameters = ListClaimsParameters.builder().status("draft").build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listClaims(requestParameters);

    System.out.println(response);
  }
}

```

## createClaim

- HTTP Method: `POST`
- Endpoint: `/claims`

**Parameters**

| Name               | Type                                                  | Required | Description  |
| :----------------- | :---------------------------------------------------- | :------- | :----------- |
| createClaimRequest | [CreateClaimRequest](../models/CreateClaimRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateClaimRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    List<String> expenseIdsList = Arrays.asList("exp_01");

    CreateClaimRequest createClaimRequest = CreateClaimRequest.builder()
      .title("September Business Trip")
      .expenseIds(expenseIdsList)
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.createClaim(createClaimRequest);

    System.out.println(response);
  }
}

```

## getClaim

- HTTP Method: `GET`
- Endpoint: `/claims/{claim_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.getClaim("clm_01");

    System.out.println(response);
  }
}

```

## submitClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/submit`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.submitClaim("clm_01");

    System.out.println(response);
  }
}

```

## approveClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/approve`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.approveClaim("clm_01");

    System.out.println(response);
  }
}

```

## rejectClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/reject`

**Parameters**

| Name               | Type                                                  | Required | Description  |
| :----------------- | :---------------------------------------------------- | :------- | :----------- |
| claimId            | String                                                | ✅       |              |
| rejectClaimRequest | [RejectClaimRequest](../models/RejectClaimRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.RejectClaimRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    RejectClaimRequest rejectClaimRequest = RejectClaimRequest.builder()
      .reason("Missing receipts for expenses above threshold")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.rejectClaim(
      "clm_01",
      rejectClaimRequest
    );

    System.out.println(response);
  }
}

```

## reimburseClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/reimburse`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.reimburseClaim("clm_01");

    System.out.println(response);
  }
}

```

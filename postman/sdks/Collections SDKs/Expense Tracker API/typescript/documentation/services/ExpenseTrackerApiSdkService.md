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

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listCategories();

  console.log(data);
})();
```

## createCategory

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name | Type                                                        | Required | Description       |
| :--- | :---------------------------------------------------------- | :------- | :---------------- |
| body | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateCategoryRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createCategoryRequest: CreateCategoryRequest = {
    name: 'Travel',
    description: 'Flights, hotels, and ground transport',
    receiptThreshold: 50,
    currency: 'USD',
  };

  const data =
    await expenseTrackerApiSdk.expenseTrackerApiSdk.createCategory(createCategoryRequest);

  console.log(data);
})();
```

## getCategory

- HTTP Method: `GET`
- Endpoint: `/categories/{category_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| categoryId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.getCategory('cat_01');

  console.log(data);
})();
```

## updateCategory

- HTTP Method: `PUT`
- Endpoint: `/categories/{category_id}`

**Parameters**

| Name       | Type                                                        | Required | Description       |
| :--------- | :---------------------------------------------------------- | :------- | :---------------- |
| body       | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | The request body. |
| categoryId | string                                                      | ✅       |                   |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateCategoryRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createCategoryRequest: CreateCategoryRequest = {
    name: 'Travel',
    description: 'Flights, hotels, and ground transport',
    receiptThreshold: 50,
    currency: 'USD',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.updateCategory(
    'cat_01',
    createCategoryRequest,
  );

  console.log(data);
})();
```

## listExpenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name   | Type   | Required | Description                            |
| :----- | :----- | :------- | :------------------------------------- |
| status | string | ❌       | Filter by status: unclaimed \| claimed |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listExpenses({
    status: 'unclaimed',
  });

  console.log(data);
})();
```

## createExpense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name | Type                                                      | Required | Description       |
| :--- | :-------------------------------------------------------- | :------- | :---------------- |
| body | [CreateExpenseRequest](../models/CreateExpenseRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateExpenseRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createExpenseRequest: CreateExpenseRequest = {
    amount: 42.5,
    currency: 'USD',
    date: '2026-09-28',
    description: 'Taxi to client site',
    categoryId: 'cat_01',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.createExpense(createExpenseRequest);

  console.log(data);
})();
```

## getExpense

- HTTP Method: `GET`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.getExpense('exp_01');

  console.log(data);
})();
```

## updateExpense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name      | Type                                                      | Required | Description       |
| :-------- | :-------------------------------------------------------- | :------- | :---------------- |
| body      | [UpdateExpenseRequest](../models/UpdateExpenseRequest.md) | ✅       | The request body. |
| expenseId | string                                                    | ✅       |                   |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, UpdateExpenseRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const updateExpenseRequest: UpdateExpenseRequest = {
    amount: 55,
    currency: 'USD',
    date: '2026-09-28',
    description: 'Taxi to client site (updated fare)',
    categoryId: 'cat_01',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.updateExpense(
    'exp_01',
    updateExpenseRequest,
  );

  console.log(data);
})();
```

## deleteExpense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | string | ✅       |             |

**Return Type**

`string`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.deleteExpense('exp_01');

  console.log(data);
})();
```

## listClaims

- HTTP Method: `GET`
- Endpoint: `/claims`

**Parameters**

| Name   | Type   | Required | Description                                                                |
| :----- | :----- | :------- | :------------------------------------------------------------------------- |
| status | string | ❌       | Filter by status: draft \| submitted \| approved \| rejected \| reimbursed |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listClaims({
    status: 'draft',
  });

  console.log(data);
})();
```

## createClaim

- HTTP Method: `POST`
- Endpoint: `/claims`

**Parameters**

| Name | Type                                                  | Required | Description       |
| :--- | :---------------------------------------------------- | :------- | :---------------- |
| body | [CreateClaimRequest](../models/CreateClaimRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateClaimRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createClaimRequest: CreateClaimRequest = {
    title: 'September Business Trip',
    expenseIds: ['exp_01'],
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.createClaim(createClaimRequest);

  console.log(data);
})();
```

## getClaim

- HTTP Method: `GET`
- Endpoint: `/claims/{claim_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.getClaim('clm_01');

  console.log(data);
})();
```

## submitClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/submit`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.submitClaim('clm_01');

  console.log(data);
})();
```

## approveClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/approve`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.approveClaim('clm_01');

  console.log(data);
})();
```

## rejectClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/reject`

**Parameters**

| Name    | Type                                                  | Required | Description       |
| :------ | :---------------------------------------------------- | :------- | :---------------- |
| body    | [RejectClaimRequest](../models/RejectClaimRequest.md) | ✅       | The request body. |
| claimId | string                                                | ✅       |                   |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, RejectClaimRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const rejectClaimRequest: RejectClaimRequest = {
    reason: 'Missing receipts for expenses above threshold',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.rejectClaim(
    'clm_01',
    rejectClaimRequest,
  );

  console.log(data);
})();
```

## reimburseClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/reimburse`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.reimburseClaim('clm_01');

  console.log(data);
})();
```

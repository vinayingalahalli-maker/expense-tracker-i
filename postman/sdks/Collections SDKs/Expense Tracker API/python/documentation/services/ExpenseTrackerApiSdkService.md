# ExpenseTrackerApiSdkService

A list of all methods in the `ExpenseTrackerApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                             | Description |
| :---------------------------------- | :---------- |
| [list_categories](#list_categories) |             |
| [create_category](#create_category) |             |
| [get_category](#get_category)       |             |
| [update_category](#update_category) |             |
| [list_expenses](#list_expenses)     |             |
| [create_expense](#create_expense)   |             |
| [get_expense](#get_expense)         |             |
| [update_expense](#update_expense)   |             |
| [delete_expense](#delete_expense)   |             |
| [list_claims](#list_claims)         |             |
| [create_claim](#create_claim)       |             |
| [get_claim](#get_claim)             |             |
| [submit_claim](#submit_claim)       |             |
| [approve_claim](#approve_claim)     |             |
| [reject_claim](#reject_claim)       |             |
| [reimburse_claim](#reimburse_claim) |             |

## list_categories

- HTTP Method: `GET`
- Endpoint: `/categories`

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_categories()

print(result)
```

## create_category

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name         | Type                                                        | Required | Description       |
| :----------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateCategoryRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateCategoryRequest(
    name="Travel",
    description="Flights, hotels, and ground transport",
    receipt_threshold=50,
    currency="USD"
)

result = sdk.expense_tracker_api_sdk.create_category(request_body=request_body)

print(result)
```

## get_category

- HTTP Method: `GET`
- Endpoint: `/categories/{category_id}`

**Parameters**

| Name        | Type | Required | Description |
| :---------- | :--- | :------- | :---------- |
| category_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.get_category(category_id="cat_01")

print(result)
```

## update_category

- HTTP Method: `PUT`
- Endpoint: `/categories/{category_id}`

**Parameters**

| Name         | Type                                                        | Required | Description       |
| :----------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | The request body. |
| category_id  | str                                                         | ✅       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateCategoryRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateCategoryRequest(
    name="Travel",
    description="Flights, hotels, and ground transport",
    receipt_threshold=50,
    currency="USD"
)

result = sdk.expense_tracker_api_sdk.update_category(
    request_body=request_body,
    category_id="cat_01"
)

print(result)
```

## list_expenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name   | Type | Required | Description                            |
| :----- | :--- | :------- | :------------------------------------- |
| status | str  | ❌       | Filter by status: unclaimed \| claimed |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_expenses(status="unclaimed")

print(result)
```

## create_expense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name         | Type                                                      | Required | Description       |
| :----------- | :-------------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateExpenseRequest](../models/CreateExpenseRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateExpenseRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateExpenseRequest(
    amount=42.5,
    currency="USD",
    date_="2026-09-28",
    description="Taxi to client site",
    category_id="cat_01"
)

result = sdk.expense_tracker_api_sdk.create_expense(request_body=request_body)

print(result)
```

## get_expense

- HTTP Method: `GET`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name       | Type | Required | Description |
| :--------- | :--- | :------- | :---------- |
| expense_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.get_expense(expense_id="exp_01")

print(result)
```

## update_expense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name         | Type                                                      | Required | Description       |
| :----------- | :-------------------------------------------------------- | :------- | :---------------- |
| request_body | [UpdateExpenseRequest](../models/UpdateExpenseRequest.md) | ✅       | The request body. |
| expense_id   | str                                                       | ✅       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import UpdateExpenseRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = UpdateExpenseRequest(
    amount=55,
    currency="USD",
    date_="2026-09-28",
    description="Taxi to client site (updated fare)",
    category_id="cat_01"
)

result = sdk.expense_tracker_api_sdk.update_expense(
    request_body=request_body,
    expense_id="exp_01"
)

print(result)
```

## delete_expense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{expense_id}`

**Parameters**

| Name       | Type | Required | Description |
| :--------- | :--- | :------- | :---------- |
| expense_id | str  | ✅       |             |

**Return Type**

`str`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.delete_expense(expense_id="exp_01")

with open("output-file.ext", "w") as f:
    f.write(result if isinstance(result, str) else result.decode(errors="replace") if isinstance(result, (bytes, bytearray)) else str(result))
```

## list_claims

- HTTP Method: `GET`
- Endpoint: `/claims`

**Parameters**

| Name   | Type | Required | Description                                                                |
| :----- | :--- | :------- | :------------------------------------------------------------------------- |
| status | str  | ❌       | Filter by status: draft \| submitted \| approved \| rejected \| reimbursed |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_claims(status="draft")

print(result)
```

## create_claim

- HTTP Method: `POST`
- Endpoint: `/claims`

**Parameters**

| Name         | Type                                                  | Required | Description       |
| :----------- | :---------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateClaimRequest](../models/CreateClaimRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateClaimRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateClaimRequest(
    title="September Business Trip",
    expense_ids=[
        "exp_01"
    ]
)

result = sdk.expense_tracker_api_sdk.create_claim(request_body=request_body)

print(result)
```

## get_claim

- HTTP Method: `GET`
- Endpoint: `/claims/{claim_id}`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.get_claim(claim_id="clm_01")

print(result)
```

## submit_claim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/submit`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.submit_claim(claim_id="clm_01")

print(result)
```

## approve_claim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/approve`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.approve_claim(claim_id="clm_01")

print(result)
```

## reject_claim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/reject`

**Parameters**

| Name         | Type                                                  | Required | Description       |
| :----------- | :---------------------------------------------------- | :------- | :---------------- |
| request_body | [RejectClaimRequest](../models/RejectClaimRequest.md) | ✅       | The request body. |
| claim_id     | str                                                   | ✅       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import RejectClaimRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = RejectClaimRequest(
    reason="Missing receipts for expenses above threshold"
)

result = sdk.expense_tracker_api_sdk.reject_claim(
    request_body=request_body,
    claim_id="clm_01"
)

print(result)
```

## reimburse_claim

- HTTP Method: `POST`
- Endpoint: `/claims/{claim_id}/reimburse`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.reimburse_claim(claim_id="clm_01")

print(result)
```

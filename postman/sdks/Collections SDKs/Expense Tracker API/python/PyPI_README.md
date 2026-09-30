# ExpenseTrackerApiSdk Python SDK 1.0.0<a id="expensetrackerapisdk-python-sdk-100"></a>

Welcome to the ExpenseTrackerApiSdk SDK documentation. This guide will help you get started with integrating and using the ExpenseTrackerApiSdk SDK in your project.

## Versions<a id="versions"></a>

- SDK version: `1.0.0`

## About the API<a id="about-the-api"></a>

API collection for the Expense Tracker service at Northbeam Consulting.

Finance Operations needs to replace a spreadsheet-and-email expense process.
Three resources: Categories, Expenses, and Claims.

Auth: JWT Bearer token (HS256). Roles: Employee, Approver, Finance.

## Table of Contents<a id="table-of-contents"></a>

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Authentication](#authentication)
  - [Access Token Authentication](#access-token-authentication)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration<a id="setup--configuration"></a>

## Supported Language Versions<a id="supported-language-versions"></a>

This SDK is compatible with the following versions: `Python >= 3.9`

## Installation<a id="installation"></a>

To get started with the SDK, we recommend installing using `pip`:

```bash
pip install expense_tracker_api_sdk
```

If you are using Python 3, you can use `pip3` instead:

```bash
pip3 install expense_tracker_api_sdk
```

## Authentication<a id="authentication"></a>

### Access Token Authentication<a id="access-token-authentication"></a>

The ExpenseTrackerApiSdk API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token<a id="setting-the-access-token"></a>

When you initialize the SDK, you can set the access token as follows:

```py
ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    timeout=10
)
```

If you need to set or update the access token after initializing the SDK, you can use:

```py
sdk.set_access_token("YOUR_ACCESS_TOKEN")
```

## Setting a Custom Timeout<a id="setting-a-custom-timeout"></a>

You can set a custom timeout for the SDK's HTTP requests as follows:

```py
from expense_tracker_api_sdk import ExpenseTrackerApiSdk

sdk = ExpenseTrackerApiSdk(timeout=10)
```

# Sample Usage<a id="sample-usage"></a>

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```py
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_categories()

print(result)

```

# Async Usage<a id="async-usage"></a>

The SDK includes an Async Client for making asynchronous API requests. This is useful for applications that need non-blocking operations, like web servers or apps with a graphical user interface.

```py
import asyncio
from expense_tracker_api_sdk import ExpenseTrackerApiSdkAsync, Environment

sdk = ExpenseTrackerApiSdkAsync(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)


async def main():
  result = await sdk.expense_tracker_api_sdk.list_categories()
  print(result)

asyncio.run(main())
```

## Services<a id="services"></a>

The SDK provides various services to interact with the API.

<details> 
<summary>Below is a list of all available services:</summary>

| Name                    |
| :---------------------- |
| expense_tracker_api_sdk |

</details>

## Models<a id="models"></a>

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details> 
<summary>Below is a list of all available models:</summary>

| Name                  | Description |
| :-------------------- | :---------- |
| CreateCategoryRequest |             |
| CreateExpenseRequest  |             |
| UpdateExpenseRequest  |             |
| CreateClaimRequest    |             |
| RejectClaimRequest    |             |

</details>
